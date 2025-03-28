import { Routes } from '@angular/router';
import {RegisterComponent} from './pages/register/register.component';
import {LoginComponent} from './pages/login/login.component';
import {HomeComponent} from './pages/home/home.component';
import {VideoComponent} from './pages/video/video.component';

export const routes: Routes = [
  {path: "",  component: HomeComponent},
  {path: "video/:id",  component: VideoComponent},
  {path: "login",  component: LoginComponent},
  {path: "register",  component: RegisterComponent},
  {path: "**",  component: HomeComponent}
];
