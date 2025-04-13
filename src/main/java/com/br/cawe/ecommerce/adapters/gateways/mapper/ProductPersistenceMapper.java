package com.br.cawe.ecommerce.adapters.gateways.mapper;

import com.br.cawe.ecommerce.entities.Product;
import com.br.cawe.ecommerce.infrastructure.adapter.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper()
public interface ProductPersistenceMapper {

    Product toDomain(ProductEntity entity);

    ProductEntity toEntity(Product domain);
}
