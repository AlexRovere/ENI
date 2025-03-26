import { Injectable } from '@angular/core';
import {Product} from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor() { }

  products: Product[] = [
    {id: 1,title: "chaussette"},
    {id: 2,title: "ballon"},
    {id: 3,title: "chaussette"},
    {id: 4,title: "baton"}
  ]
}
