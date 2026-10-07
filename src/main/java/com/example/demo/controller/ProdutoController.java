package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}