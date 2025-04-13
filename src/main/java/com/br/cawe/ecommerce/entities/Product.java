package com.br.cawe.ecommerce.entities;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(max = 100)
    private String name;

    @NotEmpty(message = "Description cannot be empty")
    @Size(max = 100)
    private String description;

    @Positive
    @NotNull(message = "The price must be provided")
    private BigDecimal price;
}
