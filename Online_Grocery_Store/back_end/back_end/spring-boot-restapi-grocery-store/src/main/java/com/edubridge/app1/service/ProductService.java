package com.edubridge.app1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edubridge.app1.model.Product;
import com.edubridge.app1.repo.ProductRepository;

@Service
public class ProductService {
	@Autowired
    private ProductRepository repo;
	
	public Product saveProduct(Product product) {
		return repo.save(product);
	}
	
	public List<Product> getProducts(){
		return repo.findAll();
	}
	
	public Product getProduct(Integer id) {
		return repo.findById(id).get();
	}
	
	public void updateProduct(Product product) {
		repo.save(product);
	}
	
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}
}