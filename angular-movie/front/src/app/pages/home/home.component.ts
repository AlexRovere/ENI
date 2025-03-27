import {Component, computed, effect, inject, OnInit} from '@angular/core';
import {ApiVideoService} from '../../services/api-video.service';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {
  apiVideo: ApiVideoService = inject(ApiVideoService)


  videos = computed(() => this.apiVideo.getVideos())



  ngOnInit() {
    this.apiVideo.getPopularVideos()
  }


  // videos: any[] = [
  //   {
  //     id: 1,
  //     imgPath: "images/logo.jpg"
  //   },
  //   {
  //     id: 2,
  //     imgPath: "images/logo.jpg"
  //   },
  //   {
  //     id: 3,
  //     imgPath: "images/logo.jpg"
  //   }
  // ]

}
