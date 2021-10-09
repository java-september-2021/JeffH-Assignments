package com.jeffh.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jeffh.store.models.Category;
import com.jeffh.store.models.Product;
import com.jeffh.store.repositories.CategoryRepo;

@Service
public class CategoryService {
	private final CategoryRepo categoryRepo;
	
	public CategoryService(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	
    public Category createCategory(Category b) {
        return categoryRepo.save(b);
    }
    
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
	public List<Category> notAddedCategories(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
    public void addProdToCat(Product product, Category category) {
    	List<Product> existingProds = category.getProducts();
    	existingProds.add(product);
    	this.categoryRepo.save(category);
    }
}
