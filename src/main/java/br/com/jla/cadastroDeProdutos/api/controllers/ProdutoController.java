package br.com.jla.cadastroDeProdutos.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
@Tag(name = "produtos",description = "Descrição dos produtos")
public class ProdutoController {

    @GetMapping
    @Operation(summary = "Listar todos os produtos")
    public void listarProdutos(){

    }
}
