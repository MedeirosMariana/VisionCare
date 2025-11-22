package com.project.visioncare.models;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_APPOINTMENT")
public class AppointmentModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_ds")
    private String email;

    @Column(name = "phone_ds")
    private String phone;

    @Column(name = "consultation_type")
    private String consultationType;

    @Column(name = "date_pref_dt")
    private LocalDate preferredDate;

    @Column(name = "time_pref_dt")
    private LocalTime preferredTime;

    @Column(name = "observation_ds", length = 1000)
    private String observation;

    @Column(name = "request_dt")
    private LocalDateTime requestDate;

    @Column(name = "is_confirmed_flag")
    private Boolean confirmed;

    @Column(name = "confirmation_dt")
    private LocalDateTime confirmationDate;

    @ManyToOne
    @JoinColumn(name = "university_fk", nullable = false)
    private UniversityModel university;
}
