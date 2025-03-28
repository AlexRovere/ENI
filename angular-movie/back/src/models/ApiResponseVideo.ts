export interface ApiResponseVideo {
  kind: string
  etag: string
  items: Item[]
  nextPageToken: string
  pageInfo: PageInfo
}

export interface Item {
  kind: string
  etag: string
  id: string
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
  tags?: string[]
  categoryId: string
  liveBroadcastContent: string
  defaultLanguage?: string
  localized: Localized
  defaultAudioLanguage?: string
}

export interface Thumbnails {
  default: Default
  medium: Medium
  high: High
  standard: Standard
  maxres?: Maxres
}

export interface Default {
  url: string
  width: number
  height: number
}

export interface Medium {
  url: string
  width: number
  height: number
}

export interface High {
  url: string
  width: number
  height: number
}

export interface Standard {
  url: string
  width: number
  height: number
}

export interface Maxres {
  url: string
  width: number
  height: number
}

export interface Localized {
  title: string
  description: string
}

export interface Statistics {
  viewCount: string
  likeCount?: string
  favoriteCount: string
  commentCount: string
}

export interface Player {
  embedHtml: string
}

export interface PageInfo {
  totalResults: number
  resultsPerPage: number
}
