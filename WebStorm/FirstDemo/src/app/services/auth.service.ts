import {inject, Injectable, signal} from '@angular/core';
import {Credential} from '../models/credential';
import {LocalStorageService} from './local-storage.service';
import {User} from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private localStorageService: LocalStorageService = inject(LocalStorageService)

  private _userLogged = signal<User | null>(null)
  private _isAuthenticated = signal<boolean>(false);

  isAuthenticated(): boolean {
    return this._isAuthenticated();
  }

  getUserLogged(): User | null {
    return this._userLogged();
  }

  login(credential: Credential): string {
    const users: User[] = this.localStorageService.get('users')
    const user: User | undefined = users.find(u => u.email === credential.email && u.password === credential.password)
    if(user) {
      this._isAuthenticated.set(true)
      this._userLogged.set(user)
      return "Connecté"
    } else {
      this._isAuthenticated.set(false)
      this._userLogged.set(null)
      return "Erreur lors de la connexion"
    }
  }

  logout() {
    this._isAuthenticated.set(false)
    this._userLogged.set(null)
  }

  register(user: any) {
    const users = this.localStorageService.has('users') ? this.localStorageService.get('users') : []
    // TODO : vérifier si l'utilisateur existe déjà
    users.push(user)
    this.localStorageService.set('users', users)
  }
}
