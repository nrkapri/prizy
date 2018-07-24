package com.prizy.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prizy.entity.ProductPrice;
import com.prizy.entity.ProductPricePK;

public interface ProductPriceRepos extends CrudRepository<ProductPrice, ProductPricePK> {

	@Query("SELECT min(p.price) FROM ProductPrice p WHERE p.productPriceKey.barCode = :productId")
    public Double  getMinPrice(@Param("productId") Long productId);

	@Query("SELECT max(p.price) FROM ProductPrice p WHERE p.productPriceKey.barCode = :productId")
    public Double  getMaxPrice(@Param("productId") Long productId);

	@Query("SELECT avg(p.price) FROM ProductPrice p WHERE p.productPriceKey.barCode = :productId")
    public Double  getAveragePrice(@Param("productId") Long productId);

	public List<ProductPrice> findAllByProductPriceKeyBarCode(Long productId);

}
