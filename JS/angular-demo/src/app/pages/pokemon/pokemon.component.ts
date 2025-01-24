import { Component, Input, SimpleChange, SimpleChanges } from '@angular/core';
import { IPokemon } from '../../interfaces/IPokemon';
import { PokemonService } from '../../services/pokemon.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-pokemon',
  imports: [CommonModule, FormsModule],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.scss'
})
export class PokemonComponent {
  constructor (private readonly pokemonService: PokemonService) { }
  pokemons: Array<IPokemon> = []
  search: string = ""

  ngOnInit () {
    this.pokemonService.getAllPokemons()
      .subscribe(data => {
        this.pokemons = data as IPokemon[]
      });
  }

  // Watch Vue
  get filteredPokemons () {
    return this.pokemons.filter(p => this.search ? p.name.toLowerCase().includes(this.search.toLowerCase()) : this.pokemons)
  }
}
