package br.com.jla.cadastroDeProdutos.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoriaRequestDTO {

    // Usamos @NotBlank para garantir que o campo não seja nulo nem vazio
    @NotBlank(message = "O nome da categoria é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    private String nome;
    private String descricao;

    // Construtor vazio (necessário para o Jackson/Spring)
    public CategoriaRequestDTO() {
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}