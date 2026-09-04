package br.cefetrj.appcorp.model;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Pessoa extends GenericEntity{

    private String nome;

    private Long cpf;

    private LocalDate dataNascimento;
}
