package br.cefetrj.appcorp.config;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Registra no log (console) qualquer exceção lançada por Servlets ou JSPs.
 *
 * Por padrão o Tomcat grava essas exceções apenas no arquivo
 * logs/localhost.AAAA-MM-DD.log, e não no console.
 */
@WebFilter(urlPatterns = "/*", dispatcherTypes = { DispatcherType.REQUEST })
public class ErrorLoggingFilter extends HttpFilter {

    private static final Logger logger = LogManager.getLogger(ErrorLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (IOException | ServletException | RuntimeException | Error e) {
            HttpServletRequest req = (HttpServletRequest) request;
            logger.error("Erro ao processar {} {}", req.getMethod(), req.getRequestURI(), e);
            // Relança para o Tomcat continuar tratando (página de erro / status 500)
            throw e;
        }
    }
}
