package com.project.visioncare.models;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CARTITEM")
public class CartItemModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartitem_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_fk", nullable = false)
    private ProductModel product;

    @ManyToOne
    @JoinColumn(name = "cart_fk", nullable = false)
    private CartModel cart;

    @Column(name = "cart_qty")
    private Integer quantity;
}
