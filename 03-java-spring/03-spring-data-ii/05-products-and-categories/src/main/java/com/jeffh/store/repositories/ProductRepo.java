package com.jeffh.store.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeffh.store.models.Category;
import com.jeffh.store.models.Product;


@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}
