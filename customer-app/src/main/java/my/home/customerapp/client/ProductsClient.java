package my.home.customerapp.client;

import my.home.customerapp.entity.Product;
import reactor.core.publisher.Flux;

public interface ProductsClient {

    Flux<Product> findAllProducts(String filter);
}
