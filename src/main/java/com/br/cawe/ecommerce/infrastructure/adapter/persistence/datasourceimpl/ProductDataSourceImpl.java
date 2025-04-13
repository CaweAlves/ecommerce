package com.br.cawe.ecommerce.infrastructure.adapter.persistence.datasourceimpl;

import com.br.cawe.ecommerce.common.interfaces.ProductDataSource;
import com.br.cawe.ecommerce.infrastructure.adapter.persistence.entity.ProductEntity;
import com.br.cawe.ecommerce.infrastructure.adapter.persistence.repository.ProductRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductDataSourceImpl implements ProductDataSource {

    private final ProductRepositoryJpa productRepositoryJpa;

    @Override
    public ProductEntity save(ProductEntity entity) {
        return productRepositoryJpa.save(entity);
    }

    @Override
    public Optional<ProductEntity> findById(Integer id) {
        return productRepositoryJpa.findById(id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepositoryJpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
     productRepositoryJpa.deleteById(id);
    }
}
