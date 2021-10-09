package com.jeffh.store.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeffh.store.models.Category;
import com.jeffh.store.models.Product;

public interface CategoryRepo extends CrudRepository<Category, Long>{
	List<Category> findAll();
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
}
