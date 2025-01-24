import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { TDummyApi } from '../types/TDummyApi';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private readonly http: HttpClient = inject(HttpClient);

  getAllPosts (): Observable<TDummyApi> {
    return this.http.get(environment.api_url_post) as Observable<TDummyApi>
  }
}
