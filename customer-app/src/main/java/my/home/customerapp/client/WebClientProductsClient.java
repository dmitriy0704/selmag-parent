package my.home.customerapp.client;

import lombok.RequiredArgsConstructor;
import my.home.customerapp.entity.Product;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@RequiredArgsConstructor
public class WebClientProductsClient implements ProductsClient {

    private final WebClient webClient;

    @Override
    public Flux<Product> findAllProducts(String filter) {
        return this.webClient
                .get()
                .uri("/catalogue-api/products?filter={filter}", filter)
                .retrieve()
                .bodyToFlux(Product.class);
    }
}
