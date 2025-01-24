import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor (private readonly http: HttpClient) { }

  getAllPokemons (): Observable<Object> {
    return this.http.get(`https://pokebuildapi.fr/api/v1/pokemon/limit/10`)
  }
}
