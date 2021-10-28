package com.geekbrains.ru.springproduct.service;

import com.geekbrains.ru.springproduct.domain.ProductEntity;
import com.geekbrains.ru.springproduct.dto.ProductDetailViewDto;
import com.geekbrains.ru.springproduct.dto.ProductListViewDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    List<ProductListViewDto> getProducts();

    ProductListViewDto saveWithImage(ProductListViewDto productListViewDto, MultipartFile image);

    ProductEntity getProductById(Long productId);

    ProductDetailViewDto getProductDtoById(Long productId);

}
