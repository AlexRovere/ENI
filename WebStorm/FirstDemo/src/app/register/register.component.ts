import {Component, inject} from '@angular/core';
import {SharedModule} from '../shared.module';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthService} from '../services/auth.service';

@Component({
  selector: 'app-register',
  imports: [SharedModule, ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  private readonly router: Router = inject(Router)
  private readonly authService: AuthService = inject(AuthService)

  registerForm = new FormGroup({
    email: new FormControl('user@gmail.com', [Validators.required, Validators.email]),
    password: new FormControl('password', Validators.required),
    passwordConfirm: new FormControl('password', Validators.required),
    pseudo: new FormControl('ganu', Validators.required),
    phone: new FormControl('0645659832', Validators.required),
    terms: new FormControl(true, Validators.required)
  })

  onSubmit() {
    if (this.registerForm.valid) {
      this.authService.register(this.registerForm.value)
      this.router.navigate(['/login'])
    }
  }

  protected readonly Object = Object;
}
