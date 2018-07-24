package com.prizy.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IdealPriceCalculator {

	IdealPriceCalculationStategy strategy;
	
	@Autowired
	IdealPriceCalculationStategyDefaultImpl defaultStrategy;

	@Value("${prizy.idealPriceStrategy}")
	String strategyProperty;


	public Double calculate(Long productId) {

		chooseStrategy();
		return strategy.calculate(productId);
	}



	private void chooseStrategy() {
		if(strategyProperty.equals("default"))
		{
			
			strategy= defaultStrategy;
		}
	}


}
