package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("usuarioLogado");
		
		//ranca tudo relacionado da session
		//req.getSession().invalidate();
		//resp.sendRedirect("logout.html");
		//vc ta enviando para o servidor
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		requestDispatcher.forward(req, resp);
		
	}
}
