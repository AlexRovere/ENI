class Voiture {
  #km: number
  #marque: string
  #modele: string
  moteur: string | null

  constructor (km: number, marque: string, modele: string) {
    this.#km = km
    this.#marque = marque
    this.#modele = modele
  }

  toString () {
    return `km : ${this.#km} marque : ${this.#marque} modele : ${this.#marque} `
  }

  getKm () {
    return this.#km
  }


}

let mazda = new Voiture(100, "mazda", "6")

console.log(mazda.toString())