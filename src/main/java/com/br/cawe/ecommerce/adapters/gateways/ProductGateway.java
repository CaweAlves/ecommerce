package com.br.cawe.ecommerce.adapters.gateways;

import com.br.cawe.ecommerce.adapters.gateways.mapper.ProductPersistenceMapper;
import com.br.cawe.ecommerce.common.interfaces.ProductDataSource;
import com.br.cawe.ecommerce.entities.Product;
import com.br.cawe.ecommerce.infrastructure.adapter.persistence.entity.ProductEntity;
import jakarta.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class ProductGateway {

    private final ProductDataSource productDataSource;
    private final ProductPersistenceMapper productPersistenceMapper;

    public ProductGateway(ProductDataSource productDataSource) {
        this.productDataSource = productDataSource;
        this.productPersistenceMapper = Mappers.getMapper(ProductPersistenceMapper.class);
    }

    @Transactional
    public Product create(Product product) {
        ProductEntity entity = productPersistenceMapper.toEntity(product);
        entity = productDataSource.save(entity);
        return productPersistenceMapper.toDomain(entity);
    }

    public List<Product> findAll() {
        return productDataSource.findAll().stream().map(productPersistenceMapper::toDomain).toList();
    }

    public Product findById(Integer id) {
        ProductEntity productEntity = productDataSource.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The product %s was not found.", id)));
        return productPersistenceMapper.toDomain(productEntity);
    }

}
