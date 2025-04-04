"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const cors_1 = __importDefault(require("cors"));
const dotenv_1 = __importDefault(require("dotenv"));
const database_1 = __importDefault(require("./database"));
const express_session_1 = __importDefault(require("express-session"));
const express_validator_1 = require("express-validator");
const User_1 = __importDefault(require("./src/models/mango/User"));
if (!process.env.SECRET || process.env.SECRET.trim() === '') {
    throw new Error('Le secret de session est manquant. Veuillez définir SECRET dans le fichier .env.');
}
const PORT = process.env.PORT;
(0, database_1.default)();
const app = (0, express_1.default)();
app.use((0, express_session_1.default)({
    resave: false,
    saveUninitialized: false,
    secret: process.env.SECRET
}));
const axios = require('axios');
dotenv_1.default.config();
const API_YOUTUBE = process.env.API_YOUTUBE;
const corsOptions = {
    origin: ['http://localhost:4200', 'http://127.0.0.1:4200'],
    methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'],
    allowedHeaders: ['Content-Type', 'Authorization'],
    credentials: true
};
app.use((0, cors_1.default)(corsOptions));
app.use(express_1.default.json());
app.use(express_1.default.urlencoded({ extended: true }));
app.get('/', (req, res) => {
    res.send('Welcome stranger');
});
const options = {
    method: 'GET',
    headers: {
        accept: 'application/json',
        Authorization: process.env.bearer
    }
};
app.get('/ping', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const { data } = yield axios.get('https://api.themoviedb.org/3/authentication', options);
    res.status(200).send(data === null || data === void 0 ? void 0 : data.success);
}));
app.get('/categories', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const { data } = yield axios.get('https://api.themoviedb.org/3/genre/movie/list?language=fr', options);
    res.json(data);
}));
app.get('/best-movies', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    var _a, _b;
    const page = (_b = (_a = req.query) === null || _a === void 0 ? void 0 : _a.page) !== null && _b !== void 0 ? _b : 1;
    const { data } = yield axios.get(`https://api.themoviedb.org/3/movie/top_rated?language=fr-FR&page=${page}`, options);
    res.json(data);
}));
app.get('/find-movies', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    var _a, _b;
    const query = (_b = (_a = req.query) === null || _a === void 0 ? void 0 : _a.query) !== null && _b !== void 0 ? _b : "";
    try {
        const { data } = yield axios.get(`https://api.themoviedb.org/3/search/movie?query=${query}&include_adult=false&language=fr-FR&page=1`, options);
        const movies = data.results.map((d) => {
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
            };
        });
        res.status(200).json({ message: 'success', code: 200, data: { movies, pages: data.total_pages, results: data.total_results } });
    }
    catch (e) {
        console.error(e);
        res.status(500).json({ message: 'server error', code: 500 });
    }
}));
const optionsYoutube = {
    method: 'GET',
    headers: {
        accept: 'application/json',
    }
};
app.get('/find-videos', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    var _a, _b;
    const query = (_b = (_a = req.query) === null || _a === void 0 ? void 0 : _a.query) !== null && _b !== void 0 ? _b : "";
    try {
        const { data: searchResponse } = yield axios.get('https://www.googleapis.com/youtube/v3/search', {
            optionsYoutube,
            params: {
                key: API_YOUTUBE,
                maxResults: 20,
                q: query,
                part: 'snippet',
                type: 'video'
            }
        });
        const videoIds = searchResponse.items.map(i => i.id.videoId).join(',');
        const { data: statisticsResponse } = yield axios.get('https://www.googleapis.com/youtube/v3/videos', {
            params: {
                key: API_YOUTUBE,
                id: videoIds,
                part: 'statistics,snippet, player'
            }
        });
        const videos = searchResponse.items.map(searchVideo => {
            var _a, _b, _c, _d, _e, _f, _g;
            const fullVideoInfo = statisticsResponse.items.find(statItem => statItem.id === searchVideo.id.videoId);
            return {
                id: searchVideo.id.videoId,
                title: searchVideo.snippet.title,
                description: searchVideo.snippet.description,
                channelTitle: searchVideo.snippet.channelTitle,
                imagePath: searchVideo.snippet.thumbnails.high.url,
                publishedAt: searchVideo.snippet.publishedAt,
                viewCount: (_a = fullVideoInfo === null || fullVideoInfo === void 0 ? void 0 : fullVideoInfo.statistics.viewCount) !== null && _a !== void 0 ? _a : null,
                likeCount: (_c = (_b = fullVideoInfo === null || fullVideoInfo === void 0 ? void 0 : fullVideoInfo.statistics) === null || _b === void 0 ? void 0 : _b.likeCount) !== null && _c !== void 0 ? _c : null,
                favoriteCount: (_d = fullVideoInfo === null || fullVideoInfo === void 0 ? void 0 : fullVideoInfo.statistics.favoriteCount) !== null && _d !== void 0 ? _d : null,
                commentCount: (_e = fullVideoInfo === null || fullVideoInfo === void 0 ? void 0 : fullVideoInfo.statistics.commentCount) !== null && _e !== void 0 ? _e : null,
                player: (_f = fullVideoInfo === null || fullVideoInfo === void 0 ? void 0 : fullVideoInfo.player.embedHtml) !== null && _f !== void 0 ? _f : null,
                tags: (_g = fullVideoInfo === null || fullVideoInfo === void 0 ? void 0 : fullVideoInfo.snippet.tags) !== null && _g !== void 0 ? _g : []
            };
        });
        res.status(200).json({ message: 'success', code: 200, data: videos });
    }
    catch (e) {
        console.error(e);
        res.status(500).json({ message: 'server error', code: 500 });
    }
}));
app.get('/get-popular-videos', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    try {
        const { data: videoResponse } = yield axios.get('https://www.googleapis.com/youtube/v3/videos', {
            optionsYoutube,
            params: {
                key: API_YOUTUBE,
                maxResults: 20,
                part: 'id,player,statistics,snippet',
                type: 'video',
                chart: 'mostPopular',
                regionCode: 'FR'
            }
        });
        const videos = videoResponse.items.map(v => {
            var _a, _b, _c, _d, _e, _f, _g;
            return {
                id: v.id,
                title: v.snippet.title,
                description: v.snippet.description,
                channelTitle: v.snippet.channelTitle,
                imagePath: v.snippet.thumbnails.high.url,
                publishedAt: v.snippet.publishedAt,
                viewCount: (_a = v === null || v === void 0 ? void 0 : v.statistics.viewCount) !== null && _a !== void 0 ? _a : null,
                likeCount: (_c = (_b = v === null || v === void 0 ? void 0 : v.statistics) === null || _b === void 0 ? void 0 : _b.likeCount) !== null && _c !== void 0 ? _c : null,
                favoriteCount: (_d = v === null || v === void 0 ? void 0 : v.statistics.favoriteCount) !== null && _d !== void 0 ? _d : null,
                commentCount: (_e = v === null || v === void 0 ? void 0 : v.statistics.commentCount) !== null && _e !== void 0 ? _e : null,
                player: (_f = v === null || v === void 0 ? void 0 : v.player.embedHtml) !== null && _f !== void 0 ? _f : null,
                tags: (_g = v === null || v === void 0 ? void 0 : v.snippet.tags) !== null && _g !== void 0 ? _g : []
            };
        });
        res.status(200).json({ message: 'success', code: 200, data: videos });
    }
    catch (e) {
        console.error(e);
        res.status(500).json({ message: 'server error', code: 500 });
    }
}));
app.post("/register", (0, express_validator_1.body)('email').notEmpty().withMessage('required'), (0, express_validator_1.body)('password').notEmpty().withMessage('required'), (0, express_validator_1.body)('pseudo').notEmpty().withMessage('required'), (0, express_validator_1.body)('phone').notEmpty().withMessage('required'), (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const result = (0, express_validator_1.validationResult)(req);
    if (!result.isEmpty()) {
        const formErrors = result.array().map((e) => {
            return {
                type: e.msg,
                field: e.path
            };
        });
        res.status(400).json({ message: 'Le formulaire n\'est pas valide', code: 400, data: formErrors });
        return;
    }
    // TODO Verifier si l'email existe déjà en DB
    // Hasher le mdp
    const newUser = new User_1.default({
        email: req.body.email,
        password: req.body.password,
        pseudo: req.body.pseudo,
        phone: req.body.phone,
        videos: []
    });
    try {
        const userCreated = yield User_1.default.create(newUser);
        if (userCreated) {
            res.status(200).json({ message: 'Utilisateur crée avec succès', code: 200, data: userCreated });
            console.info("Utilisateur crée :", userCreated);
        }
        else {
            res.status(403).json({ message: 'Erreur lors de la création de l\'utilisateur', code: 403 });
        }
    }
    catch (e) {
        res.status(500).json({ message: 'Erreur lors de la création de l\'utilisteur', code: 500 });
        console.error(e);
    }
}));
app.get("/users/detail/:id", (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    if (req.params.id) {
        const user = yield User_1.default.findById(req.params.id);
        if (user) {
            res.status(200).json({ message: "", code: 200, data: user });
        }
    }
}));
app.get("/login", (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const email = req.query.email;
    const password = req.query.password;
    if (email && password) {
        const user = yield User_1.default.findOne({ email });
        if ((user === null || user === void 0 ? void 0 : user.password) === password) {
            //TODO: renvoyer un token
            res.status(200).json({ message: "Vous êtes connecté !", code: 200, data: user });
        }
        else {
            res.status(403).json({ message: 'Impossible de se connecter', code: 403 });
        }
    }
}));
app.post("/users/add-favorite-video", (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const userId = req.body.userId;
    const video = req.body.video;
    if (userId && video) {
        const user = yield User_1.default.findById(userId);
        if (user) {
            const videoAlreadyExist = user.videos.find(v => v.id === video.id);
            if (!videoAlreadyExist) {
                user.videos.push(video);
            }
            yield User_1.default.updateOne(user);
            res.status(200).json({ message: "", code: 200, data: user });
        }
    }
    else {
        res.status(400).json({ message: 'Informations manquantes', code: 400 });
    }
}));
app.post("/users/remove-favorite-video", (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const userId = req.body.userId;
    const video = req.body.video;
    if (userId && video) {
        const user = yield User_1.default.findById(userId);
        if (user) {
            const videoAlreadyExist = user.videos.find(v => v.id === video.id);
            if (videoAlreadyExist) {
                user.videos.splice(user.videos.indexOf(video), 1);
            }
            yield User_1.default.updateOne(user);
            res.status(200).json({ message: "", code: 200, data: user });
        }
    }
    else {
        res.status(400).json({ message: 'Informations manquantes', code: 400 });
    }
}));
app.listen(PORT, () => {
    console.log('Serveur launched on port 3000');
});
