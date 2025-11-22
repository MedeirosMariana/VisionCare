package com.project.visioncare.repositories;

import com.project.visioncare.models.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, UUID> {
}
