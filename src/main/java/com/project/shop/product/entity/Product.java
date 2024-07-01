package com.project.shop.product.entity;

import com.project.shop.category.entity.Category;
import com.project.shop.global.domain.BaseTime;
import com.project.shop.global.domain.Images;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private int price;


    @Column(name = "discount_rate")
    private int discountRate;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    @Builder.Default
    @OneToMany
    @JoinColumn(name = "images_id")
    private Set<Images> images = new HashSet<>();
}
