package br.com.jla.cadastroDeProdutos.domain.services.categoria;

import br.com.jla.cadastroDeProdutos.domain.models.Categoria;
import br.com.jla.cadastroDeProdutos.dao.categoriadao.CategoriaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;


    @Override
    public List<Categoria> buscarTodas() {
        return categoriaDao.findAll();
    }

    @Override
    public Optional<Categoria> salvar(Optional<Categoria> categoriaOptional) {

        if (categoriaOptional.isPresent()) {

            Categoria categoria = new Categoria();
            categoria = Optional.of(categoriaOptional).get().get();
            categoriaDao.save(categoria);

            return categoriaOptional;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Categoria> atualizar(Long id, Categoria categoriaAtualizada) {
        var categoria = buscarPorId(id);
        Optional<Categoria> categoriaOptional = Optional.of(categoria);

        if (categoriaOptional.isEmpty()) {
            return Optional.empty();
        }
        categoria.setId(id);
        categoria.setNome(categoriaAtualizada.getNome());
        categoria.setDescricao(categoriaAtualizada.getDescricao());
        categoriaDao.update(categoria);
        return categoriaOptional;
    }

    @Override
    public Categoria buscarPorId(Long id) {

        return categoriaDao.findById(id);
    }

    @Override
    public void remover(Long id) {

        categoriaDao.delete(id);
    }
}
