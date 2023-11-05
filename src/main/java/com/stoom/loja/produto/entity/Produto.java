package com.stoom.loja.produto.entity;

import com.stoom.loja.produto.dto.ProdutoDto;
import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String nome;
        double preco;
        boolean disponivel;
        String marca;
        String categoria;

        public Produto() {
        }

        public Produto(String nome, double preco, boolean disponivel, String marca, String categoria) {
                this.nome = nome;
                this.preco = preco;
                this.disponivel = disponivel;
                this.marca = marca;
                this.categoria = categoria;
        }

        public Produto fromDto(ProdutoDto produtoDto) {
                return new Produto(
                        produtoDto.nome(),
                        produtoDto.preco(),
                        produtoDto.disponivel(),
                        produtoDto.marca(),
                        produtoDto.categoria()
                );
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public double getPreco() {
                return preco;
        }

        public void setPreco(double preco) {
                this.preco = preco;
        }

        public boolean isDisponivel() {
                return disponivel;
        }

        public void setAtivo(boolean disponivel) {
                this.disponivel = disponivel;
        }

        public String getMarca() {
                return marca;
        }

        public void setMarca(String marca) {
                this.marca = marca;
        }

        public String getCategoria() {
                return categoria;
        }

        public void setCategoria(String categoria) {
                this.categoria = categoria;
        }
}