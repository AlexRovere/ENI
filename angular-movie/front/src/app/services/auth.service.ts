import {inject, Injectable, signal} from '@angular/core';
import {User} from '../models/user';
import {HttpClient} from '@angular/common/http';
import {ApiResponse} from '../models/apiResponse';
import {Observable, tap} from 'rxjs';
import {Video} from '../models/video';
import {ApiVideoService} from './api-video.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly apiVideoService: ApiVideoService = inject(ApiVideoService)
  private readonly http: HttpClient = inject(HttpClient);
  private readonly api: string = "http://localhost:3000"

  private _userLogged = signal<User | null>(null)
  private _isAuthenticated = signal<boolean>(false);

  isAuthenticated(): boolean {
    return this._isAuthenticated();
  }

  getUserLogged(): User | null {
    return this._userLogged();
  }

  login(user: User): Observable<ApiResponse<User>> {
    return this.http.get<ApiResponse<User>>(`${this.api}/login`, {
      params: {
        email: user.email,
        password: user.password
      }
    }).pipe(
      tap({
        next: (response) => {
          this._userLogged.set(response.data);
          this._isAuthenticated.set(true);
        },
        error: (error) => {
          this._isAuthenticated.set(false);
          console.error(error);
        }
      })
    );
  }

  logout() {
    this._isAuthenticated.set(false)
    this._userLogged.set(null)
  }

  register(user: any) {
    this.http.post<ApiResponse<User>>(`${this.api}/register`, user).subscribe({
      next: (response) => {
      },
      error: (error: Error) => {
        console.error(error)
      }
    })
  }

  addVideoFavorite(video: Video) {
    const foundVideo = this._userLogged()?.videos?.find(v => v.id === video.id)
    const userId = this._userLogged()?._id

    if(userId  && !foundVideo) {
      this.apiVideoService.addVideoFavorite(video, userId)

      const currentVideos = this._userLogged()?.videos || []

      const updatedVideos = [
        ...currentVideos,
        video]
      this._userLogged.set({
        ...this._userLogged() as User,
        videos: updatedVideos
      })
    }
  }

  removeVideoFavorite(video: Video) {
    const foundVideo = this._userLogged()?.videos?.find(v => v.id === video.id)
    const userId = this._userLogged()?._id

    if(userId  && foundVideo) {
      this.apiVideoService.removeVideoFavorite(video, userId)

      const currentVideos = this._userLogged()?.videos || []
      const updatedVideos = currentVideos.filter(v => v.id !== video.id);

      this._userLogged.set({
        ...this._userLogged() as User,
        videos: updatedVideos
      })
    }
  }

}
