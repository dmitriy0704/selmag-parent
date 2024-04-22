package my.home.manager.controller;

import my.home.manager.client.BadRequestException;
import my.home.manager.client.ProductsRestClient;
import my.home.manager.controller.payload.NewProductPayload;
import my.home.manager.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ConcurrentModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Модульные тесты ProductsController")
class ProductsControllerTest {

    @Mock
    ProductsRestClient productsRestClient;

    @InjectMocks
    ProductsController controller;

    @Test
    @DisplayName("createProduct создаст новый товар и перенаправит на страницу товара")
    void createProduct_RequestIsValid_ReturnsRedirectionToProductPage() {

        //given - определение состояния при котором будет протекать тест
        var payload = new NewProductPayload("Новый товар", "Описание нового товара");
        var model = new ConcurrentModel();

        doReturn(new Product(1, "Новый товар", "Описание нового товара"))
                .when(this.productsRestClient)
                .createProduct("Новый товар", "Описание нового товара");

        //when - вызов тестируемого метода
        var result = this.controller.createProduct(payload, model);

        //then - тестирование результата
        assertEquals("redirect:/catalogue/products/1", result);

        verify(this.productsRestClient).createProduct("Новый товар", "Описание нового товара");
        verifyNoMoreInteractions(this.productsRestClient);
    }


    @Test
    @DisplayName("createProduct вернет страницу с ошибками, если запрос не валиден")
    void createProduct_RequestIsInvalid_ReturnsProductFormWithErrors() {

        //given - определение состояния при котором будет протекать тест
        var payload = new NewProductPayload("   ", null);
        var model = new ConcurrentModel();

        doThrow(new BadRequestException(List.of("Ошибка 1", "Ошибка 2")))
                .when(this.productsRestClient)
                .createProduct("   ", null);

        //when - вызов тестируемого метода
        var result = this.controller.createProduct(payload, model);

        //then - тестирование результата
        assertEquals("catalogue/products/new_product", result);
        assertEquals(payload, model.getAttribute("payload"));
        assertEquals(List.of("Ошибка 1", "Ошибка 2"), model.getAttribute("errors"));

        verify(this.productsRestClient).createProduct("   ", null);
        verifyNoMoreInteractions(this.productsRestClient);
    }


}