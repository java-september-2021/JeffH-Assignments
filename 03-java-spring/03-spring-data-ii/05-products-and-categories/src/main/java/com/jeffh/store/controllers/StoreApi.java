package com.jeffh.store.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeffh.store.models.Category;
import com.jeffh.store.models.Product;
import com.jeffh.store.services.CategoryService;
import com.jeffh.store.services.ProductService;

@Controller
public class StoreApi {
	
	private final ProductService productService;
	private final CategoryService categoryService;
    public StoreApi(ProductService productService, CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
    }
    
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    @RequestMapping("/products/new")
    public String newProduct(Model model) {
    	model.addAttribute("product", new Product());
        return "products/newProduct.jsp";
    }
    
    @RequestMapping(value="/products/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "products/newProduct.jsp";
        } else {
            productService.createProduct(product);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/categories/new")
    public String newCategory(Model model) {
    	model.addAttribute("category", new Category());
        return "categories/newCategory.jsp";
    }
    
    @RequestMapping(value="/categories/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "categories/newCategory.jsp";
        } else {
            categoryService.createCategory(category);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/products/all")
    public String allProducts(Model model) {
    	List<Product> products = productService.allProducts();
    	model.addAttribute("products", products);
        return "products/allProducts.jsp";
    }
    
    @RequestMapping("/categories/all")
    public String allCategories(Model model) {
    	List<Category> categories = categoryService.allCategories();
    	model.addAttribute("categories", categories);
        return "categories/allCategories.jsp";
    }
    
    @RequestMapping("/products/{id}")
    public String product(@PathVariable("id") Long id, Model model) {
        Product product = productService.findProduct(id);
        List<Category> notAddedcategories = categoryService.notAddedCategories(product);
        model.addAttribute("product", product);
        model.addAttribute("notAddedCategories", notAddedcategories);
        return "/products/product.jsp";
    }
    
    @RequestMapping(value="/products/addCatToProd/{id}", method=RequestMethod.POST)
    public String addCategory(@RequestParam("categories") Long id, @PathVariable("id") Long productId) {
    	Product productToAddCatTo = productService.findProduct(productId);
    	Category categoryToAdd = categoryService.findCategory(id);
    	productService.addCatToProd(productToAddCatTo, categoryToAdd);
    	return "redirect:/products/{id}";
    	
    }
    
    @RequestMapping("/categories/{id}")
    public String category(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.findCategory(id);
        List<Product> notAddedProducts = productService.notAddedProducts(category);
        model.addAttribute("category", category);
        model.addAttribute("notAddedProducts", notAddedProducts);
        return "/categories/category.jsp";
    }
    
    @RequestMapping(value="/categories/addProdToCat/{id}", method=RequestMethod.POST)
    public String addProduct(@RequestParam("products") Long id, @PathVariable("id") Long categoryId) {
    	Product productToAdd = productService.findProduct(id);
    	Category catToAddProdTo = categoryService.findCategory(categoryId);
    	categoryService.addProdToCat(productToAdd, catToAddProdTo);
    	return "redirect:/categories/{id}";
    }
}
