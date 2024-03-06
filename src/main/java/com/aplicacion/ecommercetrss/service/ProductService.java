package com.aplicacion.ecommercetrss.service;

import java.util.Optional;
import java.util.Set;

import com.aplicacion.ecommercetrss.domain.Product;

//estos son otros metodos que no puede mapeas crudRepository (addproduct modifyProduct,deleteProduct)  

public interface ProductService {
    //devuelve una lista de tipo producto
    Set<Product> findAll();
    //agregar objeto de tipo producto
    Product addProduct (Product product);
    //tiene dos tipos para encontrar por id
    Optional<Product> findById(long id);
    //recibe un id y modifica
    Product modifyProduct(long id, Product newProduct);
    //borrar producto devuelve void
    void deleteProduct(long id);
}