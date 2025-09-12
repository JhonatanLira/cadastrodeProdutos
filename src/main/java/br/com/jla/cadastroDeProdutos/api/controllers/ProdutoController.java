package br.com.jla.cadastroDeProdutos.api.controllers;

import br.com.jla.cadastroDeProdutos.domain.models.Produto;
import br.com.jla.cadastroDeProdutos.domain.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@Tag(name = "produtos",description = "Descrição dos produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    @Operation(summary = "Listar todos os produtos")
    public List<Produto> listarProdutos(){
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/id")
    @Operation(summary = "busca produto por id")
    public Produto buscaProduto(@RequestParam("id") Long id){
        return ResponseEntity.ok(produtoService.buscaPorId(id)).getBody().get();
    }




}
