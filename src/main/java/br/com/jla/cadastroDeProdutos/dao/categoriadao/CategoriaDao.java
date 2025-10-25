package br.com.jla.cadastroDeProdutos.dao.categoriadao;

import br.com.jla.cadastroDeProdutos.domain.models.Categoria;

import java.util.List;

public interface CategoriaDao {

    void save(Categoria categoria);

    void update(Categoria categoria);

    void delete(Long id);

    Categoria findById(Long id);

    List<Categoria> findAll();
}
