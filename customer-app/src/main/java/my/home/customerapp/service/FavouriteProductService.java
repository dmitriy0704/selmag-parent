package my.home.customerapp.service;


import my.home.customerapp.entity.FavouriteProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FavouriteProductService{
    Mono<FavouriteProduct> addProductToFavourite(int productId);

    Mono<Void> removeProductFromFavourite(int productId);

    Mono<FavouriteProduct> findFavouriteProductByProduct(int productId);

    Flux<FavouriteProduct> findFavouriteProducts();
}
