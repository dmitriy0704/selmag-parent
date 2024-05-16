package my.home.customerapp.client;

import lombok.RequiredArgsConstructor;
import my.home.customerapp.client.payload.NewProductReviewPayload;
import my.home.customerapp.entity.ProductReview;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class webClientProductReviewsClient implements ProductReviewsClient {


    private final WebClient webClient;

    @Override
    public Flux<ProductReview> findProductReviewsByProductId(int productId) {
        return this.webClient
                .get()
                .uri("/feedback-api/product-reviews/by-product-id/{productId}", productId)
                .retrieve()
                .bodyToFlux(ProductReview.class);
    }

    @Override
    public Mono<ProductReview> createProductReview(int productId, int rating, String review) {
        return this.webClient
                .post()
                .uri("/feedback-api/product-reviews")
                .bodyValue(new NewProductReviewPayload(productId, rating, review))
                .retrieve()
                .bodyToMono(ProductReview.class);
    }
}
