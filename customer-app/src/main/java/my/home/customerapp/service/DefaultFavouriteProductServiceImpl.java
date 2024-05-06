package my.home.customerapp.service;

import lombok.RequiredArgsConstructor;
import my.home.customerapp.entity.FavouriteProduct;
import my.home.customerapp.repo.FavouriteProductRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class DefaultFavouriteProductServiceImpl implements FavouriteProductService {


    private final FavouriteProductRepository favouriteProductRepository;


    @Override
    public Mono<FavouriteProduct> addProductToFavourite(int productId) {
        return this.favouriteProductRepository.save(new FavouriteProduct(UUID.randomUUID(), productId));
    }

    @Override
    public Mono<Void> removeProductFromFavourite(int productId) {
        return this.favouriteProductRepository.deleteByProductId(productId);
    }
}
