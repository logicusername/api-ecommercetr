package com.aplicacion.ecommercetrss.repository;

import org.springframework.data.repository.CrudRepository;

import com.aplicacion.ecommercetrss.domain.Product;

import java.util.Set;

// extendiendo del repositorio crud
// repositorio que define los metodos  
public interface ProductRepository extends CrudRepository<Product,Long>
{
    Set<Product> findAll();
    Product findByName(String name);
    Set<Product> findByCategory(String category);
}
