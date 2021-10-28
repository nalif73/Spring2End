package com.geekbrains.ru.springproduct.service.impl;

import com.geekbrains.ru.springproduct.domain.CategoryEntity;
import com.geekbrains.ru.springproduct.repository.CategoryRepository;
import com.geekbrains.ru.springproduct.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity saveCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

}
