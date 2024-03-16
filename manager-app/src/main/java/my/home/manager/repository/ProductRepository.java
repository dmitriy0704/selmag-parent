package my.home.manager.repository;

import my.home.manager.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product save(Product product);
}
