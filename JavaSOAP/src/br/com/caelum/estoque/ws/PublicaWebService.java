package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaWebService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstoqueWS service = new EstoqueWS();
		String url = "http://localhost:8080/estoquews";
		Endpoint.publish(url, service);
		
	}

}
