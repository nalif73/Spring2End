package com.geekbrains.ru.springproduct.controller;

import com.geekbrains.ru.springproduct.dto.ProductReviewDto;
import com.geekbrains.ru.springproduct.service.ProductReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.geekbrains.ru.springproduct.domain.constant.RestControllerName.API_V1;
import static com.geekbrains.ru.springproduct.domain.constant.RestControllerName.PRODUCT_REVIEW;

@RestController
@RequestMapping(API_V1 + PRODUCT_REVIEW)
@RequiredArgsConstructor
public class ProductReviewController {

    private final ProductReviewService productReviewService;

    @PostMapping
    private ProductReviewDto saveProductReview(@RequestBody ProductReviewDto productReviewDto) {
        return productReviewService.saveProductReview(productReviewDto);
    }

}
