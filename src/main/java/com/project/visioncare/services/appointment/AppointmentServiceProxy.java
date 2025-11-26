package com.project.visioncare.services.appointment;

import com.project.visioncare.dtos.AppointmentRecordDto;
import com.project.visioncare.models.AppointmentModel;
import com.project.visioncare.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentServiceProxy implements IAppointmentService {

    @Autowired
    private AppointmentService realAppointmentService;

    @Override
    public UUID create(AppointmentRecordDto dto, UniversityService universityService) {
        System.out.println("Log: Iniciando o agendamento...");
        UUID id = realAppointmentService.create(dto, universityService);
        System.out.println("Log: Consulta agendada com sucesso");
        return id;
    }

    @Override
    public UUID update(UUID id, AppointmentRecordDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<AppointmentModel> listAll() {
        return List.of();
    }

    @Override
    public AppointmentModel getById(UUID id) {
        return null;
    }
}


