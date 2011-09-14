<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" type="text/css" media="screen, projection" />
		<!--[if lte IE 6]>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global_ie.css" type="text/css" media="screen, projection" />
		<![endif]-->
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				Topo
			</div>
			<div id="middle">	
				<div id="container">
					<div id="content">
						<tiles:insertAttribute name="body" />
					</div>
				</div>
				<div class="sidebar" id="sideLeft">
					Menu
				</div>
			</div>
		</div>
		<div id="footer">
			Rodape
		</div>
	</body>
</html>