import { Component } from '@angular/core';
import { IRouter } from '../../interfaces/IRouter';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [RouterLink],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  menu: Array<IRouter> = [
    {
      name: 'accueil',
      path: '/'
    },
    {
      name: "pokemons",
      path: "/pokemon"
    },
    {
      name: "cryptos",
      path: "/crypto"
    },
    {
      name: "articles",
      path: "/post"
    }
  ]
}
