package br.edu.uniara.api.projetoApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class DtoUsuario {
    @Id
    @GeneratedValue
    private Long chave;

    private String nome;

    private String senha;

    public DtoUsuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
}
