package com.project.visioncare.models;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PRODUCT")
public class ProductModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private UUID id;

    @Column(name = "ds_product", nullable = false, length = 200)
    private String description;

    @Column(name = "product_type")
    private Integer type;

    @Column(name = "product_img", length = 255)
    private String image;

    @Column(name = "product_qty")
    private Integer quantity;

    @Column(name = "product_vl", precision = 10, scale = 2)
    private BigDecimal value;

    @Column(name = "discount_vl", precision = 10, scale = 2)
    private BigDecimal discountValue;

    @Column(name = "discount_pct", precision = 5, scale = 2)
    private BigDecimal discountPercent;

    @Column(name = "reviews_qty")
    private Integer reviewsQuantity;

    @Column(name = "reviews_rating_stars_q", precision = 3, scale = 2)
    private BigDecimal starsAvg;
}
