package com.geekbrains.ru.springproduct.service;

import com.geekbrains.ru.springproduct.domain.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> getCategories();

    CategoryEntity saveCategory(CategoryEntity category);

    CategoryEntity getCategoryById(Long id);
}
