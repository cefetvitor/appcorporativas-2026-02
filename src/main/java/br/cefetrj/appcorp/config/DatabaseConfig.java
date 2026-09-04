package br.cefetrj.appcorp.config;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConfig {
     private final HikariDataSource dataSource;

    public DatabaseConfig() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(
            "jdbc:mysql://localhost:3306/meubanco" +
            "?useSSL=false" +
            "&serverTimezone=UTC"
        );

        config.setUsername("root");
        config.setPassword("senha");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);

        this.dataSource = new HikariDataSource(config);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void close() {
        dataSource.close();
    }
}
