package com.geekbrains.ru.springproduct.util;

import com.geekbrains.ru.springproduct.domain.ProductEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Cart {
    private List<ProductEntity> items;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public List<ProductEntity> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addProduct(ProductEntity product) {
        items.add(product);
    }

    public void clearCart() {
        items.clear();
    }
}

