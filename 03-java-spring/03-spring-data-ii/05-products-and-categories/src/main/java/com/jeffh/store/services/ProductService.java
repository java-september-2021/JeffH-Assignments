package com.jeffh.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jeffh.store.models.Category;
import com.jeffh.store.models.Product;
import com.jeffh.store.repositories.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo productRepo;
	
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
    public Product createProduct(Product b) {
        return productRepo.save(b);
    }
    
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
    
    public void addCatToProd(Product product, Category category) {
    	List<Category> existingCats = product.getCategories();
    	existingCats.add(category);
    	this.productRepo.save(product);
    }
    
	public List<Product> notAddedProducts(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
}
