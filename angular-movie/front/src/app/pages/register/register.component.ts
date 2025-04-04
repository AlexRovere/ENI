import {Component, inject} from '@angular/core';
import {SharedModule} from '../../shared.module';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthService} from '../../services/auth.service'
import {confirmPasswordValidator} from '../../validators/confimPasswordValidator';
import {User} from '../../models/user';

@Component({
  selector: 'app-register',
  imports: [SharedModule, ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  private readonly router: Router = inject(Router)
  private readonly authService: AuthService = inject(AuthService)

  emailControl = new FormControl('user@gmail.com', [Validators.required, Validators.email])
  passwordControl = new FormControl('password', [Validators.required, Validators.minLength(6)])
  passwordConfirmControl = new FormControl('password', [Validators.required])
  pseudoControl = new FormControl('ganu', Validators.required)
  phoneControl = new FormControl('0645659832', Validators.required)
  termsControl = new FormControl(true, Validators.required)

  registerForm = new FormGroup({
      email: this.emailControl,
      pseudo: this.pseudoControl,
      phone: this.phoneControl,
      terms: this.termsControl,
      passwordGroup: new FormGroup({
          password: this.passwordControl,
          passwordConfirm: this.passwordConfirmControl,
        },{validators: confirmPasswordValidator}
      )
    },
  )

   onSubmit() {
    if (this.registerForm.valid) {
      const user: User = {
        email:  this.registerForm.value.email ?? '',
        password:  this.registerForm.value.passwordGroup?.password ?? '',
        pseudo:  this.registerForm.value.pseudo ?? '',
        phone:  this.registerForm.value.phone  ?? '',
      }
      this.authService.register(user)
      // TODO: Gérer les erreurs du back
      this.router.navigate(['/login'])
    }
  }
}
