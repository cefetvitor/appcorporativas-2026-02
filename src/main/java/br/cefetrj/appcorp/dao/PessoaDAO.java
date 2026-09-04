package br.cefetrj.appcorp.dao;

import java.sql.Date;

import br.cefetrj.appcorp.model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class PessoaDAO extends GenericDAO<Pessoa>{

	public PessoaDAO(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	protected String getInsertSql() {
		return "INSERT INTO pessoa (nome, cpf, quemCadastrou, quemAlterouAUltimavez, dataCadastro, dataUltimaAlteracao) VALUES (?, ?, ?, ?, ?, ?)";
	}

	@Override
	protected void setInsertParameters(PreparedStatement statement, Pessoa pessoa)
			throws SQLException {
		statement.setString(1, pessoa.getNome());
        statement.setDate(2, Date.valueOf(pessoa.getDataNascimento()));
        statement.setLong(3, pessoa.getQuemCadastrou().getId());
        statement.setLong(4, pessoa.getQuemAlterouAUltimavez().getId());
        statement.setDate(5, Date.valueOf(pessoa.getDataCadastro()));   
        statement.setDate(6, Date.valueOf(pessoa.getDataUltimaAlteracao()));
		
	}

}
