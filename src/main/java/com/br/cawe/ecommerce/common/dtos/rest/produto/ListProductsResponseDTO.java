package com.br.cawe.ecommerce.common.dtos.rest.produto;

import java.math.BigDecimal;

public record ListProductsResponseDTO(Integer id,
                                      String name,
                                      String description,
                                      BigDecimal price) {
}
