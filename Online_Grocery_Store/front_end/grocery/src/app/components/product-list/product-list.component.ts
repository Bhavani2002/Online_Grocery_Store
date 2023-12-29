import { Component } from '@angular/core';
import { Product } from '../../common/product';
import { Router } from '@angular/router';
import { ProductService } from '../../sevices/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

  products: Product[]

  constructor (private service :ProductService, private router: Router){}

  showEdit(id:number){
     this.router.navigate(['product-edit', id]);
  }

  getProducts() {
   this.service.getProducts().subscribe((data)=> {
      this.products = data;
      console.log(data)
    });
  }

  ngOnInit(){
    this.getProducts();
  }

  deleteProducts(id:number){
   if(confirm("Are you sure delete this product?")){
    this.service.deleteProduct(id).subscribe((data) =>{
      this.getProducts();
    });
   } 
  }
  
}
