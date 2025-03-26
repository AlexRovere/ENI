import {Component, computed, inject, Input, signal} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {User} from '../../models/user';

@Component({
  selector: 'app-header',
  imports: [
    RouterLink
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  authService: AuthService = inject(AuthService)
  router: Router = inject(Router)

  isAuthenticated = computed(() => this.authService.isAuthenticated())

  userLogged = computed(() => this.authService.getUserLogged())

  logout() {
    this.authService.logout()
    this.router.navigateByUrl('/login')
  }
}
