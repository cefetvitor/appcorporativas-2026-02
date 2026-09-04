package br.cefetrj.appcorp.controller;

import java.io.IOException;

import javax.sql.DataSource;

import br.cefetrj.appcorp.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pessoas")
public class PessoaServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException {
        DataSource dataSource =
            (DataSource) getServletContext()
                .getAttribute("dataSource");
        super.doPost(req, resp);
    }

}