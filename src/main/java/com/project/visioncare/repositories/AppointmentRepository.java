package com.project.visioncare.repositories;

import com.project.visioncare.models.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel, UUID> {
}
