package com.Tamara.ProductsandCategories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tamara.ProductsandCategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category ,Long>{
	List<Category> findAll();
}
