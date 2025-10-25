package br.com.jla.cadastroDeProdutos.domain.services.categoria;

import br.com.jla.cadastroDeProdutos.domain.models.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> buscarTodas();

    Optional<Categoria> salvar(Optional<Categoria> categoriaOptional);

    Optional<Categoria> atualizar(Long id, Categoria categoriaAtualizada);

    Categoria buscarPorId(Long id);

    void remover(Long id);
}
