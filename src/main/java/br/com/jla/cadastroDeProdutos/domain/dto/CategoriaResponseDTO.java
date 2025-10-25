package br.com.jla.cadastroDeProdutos.domain.dto;

public class CategoriaResponseDTO {

    private Long id;
    private String nome;

    // Construtor vazio (necessário para o Jackson/Spring)
    public CategoriaResponseDTO() {
    }

    // Construtor para mapeamento (útil no Service)
    public CategoriaResponseDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}