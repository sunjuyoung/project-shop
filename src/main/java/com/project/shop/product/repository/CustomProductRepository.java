package com.project.shop.product.repository;

import com.project.shop.product.dto.response.ProductListDTO;
import com.project.shop.product.vo.ProductSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomProductRepository {

    public List<ProductListDTO> searchProductList(ProductSearchCondition condition, Pageable pageable);

    public Page<ProductListDTO> searchProductListPage(ProductSearchCondition condition, Pageable pageable);

    public Page<ProductListDTO> searchProductListPageSimple(ProductSearchCondition condition, Pageable pageable);
}
