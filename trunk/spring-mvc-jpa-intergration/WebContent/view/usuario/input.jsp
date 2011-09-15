<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insertTemplate template="/view/template/base.jsp">
	<tiles:putAttribute name="body">
		<form action="${pageContext.request.contextPath}/usuario/save.java" method="POST">
			<form:input path="usuario.nome" /><br />
			<form:input path="usuario.login" /><br />
			<form:input path="usuario.senha" /><br />
			<form:select items="${tiposUsuario}" itemValue="id" itemLabel="descricao" path="usuario.tipoUsuario.id" /><br />
			<input type="submit" value="enviar" />
		</form>
	</tiles:putAttribute>
</tiles:insertTemplate>