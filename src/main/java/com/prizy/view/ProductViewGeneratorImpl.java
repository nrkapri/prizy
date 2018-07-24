package com.prizy.view;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prizy.entity.Product;
import com.prizy.repos.ProductPriceRepos;
import com.prizy.repos.ProductRepos;
@Component
public class ProductViewGeneratorImpl implements ProductViewGenerator {

	@Autowired
	private ProductPriceRepos productPriceRepos;
	
	@Autowired
	private ProductRepos productRepos;
	
	@Autowired
	private ProductPriceView productView;
	
	@Autowired
	private IdealPriceCalculator idealPriceCalculator;
	
	@Override
	public ProductPriceView productPriceView(Long productId) throws Exception {

		Optional<Product> op =productRepos.findById(productId);
		if(!op.isPresent()) 
				throw new Exception();
		
		Product p=op.get();
		
		productView.setBarCode(p.getBarCode());
		
		productView.setMinPrice(productPriceRepos.getMinPrice(productId));
		productView.setMaxPrice(productPriceRepos.getMaxPrice(productId));
		productView.setAveragePrice(productPriceRepos.getAveragePrice(productId));
		
		productView.setProductDescription(p.getProductDescription());
		
		productView.setIdealPrice(idealPriceCalculator.calculate(productId));
		
		return productView;
	}

}
