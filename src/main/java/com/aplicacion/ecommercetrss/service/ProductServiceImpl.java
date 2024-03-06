package com.aplicacion.ecommercetrss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacion.ecommercetrss.domain.Product;
import com.aplicacion.ecommercetrss.repository.ProductRepository;
import com.aplicacion.ecommercetrss.exception.ProductNotFoundException;
import java.util.Optional;
import java.util.Set;

@Service // sobrescribiendo para implementacion 
public class ProductServiceImpl implements ProductService  {

    @Autowired
    private ProductRepository productRepository; //llamado para la utilizacion del repository

    @Override
    public Set<Product> findAll(){
        return productRepository.findAll();
    }
    @Override 
    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }
    @Override 
    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    // metodo implementado parar modificar producto
    @Override
    public Product modifyProduct(long id, Product newProduct) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(id));
        newProduct.setId(product.getId());
        return productRepository.save(newProduct);
    }
    // metodo implementado para borrar producto
    @Override
    public void deleteProduct(long id){
        productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.deleteById(id);
    }
}
