package com.Tamara.ProductsandCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Tamara.ProductsandCategories.models.Category;
import com.Tamara.ProductsandCategories.models.Product;
import com.Tamara.ProductsandCategories.repository.CategoryRepository;
import com.Tamara.ProductsandCategories.repository.ProductRepository;

@Service
public class ProductCategorieService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	
	public ProductCategorieService (CategoryRepository categoryRepository,ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	public Category createCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
	public Product createProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	public Category findCategoryById(Long id) {
		 Optional<Category> optionalCategory = this.categoryRepository.findById(id);
		 if(optionalCategory.isPresent()) {
			 return optionalCategory.get();
		 }
		 return null;
	}
	
	public Product findProductById(Long id) {
		 Optional<Product> optionalProduct = this.productRepository.findById(id);
		 if(optionalProduct.isPresent()) {
			 return optionalProduct.get();
		 }
		 return null;
	}
	
	public Category addProductToCategory(Product product, Long id){
		Category category = this.findCategoryById(id);
		category.addPoducts(product);
		return this.categoryRepository.save(category);
	}
	
	public Product addCategoryToProduct(Category category, Long id){
		Product product = this.findProductById(id);
		product.addCategories(category);
		return this.productRepository.save(product);
	}
	
	public List<Category> findAllCategory() {
		return this.categoryRepository.findAll();
	}
	public List<Product> findAllProduct(){
		return this.productRepository.findAll();
	}
}
