package com.project.visioncare.services;

import com.project.visioncare.dtos.CartRecordDto;
import com.project.visioncare.exceptions.NotFoundException;
import com.project.visioncare.models.CartModel;
import com.project.visioncare.repositories.CartRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    private final String notFoundMessage = "Cart not found";

    public List<CartModel> listAll() {
        return cartRepository.findAll();
    }

    public CartModel getById(UUID id) {
        return cartRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));
    }

    public UUID create(CartRecordDto dto) {
        var model = new CartModel();
        BeanUtils.copyProperties(dto, model);
        return cartRepository.save(model).getId();
    }

    public UUID update(UUID id, CartRecordDto dto) {
        var model = cartRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));

        BeanUtils.copyProperties(dto, model);
        return cartRepository.save(model).getId();
    }

    public void delete(UUID id) {
        var found = cartRepository.findById(id);

        if (found.isEmpty()) throw new NotFoundException(notFoundMessage);

        cartRepository.delete(found.get());
    }
}
