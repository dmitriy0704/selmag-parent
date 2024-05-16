package my.home.feedback.controller.payload;

import jakarta.validation.constraints.NotNull;

public record NewFavouriteProductPayload(

        @NotNull(message = "{feedback.products.favourites.create.rating.errors.product_id_is_null}")
        Integer productId
) {
}
