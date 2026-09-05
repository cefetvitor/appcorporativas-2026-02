package br.cefetrj.appcorp.controller;

import java.io.IOException;

import javax.sql.DataSource;

import br.cefetrj.appcorp.model.Pessoa;
import br.cefetrj.appcorp.service.PessoaService;
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

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(req.getParameter("nome"));
        pessoa.setDataNascimento(
            java.time.LocalDate.parse(req.getParameter("dataNascimento"))
        );
        PessoaService pessoaService = new PessoaService(dataSource);
        pessoaService.create(pessoa);
        super.doPost(req, resp);
    }

}