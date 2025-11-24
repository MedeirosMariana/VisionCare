package com.project.visioncare.controllers;

import com.project.visioncare.dtos.ServiceRecordDto;
import com.project.visioncare.models.ServiceModel;
import com.project.visioncare.services.ServiceModelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @Autowired
    ServiceModelService service;

    @GetMapping("/services")
    public ResponseEntity<List<ServiceModel>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/service/{id}")
    public ResponseEntity<ServiceModel> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/service")
    public ResponseEntity<UUID> create(@RequestBody @Valid ServiceRecordDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/service/{id}")
    public ResponseEntity<UUID> update(@PathVariable UUID id, @RequestBody @Valid ServiceRecordDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/service/{id}")
    public ResponseEntity<UUID> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok(id);
    }
}
