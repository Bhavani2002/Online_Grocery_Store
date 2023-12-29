package com.edubridge.app1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.app1.model.Product;
import com.edubridge.app1.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping("/product")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		Product savedProduct = service.saveProduct(product);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@GetMapping("/product")
	public ResponseEntity<?> getAllProducts() {
		List<Product> productList = service.getProducts();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	// http://localhost:8181/myapp/api/product/2
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getSingleProduct(@PathVariable Integer id) {
		Product product = service.getProduct(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PutMapping("/product")
	public ResponseEntity<Product> update(@RequestBody Product product) {
		service.updateProduct(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
