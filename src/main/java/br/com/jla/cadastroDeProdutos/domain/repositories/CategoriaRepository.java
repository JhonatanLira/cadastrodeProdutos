package br.com.jla.cadastroDeProdutos.domain.repositories;

import br.com.jla.cadastroDeProdutos.domain.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    @Override
    List<Categoria> findAll();
}
