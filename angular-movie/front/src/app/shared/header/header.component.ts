import {Component, computed, inject} from '@angular/core';
import {ActivatedRoute, Route, Router, RouterLink} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {ApiVideoService} from '../../services/api-video.service';

@Component({
  selector: 'app-header',
  imports: [
    RouterLink
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  private readonly router: Router = inject(Router)
  private readonly authService: AuthService = inject(AuthService)
  private readonly apiVideo: ApiVideoService = inject(ApiVideoService)

  logoPath: string = "images/logo.jpg"

  searchVideo(search: string) {
    if(this.router.url !== '/') {
      this.router.navigateByUrl('/')
    }
    this.apiVideo.searchVideo(search)
  }

  isAuthenticated = computed(() => this.authService.isAuthenticated())

  userLogged = computed(() => this.authService.getUserLogged())

  logout() {
    this.authService.logout()
    this.router.navigateByUrl('/login')
  }
}
