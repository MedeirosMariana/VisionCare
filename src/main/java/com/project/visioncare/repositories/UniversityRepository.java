package com.project.visioncare.repositories;

import com.project.visioncare.models.UniversityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UniversityRepository extends JpaRepository<UniversityModel, UUID> {
}
