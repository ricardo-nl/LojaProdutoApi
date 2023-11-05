package com.stoom.loja.produto.service;

import com.stoom.loja.produto.dto.ProdutoDto;
import com.stoom.loja.produto.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Produto createProduto(ProdutoDto produtoDto);
    Optional<Produto> getProdutoById(Long id);
    Optional<Produto> updateProduto(Long id, ProdutoDto produtoDto);
    List<Produto> getAllProdutos();
    List<Produto> getProdutosAtivosByMarca(String marca);
    List<Produto> getProdutosAtivosByCategoria(String categoria);
    void deleteProduto(Long id);
}
