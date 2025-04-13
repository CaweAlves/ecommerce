package com.br.cawe.ecommerce.infrastructure.adapter.persistence.repository;

import com.br.cawe.ecommerce.infrastructure.adapter.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepositoryJpa extends JpaRepository<ProductEntity, Integer> {
}
