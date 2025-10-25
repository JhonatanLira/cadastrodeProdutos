package br.com.jla.cadastroDeProdutos.dao.categoriadao;

import br.com.jla.cadastroDeProdutos.dao.AbstractDao;
import br.com.jla.cadastroDeProdutos.domain.models.Categoria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class CategoriaDaoImpl extends AbstractDao<Categoria, Long> implements CategoriaDao{

}