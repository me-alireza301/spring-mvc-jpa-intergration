<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="pessoa" action="${pageContext.request.contextPath}/pessoa/save">
	<c:if test="${not empty pessoa.id}">
		<form:hidden path="id" />
	</c:if>
	Nome: <form:input path="nome" /><br />
	Telefone: <form:input path="telefone" /><br />
	<input type="submit" value="enviar" />
</form:form>
</body>
</html>