package com.project.visioncare.services;

import com.project.visioncare.dtos.ProductRecordDto;
import com.project.visioncare.exceptions.NotFoundException;
import com.project.visioncare.models.ProductModel;
import com.project.visioncare.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private final String notFoundMessage = "Product not found";

    public List<ProductModel> listAll() {
        return productRepository.findAll();
    }

    public ProductModel getById(UUID id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));
    }

    public UUID create(ProductRecordDto dto) {
        var product = new ProductModel();
        BeanUtils.copyProperties(dto, product);
        return productRepository.save(product).getId();
    }

    public UUID update(UUID id, ProductRecordDto dto) {
        var product = productRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));

        BeanUtils.copyProperties(dto, product);
        return productRepository.save(product).getId();
    }

    public void delete(UUID id) {
        var productFindById = productRepository.findById(id);

        if (productFindById.isEmpty()) throw new NotFoundException(notFoundMessage);

        productRepository.delete(productFindById.get());
    }
}
