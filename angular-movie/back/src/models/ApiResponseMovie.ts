export interface ApiResponseMovie {
  adult: boolean,
  id: number,
  genre_ids: number[],
  overview: string,
  popularity: number,
  release_date: string,
  vote_average: number,
  vote_count: number,
  poster_path: string,
  background_path: string
  original_language: string,
  original_title: 'string',
  title: string,
  video: boolean,
}