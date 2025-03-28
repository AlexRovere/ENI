import express, { Application, Request, Response } from "express";
import cors, { CorsOptions } from "cors";
import dotenv from "dotenv";
import { Movie } from "./src/models/Movie";
import { ApiResponseMovie } from "./src/models/ApiResponseMovie";
import { ApiResponseVideo } from "./src/models/ApiResponseVideo";
import { ApiResponseVideoSearch } from "./src/models/ApiResponseVideoSearch";
import { Video } from "./src/models/Video";
import connectDB from './database'
import session from 'express-session'
import { body, validationResult } from 'express-validator';
import UserDb, { User } from './src/models/mango/User'



if (!process.env.SECRET || process.env.SECRET.trim() === '') {
  throw new Error('Le secret de session est manquant. Veuillez définir SECRET dans le fichier .env.');
}


const PORT = process.env.PORT;


connectDB()

const app: Application = express()


app.use(session({
  resave: false,
  saveUninitialized: false,
  secret: process.env.SECRET
}));

const axios = require('axios')

dotenv.config();

const API_YOUTUBE = process.env.API_YOUTUBE


const corsOptions: CorsOptions = {
  origin: ['http://localhost:4200', 'http://127.0.0.1:4200'],
  methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'],
  allowedHeaders: ['Content-Type', 'Authorization'],
  credentials: true
};

app.use(cors(corsOptions));

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

declare module 'express-session' {
  interface Session {
    video: Video
  }
}


app.get('/', (req: Request, res: Response) => {
  res.send('Welcome stranger')
})

const options = {
  method: 'GET',
  headers: {
    accept: 'application/json',
    Authorization: process.env.bearer
  }
};

app.get('/ping', async (req: Request, res: Response) => {
  const { data } = await axios.get('https://api.themoviedb.org/3/authentication', options)
  res.status(200).send(data?.success)
})

app.get('/categories', async (req: Request, res: Response) => {
  const { data } = await axios.get('https://api.themoviedb.org/3/genre/movie/list?language=fr', options)
  res.json(data)
})

app.get('/best-movies', async (req: Request, res: Response) => {
  const page = req.query?.page ?? 1
  const { data } = await axios.get(`https://api.themoviedb.org/3/movie/top_rated?language=fr-FR&page=${page}`, options)
  res.json(data)
})

app.get('/find-movies', async (req: Request, res: Response) => {
  const query = req.query?.query ?? ""
  try {
    const { data } = await axios.get(`https://api.themoviedb.org/3/search/movie?query=${query}&include_adult=false&language=fr-FR&page=1`, options)
    const movies: Movie = data.results.map((d: ApiResponseMovie) => {
      return {
        id: d.id,
        categories: d.genre_ids,
        title: d.title,
        description: d.overview,
        popularity: d.popularity,
        releaseAt: d.release_date,
        voteAverage: d.vote_average,
        voteCount: d.vote_count,
        posterPath: `https://image.tmdb.org/${d.poster_path}`,
        backgroundPath: `https://image.tmdb.org/${d.background_path}`
      }
    })
    res.status(200).json({ message: 'success', code: 200, data: { movies, pages: data.total_pages, results: data.total_results } })
  } catch (e) {
    console.error(e)
    res.status(500).json({ message: 'server error', code: 500 })
  }
})

const optionsYoutube = {
  method: 'GET',
  headers: {
    accept: 'application/json',
  }
};

app.get('/find-videos', async (req: Request, res: Response) => {
  const query = req.query?.query ?? ""
  try {
    const { data: searchResponse }: { data: ApiResponseVideoSearch } = await axios.get('https://www.googleapis.com/youtube/v3/search', {
      optionsYoutube,
      params: {
        key: API_YOUTUBE,
        maxResults: 20,
        q: query,
        part: 'snippet',
        type: 'video'
      }
    })
    const videoIds = searchResponse.items.map(i => i.id.videoId).join(',')
    const { data: statisticsResponse }: { data: ApiResponseVideo } = await axios.get('https://www.googleapis.com/youtube/v3/videos', {
      params: {
        key: API_YOUTUBE,
        id: videoIds,
        part: 'statistics,snippet, player'
      }
    })
    const videos: Video[] = searchResponse.items.map(searchVideo => {
      const fullVideoInfo = statisticsResponse.items.find(statItem => statItem.id === searchVideo.id.videoId)

      return {
        id: searchVideo.id.videoId,
        title: searchVideo.snippet.title,
        description: searchVideo.snippet.description,
        channelTitle: searchVideo.snippet.channelTitle,
        imagePath: searchVideo.snippet.thumbnails.high.url,
        publishedAt: searchVideo.snippet.publishedAt,
        viewCount: fullVideoInfo?.statistics.viewCount ?? null,
        likeCount: fullVideoInfo?.statistics?.likeCount ?? null,
        favoriteCount: fullVideoInfo?.statistics.favoriteCount ?? null,
        commentCount: fullVideoInfo?.statistics.commentCount ?? null,
        player: fullVideoInfo?.player.embedHtml ?? null,
        tags: fullVideoInfo?.snippet.tags ?? []
      };
    });
    res.status(200).json({ message: 'success', code: 200, data: videos })
  } catch (e) {
    console.error(e)
    res.status(500).json({ message: 'server error', code: 500 })
  }
})

