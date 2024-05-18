package my.home.feedback.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.home.feedback.controller.payload.NewFavouriteProductPayload;
import my.home.feedback.entity.FavouriteProduct;
import my.home.feedback.service.FavouriteProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("feedback-api/favourite-products")
@RequiredArgsConstructor
public class FavouriteProductsRestController {

    private final FavouriteProductsService favouriteProductsService;

    @GetMapping
    public Flux<FavouriteProduct> findFavouriteProducts() {
        return favouriteProductsService.findFavouriteProducts();
    }

    @GetMapping("by-product-id/{productId:\\d+}")
    public Mono<FavouriteProduct> findFavouriteProductByProductId(@PathVariable("productId") int productId) {
        return this.favouriteProductsService.findFavouriteProductByProduct(productId);
    }

    @PostMapping
    public Mono<ResponseEntity<FavouriteProduct>> addProductToFavourites(
            @Valid @RequestBody Mono<NewFavouriteProductPayload> payloadMono,
            UriComponentsBuilder uriComponentsBuilder) {
        return payloadMono
                .flatMap(payload -> this.favouriteProductsService.addProductToFavourite(payload.productId()))
                .map(favouriteProduct -> ResponseEntity.created(uriComponentsBuilder
                                .replacePath("feedback-api/favourite-products/{id}")
                                .build(favouriteProduct.getId()))
                        .body(favouriteProduct));
    }

    @DeleteMapping("by-product-id/{productId:\\d+}")
    public Mono<ResponseEntity<Void>> removeProductFromFavourites(@PathVariable("productId") int productId) {
        return this.favouriteProductsService.removeProductFromFavourite(productId)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }

}
