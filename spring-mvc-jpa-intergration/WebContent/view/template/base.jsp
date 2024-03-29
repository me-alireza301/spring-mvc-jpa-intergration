<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" type="text/css" media="screen, projection" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css" type="text/css" media="screen, projection" />
		<tiles:insertAttribute name="css" ignore="true" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.6.4.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/util.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/menu.js"></script>
		<tiles:insertAttribute name="js" ignore="true" />
	</head>
	<body>
		<div class="wrapper">
	        <div class="header">
	            header
	        </div>
	        <div class="horizontal-menu">
	        	<%@ include file="menu.jsp" %>
	        </div>
	        <div class="content">
	        	<c:if test="${errors != null}">
		        	<div class="content-error">
		        		<c:forEach items="${errors}" var="error">
		        			<c:out value="${error}" /><br />
		        		</c:forEach>
		        	</div>
	        	</c:if>
	            <tiles:insertAttribute name="body" />
	        </div> 	       
	        <div class="footer">
	            footer
	        </div>
		</div>
	</body>
</html>