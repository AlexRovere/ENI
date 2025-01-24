import { Component } from '@angular/core';
import { BehaviorSubject, Subscription } from 'rxjs';
import { CryptoService } from '../../services/crypto.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-crypto',
  imports: [FormsModule, CommonModule],
  templateUrl: './crypto.component.html',
  styleUrl: './crypto.component.scss'
})
export class CryptoComponent {
  constructor (private readonly cryptoService: CryptoService) {

  }
  title = 'angular-demo'
  firstname: string = "Alex"
  age = 34
  counter: number = 0
  todos: Array<string> = ["dormir", "manger", "boire"]
  crypto: BehaviorSubject<string> = new BehaviorSubject<string>("BTC")
  selectedCrypto: string = "BTC"
  cryptoSubscription: Subscription = new Subscription()
  price!: number
  cryptos: Array<any> = []

  ngOnInit () {
    this.getAllCryptos()
    this.cryptoSubscription = this.crypto.subscribe(val => {
      this.getCryptoPrice(val)
    })
  }

  ngOnDestroy (): void {
    if (this.cryptoSubscription) {
      this.cryptoSubscription.unsubscribe();
    }
  }

  getAllCryptos () {
    this.cryptoService.getAllCryptos().subscribe({
      next: (data: any) => {
        this.cryptos = data.data.map((e: any) => {
          return {
            label: e.name,
            value: e.code
          }
        })
      }
    })
  }

  getCryptoPrice (crypto: string) {
    this.cryptoService.getCrypto(crypto).subscribe({
      next: (data: any) => {
        this.price = data.data.rates.EUR
      }
    })
  }

  changeCrypto (newCrypto: string): void {
    this.crypto.next(newCrypto)
    this.selectedCrypto = newCrypto
  }

}

