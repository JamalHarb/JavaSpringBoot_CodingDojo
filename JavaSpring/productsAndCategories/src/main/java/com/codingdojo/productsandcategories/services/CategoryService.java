package com.codingdojo.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.repositories.CategoryRepo;

@Service
public class CategoryService {
	private CategoryRepo categoryRepo;
	public CategoryService(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	public Category create(Category c) {
		return categoryRepo.save(c);
	}
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		else {
			return null;
		}
	}
	public List<Category> categoriesNotIn(Product p) {
		return categoryRepo.findByProductsNotContains(p);
	}
	public Category update(Category c) {
		return categoryRepo.save(c);
	}
}
