<html>
	<head>
		<title>Teste</title>
		<script language="javascript">

		function avaliar(id) {
			avaliarScroll();
		}

		function avaliarScroll(id, sentido) {

			TEMPO = 50;
			
			htmlElement = document.getElementById(id);
			area = htmlElement.scrollHeight - htmlElement.offsetHeight;

			if (sentido == "sobe") {
				htmlElement.scrollTop = htmlElement.scrollTop - 1;
				if (htmlElement.scrollTop == 0) {
					setTimeout('avaliarScroll("'+id+'", "desce")', TEMPO);
				} else {
					setTimeout('avaliarScroll("'+id+'", "sobe")', TEMPO);
				}
			} else if (sentido == "desce") {
				htmlElement.scrollTop = htmlElement.scrollTop + 1;
				if (htmlElement.scrollTop < area) {
					setTimeout('avaliarScroll("'+id+'", "desce")', TEMPO);
				} else {
					setTimeout('avaliarScroll("'+id+'", "sobe")', TEMPO);
				}
			}		
		}

		function init() {
			avaliarScroll("teste", "desce");
			avaliarScroll("teste2", "desce");
			avaliarScroll("teste3", "desce");
			avaliarScroll("teste4", "desce");
		}
		</script>
	</head>
	<body onload="init();">
		<div id="teste" style="border: 0px solid red; width: 300px; height: 100px; overflow: auto;">
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
		</div>
		<br />
		<div id="teste2" style="border: 0px solid red; width: 300px; height: 100px; overflow: auto;">
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
		</div>
		<br />
		<div id="teste3" style="border: 0px solid red; width: 300px; height: 100px; overflow: auto;">
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
		</div>
		<br />
		<div id="teste4" style="border: 0px solid red; width: 300px; height: 100px; overflow: auto;">
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
			dasdsa<br />
		</div>
		<br />
	</body>
</html>