import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  constructor () { }
  title = 'angular-demo'
  firstname: string = "Alex"
  age = 34
  counter: number = 0
  todos: Array<string> = ["dormir", "manger", "boire"]

  incrementCounter () {
    this.counter++
  }
  decrementCounter () {
    if (this.counter > 0) {
      this.counter--
    }
  }
}
