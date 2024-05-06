package my.home.customerapp.repo;


import my.home.customerapp.entity.FavouriteProduct;
import reactor.core.publisher.Mono;

public interface FavouriteProductRepository {
    Mono<FavouriteProduct> save(FavouriteProduct favouriteProduct);

    Mono<Void> deleteByProductId(int productId);
}
