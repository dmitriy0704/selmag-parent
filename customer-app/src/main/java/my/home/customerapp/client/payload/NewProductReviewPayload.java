package my.home.customerapp.client.payload;

public record NewProductReviewPayload(int productId, int rating, String review) {
}
