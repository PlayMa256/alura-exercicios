<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de produtos</title>
</head>
<body>
<a href="<c:url value='/produto/formulario'/>">
    Adicionar mais produtos!
</a>
	<h1>Listagem de produtos do ${usuarioLogado.usuario.nome}</h1>
	<table class="table table-stripped table-bordered table-hover">
		<thrad>
			<tr>
				<th>Nome</th>
				<th>Valor</th>
				<th>Quantidade</th>
				<th>Ação</th>
			</tr>
		</thrad>
		<tbody>
			<c:forEach items="${produtoList}" var="produto">						
				<tr>
					<td>${produto.nome}</td>
					<td>${produto.valor}</td>
					<td>${produto.quantidade}</td>
					<td><a href="<c:url value='/produto/remover?produto.id=${produto.id}' />">Remover</a></td>
					<td>
						<c:url value='/produto/enviaPedidoNovoItens?produto.nome=${produto.nome}' var = "url" />
						<a href="${url }">Pedir mais items</a>
					</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	${mensagem }
</body>
</html>