package com.project.visioncare.controllers.api;

import com.project.visioncare.dtos.UniversityRecordDto;
import com.project.visioncare.models.UniversityModel;
import com.project.visioncare.services.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @GetMapping("/universities")
    public ResponseEntity<List<UniversityModel>> listAll() {
        return ResponseEntity.ok(universityService.listAll());
    }

    @GetMapping("/university/{id}")
    public ResponseEntity<UniversityModel> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(universityService.getById(id));
    }

    @PostMapping("/university")
    public ResponseEntity<UUID> create(@RequestBody @Valid UniversityRecordDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(universityService.create(dto));
    }

    @PutMapping("/university/{id}")
    public ResponseEntity<UUID> update(@PathVariable UUID id, @RequestBody @Valid UniversityRecordDto dto) {
        return ResponseEntity.ok(universityService.update(id, dto));
    }

    @DeleteMapping("/university/{id}")
    public ResponseEntity<UUID> delete(@PathVariable UUID id) {
        universityService.delete(id);
        return ResponseEntity.ok(id);
    }
}
