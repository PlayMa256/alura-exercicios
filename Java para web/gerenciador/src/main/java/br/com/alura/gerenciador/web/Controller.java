package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet {

	private String pagina;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		
		//qual tarefa
		if(tarefa == null){
			throw new IllegalArgumentException("vc esqueceu de passar a tarefa");
		}

		tarefa = "br.com.alura.gerenciar.web."+tarefa;
		
		//usar api que converte api para instancia de classe
		
		try {
			Class<?> tipo;
			tipo = Class.forName(tarefa);
			Tarefa instancia = (Tarefa) tipo.newInstance();	
			pagina = instancia.executa(req, resp);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
			requestDispatcher.forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		
		// redirecionar
		
		
		
	}
	
}
