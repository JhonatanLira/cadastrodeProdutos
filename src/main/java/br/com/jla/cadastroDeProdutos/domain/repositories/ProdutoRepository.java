package br.com.jla.cadastroDeProdutos.domain.repositories;

import br.com.jla.cadastroDeProdutos.domain.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    @Override
    List<Produto> findAll();

    @Override
    Optional<Produto> findById(Long id);

}
