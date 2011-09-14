<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div id="geral">
		<c:forEach items="${cards}" var="card">
			${card.nome} <br /> 
		</c:forEach>
		<br />
		Resultados encontrados: ${resultados}
	</div>
