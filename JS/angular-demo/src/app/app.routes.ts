import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { PokemonComponent } from './pages/pokemon/pokemon.component';
import { CryptoComponent } from './pages/crypto/crypto.component';
import { PostsComponent } from './pages/posts/posts.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'crypto', component: CryptoComponent },
  { path: 'post', component: PostsComponent },
  { path: 'pokemon', component: PokemonComponent },
];
