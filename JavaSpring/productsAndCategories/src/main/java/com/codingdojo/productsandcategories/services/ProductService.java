package com.codingdojo.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.repositories.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo productRepo;
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	public Product create(Product p) {
		return productRepo.save(p);
	}
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}
	}
	public List<Product> productsNotInCategory(Category c) {
		return productRepo.findByCategoriesNotContains(c);
	}
	public Product update(Product p) {
		return productRepo.save(p);
	}
}
