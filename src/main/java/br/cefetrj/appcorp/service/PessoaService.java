package br.cefetrj.appcorp.service;

import br.cefetrj.appcorp.dao.PessoaDAO;
import br.cefetrj.appcorp.model.Pessoa;

public class PessoaService extends GenericService<Pessoa>{
    
    public PessoaService() {
        super(new PessoaDAO());
    }
}