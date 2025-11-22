package com.project.visioncare.repositories;

import com.project.visioncare.models.CartItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemModel, UUID> {
}
