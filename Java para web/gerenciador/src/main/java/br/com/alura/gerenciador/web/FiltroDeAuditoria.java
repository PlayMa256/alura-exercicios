package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter{

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
    	
    	HttpServletRequest req = (HttpServletRequest) request;
    	String usuario = getUsuario(req);
    	
    	System.out.println(req.getRequestURI() + " usuario logado: " + usuario);
    	chain.doFilter(request, response);
    }
    private String getUsuario(HttpServletRequest req){
    	Usuario usuarioLogado = (Usuario) req.getSession().getAttribute("usuarioLogado");
    	if(usuarioLogado == null) return "deslogado";
		return usuarioLogado.getEmail();
    }

}
