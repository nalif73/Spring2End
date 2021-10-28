package com.geekbrains.ru.springproduct.repository;

import com.geekbrains.ru.springproduct.domain.ProductReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReviewEntity, Long> {

}
