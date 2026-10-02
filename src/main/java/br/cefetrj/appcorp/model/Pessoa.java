package br.cefetrj.appcorp.model;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity 
public class Pessoa extends GenericEntity{

    private String nome;

    private LocalDate dataNascimento;
}
