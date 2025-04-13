package com.br.cawe.ecommerce.adapters.controllers;

import com.br.cawe.ecommerce.adapters.gateways.ProductGateway;
import com.br.cawe.ecommerce.adapters.presenters.ProductRestPresenter;
import com.br.cawe.ecommerce.common.dtos.rest.produto.RegisterProductRequestDTO;
import com.br.cawe.ecommerce.common.dtos.rest.produto.RegisterProductResponseDTO;
import com.br.cawe.ecommerce.common.interfaces.ProductDataSource;
import com.br.cawe.ecommerce.entities.Product;
import com.br.cawe.ecommerce.usecases.CreateProductUseCase;
import org.mapstruct.factory.Mappers;

public class ProductController {
    private final ProductGateway productGateway;
    private final ProductRestPresenter productRestPresenter;

    public ProductController(ProductDataSource productDataSource) {
        this.productGateway = new ProductGateway(productDataSource);
        this.productRestPresenter = Mappers.getMapper(ProductRestPresenter.class);
    }

    public RegisterProductResponseDTO create(RegisterProductRequestDTO request) {
        Product product = productRestPresenter.toDomain(request);
        product = CreateProductUseCase.build(productGateway).execute(product);
        return productRestPresenter.toRegisterProductResponseDTO(product);
    }
}
