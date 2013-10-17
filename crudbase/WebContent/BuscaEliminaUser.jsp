<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Eliminar, estilos de ejemplo -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href="jquery-datatables/css/demo_page.css" rel="stylesheet">
<link href="jquery-datatables/css/demo_table.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="jquery-datatables/js/jquery.dataTables.js"></script>
<!-- Eliminar, estilos de ejemplo -->

<script type="text/javascript">
	$(document).ready(function() {
	    $('#tablaInformacion').dataTable();
	});
	function fncBuscarUser() {
		document.BuscaEliminaUserForm.action = "/CrudBase/BuscaEliminaUser.do";
		document.BuscaEliminaUserForm.submit();
	}
	function fncEliminarUser() {
		if (confirm('Está seguro que desea eliminar?')) {
			document.BuscaEliminaUserForm.action = "/CrudBase/BuscaEliminaUser.do?do=eliminar";
			document.BuscaEliminaUserForm.submit();
		}
	}

	function fncSelectUser(id) {
		document.getElementById('selectedUser').value = id;
	}

	function fncCreaUser() {
		document.BuscaEliminaUserForm.action = "/CrudBase/CreaModificaUser.do?operacion=CREAR";
		document.BuscaEliminaUserForm.submit();
	}

	function fncModificaUser() {
		document.BuscaEliminaUserForm.action = "/CrudBase/CreaModificaUser.do?operacion=MODIFICAR&id=" + 
												document.getElementById('selectedUser').value;
		document.BuscaEliminaUserForm.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busca-Elimina User</title>
</head>
<body>
	<html:form action="/BuscaEliminaUser">
		<div>
			<fieldset>
				<legend>Buscar</legend>
				<table>
					<tr>
						<td>
							Id:
						</td>
						<td>
							<html:text name="BuscaEliminaUserForm" property="id"></html:text>
						</td>
					</tr>
					<tr>
						<td>
							Username:
						</td>
						<td>
							<html:text name="BuscaEliminaUserForm" property="username"></html:text>
						</td>
					</tr>
					<tr>
						<td>
							Password:
						</td>
						<td>
							<html:text name="BuscaEliminaUserForm" property="password"></html:text>
						</td>
					</tr>
				</table>
				<html:submit onclick="javascript: fncBuscarUser(); return false;"
					styleId="btnBuscar" property="botonFormulario" tabindex="23" value="Buscar"/>
				<html:submit onclick="javascript: fncCreaUser(); return false;"
					styleId="btnCrear" property="botonFormulario" tabindex="23" value="Crear nuevo"/>
			</fieldset>
		</div>
		<div>
			<logic:notEmpty name="BuscaEliminaUserForm" property="userList">
				<fieldset>
					<legend>Resultados</legend>
					<table id="tablaInformacion">
						<thead>
							<tr>
								<td>Id</td>
								<td>Username</td>
								<td>Password</td>
							</tr>
						</thead>
						<logic:iterate id="registro" name="BuscaEliminaUserForm"
							property="userList" type="com.scrumucen.crudbase.dto.User">
							<tr>
								<td><html:radio styleId="selectUser"
										name="BuscaEliminaUserForm" property="selectedUser"
										onchange="javascript: fncSelectUser(this.value);"
										value="<%=registro.getId().toString()%>" /> <bean:write
										name="registro" property="id" /></td>
								<td><bean:write name="registro" property="username" /></td>
								<td><bean:write name="registro" property="password" /></td>
							</tr>
						</logic:iterate>
					</table>
					<html:submit styleClass="btn btn-small" onclick="javascript: fncEliminarUser(); return false;"
						styleId="btnEliminar" property="botonFormulario" tabindex="23" value="Eliminar"/>
					<html:submit onclick="javascript: fncModificarUser(); return false;"
						styleId="btnModificar" property="botonFormulario" tabindex="23" value="Modificar"/>
				</fieldset>
			</logic:notEmpty>
		</div>
		<html:hidden styleId="selectedUser" name="BuscaEliminaUserForm"
			property="selectedUser" />
	</html:form>
</body>
</html>