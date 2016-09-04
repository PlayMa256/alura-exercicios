package br.com.alura.loja;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {
	public static void main(String[] args) throws IOException {
		//tudo que tiver aqui dentro será usado pelo servidor
		HttpServer server = inicializaServidor();
		System.out.println("Servidor criado com sucesso");
		System.in.read();
		server.stop();
	}

	public static HttpServer inicializaServidor() {
		ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
		//criando a url
		URI uri = URI.create("http://localhost:8080/");
		//gerando o servidor
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		return server;
	}
}
