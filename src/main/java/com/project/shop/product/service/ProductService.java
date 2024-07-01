package com.project.shop.product.service;

import com.project.shop.product.dto.response.ProductListDTO;
import com.project.shop.product.repository.ProductRepository;
import com.project.shop.product.vo.ProductSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public Page<ProductListDTO> searchProductListPage(ProductSearchCondition condition, Pageable pageable) {

        return productRepository.searchProductListPage(condition, pageable);
    }
}
