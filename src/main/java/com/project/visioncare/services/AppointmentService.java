package com.project.visioncare.services;

import com.project.visioncare.dtos.AppointmentRecordDto;
import com.project.visioncare.exceptions.NotFoundException;
import com.project.visioncare.models.AppointmentModel;
import com.project.visioncare.repositories.AppointmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    private final String notFoundMessage = "Appointment not found";

    public List<AppointmentModel> listAll() {
        return appointmentRepository.findAll();
    }

    public AppointmentModel getById(UUID id) {
        return appointmentRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));
    }

    public UUID create(AppointmentRecordDto dto) {
        var model = new AppointmentModel();
        BeanUtils.copyProperties(dto, model);
        return appointmentRepository.save(model).getId();
    }

    public UUID update(UUID id, AppointmentRecordDto dto) {
        var model = appointmentRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));

        BeanUtils.copyProperties(dto, model);
        return appointmentRepository.save(model).getId();
    }

    public void delete(UUID id) {
        var found = appointmentRepository.findById(id);

        if (found.isEmpty()) throw new NotFoundException(notFoundMessage);

        appointmentRepository.delete(found.get());
    }
}
