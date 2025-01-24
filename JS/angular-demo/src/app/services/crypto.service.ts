import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CryptoService {

  constructor (private readonly http: HttpClient) { }

  getCrypto (crypto: string): Observable<Object> {
    return this.http.get(`https://api.coinbase.com/v2/exchange-rates?currency=${crypto}`)
  }

  getAllCryptos (): Observable<Object> {
    return this.http.get(`https://api.coinbase.com/v2/currencies/crypto`)
  }
}
