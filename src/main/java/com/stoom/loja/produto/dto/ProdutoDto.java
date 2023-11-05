package com.stoom.loja.produto.dto;

import com.stoom.loja.produto.entity.Produto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDto(
        @NotBlank(message = "O campo 'nome' é obrigatório e não pode estar em branco")
        String nome,
        @DecimalMin(value = "0.0", inclusive = false, message = "O campo 'preco' é obrigatório e deve ser válido")
        double preco,
        @NotNull(message = "O campo 'disponivel' é obrigatório e não pode estar em branco")
        boolean disponivel,
        @NotBlank(message = "O campo 'marca' é obrigatório e não pode estar em branco")
        String marca,
        @NotBlank(message = "O campo 'categoria' é obrigatório e não pode estar em branco")
        String categoria
) {
        public Produto toEntity() {
                return new Produto(
                        this.nome(),
                        this.preco(),
                        this.disponivel(),
                        this.marca(),
                        this.categoria()
                );
        }
}
