package my.home.manager.service;

import lombok.RequiredArgsConstructor;
import my.home.manager.entity.Product;
import my.home.manager.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String details) {
        return this.productRepository.save(new Product(null, title, details));
    }
}
