package com.geekbrains.ru.springproduct.service;

import com.geekbrains.ru.springproduct.domain.ProductReviewEntity;
import com.geekbrains.ru.springproduct.dto.ProductReviewDto;

public interface ProductReviewConverterService {

    ProductReviewEntity convertDtoToEntity(ProductReviewDto reviewDto);

    ProductReviewDto convertEntityToDto(ProductReviewEntity savedEntity);

}
