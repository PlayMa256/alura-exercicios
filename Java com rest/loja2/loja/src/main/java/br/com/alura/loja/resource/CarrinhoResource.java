package br.com.alura.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;

@Path("carrinhos")
public class CarrinhoResource {
	//fala que vai ter um id falando depois do recurso/id
	@Path("{id}")
	@GET
	//fala pra ele que é produzido um xml
	@Produces(MediaType.APPLICATION_XML)
	public String busca(@PathParam("id") long id){
		Carrinho busca = new CarrinhoDAO().busca(id);
		return busca.toXML();
	}
	
	@POST
	//porem ele consome alguma coisa
	@Consumes(MediaType.APPLICATION_XML)
	//nao precisa devolver nada, ja que está sendo devolvido o header apenas.
	public Response adiciona(String conteudo){
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		new CarrinhoDAO().adiciona(carrinho);
		URI uri = URI.create("/carrinhos/" + carrinho.getId());
		return Response.created(uri).build();
	}
	
	//criando subrecurso para acessar um dado dentro de um outro recurso
	@Path("{id}/produtos/{produtosID}")
	@DELETE
	public Response removeProduto(@PathParam("id") long id, @PathParam("produtoID") long produtoID){
		//aqui vc faz qqr coisa.
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		carrinho.remove(produtoID);
		return Response.ok().build();		
	}
	
	//trocando recurso por outro recurso - usando PUT
	@Path("{id}/produtos/{produtosID}/quantidade")
	@PUT
	public Response alteraProduto(String conteudo, @PathParam("id") long id, @PathParam("produtoID") long produtoID){
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		Produto produto = (Produto) new XStream().fromXML(conteudo);
		carrinho.trocaQuantidade(produto);
		return Response.ok().build();
		
		
	}
	
	
}
