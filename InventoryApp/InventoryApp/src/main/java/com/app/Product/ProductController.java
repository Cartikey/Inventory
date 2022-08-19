package com.app.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.category.Category;
import com.app.category.CategoryRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	
	
	@GetMapping("/product/new") //match with index.html page written
	public String showNewProductForm(Model model) {
		
		List<Category> listCategories= categoryRepo.findAll();
		model.addAttribute("product",new Product());
		model.addAttribute("listCategories", listCategories);
		return "product_form";
	}

	
	@PostMapping("/product/save")
	public String saveProduct(Product product) {
		
		productRepo.save(product);
		
		return "redirect:/product";
	}
	
	@GetMapping("/product")
	public String listProducts(Model model) {
		List<Product> listProducts=productRepo.findAll();
		
		model.addAttribute("listProducts", listProducts);
		
		return "products";
	}
}
