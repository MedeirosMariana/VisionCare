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
@Table(name = "TB_UNIVERSITY")
public class UniversityModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "university_id")
    private UUID id;

    @Column(name = "ds_university", nullable = false, length = 200)
    private String description;

    @Column(name = "university_acronym", nullable = false, length = 10)
    private String acronym;

    @Column(name = "university_img", length = 255)
    private String image;

    @Column(name = "student_total")
    private Integer totalStudents;

    @Column(name = "university_city", length = 100)
    private String city;

    @Column(name = "active_partnership_flag")
    private Boolean activePartnership;

    @Column(name = "discount_pct", precision = 5, scale = 2)
    private BigDecimal discountPercent;

    @Column(name = "university_rating", precision = 2, scale = 1)
    private BigDecimal rating;
}
