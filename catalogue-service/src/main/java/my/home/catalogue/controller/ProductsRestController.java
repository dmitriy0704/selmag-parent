package my.home.catalogue.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.home.catalogue.controller.payload.NewProductPayload;
import my.home.catalogue.entity.Product;
import my.home.catalogue.service.ProductService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalogue-api/products")
public class ProductsRestController {

    private final ProductService productService;
    private final MessageSource messageSource;

    @GetMapping
    public List<Product> findProducts() {
        return this.productService.findAllProducts();
    }

    @PostMapping
    public ResponseEntity<?> createProduct(
            @Valid @RequestBody NewProductPayload payload,
            BindingResult bindingResult,
            UriComponentsBuilder uriComponentsBuilder) throws BindException {
        if (bindingResult.hasErrors()) {
          if(bindingResult instanceof BindException exception){
              throw exception;
          }  else {
              throw new BindException(bindingResult);
          }
        } else {
            Product product = this.productService.createProduct(payload.title(), payload.details());
            return ResponseEntity.created(
                    uriComponentsBuilder
                            .replacePath("/catalogue-api/products/{productId}")
                            .build(Map.of("productId", product.getId()))).body(product);
        }
    }
}
