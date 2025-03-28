import {Component, computed, inject, OnInit} from '@angular/core';
import {Router, RouterOutlet} from '@angular/router';
import {initFlowbite} from 'flowbite';
import {FooterComponent} from './shared/footer/footer.component';
import {HeaderComponent} from './shared/header/header.component';
import {DrawerComponent} from './shared/drawer/drawer.component';
import {AuthService} from './services/auth.service';
import {AppDataService} from './services/app-data.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent, FooterComponent, DrawerComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit{
  ngOnInit(): void {
    initFlowbite();
  }
  authService: AuthService = inject(AuthService)
  appDataService: AppDataService = inject(AppDataService)

  showDrawer = computed(() => this.appDataService.showDrawer())
  isAuthenticated = computed(() => this.authService.isAuthenticated())
}
