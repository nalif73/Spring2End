package com.geekbrains.ru.springproduct.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailViewDto extends ProductBaseViewDto {

    private Set<com.geekbrains.ru.springproduct.dto.ProductReviewDto> reviews;

}
