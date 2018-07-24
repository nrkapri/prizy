package com.prizy.repos;

import org.springframework.data.repository.CrudRepository;

import com.prizy.entity.Product;

public interface ProductRepos extends CrudRepository<Product, Long> {

}
