package my.home.manager.repository;

import my.home.manager.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryProductRepositoryImpl implements ProductRepository {
    private final List<Product> products = Collections.synchronizedList(new LinkedList<>());

    public InMemoryProductRepositoryImpl() {
        IntStream.range(1, 4)
                .forEach(i ->
                        this.products.add(
                                new Product(i, "Товар №%d".formatted(i),
                                        "Описание товара №%d".formatted(i)))
                );
    }

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(this.products);
    }

    @Override
    public Product save(Product product) {
        product.setId(this.products.stream()
                .max(Comparator.comparing(Product::getId))
                .map(Product::getId)
                .orElse(0) + 1
        );
        this.products.add(product);
        return product;
    }
}
