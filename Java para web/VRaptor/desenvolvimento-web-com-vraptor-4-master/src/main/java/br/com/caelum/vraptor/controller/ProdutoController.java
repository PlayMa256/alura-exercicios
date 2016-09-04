package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.commons.mail.SimpleEmail;
import org.hibernate.validator.constraints.Email;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {
	
	//o vraptor irá criar a dependencia sozinho.
	private final Result result;
	private final ProdutoDao dao;
	private final Validator validator;
	
	@Inject
	//o vraptor irá criar o result por aqui tambem.
	public ProdutoController(Result result, ProdutoDao dao, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}
	
	//sempre que fizer a injeção de dependencia com construtor, criar construtor sem argumentos.
	public ProdutoController() {
		this(null, null, null);
	}
	
	
	
	@Get("/") 
	//crio então uma pasta em web-info com o nome da classe, e depois um jsp com o nome do metodo
	public void inicio(){
		
	}
	

	//vraptor ja conside /controller/metodo
	@Get
	public void lista(){
		result.include("produtoList", dao.lista());
	}
	@Get
	public void listaXml(){
		result.use(Results.xml()).from(dao.lista()).serialize();;
	}
	
	@Get
	public void formulario(){
		
	}
	
	@Post
	public void adiciona(@Valid Produto produto){
		//quantidade.negativa será atribuida em resources/messages.properties
		validator.onErrorForwardTo(this).formulario();
		
		
		dao.adiciona(produto);	
		//redefinindo a route, so que não mudaria a url, só mudaria a logica internamente
//		result.forwardTo(this).lista();
		//inserindo mensagem.
		result.include("mensagem", "Inserido com sucesso");
		//redirecinando mudando a url.
		result.redirectTo(this).lista();
		
	}
	@Delete
	public void remove(Produto produto){
		dao.remove(produto);				
	}
	@Get
	public void enviaPedidoDeNovosItens(){
		
		Email simpleEmail = (Email) new SimpleEmail();
		
		
	}
}
