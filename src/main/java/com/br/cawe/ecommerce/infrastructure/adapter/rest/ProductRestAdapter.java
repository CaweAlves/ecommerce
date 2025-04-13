package com.br.cawe.ecommerce.infrastructure.adapter.rest;

import com.br.cawe.ecommerce.adapters.controllers.ProductController;
import com.br.cawe.ecommerce.common.dtos.rest.produto.RegisterProductRequestDTO;
import com.br.cawe.ecommerce.common.dtos.rest.produto.RegisterProductResponseDTO;
import com.br.cawe.ecommerce.common.interfaces.ProductDataSource;
import com.br.cawe.ecommerce.infrastructure.adapter.HeaderUtil;
import com.br.cawe.ecommerce.infrastructure.adapter.persistence.entity.ProductEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
@RequestMapping("/api/v1/products")
public class ProductRestAdapter {

    public static final String ENTITY_NAME = ProductEntity.class.getName();

    private final ProductController productController;

    public ProductRestAdapter(ProductDataSource productDataSource) {
        this.productController = new ProductController(productDataSource);
    }

    @Value("${app.name}")
    private String applicationName;

    @PostMapping
    public ResponseEntity<RegisterProductResponseDTO> create(@RequestBody @Valid RegisterProductRequestDTO request) throws URISyntaxException {
        RegisterProductResponseDTO response = productController.create(request);
        HttpHeaders headers = HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, response.id().toString());
        return ResponseEntity.created(new URI("/api/v1/produtos/" + response.id())).headers(headers).body(response);
    }

}
