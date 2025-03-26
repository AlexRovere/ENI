import {Component, inject, OnInit} from '@angular/core';
import {ProductsService} from '../../services/products.service';
import {Product} from '../../models/product';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-products',
  imports: [RouterLink],
  templateUrl: './products.component.html',
  styleUrl: './products.component.scss'
})
export class ProductsComponent implements OnInit{
    productsService: ProductsService = inject(ProductsService)
  products?: Product[]

  ngOnInit(): void {
    this.products = this.productsService.products
  }

}
