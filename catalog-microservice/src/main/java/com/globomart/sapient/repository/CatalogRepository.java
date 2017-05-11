package com.globomart.sapient.repository;

import org.springframework.data.repository.CrudRepository;

import com.globomart.sapient.entity.Product;

public interface CatalogRepository extends CrudRepository<Product, Long>{

}
