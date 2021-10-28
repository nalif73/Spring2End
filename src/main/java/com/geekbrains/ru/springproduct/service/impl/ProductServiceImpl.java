package com.geekbrains.ru.springproduct.service.impl;

import com.geekbrains.ru.springproduct.domain.ProductEntity;
import com.geekbrains.ru.springproduct.dto.ProductBaseViewDto;
import com.geekbrains.ru.springproduct.dto.ProductDetailViewDto;
import com.geekbrains.ru.springproduct.dto.ProductListViewDto;
import com.geekbrains.ru.springproduct.dto.ProductReviewDto;
import com.geekbrains.ru.springproduct.repository.ProductRepository;
import com.geekbrains.ru.springproduct.service.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;

    private final FileService fileService;
    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    private ProductReviewConverterService productReviewConverter;

    @Autowired
    public void setProductReviewConvert(ProductReviewConverterService productReviewConverter) {
        this.productReviewConverter = productReviewConverter;
    }

    @Override
    public List<ProductListViewDto> getProducts() {
        List<ProductEntity> products = productRepository.findAll();

        return products.stream()
                .map(product -> convertEntityToDto(product, ProductListViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductListViewDto saveWithImage(ProductListViewDto productListViewDto, MultipartFile image) {
        ProductEntity entity = convertDtoToEntity(productListViewDto);
        ProductEntity savedProduct = productRepository.save(entity);

        if (image != null && !image.isEmpty()) {
            Path pathImage = fileService.saveProductImage(image);
            savedProduct.setImageLink(pathImage.toString());

            productRepository.save(savedProduct);
        }

        return convertEntityToDto(savedProduct, ProductListViewDto.class);
    }

    @Override
    public ProductEntity getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }

    @Override
    public ProductDetailViewDto getProductDtoById(Long productId) {
        ProductEntity productEntity = getProductById(productId);
        ProductDetailViewDto productDetailViewDto = convertEntityToDto(productEntity, ProductDetailViewDto.class);

        Set<ProductReviewDto> productReviewDto = productEntity.getProductReviews().stream()
                .map(productReviewConverter::convertEntityToDto)
                .collect(Collectors.toSet());
        productDetailViewDto.setReviews(productReviewDto);

        return productDetailViewDto;
    }

    private <T extends ProductBaseViewDto> ProductEntity convertDtoToEntity(T dto) {
        ProductEntity entity = modelMapper.map(dto, ProductEntity.class);
        entity.setCategory(categoryService.getCategoryById(dto.getCategoryId()));

        return entity;
    }

    private <T extends ProductBaseViewDto> T convertEntityToDto(ProductEntity savedEntity, Class<T> dtoClass) {
        T dto = modelMapper.map(savedEntity, dtoClass);
        dto.setCategoryId(savedEntity.getCategory().getId());

        return dto;
    }

}
