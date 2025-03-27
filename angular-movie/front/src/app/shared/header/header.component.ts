import {Component, computed, inject} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
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
  apiVideo: ApiVideoService = inject(ApiVideoService)
  logoPath: string = "images/logo.jpg"

  searchVideo(search: string) {
    this.apiVideo.searchVideo(search)
  }
  authService: AuthService = inject(AuthService)
  router: Router = inject(Router)

  isAuthenticated = computed(() => this.authService.isAuthenticated())

  userLogged = computed(() => this.authService.getUserLogged())

  logout() {
    this.authService.logout()
    this.router.navigateByUrl('/login')
  }
}
