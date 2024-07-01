package com.project.shop.product.controller;

import com.project.shop.product.dto.response.ProductListDTO;
import com.project.shop.product.service.ProductService;
import com.project.shop.product.vo.ProductSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductListDTO>> getProductList(@RequestBody ProductSearchCondition condition, Pageable pageable) {

        Page<ProductListDTO> result = productService.searchProductListPage(condition, pageable);

        return ResponseEntity.ok(result);
    }
}
