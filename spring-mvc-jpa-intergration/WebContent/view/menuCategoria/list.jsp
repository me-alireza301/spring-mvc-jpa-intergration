<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insertTemplate template="/view/template/base.jsp">
	<tiles:putAttribute name="body">
		<c:forEach items="${menuCategorias}" var="menuCategoria">
			<c:out value="${menuCategoria.descricao}" /><br />
		</c:forEach>
	</tiles:putAttribute>
</tiles:insertTemplate>