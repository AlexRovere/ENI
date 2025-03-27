import express, { Application, Request, Response } from "express";
import cors, { CorsOptions } from "cors";
import dotenv from "dotenv";
import { Movie } from "./src/models/Movie";
import { ApiResponseMovie } from "./src/models/ApiResponseMovie";
import { ApiResponseVideo } from "./src/models/ApiResponseVideo";


const app: Application = express()
const port = 3000
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
    const { data } = await axios.get(`https://www.googleapis.com/youtube/v3/search?key=${API_YOUTUBE}&maxResults=20&q=${query}&part=snippet`, optionsYoutube)
    res.status(200).json({ message: 'success', code: 200, data })
  } catch (e) {
    console.error(e)
    res.status(500).json({ message: 'server error', code: 500 })
  }
})

app.get('/get-popular-videos', async (req: Request, res: Response) => {
  try {
    const { data } = await axios.get(`https://www.googleapis.com/youtube/v3/videos?key=${API_YOUTUBE}&maxResults=20&chart=mostPopular&regionCode=FR&part=id,player,statistics,snippet`, optionsYoutube)
    res.status(200).json({ message: 'success', code: 200, data })
  } catch (e) {
    console.error(e)
    res.status(500).json({ message: 'server error', code: 500 })
  }
})




app.listen(port, () => {
  console.log('Serveur launched on port 3000')
})



