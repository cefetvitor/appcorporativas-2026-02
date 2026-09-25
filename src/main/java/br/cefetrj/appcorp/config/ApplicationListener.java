package br.cefetrj.appcorp.config;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class ApplicationListener implements ServletContextListener {

    private static final Logger logger = LogManager.getLogger(ApplicationListener.class);

    private DatabaseConfig databaseConfig;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        logger.info("Inicializando conexão com o banco de dados...");

        try {
            databaseConfig = new DatabaseConfig();
        } catch (RuntimeException e) {
            logger.error("Erro ao conectar no banco de dados: {}", rootCauseMessage(e), e);
            // Relança para o Tomcat interromper o deploy da aplicação
            throw e;
        }

        DataSource dataSource = databaseConfig.getDataSource();

        event.getServletContext()
             .setAttribute("dataSource", dataSource);

        logger.info("Conexão com o banco de dados estabelecida com sucesso.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        if(databaseConfig != null) {
            databaseConfig.close();
        }
    }

    private static String rootCauseMessage(Throwable e) {
        Throwable cause = e;
        while (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return cause.getClass().getSimpleName() + ": " + cause.getMessage();
    }
}
