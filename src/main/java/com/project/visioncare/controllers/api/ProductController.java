package com.project.visioncare.controllers.api;

import com.project.visioncare.dtos.ProductRecordDto;
import com.project.visioncare.models.ProductModel;
import com.project.visioncare.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> listProducts() {
        return ResponseEntity.ok(productService.listAll());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductModel> getOneProduct(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping("/product")
    public ResponseEntity<UUID> createProduct(@RequestBody @Valid ProductRecordDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(dto));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<UUID> editProduct(@PathVariable UUID id, @RequestBody @Valid ProductRecordDto dto) {
        return ResponseEntity.ok(productService.update(id, dto));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<UUID> deleteProduct(@PathVariable UUID id) {
        productService.delete(id);
        return ResponseEntity.ok(id);
    }

}
