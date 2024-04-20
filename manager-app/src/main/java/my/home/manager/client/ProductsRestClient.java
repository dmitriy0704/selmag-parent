package my.home.manager.client;

import my.home.manager.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface ProductsRestClient {

    List<Product> findAllProducts();
    Product createProduct(String title, String details);
    Optional<Product> findProduct(int productId);
    void updateProduct(int product, String title, String details);
    void deleteProduct(int product);
}
