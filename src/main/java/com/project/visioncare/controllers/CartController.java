package com.project.visioncare.controllers;

import com.project.visioncare.models.CartModel;
import com.project.visioncare.services.CartService;
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
    public ResponseEntity<UUID> create(@RequestBody CartModel model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.create(model));
    }

    @PutMapping("/cart/{id}")
    public ResponseEntity<UUID> update(@PathVariable UUID id, @RequestBody CartModel model) {
        return ResponseEntity.ok(cartService.update(id, model));
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<UUID> delete(@PathVariable UUID id) {
        cartService.delete(id);
        return ResponseEntity.ok(id);
    }
}
