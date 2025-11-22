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
@Table(name = "TB_SERVICE")
public class ServiceModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_id")
    private UUID id;

    @Column(name = "service_title", nullable = false, length = 150)
    private String title;

    @Column(name = "ds_service", length = 500)
    private String description;

    @Column(name = "service_img", length = 255)
    private String image;

    @Column(name = "price_vl", precision = 10, scale = 2)
    private BigDecimal price;
}
