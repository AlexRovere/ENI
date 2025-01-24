import { Component, inject } from '@angular/core';
import { PostService } from '../../services/post.service';
import { TPost, TDummyApi } from '../../types/TDummyApi';

@Component({
  selector: 'app-posts',
  imports: [],
  templateUrl: './posts.component.html',
  styleUrl: './posts.component.scss'
})
export class PostsComponent {
  private readonly postService: PostService = inject(PostService)

  posts: Array<TPost> = []

  ngOnInit () {
    this.postService.getAllPosts().subscribe({
      next: (data: TDummyApi) => {
        this.posts = data.posts
      },
      error: (err: Error) => {
        console.error(err)
      }
    })
  }
}
