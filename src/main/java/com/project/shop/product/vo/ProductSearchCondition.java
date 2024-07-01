package com.project.shop.product.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchCondition {

    private String keyword;
    private int priceGoe;
    private int priceLoe;

}
