package com.stoom.loja.produto.service;

import com.stoom.loja.produto.dto.ProdutoDto;
import com.stoom.loja.produto.entity.Produto;
import com.stoom.loja.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repository;

    @Override
    public Produto createProduto(ProdutoDto produtoDto) {
        return repository.save(produtoDto.toEntity());
    }

    @Override
    public Optional<Produto> getProdutoById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Produto> getProdutos() {
        return repository.findAll();
    }

    @Override
    public List<Produto> getProdutosByMarca(String marca) {
        return repository.findAllByMarca(marca);
    }

    @Override
    public List<Produto> obterProdutosByCategoria(String categoria) {
        return repository.findAllByCategoria(categoria);
    }

    @Override
    public void deleteProduto(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Produto> updateProduto(Long id, ProdutoDto produtoDto) {

        Optional<Produto> produtoAtual = getProdutoById(id);
        if (produtoAtual.isEmpty()) {
            return produtoAtual;
        }

        Produto produtoAlterado = produtoAtual.get();
        produtoAlterado.setNome(produtoDto.nome());
        produtoAlterado.setPreco(produtoDto.preco());
        produtoAlterado.setAtivo(produtoDto.disponivel());
        produtoAlterado.setMarca(produtoDto.marca());
        produtoAlterado.setCategoria(produtoDto.categoria());

        return Optional.of(repository.save(produtoAlterado));
    }
}
