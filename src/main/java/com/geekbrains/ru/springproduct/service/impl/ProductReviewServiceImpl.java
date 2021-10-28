package com.geekbrains.ru.springproduct.service.impl;

import com.geekbrains.ru.springproduct.domain.ProductReviewEntity;
import com.geekbrains.ru.springproduct.domain.UserEntity;
import com.geekbrains.ru.springproduct.dto.ProductReviewDto;
import com.geekbrains.ru.springproduct.repository.ProductReviewRepository;
import com.geekbrains.ru.springproduct.service.ProductReviewConverterService;
import com.geekbrains.ru.springproduct.service.ProductReviewService;
import com.geekbrains.ru.springproduct.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductReviewServiceImpl implements ProductReviewService {

    private final ProductReviewRepository repository;
    private final ProductReviewConverterService converterService;
    private final UserService userService;

    @Override
    public ProductReviewDto saveProductReview(ProductReviewDto productReviewDto) {
        ProductReviewEntity productReviewEntity = converterService.convertDtoToEntity(productReviewDto);
        productReviewEntity.setId(null);

        if (productReviewDto.getUser() != null) {
            UserEntity user = userService.findByUsername(productReviewDto.getUser().getUsername());
            productReviewEntity.setUser(user);
        }

        return converterService.convertEntityToDto(repository.save(productReviewEntity));
    }

}
