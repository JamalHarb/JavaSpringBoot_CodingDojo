package com.codingdojo.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.services.CategoryService;
import com.codingdojo.productsandcategories.services.ProductService;

@Controller
public class AppController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public AppController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("products", productService.allProducts());
		model.addAttribute("categories", categoryService.allCategories());
		return "home.jsp";
	}
	@GetMapping("/products/new")
	public String productForm(@ModelAttribute("product") Product product) {
		return "new_product.jsp";
	}
	@PostMapping("/products/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "new_product.jsp";
		}
		else {
			productService.create(product);
			return "redirect:/";
		}
	}
	@GetMapping("/categories/new")
	public String categoryForm(@ModelAttribute("category") Category category) {
		return "new_category.jsp";
	}
	@PostMapping("/categories/create")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "new_category.jsp";
		}
		else {
			categoryService.create(category);
			return "redirect:/";
		}
	}
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		List<Category> categoriesNotIn = categoryService.categoriesNotIn(product);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoriesNotIn);
		return "show_product.jsp";
	}
	@PostMapping("/products/{id}/add_category")
	public String assignCategoryToProduct(@PathVariable("id") Long id, @RequestParam(name="categories") Long categoryId) {
		Product product = productService.findProduct(id);
		List<Category> categories = product.getCategories();
		Category category = categoryService.findCategory(categoryId);
		categories.add(category);
		product.setCategories(categories);
		productService.update(product);
		return "redirect:/products/{id}";
	}
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		List<Product> productsNotIn = productService.productsNotInCategory(category);
		model.addAttribute("category", category);
		model.addAttribute("products", productsNotIn);
		return "show_category.jsp";
	}
	@PostMapping("/categories/{id}/add_product")
	public String assignProductToCategory(@PathVariable("id") Long id, @RequestParam(name="products") Long productId) {
		Category category = categoryService.findCategory(id);
		List<Product> products = category.getProducts();
		Product product = productService.findProduct(productId);
		products.add(product);
		category.setProducts(products);
		categoryService.update(category);
		return "redirect:/categories/{id}";
	}
}
