package com.stoom.loja.produto.controller;

import com.stoom.loja.produto.dto.ProdutoDto;
import com.stoom.loja.produto.entity.Produto;
import com.stoom.loja.produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping("/add")
    public ResponseEntity<?> createProduto(@RequestBody @Valid ProdutoDto produtoDto){
        Produto produto = service.createProduto(produtoDto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    /*
     * Intercepta e trata os erros de validacao do dto
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.badRequest().body("Bad Request: " + errorMessage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Optional<Produto> produto = service.getProdutoById(id);
        return produto.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public List<Produto> getAllProdutos() {
        return service.getAllProdutos();
    }

    @GetMapping("/marca/{marca}")
    public List<Produto> getAllProdutosAtivosByMarca(@PathVariable String marca) {
        return service.getProdutosAtivosByMarca(marca);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Produto> getAllProdutosAtivosByCategoria(@PathVariable String categoria) {
        return service.getProdutosAtivosByCategoria(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody @Valid ProdutoDto produtoDto){
        Optional<Produto> produtoUpdate = service.updateProduto(id, produtoDto);
        return produtoUpdate.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
