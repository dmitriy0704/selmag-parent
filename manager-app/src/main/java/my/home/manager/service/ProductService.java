package my.home.manager.service;

import my.home.manager.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    Product createProduct(String title, String details);
}
