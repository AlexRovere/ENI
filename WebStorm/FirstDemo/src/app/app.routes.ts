import { Routes } from '@angular/router';
import {HomeComponent} from './pages/home/home.component';
import {ImageToggleComponent} from './pages/image-toggle/image-toggle.component';
import {ClickerComponent} from './pages/clicker/clicker.component';
import {TodoListComponent} from './pages/todo-list/todo-list.component';
import {ProductsComponent} from './pages/products/products.component';
import {ProductComponent} from './pages/product/product.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {AuthGuard} from './guards/auth.guard';

export const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "image", component: ImageToggleComponent},
  {path: "clicker", component: ClickerComponent},
  {path: "todo",  component: TodoListComponent},
  {path: "products",  component: ProductsComponent, canActivate: [AuthGuard]},
  {path: "products/:id",  component: ProductComponent, canActivate: [AuthGuard]},
  {path: "login",  component: LoginComponent},
  {path: "register",  component: RegisterComponent}
];
