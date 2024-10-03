package br.edu.uniara.api.projetoApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Dto {
    @Id
    @GeneratedValue
    private Long chave;

    private String nome;

    private String tipo;

    public Dto(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }
}
