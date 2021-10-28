package com.geekbrains.ru.springproduct.service.impl;

import com.geekbrains.ru.springproduct.domain.ProductReviewEntity;
import com.geekbrains.ru.springproduct.dto.ProductReviewDto;
import com.geekbrains.ru.springproduct.service.ProductReviewConverterService;
import com.geekbrains.ru.springproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductReviewConverterServiceImpl implements ProductReviewConverterService {

    private final ModelMapper modelMapper;
    private final ProductService productService;

    @Override
    public ProductReviewEntity convertDtoToEntity(ProductReviewDto reviewDto) {
        ProductReviewEntity entity = modelMapper.map(reviewDto, ProductReviewEntity.class);
        entity.setProduct(productService.getProductById(reviewDto.getProductId()));

        return entity;
    }

    @Override
    public ProductReviewDto convertEntityToDto(ProductReviewEntity savedEntity) {
        ProductReviewDto dto = modelMapper.map(savedEntity, ProductReviewDto.class);
        dto.setProductId(savedEntity.getProduct().getId());

        return dto;
    }
}
