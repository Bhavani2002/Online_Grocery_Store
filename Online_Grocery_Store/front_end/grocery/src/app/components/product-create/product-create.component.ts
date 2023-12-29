import { Component } from '@angular/core';
import { ProductService } from '../../sevices/product.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrl: './product-create.component.css'
})
export class ProductCreateComponent {
  productForm:FormGroup;
  constructor(private builder:FormBuilder, 
    private service: ProductService,
    private router: Router) {} 

   ngOnInit(){
   this.productForm = this.builder.group({
     productName: ['',[Validators.required, Validators.pattern('^[a-zA-Z]*$')],
     ],
     productPrice: ['',Validators.required],
     productMfDate: ['',Validators.required],
     productExDate: ['',Validators.required]
   });
  }

  createProduct(){
   if(this.productForm.valid){
     this.service.createProduct(this.productForm.value).subscribe((data) => {
       this.router.navigateByUrl('/product-list');
       console.log(data)
     })
   }else{
     console.log(this.productForm.value)
   }
  }
}
