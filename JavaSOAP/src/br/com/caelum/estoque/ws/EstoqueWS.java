package br.com.caelum.estoque.ws;

import javax.jws.WebService;

@WebService
public class EstoqueWS {
	private ItemDao dao = new ItemDao();
	public List<Item> getItens(){
		System.out.println("Chamando getItens()");
		List<Item> lista = dao.todosItens();
		return lista;
	}
}
