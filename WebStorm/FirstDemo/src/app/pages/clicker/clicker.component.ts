import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clicker',
  imports: [],
  templateUrl: './clicker.component.html',
  styleUrl: './clicker.component.scss'
})
export class ClickerComponent implements OnInit{
  gold: number = 0
  goldMultiplier: number = 1

  peasants: number = 0
  peasantCost: number = 10

  dragon: number = 0
  dragonCost: number = 1000

  dragonUpgrade: number = 5000

  addGold() {
    this.gold += this.goldMultiplier
  }

  addPeasant() {
    if(this.gold >= this.peasantCost) {
      this.peasants++
      this.gold -= this.peasantCost
      this.peasantCost *= 2
    }
  }

  addDragon() {
    if(this.gold >= this.dragonCost) {
      this.dragon++
      this.gold -= this.dragonCost
      this.dragonCost *= 5
    }
  }

  upgradeDragon() {
    if(this.gold >= this.dragonCost) {
      this.dragon++
      this.gold -= this.dragonCost
      this.dragonCost *= 5
    }
  }

  ngOnInit(){
    setInterval(() => {
      this.gold += this.peasants
      this.gold += this.dragon * 1000
    }, 1000)
  }
}
