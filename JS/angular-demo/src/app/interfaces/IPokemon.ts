export interface IPokemon {
  id: number
  pokedexId: number
  name: string
  image: string
  sprite: string
  slug: string
  stats: Stats
  apiTypes: ApiType[]
  apiGeneration: number
  apiResistances: ApiResistance[]
  resistanceModifyingAbilitiesForApi: any[]
  apiEvolutions: ApiEvolution[]
  apiPreEvolution: string
  apiResistancesWithAbilities: any[]
}

interface Stats {
  HP: number
  attack: number
  defense: number
  special_attack: number
  special_defense: number
  speed: number
}

interface ApiType {
  name: string
  image: string
}

interface ApiResistance {
  name: string
  damage_multiplier: number
  damage_relation: string
}

interface ApiEvolution {
  name: string
  pokedexId: number
}
