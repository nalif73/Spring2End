package com.geekbrains.ru.springproduct.controller;


import com.geekbrains.ru.springproduct.domain.ProductEntity;
import com.geekbrains.ru.springproduct.repository.ProductRepository;
import com.geekbrains.ru.springproduct.service.ProductService;
import com.geekbrains.ru.springproduct.util.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.geekbrains.ru.springproduct.domain.constant.RestControllerName.API_V1;
import static com.geekbrains.ru.springproduct.domain.constant.RestControllerName.CART;

@RestController
@RequestMapping(API_V1 + CART)
@RequiredArgsConstructor
public class CartController {

    private final Cart cart;
    private final ProductRepository productRepository;

    @GetMapping("/add")
    public void addProductToCart(@RequestParam Long id) {
        ProductEntity product = productRepository.getById(id);
        cart.addProduct(product);
    }

    @GetMapping
    public List<ProductEntity> showAllProductsInCart() {
        return cart.getItems();
    }

    @GetMapping("/clear")
    public void clearCart() {
        cart.clearCart();

    }

}
