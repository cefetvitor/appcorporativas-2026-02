package br.cefetrj.appcorp.dao;

import java.sql.Date;

import br.cefetrj.appcorp.model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class PessoaDAO extends GenericDAO<Pessoa>{

	public PessoaDAO(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	protected String getInsertSql() {
		return "INSERT INTO pessoa (nome, dataNascimento, quemCadastrou, quemAlterouAUltimavez, dataCadastro, dataUltimaAlteracao) VALUES (?, ?, ?, ?, ?, ?)";
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

	@Override
	protected String getUpdateSql() {
		return "UPDATE pessoa SET nome=?, dataNascimento=?, quemAlterouAUltimavez=?, dataUltimaAlteracao=? WHERE id=?";
	}

	@Override
	protected void setUpdateParameters(PreparedStatement statement, Pessoa pessoa)
			throws SQLException {
		statement.setString(1, pessoa.getNome());
		statement.setDate(2, Date.valueOf(pessoa.getDataNascimento()));
		statement.setLong(3, pessoa.getQuemAlterouAUltimavez().getId());
		statement.setDate(4, Date.valueOf(pessoa.getDataUltimaAlteracao()));
		statement.setLong(5, pessoa.getId());
	}

	@Override
	protected String getTableName() {
		return "pessoa";
	}

	@Override
	protected Pessoa mapResultSetToEntity(ResultSet resultSet) throws SQLException {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(resultSet.getLong("id"));
		pessoa.setNome(resultSet.getString("nome"));
		pessoa.setDataNascimento(resultSet.getDate("dataNascimento").toLocalDate());
		pessoa.setDataCadastro(resultSet.getDate("dataCadastro").toLocalDate());
		pessoa.setDataUltimaAlteracao(resultSet.getDate("dataUltimaAlteracao").toLocalDate());

		long quemCadastrouId = resultSet.getLong("quemCadastrou");
		if (!resultSet.wasNull()) {
			pessoa.setQuemCadastrou(this.getById(quemCadastrouId));
		}

		long quemAlterouAUltimavezId = resultSet.getLong("quemAlterouAUltimavez");
		if (!resultSet.wasNull()) {
			pessoa.setQuemAlterouAUltimavez(this.getById(quemAlterouAUltimavezId));
		}

		return pessoa;
	}

}
