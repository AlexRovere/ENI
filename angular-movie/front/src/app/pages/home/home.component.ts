import {Component, computed, effect, inject, OnInit} from '@angular/core';
import {ApiVideoService} from '../../services/api-video.service';
import {RouterLink} from '@angular/router';
import {Video} from '../../models/video';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-home',
  imports: [
    RouterLink
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {
  apiVideoService: ApiVideoService = inject(ApiVideoService)
  authService: AuthService = inject(AuthService)


  videos = computed(() => this.apiVideoService.getVideos())

  addFavorite(video: Video) {
    this.authService.addVideoFavorite(video)
  }

  ngOnInit() {
    this.apiVideoService.getPopularVideos()
  }

}
