package my.home.feedback.controller.payload;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewProductReviewPayload(
        @NotNull(message = "{feedback.products.reviews.create.rating.errors.product_id_is_null}")
        Integer productId,

        @NotNull(message = "{feedback.products.reviews.create.rating.errors.rating_is_null}")
        @Min(value = 1, message = "{feedback.products.reviews.create.rating.errors.rating_bellow_min}")
        @Max(value = 5, message = "{feedback.products.reviews.create.rating.errors.rating_above_max}")
        Integer rating,

        @Size(max = 100, message = "{feedback.products.reviews.create.rating.errors.review_is_too_big}")
        String reviews

){

}
