package org.example.products.controller;

import org.example.products.entity.Product;
import org.example.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class productpage {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return productService.fetchAllProducts();
    }

    @PostMapping("/createproduct")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProductById(id);
    }

    @PutMapping("/employee/{id}")
        public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product ){
            return productService.updateProductById(id, product);
        }


}
