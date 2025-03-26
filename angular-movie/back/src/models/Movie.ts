export interface Movie {
  id: number,
  categories: number[],
  title: string,
  description: string,
  popularity: number,
  releaseAt: Date,
  voteAverage: number,
  voteCount: number,
  posterPath: string,
  backgroundPath: string
}