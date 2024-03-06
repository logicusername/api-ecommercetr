package com.aplicacion.ecommercetrss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aplicacion.ecommercetrss.domain.Product;
import com.aplicacion.ecommercetrss.exception.ProductNotFoundException;
import com.aplicacion.ecommercetrss.service.ProductService;

import java.util.Set;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Set<Product>> getProducts(@RequestParam(value = "category", defaultValue = "") String category){
        Set<Product> products = null;
        // if (category.equals(""))
            products = productService.findAll();
        // else
        //     logger.info("hola que mas");
        
        // logger.info("fin getProducts");
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        Product product = productService.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(id));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product addedProduct = productService.addProduct(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }
    
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> modifyProduct(@PathVariable long id, @RequestBody Product newProduct) {
        Product product = productService.modifyProduct(id, newProduct);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK); 
    }
}
