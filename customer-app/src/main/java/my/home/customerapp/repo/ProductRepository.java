package my.home.customerapp.repo;


import my.home.customerapp.entity.FavouriteProduct;
import reactor.core.publisher.Mono;

public interface ProductRepository {
    Mono<FavouriteProduct> save(FavouriteProduct favouriteProduct);
}
