package com.stoom.loja.produto.dto;

import com.stoom.loja.produto.entity.Produto;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record ProdutoDto(
        @NotBlank(message = "O nome não pode estar em branco")
        String nome,
        @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser válido")
        double preco,
        @AssertTrue(message = "O produto deve estar ativo")
        boolean ativo,
        @NotBlank(message = "A marca não pode estar em branco")
        String marca,
        @NotBlank(message = "A categoria não pode estar em branco")
        String categoria
) {
        public Produto toEntity() {
                return new Produto(
                        this.nome(),
                        this.preco(),
                        this.ativo(),
                        this.marca(),
                        this.categoria()
                );
        }
}
