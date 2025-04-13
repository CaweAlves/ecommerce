package com.br.cawe.ecommerce.common.interfaces;

import com.br.cawe.ecommerce.infrastructure.adapter.persistence.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductDataSource {

    ProductEntity save(ProductEntity entity);

    Optional<ProductEntity> findById(Integer id);

    List<ProductEntity> findAll();

    void deleteById(Integer id);
}
