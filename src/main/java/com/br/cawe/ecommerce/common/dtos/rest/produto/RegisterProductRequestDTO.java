package com.br.cawe.ecommerce.common.dtos.rest.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RegisterProductRequestDTO(@NotBlank
                                        String name,
                                        @NotBlank
                                        String description,
                                        @NotNull
                                        BigDecimal price) {
}
