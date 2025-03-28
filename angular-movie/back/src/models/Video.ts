export interface Video {
  id: string,
  title: string,
  description: string,
  channelTitle: string,
  imagePath: string,
  publishedAt: string,
  viewCount: string | null
  likeCount: string | null
  favoriteCount: string | null
  commentCount: string | null
  player?: string | null,
  tags: string[]
}