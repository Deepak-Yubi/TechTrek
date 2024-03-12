package org.example.products.service;

import org.example.products.entity.Product;
import org.example.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product updateProductById(Long id, Product product) {
        Optional<Product> product1 = productRepository.findById(id);

        if ( product1.isPresent()) {
            Product originalproduct = product1.get();
            if (Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())) {
                originalproduct.setName(product.getName());
            }
            return productRepository.save(originalproduct);
        }
        return null;
    }

    @Override
    public String deleteProductById(Long id) {

        if(productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
            return "Product deleted Successfully";
        }
        return "Product not Found";
    }
}
