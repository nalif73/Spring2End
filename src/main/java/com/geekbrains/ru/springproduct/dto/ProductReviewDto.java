package com.geekbrains.ru.springproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductReviewDto {

    private String comment;

    private int rating;

    private Long productId;

    private UserDto user;

    private LocalDateTime created;

    private LocalDateTime updated;

}
