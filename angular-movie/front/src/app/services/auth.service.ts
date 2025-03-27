import {Injectable, signal} from '@angular/core';
import {User} from '../models/user';

@Injectable({
    providedIn: 'root'
})
export class AuthService {

    private _userLogged = signal<User | null>(null)
    private _isAuthenticated = signal<boolean>(false);
    private fakeUsers: User[] = [
        {
            email: 'wormz91@hotmail.fr',
            password: 'password',
            pseudo: 'ganu',
            phone: '0645896487'
        }
    ]

    isAuthenticated(): boolean {
        return this._isAuthenticated();
    }

    getUserLogged(): User | null {
        return this._userLogged();
    }

    login(user: User) {
        // TODO : CALL API
        const userFound = this.fakeUsers.find(f => f.email === user.email && f.password === user.password)
        if (userFound) {
            this._isAuthenticated.set(true)
            this._userLogged.set(user)
        } else {
            this._isAuthenticated.set(false)
            this._userLogged.set(null)
        }
    }

    logout() {
        this._isAuthenticated.set(false)
        this._userLogged.set(null)
    }

    register(user: any) {
        // TODO : CALL API
        this.fakeUsers.push(user)
    }
}
