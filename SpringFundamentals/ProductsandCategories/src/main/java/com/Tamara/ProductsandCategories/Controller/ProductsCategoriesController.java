package com.Tamara.ProductsandCategories.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Tamara.ProductsandCategories.models.Category;
import com.Tamara.ProductsandCategories.models.Product;
import com.Tamara.ProductsandCategories.services.ProductCategorieService;

@Controller
public class ProductsCategoriesController {
	private final ProductCategorieService productCategorieService;

	public ProductsCategoriesController(ProductCategorieService productCategorieService) {
		this.productCategorieService = productCategorieService;
	}
	
	@GetMapping("/products/new")
	public String createProduct(@ModelAttribute("product") Product product) {
		return "addProduct.jsp";
	}
	@PostMapping("/addProduct")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result ) {
		if(result.hasErrors()) {
			return "addProduct.jsp";
		}
		this.productCategorieService.createProduct(product);
		return "redirect:/products/new";
	}
	
	@GetMapping("/categorie/new")
	public String createCategory(@ModelAttribute("catogry") Category catogry) {
		return "addCatogry.jsp";
	}
	@PostMapping("/addCatogry")
	public String addCatogry(@Valid @ModelAttribute("catogry") Category catogry,BindingResult result ) {
		if(result.hasErrors()) {
			return "addCatogry.jsp";
		}
		this.productCategorieService.createCategory(catogry);
		return "redirect:/categorie/new";
	}
	@GetMapping("/products/{id}")
	public String DisplayProduct(@PathVariable("id")Long id,Model model) {
		model.addAttribute("product", this.productCategorieService.findProductById(id));
		model.addAttribute("catogories", this.productCategorieService.findAllCategory());
		return "product.jsp";
	}
		
	@PostMapping("/addCategory-toProduct/{id}")
	public String addCategoryToProducts(@RequestParam(value="category") Category catogry,@PathVariable("id") Long id) {
//		int catogryId = Integer.parseInt(catogry);
//		Category selectedCatogry = this.productCategorieService.findCategoryById(catogry.getId()); why it contain all the object and not only the id
		this.productCategorieService.addCategoryToProduct(catogry, id);
		return "redirect:/products/"+id+"";
		
	}
	@GetMapping("/categorie/{id}")
	public String DisplayCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", this.productCategorieService.findCategoryById(id));
		model.addAttribute("products", this.productCategorieService.findAllProduct());
		return "category.jsp";
	}
	@PostMapping("/addProduct-toCategory/{id}")
	public String addProductToCategory(@RequestParam(value="product") Product product,@PathVariable("id") Long id) {
		this.productCategorieService.addProductToCategory(product, id);
		return "redirect:/categorie/"+id+"";
	}

}
