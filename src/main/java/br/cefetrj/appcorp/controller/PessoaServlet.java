package br.cefetrj.appcorp.controller;

import java.io.IOException;
import java.util.List;

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

    private PessoaService getPessoaService() {
        DataSource dataSource =
            (DataSource) getServletContext()
                .getAttribute("dataSource");
        return new PessoaService(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        List<Pessoa> pessoas = getPessoaService().getAll();
        req.setAttribute("pessoas", pessoas);
        req.getRequestDispatcher("/pessoas/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException {
        PessoaService pessoaService = getPessoaService();
        String id = req.getParameter("id");
        boolean edicao = id != null && !id.isEmpty();

        Pessoa pessoa = edicao
            ? pessoaService.getById(Long.valueOf(id))
            : new Pessoa();
        pessoa.setNome(req.getParameter("nome"));
        pessoa.setDataNascimento(
            java.time.LocalDate.parse(req.getParameter("dataNascimento"))
        );

        if (edicao) {
            pessoaService.update(pessoa);
        } else {
            pessoaService.create(pessoa);
        }
        resp.sendRedirect(req.getContextPath() + "/pessoas");
    }

}
