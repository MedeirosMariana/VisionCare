package com.project.visioncare.models;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CART")
public class CartModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private UUID id;

    @Column(name = "create_dt")
    private LocalDateTime createdAt;

    @Column(name = "customer_name", nullable = false, length = 200)
    private String customerName;

    @Column(name = "customer_phone")
    private String phone;

    @Column(name = "university_ds")
    private String universityName;

    @Column(name = "shipping_postal_code")
    private String postalCode;

    @Column(name = "shipping_street_loc")
    private String street;

    @Column(name = "shipping_neighborhood")
    private String neighborhood;

    @Column(name = "shipping_city_loc")
    private String city;

    @Column(name = "shipping_state_loc")
    private String state;

    @Column(name = "shipping_type")
    private Integer shippingType;

    @Column(name = "shipping_vl", precision = 10, scale = 2)
    private BigDecimal shippingValue;

    @Column(name = "payment_type_desc")
    private String paymentType;

    @Column(name = "payment_discount_pct", precision = 5, scale = 2)
    private BigDecimal paymentDiscount;

    @Column(name = "total_subtotal_vl", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "update_dt")
    private LocalDateTime updatedAt;

    @Column(name = "active_flag")
    private Boolean active;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItemModel> items;
}
