package com.project.visioncare.services;

import com.project.visioncare.dtos.UniversityRecordDto;
import com.project.visioncare.exceptions.NotFoundException;
import com.project.visioncare.models.UniversityModel;
import com.project.visioncare.repositories.UniversityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    private final String notFoundMessage = "University not found";

    public List<UniversityModel> listAll() {
        return universityRepository.findAll();
    }

    public UniversityModel getById(UUID id) {
        return universityRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));
    }

    public UUID create(UniversityRecordDto dto) {
        var m = new UniversityModel();
        BeanUtils.copyProperties(dto, m);
        return universityRepository.save(m).getId();
    }

    public UUID update(UUID id, UniversityRecordDto dto) {
        var m = universityRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));

        BeanUtils.copyProperties(dto, m);
        return universityRepository.save(m).getId();
    }

    public void delete(UUID id) {
        var found = universityRepository.findById(id);

        if (found.isEmpty()) throw new NotFoundException(notFoundMessage);

        universityRepository.delete(found.get());
    }
}
