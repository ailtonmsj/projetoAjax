<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />

<html>
	<head>
		<script>
			var request = null;
			
			function createRequest() {
			    try {
			      request = new XMLHttpRequest();
			    } catch (trymicrosoft) {
			      try {
			        request = new ActiveXObject("Msxml2.XMLHTTP");
			      } catch (othermicrosoft) {
			        try {
			          request = new ActiveXObject("Microsoft.XMLHTTP");
			        } catch (failed) {
			          request = null;
			        }
			      }
			    }
			
			    if (request == null)
			      alert("Error creating request object!");
			}
			
			function fn_populaMunicipioAjax(){
				createRequest();
				var url = '${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/';
				url = url + 'populaMunicipio';
				estadoNome = document.getElementById('estado').value;
				request.open('POST', url, true);
				request.onreadystatechange = fn_updateComboMunicipio;
				request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				request.send('estado=' + estadoNome);
			}
			
			function fn_updateComboMunicipio(){
				if(request.readyState == 4){
			
					var selectMunicipio = document.getElementById('municipio'); 
			
					fn_limparCombo(selectMunicipio);
						
					var newMunicipios = request.responseText;
			
					selectMunicipio.value = null;
					selectMunicipio.text = null;
					newMunicipios = newMunicipios.slice(1,newMunicipios.length-1);
					municipios = newMunicipios.split(",");
			
					for (x=0; x<municipios.length; x++) {
						  
						novoOption = document.createElement('option');
					    novoOption.text = municipios[x];
					    novoOption.value = municipios[x];
					    selectMunicipio.options.add(novoOption);
					}
				}
			}
			
			function fn_limparCombo(combo){
				for (var i = combo.options.length - 1; i >= 1; i--){
					combo.options[i] = null;
				}
				combo.selectedIndex = -1;
			}
		
		</script>
	</head>
	<body>
		<form action="view/selecionados.jsp" method="post">
			<table>
				<tr>
					<td align="right"><label>Estado:</label></td>
					<td><select name="estado"
						onchange="javascript:fn_populaMunicipioAjax();" id="estado">
						<option value="" selected="selected">Selecione o Estado</option>
						<c:forEach items="${estados}" var="estado">
							<option value="${estado.nome}">${estado.nome}</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="right"><label>Munic&iacute;pio:</label></td>
					<td><select name="municipio" id="municipio">
						<option value="" selected="selected">Selecione o Munic&iacute;pio</option>
						<c:forEach items="${municipios}" var="municipio">
							<option value="${municipio.nome}">${municipio.nome}</option>
						</c:forEach>
					</select></td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						<img src="imagens/java.jpg">
					<td>
					<td>
						<img src="imagens/duke.jpg">
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><input type="submit" value="Mostrar sele&ccedil;&atilde;o">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>