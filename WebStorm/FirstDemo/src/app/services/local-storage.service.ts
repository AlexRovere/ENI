import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  get(key: string): any {
    return JSON.parse(<string>localStorage.getItem(key))
  }

  set(key: string, value: string) {
    localStorage.setItem(key, JSON.stringify(value))
  }

  has(key: string): boolean {
    return !!localStorage.getItem(key);
  }
}
