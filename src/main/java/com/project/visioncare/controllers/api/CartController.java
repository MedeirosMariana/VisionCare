package com.project.visioncare.controllers.api;

import com.project.visioncare.dtos.CartRecordDto;
import com.project.visioncare.models.CartModel;
import com.project.visioncare.services.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/carts")
    public ResponseEntity<List<CartModel>> listAll() {
        return ResponseEntity.ok(cartService.listAll());
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<CartModel> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(cartService.getById(id));
    }

    @PostMapping("/cart")
    public ResponseEntity<UUID> create(@RequestBody @Valid CartRecordDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.create(dto));
    }

    @PutMapping("/cart/{id}")
    public ResponseEntity<UUID> update(@PathVariable UUID id, @RequestBody @Valid CartRecordDto dto) {
        return ResponseEntity.ok(cartService.update(id, dto));
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<UUID> delete(@PathVariable UUID id) {
        cartService.delete(id);
        return ResponseEntity.ok(id);
    }
}
