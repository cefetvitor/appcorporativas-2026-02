package br.cefetrj.appcorp.service;

import javax.sql.DataSource;

import br.cefetrj.appcorp.dao.PessoaDAO;
import br.cefetrj.appcorp.model.Pessoa;

public class PessoaService extends GenericService<Pessoa>{
    
    public PessoaService(DataSource dataSource) {
        super(new PessoaDAO(dataSource));
    }
}