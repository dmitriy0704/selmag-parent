package my.home.customerapp.controller.payload;

public record NewProductReviewPayload(
        Integer productId,
        Integer rating,
        String review) {
}