app.get('/get-popular-videos', async (req: Request, res: Response) => {
  try {
    const { data: videoResponse }: { data: ApiResponseVideo } = await axios.get('https://www.googleapis.com/youtube/v3/videos', {
      optionsYoutube,
      params: {
        key: API_YOUTUBE,
        maxResults: 20,
        part: 'id,player,statistics,snippet',
        type: 'video',
        chart: 'mostPopular',
        regionCode: 'FR'
      }
    })

    const videos: Video[] = videoResponse.items.map(v => {
      return {
        id: v.id,
        title: v.snippet.title,
        description: v.snippet.description,
        channelTitle: v.snippet.channelTitle,
        imagePath: v.snippet.thumbnails.high.url,
        publishedAt: v.snippet.publishedAt,
        viewCount: v?.statistics.viewCount ?? null,
        likeCount: v?.statistics?.likeCount ?? null,
        favoriteCount: v?.statistics.favoriteCount ?? null,
        commentCount: v?.statistics.commentCount ?? null,
        player: v?.player.embedHtml ?? null,
        tags: v?.snippet.tags ?? []
      };
    })

    res.status(200).json({ message: 'success', code: 200, data: videos })
  } catch (e) {
    console.error(e)
    res.status(500).json({ message: 'server error', code: 500 })
  }
})

app.post("/register",
  body('email').notEmpty().withMessage('required'),
  body('password').notEmpty().withMessage('required'),
  body('pseudo').notEmpty().withMessage('required'),
  body('phone').notEmpty().withMessage('required')
  , async (req: Request, res: Response) => {

    const result = validationResult(req);

    if (!result.isEmpty()) {
      const formErrors = result.array().map((e: any) => {
        return {
          type: e.msg,
          field: e.path
        }
      });
      res.status(400).json({ message: 'Le formulaire n\'est pas valide', code: 400, data: formErrors });
      return
    }

    // TODO Verifier si l'email existe déjà en DB
    // Hasher le mdp

    const newUser: User = new UserDb({
      email: req.body.email,
      password: req.body.password,
      pseudo: req.body.pseudo,
      phone: req.body.phone,
      videos: []
    });

    try {
      const userCreated = await UserDb.create(newUser)

      if (userCreated) {
        res.status(200).json({ message: 'Utilisateur crée avec succès', code: 200, data: userCreated })
        console.info("Utilisateur crée :", userCreated);
      } else {
        res.status(403).json({ message: 'Erreur lors de la création de l\'utilisateur', code: 403 });
      }
    } catch (e: any) {
      res.status(500).json({ message: 'Erreur lors de la création de l\'utilisteur', code: 500 });
      console.error(e)
    }

  })

app.get("/users/detail/:id", async (req: Request, res: Response) => {
  if (req.params.id) {
    const user = await UserDb.findById(req.params.id)

    if (user) {
      res.status(200).json({ message: "", code: 200, data: user })
    }
  }
})

app.get("/login", async (req: Request, res: Response) => {
  const email = req.query.email
  const password = req.query.password
  if (email && password) {
    const user = await UserDb.findOne({ email })

    if (user?.password === password) {
      //TODO: renvoyer un token
      res.status(200).json({ message: "Vous êtes connecté !", code: 200, data: user })
    } else {
      res.status(403).json({ message: 'Impossible de se connecter', code: 403 });
    }
  }
})

app.post("/users/add-favorite-video", async (req: Request, res: Response) => {
  const userId = req.body.userId
  const video: Video = req.body.video

  if (userId && video) {
    const user = await UserDb.findById(userId)

    if (user) {
      const videoAlreadyExist = user.videos.find(v => v.id === video.id)
      if (!videoAlreadyExist) {
        user.videos.push(video)
      }
      await UserDb.updateOne(user)
      res.status(200).json({ message: "", code: 200, data: user })
    }
  } else {
    res.status(400).json({ message: 'Informations manquantes', code: 400 });
  }
})

app.post("/users/remove-favorite-video", async (req: Request, res: Response) => {
  const userId = req.body.userId
  const video: Video = req.body.video

  if (userId && video) {
    const user = await UserDb.findById(userId)

    if (user) {
      const videoAlreadyExist = user.videos.find(v => v.id === video.id)
      if (videoAlreadyExist) {
        user.videos.splice(user.videos.indexOf(video), 1)
      }
      await UserDb.updateOne(user)
      res.status(200).json({ message: "", code: 200, data: user })
    }
  } else {
    res.status(400).json({ message: 'Informations manquantes', code: 400 });
  }
})




app.listen(PORT, () => {
  console.log('Serveur launched on port 3000')
})



