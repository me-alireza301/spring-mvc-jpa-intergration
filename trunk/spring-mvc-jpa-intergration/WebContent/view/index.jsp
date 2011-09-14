<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link type="text/css" href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" />
<body>
	<div id="geral">
		<br />
		<div id="caixa-de-busca">
			<img alt="logo" src="${pageContext.request.contextPath}/imagem/logo.jpg" />
			<form action="${pageContext.request.contextPath}/card/busca.java">
				<input type="text" name="q" />
				<input type="submit" value="buscar" />
			</form>
		</div>
	</div>
</body>
</html>