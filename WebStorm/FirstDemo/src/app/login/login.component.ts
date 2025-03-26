import {Component, inject} from '@angular/core';
import {SharedModule} from '../shared.module';
import {NgForm} from '@angular/forms';
import {AuthService} from '../services/auth.service';
import {Credential} from '../models/credential';
import {Router} from '@angular/router';
import {LocalStorageService} from '../services/local-storage.service';
import {User} from '../models/user';

@Component({
  selector: 'app-login',
  imports: [SharedModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  private authService: AuthService = inject(AuthService)
  private router: Router = inject(Router)
  private localStorageService: LocalStorageService = inject(LocalStorageService)

  users: User[] = this.localStorageService.get('users')
  showUsers: boolean = false

  onSubmit(loginForm: NgForm) {
    if (loginForm.valid) {
      const credential: Credential = {
        email: loginForm.value.email,
        password: loginForm.value.password
      }
      this.authService.login(credential)
      if (this.authService.isAuthenticated()) {
        this.router.navigateByUrl('/products')
      }
    }

  }

}
