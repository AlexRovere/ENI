export interface TDummyApi {
  posts: TPost[]
  total: number
  skip: number
  limit: number
}

export interface TPost {
  id: number
  title: string
  body: string
  tags: string[]
  reactions: TReactions
  views: number
  userId: number
}

export interface TReactions {
  likes: number
  dislikes: number
}
