import {Component, inject, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ProductsService} from '../../services/products.service';
import {Product} from '../../models/product';

@Component({
  selector: 'app-product',
  imports: [],
  templateUrl: './product.component.html',
  styleUrl: './product.component.scss'
})
export class ProductComponent implements OnInit{
  private route = inject(ActivatedRoute)
  productsService: ProductsService = inject(ProductsService)

  id: number = 0
  product?: Product

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = +params['id']
      if(this.id) {
        this.product = this.productsService.products.find(p => p.id === this.id)
      }
    })
  }

}
