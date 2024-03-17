package my.home.manager.controller;

import lombok.RequiredArgsConstructor;
import my.home.manager.controller.payload.NewProductPayload;
import my.home.manager.entity.Product;
import my.home.manager.service.ProductService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductsController {
    private final ProductService productService;

    @GetMapping("list")
    public String getProducts(Model model) {
        model.addAttribute("products", this.productService.findAllProducts());
        return "catalogue/products/list";
    }

    @GetMapping("create")
    public String getNewProductPage() {
        return "catalogue/products/new_product";
    }

    @PostMapping("create")
    public String createProduct(NewProductPayload productPayload) {
        Product product = this.productService.createProduct(
                productPayload.title(), productPayload.details()
        );
        return "redirect:/catalogue/products/list";
    }
}
