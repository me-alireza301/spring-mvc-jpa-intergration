<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<ul id="jsddm">
	<c:forEach items="${MENU}" var="menuCategoria">
    <li><a href="#">${menuCategoria.descricao}</a>
    <c:if test="${fn:length(menuCategoria.menuLinks) > 0}">
        <ul>
        <c:forEach items="${menuCategoria.menuLinks}" var="menuLink">
            <li><a href="${pageContext.request.contextPath}${menuLink.url}">${menuLink.descricao}</a></li>
        </c:forEach>
        </ul>
       </c:if>
    </li>
	</c:forEach>
</ul>