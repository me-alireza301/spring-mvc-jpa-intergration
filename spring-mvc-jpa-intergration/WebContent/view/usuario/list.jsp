<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insertTemplate template="/view/template/base.jsp">
	<tiles:putAttribute name="body">
		<table border="1" align="center">
			<caption>testes</caption>
			<tr>
				<td>login</td><td>senha</td><td>edit</td>
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.login}</td><td>${usuario.senha}</td><td><a href="edit.java?id=${usuario.id}">edit</a></td>
			</tr>
			</c:forEach>
		</table>
		<br />
		<a href="add.java">Adicionar</a>
	</tiles:putAttribute>
</tiles:insertTemplate>