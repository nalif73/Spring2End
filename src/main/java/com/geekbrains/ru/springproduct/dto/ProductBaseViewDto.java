package com.geekbrains.ru.springproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductBaseViewDto {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private String imageLink;

    private Long categoryId;

}
