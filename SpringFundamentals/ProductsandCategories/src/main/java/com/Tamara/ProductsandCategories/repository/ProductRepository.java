package com.Tamara.ProductsandCategories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tamara.ProductsandCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
	List<Product> findAll();
}
