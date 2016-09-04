<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- foreach é de uma biblioteca de tags, chamada core. -->
<ul>
	Resultado da busca:
	<c:forEach var="empresa" items="${empresas }">
		<li>${empresa.id } : ${empresa.nome }
	</c:forEach>
</ul>
</body>
</html>