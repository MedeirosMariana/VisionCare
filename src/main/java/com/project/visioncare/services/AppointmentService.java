package com.project.visioncare.services;

import com.project.visioncare.exceptions.NotFoundException;
import com.project.visioncare.models.AppointmentModel;
import com.project.visioncare.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    private static final String notFoundMessage = "Appointment not found";

    public List<AppointmentModel> listAll() {
        return appointmentRepository.findAll();
    }

    public AppointmentModel getById(UUID id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));
    }

    public UUID create(AppointmentModel model) {
        model.setId(null); // garante novo registro
        return appointmentRepository.save(model).getId();
    }

    public UUID update(UUID id, AppointmentModel model) {
        var exists = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));

        model.setId(id);
        return appointmentRepository.save(model).getId();
    }

    public void delete(UUID id) {
        var exists = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));

        appointmentRepository.delete(exists);
    }
}
