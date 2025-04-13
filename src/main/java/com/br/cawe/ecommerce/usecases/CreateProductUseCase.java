package com.br.cawe.ecommerce.usecases;

import com.br.cawe.ecommerce.adapters.gateways.ProductGateway;
import com.br.cawe.ecommerce.entities.Product;

public class CreateProductUseCase {
    private final ProductGateway productGateway;

    private CreateProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public static CreateProductUseCase build(ProductGateway productGateway) {
        return new CreateProductUseCase(productGateway);
    }

    public Product execute(Product product) {
        return productGateway.create(product);
    }
}
