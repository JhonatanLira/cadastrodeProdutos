package br.com.jla.cadastroDeProdutos.domain.repositories;

import br.com.jla.cadastroDeProdutos.domain.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    @Override
    List<Categoria> findAll();

    @Override
    Optional<Categoria> findById(Long id);

    @Override
    boolean existsById(Long id);
}
