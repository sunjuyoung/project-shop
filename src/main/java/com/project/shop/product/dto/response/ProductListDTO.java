package com.project.shop.product.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductListDTO {

    private Long id;
    private String name;
    private int price;
    private int discountRate;

    private String description;

    @QueryProjection
    public ProductListDTO(Long id, String name, int price, int discountRate, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.description = description;
    }
}
