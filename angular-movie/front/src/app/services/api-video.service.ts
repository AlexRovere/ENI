import {inject, Injectable, signal} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Video} from '../models/video';
import {ApiResponse} from '../models/apiResponse';

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
    this.http.get<ApiResponse<Video[]>>(`${this.api}/find-videos`, {params: {query: query.replace(/ /g, '+')}}).subscribe({
      next: (response) => {
        this.videos.set(response.data)
      },
      error: (error: Error) => {
        console.error(error)
      }
    })
  }

  getPopularVideos() {
    this.http.get<ApiResponse<Video[]>>(`${this.api}/get-popular-videos`).subscribe({
      next: (response) => {
        this.videos.set(response.data)
      },
      error: (error: Error) => {
        console.error(error)
      }
    })
  }

  addVideoFavorite(video: Video, userId: string) {
    this.http.post<ApiResponse<null>>(`${this.api}/users/add-favorite-video`, {
        video,
        userId
    }).subscribe({
      next: (response) => {
        console.log(response)
      },
      error: (error: Error) => {
        console.error(error)
      }
    })
  }

  removeVideoFavorite(video: Video, userId: string) {
    this.http.post<ApiResponse<null>>(`${this.api}/users/remove-favorite-video`, {
      video,
      userId
    }).subscribe({
      next: (response) => {
        console.log(response)
      },
      error: (error: Error) => {
        console.error(error)
      }
    })
  }
}


