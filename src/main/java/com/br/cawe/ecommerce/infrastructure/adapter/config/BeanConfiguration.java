package com.br.cawe.ecommerce.infrastructure.adapter.config;

import com.br.cawe.ecommerce.common.interfaces.ProductDataSource;
import com.br.cawe.ecommerce.infrastructure.adapter.persistence.datasourceimpl.ProductDataSourceImpl;
import com.br.cawe.ecommerce.infrastructure.adapter.persistence.repository.ProductRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductDataSource productDataSource(ProductRepositoryJpa productRepositoryJpa) {
        return new ProductDataSourceImpl(productRepositoryJpa);
    }

}
