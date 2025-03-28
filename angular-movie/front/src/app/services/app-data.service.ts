import {Injectable, signal} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppDataService {

  showDrawer = signal(false)

  toggleDrawer() {
    this.showDrawer.set(!this.showDrawer())
  }
}
