package com.project.visioncare.services;

import com.project.visioncare.exceptions.NotFoundException;
import com.project.visioncare.models.ServiceModel;
import com.project.visioncare.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceModelService {

    @Autowired
    ServiceRepository serviceRepository;

    private static final String notFoundMessage = "Service not found";

    public List<ServiceModel> listAll() {
        return serviceRepository.findAll();
    }

    public ServiceModel getById(UUID id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));
    }

    public UUID create(ServiceModel model) {
        model.setId(null);
        return serviceRepository.save(model).getId();
    }

    public UUID update(UUID id, ServiceModel model) {
        getById(id);
        model.setId(id);
        return serviceRepository.save(model).getId();
    }

    public void delete(UUID id) {
        var existing = getById(id);
        serviceRepository.delete(existing);
    }
}
