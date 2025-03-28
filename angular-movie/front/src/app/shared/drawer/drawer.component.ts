import {Component, computed, inject} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Video} from '../../models/video';

@Component({
  selector: 'app-drawer',
  imports: [
  ],
  templateUrl: './drawer.component.html',
  styleUrl: './drawer.component.scss'
})
export class DrawerComponent {
  authService: AuthService = inject(AuthService)

  userLogged = computed(() => this.authService.getUserLogged())

  removeVideoFavorite(video: Video) {
    this.authService.removeVideoFavorite(video)
  }

}
