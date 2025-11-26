package com.project.visioncare.services.appointment;

import com.project.visioncare.dtos.AppointmentRecordDto;
import com.project.visioncare.models.AppointmentModel;
import com.project.visioncare.services.UniversityService;

import java.util.List;
import java.util.UUID;

public interface IAppointmentService {
    UUID create(AppointmentRecordDto dto, UniversityService universityService);
    UUID update(UUID id, AppointmentRecordDto dto);
    void delete(UUID id);
    List<AppointmentModel> listAll();
    AppointmentModel getById(UUID id);
}

