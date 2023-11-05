package com.stoom.loja.produto.exception;

public class ProdutoNotFoundException extends RuntimeException{
    public ProdutoNotFoundException(String message) {
        super(message);
    }
    public ProdutoNotFoundException(Long id) {
        super("Produto não encontrado com o id: " + id);
    }
}
