import {inject, Injectable, signal} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Video} from '../models/video';
import {ApiResponseVideo} from '../models/apiResponseMovie';

@Injectable({
  providedIn: 'root'
})
export class ApiVideoService {
  private readonly http: HttpClient = inject(HttpClient);
  private readonly api: string = "http://localhost:3000"

  private videos = signal<Video[]>([])

  getVideos(): Video[] {
    return this.videos()
  }

  searchVideo(query: string) {
    this.http.get<ApiResponseVideo>(`${this.api}/find-videos`, {params: {query: query.replace(/ /g, '+')}}).subscribe({
      next: (response) => {
        console.log(response)
        this.videos.set(response.data.items)
      },
      error: (error: Error) => {
        console.error(error)
      }
    })
  }

  getPopularVideos() {
    this.http.get<ApiResponseVideo>(`${this.api}/get-popular-videos`).subscribe({
      next: (response) => {
        this.videos.set(response.data.items)
      },
      error: (error: Error) => {
        console.error(error)
      }
    })
  }
}


