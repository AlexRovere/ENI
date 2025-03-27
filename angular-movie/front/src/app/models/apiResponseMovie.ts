import {Video} from './video';

export interface ApiResponseVideo {
  message: string,
  code: number,
  data: {
    kind: string
    etag: string
    items: Video[]
  }
}


