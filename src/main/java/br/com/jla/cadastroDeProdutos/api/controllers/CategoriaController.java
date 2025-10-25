package br.com.jla.cadastroDeProdutos.api.controllers;

import br.com.jla.cadastroDeProdutos.domain.models.Categoria;
import br.com.jla.cadastroDeProdutos.domain.services.categoria.CategoriaServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/categorias")
@Tag(name = "Categoria", description = "Cadastro de categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @GetMapping
    public List<Categoria> buscarTodos() {
        return categoriaService.buscarTodas();
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria) {

        Optional<Categoria> categoriaOptional = Optional.of(categoria);

        return categoriaService.salvar(categoriaOptional).map(Categoria -> new ResponseEntity<>(categoria, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable(value = "id") Long id) {

        if (categoriaService.buscarPorId(id) == null) {

            return ResponseEntity.notFound().build();//404
        }
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {

        if (categoriaService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();//404
        }
        categoriaService.atualizar(id, categoria);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> remover(@PathVariable Long id) {

        if (categoriaService.buscarPorId(id) != null) {
            categoriaService.remover(id);
            return ResponseEntity.noContent().build(); //204
        }
        return ResponseEntity.notFound().build(); //404
    }
}