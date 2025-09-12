package br.com.jla.cadastroDeProdutos.domain.services;

import br.com.jla.cadastroDeProdutos.domain.models.Categoria;
import br.com.jla.cadastroDeProdutos.domain.models.Produto;
import br.com.jla.cadastroDeProdutos.domain.repositories.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listaTodasCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    @Transactional
    public void salvaCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Transactional
    public void deletaCategoria(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }

}
