package com.project.visioncare.services;

import com.project.visioncare.dtos.ServiceRecordDto;
import com.project.visioncare.dtos.ServiceResponseDto;
import com.project.visioncare.exceptions.NotFoundException;
import com.project.visioncare.models.ServiceModel;
import com.project.visioncare.repositories.ServiceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    private final String notFoundMessage = "Service not found";

    public List<ServiceModel> listAll() {
        return serviceRepository.findAll();
    }

    public ServiceModel getById(UUID id) {
        return serviceRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));
    }

    public UUID create(ServiceRecordDto dto) {
        var model = new ServiceModel();
        BeanUtils.copyProperties(dto, model);

        return serviceRepository.save(model).getId();
    }

    public UUID update(UUID id, ServiceRecordDto dto) {
        var model = serviceRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));

        BeanUtils.copyProperties(dto, model);

        return serviceRepository.save(model).getId();
    }

    public void delete(UUID id) {
        var found = serviceRepository.findById(id);
        if (found.isEmpty()) throw new NotFoundException(notFoundMessage);

        serviceRepository.delete(found.get());
    }

    public List<ServiceResponseDto> listAllForFront() {
        List<ServiceModel> services = serviceRepository.findAll();

        return services.stream().map(s ->
                new ServiceResponseDto(
                        s.getTitle(),
                        s.getDescription(),
                        s.getFeatures(),
                        s.getPrice(),
                        s.getDuration(),
                        s.getBadge(),
                        s.getImage(),
                        mapColor(s.getTitle())
                )
        ).toList();
    }

    private String mapColor(String title) {
        return switch (title.toLowerCase()) {
            case "exames de vista" -> "text-blue-600";
            case "óculos de grau" -> "text-green-600";
            default -> "text-blue-600";
        };
    }
}
