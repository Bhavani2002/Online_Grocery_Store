import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Product } from '../../common/product';
import { ProductService } from '../../sevices/product.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrl: './product-edit.component.css'
})
export class ProductEditComponent {
productForm : FormGroup;
product : Product = new Product();
id:number;

constructor(
  private builder:FormBuilder, 
  private service: ProductService,
  private activatedRoute: ActivatedRoute,
  private router: Router
  ) {} 

  ngOnInit(){
    this.productForm = this.builder.group({
      productName: ['',[Validators.required, Validators.pattern('^[a-zA-Z]*$')],
      ],
      productPrice: ['',Validators.required],
      productMfDate: ['',Validators.required],
      productExDate: ['',Validators.required]
    });
  
    //reading id given in the ListComponent onclick of Edit Button
     this.id = this.activatedRoute.snapshot.params['id'];

     this.service.getProduct(this.id).subscribe((data) => {
      this.product = data;
      console.log(data);
     });
   }
   

   updateProduct(){
    if(confirm("Are you sure to update?")){
    this.service.updateProduct(this.product).subscribe((data) => {
      alert("Product is updated")
      this.router.navigateByUrl('product-list');
    });
   }

  }
}

