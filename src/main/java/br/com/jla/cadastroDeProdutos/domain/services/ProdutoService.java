package br.com.jla.cadastroDeProdutos.domain.services;

import br.com.jla.cadastroDeProdutos.domain.models.Produto;
import br.com.jla.cadastroDeProdutos.domain.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<Produto> listarTodosProdutos() {

        return produtoRepository.findAll();
    }

    public Optional<Produto> buscaPorId(Long id) {
        return produtoRepository.findById(id);
    }

    @Transactional
    public void salvaProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    @Transactional
    public void deletaProduto(Produto produto) {
        produtoRepository.delete(produto);
    }


}
