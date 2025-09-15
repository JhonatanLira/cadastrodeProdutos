package br.com.jla.cadastroDeProdutos.api.controllers;

import br.com.jla.cadastroDeProdutos.domain.models.Categoria;
import br.com.jla.cadastroDeProdutos.domain.services.CategoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categorias")
@Tag(name = "Categoria", description = "Cadastro de categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listaCategoorias() {
        return categoriaService.listaTodasCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscaPorId(@PathVariable(value = "id") Long id) {

        if (!categoriaService.idExiste(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoriaService.buscaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravaCategoria(@RequestBody @Valid Categoria categoria){
        if(!categoriaService.idExiste(categoria.getId())){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.created().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraCategoria(@PathVariable(value = "id") Long id, Categoria categoria){
        if(!categoriaService.idExiste(id)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deletaCategoria(@RequestBody Categoria categoria) {
        if (!categoriaService.idExiste(categoria.getId())) {
            return ResponseEntity.notFound().build();
        }

        categoriaService.deletaCategoria(categoria);
        return ResponseEntity.ok().build();
    }
}
