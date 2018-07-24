package com.prizy.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prizy.entity.Product;
import com.prizy.entity.ProductPrice;
import com.prizy.error.AddPriceException;
import com.prizy.error.ProductPageNotFoundException;
import com.prizy.error.ProductPriceDeailsNotFoundException;
import com.prizy.services.ProductService;
import com.prizy.view.ProductPriceView;

@Controller
public class ProductController {

	private String message = "Welcome to Prizy";

	@Autowired
	ProductService productService;

	@RequestMapping("/")
	public String productsPage() {
		return "productsview";
	}
	
	@RequestMapping("/price")
	public String pricePage() {
		return "price";
	}

	@PostMapping("/price")
	@ResponseBody
	public ProductPrice addProductPrice(@RequestBody ProductPrice newProductPrice) 
	{
		ProductPrice productPrice;
		try 
		{
			productPrice=productService.addProductPrice(newProductPrice);

		}
		catch (Exception ex)
		{
			throw new AddPriceException(newProductPrice.toString());
		}

		return productPrice;
	}


	@GetMapping("/products/{page}")
	@ResponseBody
	public HashMap<String, Object> products(@PathVariable int  page) 
	{

		List<Product> products;

		try {
			products=productService.getProducts(page);
		}
		catch (Exception ex)
		{
			throw new ProductPageNotFoundException(""+page);
		}
		HashMap<String, Object> result =new HashMap<String, Object>();
		result.put("products",products);
		result.put("totalPages",productService.getTotalProductsPages());
		return result;	
	}

	@GetMapping("/price/{productId}")
	@ResponseBody
	public ProductPriceView productPriceView(@PathVariable Long productId) {
		ProductPriceView productPriceView;

		try 
		{
			productPriceView= productService.productPriceView(productId);
		}
		catch (Exception ex)
		{
			throw new ProductPriceDeailsNotFoundException(""+ productId);
		}

		return productPriceView;
	}


}
