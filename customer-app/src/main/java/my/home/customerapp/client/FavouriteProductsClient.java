package my.home.customerapp.client;

import my.home.customerapp.entity.FavouriteProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FavouriteProductsClient {

    Flux<FavouriteProduct> findFavouriteProducts();

    Mono<FavouriteProduct> findFavouriteProductByProductId(int id);

    Mono<FavouriteProduct> addProductToFavourite(int productId);

    Mono<Void> removeProductFromFavourites(int productId);


}
