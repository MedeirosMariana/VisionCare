package com.project.visioncare.services;

import com.project.visioncare.exceptions.NotFoundException;
import com.project.visioncare.models.CartModel;
import com.project.visioncare.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    private static final String notFoundMessage = "Cart not found";

    public List<CartModel> listAll() {
        return cartRepository.findAll();
    }

    public CartModel getById(UUID id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));
    }

    public UUID create(CartModel model) {
        model.setId(null);
        return cartRepository.save(model).getId();
    }

    public UUID update(UUID id, CartModel model) {
        var exists = getById(id);
        model.setId(id);
        return cartRepository.save(model).getId();
    }

    public void delete(UUID id) {
        var exists = getById(id);
        cartRepository.delete(exists);
    }
}
