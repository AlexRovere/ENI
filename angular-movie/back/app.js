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
const app = (0, express_1.default)();
const port = 3000;
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
        const { data } = yield axios.get(`https://www.googleapis.com/youtube/v3/search?key=${API_YOUTUBE}&maxResults=20&q=${query}&part=snippet`, optionsYoutube);
        res.status(200).json({ message: 'success', code: 200, data });
    }
    catch (e) {
        console.error(e);
        res.status(500).json({ message: 'server error', code: 500 });
    }
}));
app.get('/get-popular-videos', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    try {
        const { data } = yield axios.get(`https://www.googleapis.com/youtube/v3/videos?key=${API_YOUTUBE}&maxResults=20&chart=mostPopular&regionCode=FR&part=id,player,statistics,snippet`, optionsYoutube);
        res.status(200).json({ message: 'success', code: 200, data });
    }
    catch (e) {
        console.error(e);
        res.status(500).json({ message: 'server error', code: 500 });
    }
}));
app.listen(port, () => {
    console.log('Serveur launched on port 3000');
});
