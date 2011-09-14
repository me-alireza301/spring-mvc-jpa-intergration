<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insertTemplate template="/view/template/base.jsp">
	<tiles:putAttribute name="body">
		<form method="POST" action="${pageContext.request.contextPath}/colecao/save.java">
			<input type="text" name="nome" value="${colecao.nome}" />
			<c:forEach items="${colecao.cards}" var="card" varStatus="loop">
				<br /><input type="text" name="cards[${loop.index}].nome" id="cards${loop.index}.nome" value="${card.nome}" />
			</c:forEach>
			<input type="submit" value="save" />
		</form>
	</tiles:putAttribute>
</tiles:insertTemplate>