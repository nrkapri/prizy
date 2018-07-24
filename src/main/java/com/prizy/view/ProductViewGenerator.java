package com.prizy.view;

import org.springframework.stereotype.Component;

@Component
public interface ProductViewGenerator {

	ProductPriceView productPriceView(Long productId) throws Exception;

}
