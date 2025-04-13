package com.br.cawe.ecommerce.adapters.presenters;

import com.br.cawe.ecommerce.common.dtos.rest.produto.ListProductsResponseDTO;
import com.br.cawe.ecommerce.common.dtos.rest.produto.RegisterProductRequestDTO;
import com.br.cawe.ecommerce.common.dtos.rest.produto.RegisterProductResponseDTO;
import com.br.cawe.ecommerce.common.dtos.rest.produto.UpdateProductResponseDTO;
import com.br.cawe.ecommerce.entities.Product;

public interface ProductRestPresenter {

    Product toDomain(RegisterProductRequestDTO request);

    RegisterProductResponseDTO toRegisterProductResponseDTO(Product domain);

    ListProductsResponseDTO toListProductsResponse(Product domain);

    UpdateProductResponseDTO toUpdateProductResponse(Product domain);

}
