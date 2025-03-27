import {Component} from '@angular/core';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [
    RouterLink
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  logoPath: string = "images/logo.jpg"

  searchVideo(search: string) {
    console.log(search)
  }
  // authService: AuthService = inject(AuthService)
  // router: Router = inject(Router)
  //
  // isAuthenticated = computed(() => this.authService.isAuthenticated())
  //
  // userLogged = computed(() => this.authService.getUserLogged())
  //
  // logout() {
  //   this.authService.logout()
  //   this.router.navigateByUrl('/login')
  // }
}
