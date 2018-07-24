package com.prizy.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.prizy.entity.ProductPrice;
import com.prizy.repos.ProductPriceRepos;

@Service
public class IdealPriceCalculationStategyDefaultImpl implements IdealPriceCalculationStategy {

	@Autowired
	ProductPriceRepos producePriceRepos ;

	@Value("${prizy.idealPriceStrategy.percent}")
	String percent;
	
	@Override
	public Double calculate(Long productId) {
		Double pct=20.0;
		try {
		 pct=Double.valueOf(percent);
		}
		catch (Exception e)
		{
			System.out.println("percent not defined correctly");
		}
		double factor =1+pct/100;

		if(producePriceRepos==null)
			System.out.println("producePriceRepos is null");
		
		List<ProductPrice> productPrices= producePriceRepos.findAllByProductPriceKeyBarCode(productId);

		Double max=Double.MIN_VALUE;
		Double secondMax=Double.MIN_VALUE;

		Double min=Double.MIN_VALUE;
		Double secondMin=Double.MIN_VALUE;

		Double sum=0.0;
		
		if(productPrices.size()<=4)
		{
			return 0.0;
		}

		for(ProductPrice pp: productPrices )
		{
			if(pp.getPrice()>max)
			{
				max=pp.getPrice();
				secondMax=max;
			}
			
			if(pp.getPrice()<min)
			{
				min=pp.getPrice();
				secondMin=min;
			}
			sum+=pp.getPrice();
		}

		sum=sum - max-secondMax-min-secondMin;
		
		return (sum/(productPrices.size()-2))*factor;
	}


}

