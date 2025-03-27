import {Component, inject} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {FormsModule, NgForm} from '@angular/forms';
import {User} from '../../models/user';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-login',
  imports: [
    RouterLink,
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  private authService: AuthService = inject(AuthService)
  private router: Router = inject(Router)

  errorLogin: string = ""

  onSubmit(loginForm: NgForm) {
    this.errorLogin = ""
    if (loginForm.valid) {
      const user: User = {
        email: loginForm.value.email,
        password: loginForm.value.password
      }
      this.authService.login(user)
      if (this.authService.isAuthenticated()) {
        this.router.navigateByUrl('/')
      } else {
        this.errorLogin = "Login et/ou mot de passe invalide"
      }
    }
  }

}
