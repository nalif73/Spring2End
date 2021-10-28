package com.geekbrains.ru.springproduct.controller;

import com.geekbrains.ru.springproduct.domain.CategoryEntity;
import com.geekbrains.ru.springproduct.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.geekbrains.ru.springproduct.domain.constant.RestControllerName.API_V1;
import static com.geekbrains.ru.springproduct.domain.constant.RestControllerName.CATEGORY;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(API_V1 + CATEGORY)
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryEntity> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public CategoryEntity getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @RequestMapping(method = { POST, PUT })
    public CategoryEntity getCategories(@RequestBody CategoryEntity category) {
        return categoryService.saveCategory(category);
    }

}
