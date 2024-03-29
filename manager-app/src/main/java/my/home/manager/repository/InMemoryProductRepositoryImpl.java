package my.home.manager.repository;

import my.home.manager.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.IntStream;

@Repository
public class InMemoryProductRepositoryImpl implements ProductRepository {
    private final List<Product> products = Collections.synchronizedList(new LinkedList<>());


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

    @Override
    public Optional<Product> findById(Integer productId) {
        return this.products
                .stream()
                .filter(product -> Objects.equals(productId, product.getId()))
                .findFirst();
    }
}
