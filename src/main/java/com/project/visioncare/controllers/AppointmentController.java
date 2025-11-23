package com.project.visioncare.controllers;

import com.project.visioncare.models.AppointmentModel;
import com.project.visioncare.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentModel>> listAll() {
        return ResponseEntity.ok(appointmentService.listAll());
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<AppointmentModel> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(appointmentService.getById(id));
    }

    @PostMapping("/appointment")
    public ResponseEntity<UUID> create(@RequestBody AppointmentModel model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.create(model));
    }

    @PutMapping("/appointment/{id}")
    public ResponseEntity<UUID> update(@PathVariable UUID id, @RequestBody AppointmentModel model) {
        return ResponseEntity.ok(appointmentService.update(id, model));
    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<UUID> delete(@PathVariable UUID id) {
        appointmentService.delete(id);
        return ResponseEntity.ok(id);
    }
}
