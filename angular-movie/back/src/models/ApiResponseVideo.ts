export interface ApiResponseVideo {
  kind: string
  etag: string
  items: Video[]
}

export interface Video {
  kind: string
  etag: string
  snippet: Snippet
  statistics: Statistics
  player: Player
}

export interface Snippet {
  publishedAt: string
  channelId: string
  title: string
  description: string
  thumbnails: Thumbnails
  channelTitle: string
  tags: string[]
  categoryId: string
  liveBroadcastContent: string
  defaultLanguage: string
  defaultAudioLanguage: string
}

export interface Thumbnails {
  standard: Standard
}

export interface Standard {
  url: string
  width: number
  height: number
}

export interface Statistics {
  viewCount: string
  likeCount: string
  favoriteCount: string
  commentCount: string
}

export interface Player {
  embedHtml: string
}
