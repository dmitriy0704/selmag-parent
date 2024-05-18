package my.home.customerapp.entity;

import java.util.UUID;

public record FavouriteProduct(
        UUID id,
        int productId) {
}
