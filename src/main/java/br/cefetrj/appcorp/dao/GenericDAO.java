package br.cefetrj.appcorp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import br.cefetrj.appcorp.model.GenericEntity;
public abstract class GenericDAO<T extends GenericEntity> {
    protected final DataSource dataSource;
    public GenericDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    protected abstract String getInsertSql();

    protected abstract void setInsertParameters(
        PreparedStatement statement,
        T entity
    ) throws SQLException;
    public void create(T entity) {
        String sql = getInsertSql();

        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                connection.prepareStatement(sql)
        ) {

            setInsertParameters(statement, entity);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao criar entidade",
                e
            );
        }
    }
    public List<T> getAll() {
        return null;
    } 
    public T getById(Long id) {
        return null;
    }
    protected abstract String getUpdateSql();
     protected abstract void setUpdateParameters(
        PreparedStatement statement,
        T entity
    ) throws SQLException;
    public void update(T entity) {
         String sql = getUpdateSql();

        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                connection.prepareStatement(sql)
        ) {

            setUpdateParameters(statement, entity);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao atualizar entidade",
                e
            );
        }
    }
    protected abstract String getTableName();
    public void delete(T entity) {

        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                connection.prepareStatement("DELETE FROM "+this.getTableName()+" WHERE id=?")
        ) {
            statement.setLong(1, entity.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao remover entidade",
                e
            );
        }
    }
}