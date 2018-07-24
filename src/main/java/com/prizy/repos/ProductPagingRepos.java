package com.prizy.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.prizy.entity.Product;

public interface ProductPagingRepos extends PagingAndSortingRepository<Product, Long> {

}
