import {Component, computed, effect, inject, OnInit} from '@angular/core';
import {ApiVideoService} from '../../services/api-video.service';
import {RouterLink} from '@angular/router';
import {Video} from '../../models/video';
import {AuthService} from '../../services/auth.service';
import {DatePipe} from '@angular/common';
import {ShortTextPipe} from '../../pipes/short-text.pipe';

@Component({
  selector: 'app-home',
  imports: [
    RouterLink,
    DatePipe,
    ShortTextPipe
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {
  apiVideoService: ApiVideoService = inject(ApiVideoService)
  authService: AuthService = inject(AuthService)


  videos = computed(() => this.apiVideoService.getVideos())

  isVideoFavorite(video: Video) {
    const videosFavorite = this.authService.getUserLogged()?.videos ?? []
    return videosFavorite.some(v => v.id === video.id)
  }

  addFavorite(video: Video) {
    this.authService.addVideoFavorite(video)
  }

  ngOnInit() {
    this.apiVideoService.getPopularVideos()
  }

}
