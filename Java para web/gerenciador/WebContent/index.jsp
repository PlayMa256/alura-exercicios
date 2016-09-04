<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<body>

<form action="novaEmpresa" method="post">
	Nome : <input type="text" name="nome" />
	<input type="submit" value="enviar" />
</form>

<form action="executa" method="POST">
	Email: <input type="email" name="email" />
	Senha: <input type="password" name="senha" />
	<input type="submit" value="enviar" />
</form>
<form action="logout" method="POST">
	<input type="submit" value="Deslogadr" />
</form>


<!-- executa tbm -->

<c:if test="${not empty usuarioLogado}">
	Logado como ${usuarioLogado.email}
</c:if> 


</body>
</html>