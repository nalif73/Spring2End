package com.geekbrains.ru.springproduct.controller;

import com.geekbrains.ru.springproduct.dto.ProductDetailViewDto;
import com.geekbrains.ru.springproduct.dto.ProductListViewDto;
import com.geekbrains.ru.springproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.geekbrains.ru.springproduct.domain.constant.RestControllerName.API_V1;
import static com.geekbrains.ru.springproduct.domain.constant.RestControllerName.PRODUCT;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(API_V1 + PRODUCT)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductListViewDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public ProductDetailViewDto getProductById(@PathVariable Long productId) {
        return productService.getProductDtoById(productId);
    }

    @RequestMapping(method = { POST, PUT }, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ProductListViewDto saveProduct(@RequestPart ProductListViewDto product,
                                          @RequestPart(required = false) MultipartFile image) {

        return productService.saveWithImage(product, image);
    }

}
