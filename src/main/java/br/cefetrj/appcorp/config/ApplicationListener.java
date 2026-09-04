package br.cefetrj.appcorp.config;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import javax.sql.DataSource;

@WebListener
public class ApplicationListener implements ServletContextListener {

    private DatabaseConfig databaseConfig;

    @Override
    public void contextInitialized(ServletContextEvent event) {

        databaseConfig = new DatabaseConfig();

        DataSource dataSource = databaseConfig.getDataSource();

        event.getServletContext()
             .setAttribute("dataSource", dataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

        databaseConfig.close();
    }
}