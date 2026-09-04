package br.cefetrj.appcorp.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bemvindo")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
                int oi = Integer.valueOf(request.getParameter("oi")).intValue();
                String nome = request.getParameter("nome");
                
                request.setAttribute("nome2", nome);
                request.setAttribute("oi2", oi);
                request.getRequestDispatcher("/oi.jsp").forward(request, response);
            }

    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException{
            doGet(request, response);
        }
}
