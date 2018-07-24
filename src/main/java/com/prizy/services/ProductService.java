package com.prizy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.prizy.entity.Product;
import com.prizy.entity.ProductPrice;
import com.prizy.repos.ProductPagingRepos;
import com.prizy.repos.ProductPriceRepos;
import com.prizy.repos.ProductRepos;
import com.prizy.view.ProductPriceView;
import com.prizy.view.ProductViewGeneratorImpl;



@Service
public class ProductService {

	private final int PAGESIZE = 5;
	
	@Autowired
	private ProductPriceRepos productPriceRepos;
	
	@Autowired
	private ProductRepos productRepos;
	
	@Autowired
	private ProductViewGeneratorImpl productViewGeneratorImpl;

	@Autowired
	private ProductPagingRepos productPagingRepos;

	public ProductPrice addProductPrice(ProductPrice newProductPrice) {
		return productPriceRepos.save(newProductPrice);
	}

	public List<Product> getProducts(int pageNumber) {
		PageRequest request = PageRequest.of(pageNumber -1, PAGESIZE, Direction.ASC, "barCode") ;
		
		
		List<Product> products=(List<Product>) productPagingRepos.findAll(request).getContent();
		System.out.println("Prices are:"+products.size());
		products.forEach((a)->
		{
			Product p = (Product)a;
			System.out.println("Bar Code:"+p.toString());
		});
		
		return products;
	}

	public ProductPriceView productPriceView(Long productId) throws Exception {
		return  productViewGeneratorImpl.productPriceView(productId);
	}

	public Integer getTotalProductsPages() {
		// TODO Auto-generated method stub
		Integer totalPages= (int) Math.ceil((double)productRepos.count()/PAGESIZE);
		System.out.println("total Pages:"+totalPages+",Count"+productRepos.count());
		return totalPages;
	}
}
