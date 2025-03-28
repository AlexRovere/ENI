import {Component, inject, OnInit} from '@angular/core';
import {ApiVideoService} from '../../services/api-video.service';
import { DomSanitizer } from '@angular/platform-browser';
import {Video} from '../../models/video';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-video',
  imports: [
  ],
  templateUrl: './video.component.html',
  styleUrl: './video.component.scss'
})
export class VideoComponent implements OnInit{
  private readonly route = inject(ActivatedRoute)
  private readonly router = inject(Router)
  private readonly apiVideoService: ApiVideoService = inject(ApiVideoService)
  private readonly sanitizer: DomSanitizer = inject(DomSanitizer)
  video?: Video | null = null

  getVideoUrl() {
    if(this.video?.player) {
      const videoUrl = `https://www.youtube.com/embed/${this.video.id}`
      return this.sanitizer.bypassSecurityTrustResourceUrl(videoUrl)
    }
    return null
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = params['id']
      if(id) {
        let video = this.apiVideoService.getVideos().find(v => v.id === id)
        if(video) {
          this.video = video
        } else {
          this.router.navigateByUrl('/')
        }
      }
    })
  }

}
