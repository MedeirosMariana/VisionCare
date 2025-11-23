package com.project.visioncare.services;

import com.project.visioncare.exceptions.NotFoundException;
import com.project.visioncare.models.UniversityModel;
import com.project.visioncare.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    private static final String notFoundMessage = "University not found";

    public List<UniversityModel> listAll() {
        return universityRepository.findAll();
    }

    public UniversityModel getById(UUID id) {
        return universityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));
    }

    public UUID create(UniversityModel model) {
        model.setId(null);
        return universityRepository.save(model).getId();
    }

    public UUID update(UUID id, UniversityModel model) {
        getById(id);
        model.setId(id);
        return universityRepository.save(model).getId();
    }

    public void delete(UUID id) {
        var existing = getById(id);
        universityRepository.delete(existing);
    }
}
