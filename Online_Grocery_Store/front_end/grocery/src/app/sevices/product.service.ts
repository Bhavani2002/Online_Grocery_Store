import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  basePath:string = "http://localhost:8181/myapp/api/product"

  constructor(private http : HttpClient) { }

  getProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(this.basePath);
  }

  createProduct(product:Product):Observable<Product>{
    return this.http.post<Product>(this.basePath,product)
  }

  deleteProduct(id: number):Observable<any> {
    return this.http.delete(`${this.basePath}/${id}`);
  }

  getProduct(id: number):Observable<Product>{
    return this.http.get<Product>(`${this.basePath}/${id}1`);
  }

  updateProduct(product: Product):Observable<any>{
    return this.http.put(this.basePath,product);
  }
}
