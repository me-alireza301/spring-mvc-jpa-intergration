<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" type="text/css" media="screen, projection" />
		<tiles:insertAttribute name="css" defaultValue="" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery-1.6.4.js"></script>
		<tiles:insertAttribute name="javascript" defaultValue="" />
	</head>
	<body>
		<div class="wrapper">
	        <div class="header">
	            header
	        </div>	    
	        <div class="content">
	        aa
	            <tiles:insertAttribute name="body" />
	        </div> 	       
	        <div class="footer">
	            footer
	        </div>
		</div>
	</body>
</html>