package com.project.shop.product.repository;

import com.project.shop.product.dto.response.ProductListDTO;
import com.project.shop.product.dto.response.QProductListDTO;
import com.project.shop.product.entity.QProduct;
import com.project.shop.product.vo.ProductSearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.project.shop.product.entity.QProduct.*;

public class ProductRepositoryImpl implements CustomProductRepository{

    private final JPAQueryFactory queryFactory;

    public ProductRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<ProductListDTO> searchProductListPage(ProductSearchCondition condition, Pageable pageable) {

        List<ProductListDTO> result = queryFactory
                .select(new QProductListDTO(
                        product.id.as("productId"),
                        product.name,
                        product.price,
                        product.discountRate,
                        product.description
                ))
                .from(product)
                .where(nameEq(condition.getKeyword()))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory.select(product.count())
                .from(product)
                .where(nameEq(condition.getKeyword()))
                ;

        return PageableExecutionUtils.getPage(result, pageable, countQuery::fetchOne);
    }

    @Override
    public Page<ProductListDTO> searchProductListPageSimple(ProductSearchCondition condition, Pageable pageable) {
        return null;
    }

    @Override
    public List<ProductListDTO> searchProductList(ProductSearchCondition condition, Pageable pageable) {


        return  queryFactory
                .select(new QProductListDTO(
                        product.id.as("productId"),
                        product.name,
                        product.price,
                        product.discountRate,
                        product.description
                ))
                .from(product)
                .where(nameEq(condition.getKeyword()))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();
    }

    private BooleanExpression nameEq(String keyword) {
        return StringUtils.hasText(keyword) ? product.name.contains(keyword) : null;
    }
    private BooleanExpression priceGoe(Integer priceGoe) {
        return priceGoe != null ? product.price.goe(priceGoe) : null;
    }

}
