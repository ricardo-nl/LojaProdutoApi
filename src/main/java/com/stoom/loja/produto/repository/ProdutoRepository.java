package com.stoom.loja.produto.repository;

import com.stoom.loja.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    List<Produto> findByAtivoIsTrueAndMarca(String marca);

    List<Produto> findByAtivoIsTrueAndCategoria(String categoria);
}
