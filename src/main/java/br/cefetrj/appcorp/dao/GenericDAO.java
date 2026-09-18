package br.cefetrj.appcorp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    public List<T> getAll() {
        String sql = "SELECT * FROM " + this.getTableName();
        List<T> entities = new ArrayList<>();

        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {
                entities.add(mapResultSetToEntity(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao buscar entidades",
                e
            );
        }

        return entities;
    }

    public T getById(Long id) {
        String sql = "SELECT * FROM " + this.getTableName() + " WHERE id=?";

        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                connection.prepareStatement(sql)
        ) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToEntity(resultSet);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao buscar entidade",
                e
            );
        }

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