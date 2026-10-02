package br.cefetrj.appcorp.dao;

import br.cefetrj.appcorp.model.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa>{

	public Class<Pessoa> getEntityClass() {
		return Pessoa.class;
	}
	public PessoaDAO() {
		super();
	}

}
