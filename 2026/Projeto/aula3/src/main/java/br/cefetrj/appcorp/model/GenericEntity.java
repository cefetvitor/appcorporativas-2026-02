package br.cefetrj.appcorp.model;

import java.time.LocalDate;

import lombok.Data;

@Data 
public abstract class GenericEntity {
    private Long id;

    private Pessoa quemCadastrou;

    private Pessoa quemAlterouAUltimavez;

    private LocalDate dataCadastro;

    private LocalDate dataUltimaAlteracao;
}
