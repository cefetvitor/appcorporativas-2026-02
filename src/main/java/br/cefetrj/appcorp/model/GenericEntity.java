package br.cefetrj.appcorp.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data 
@Entity
@MappedSuperclass
public abstract class GenericEntity {
    @Id 
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private Pessoa quemCadastrou;

    private Pessoa quemAlterouAUltimavez;

    private LocalDate dataCadastro;

    private LocalDate dataUltimaAlteracao;
}
