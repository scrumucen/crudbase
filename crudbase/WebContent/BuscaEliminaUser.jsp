<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function fncEliminarUser() {
		if (confirm('Está seguro que desea eliminar?')) {
			document.BuscaEliminaUserForm.action = "/CrudBase/BuscaEliminaUser.do?do=eliminar";
			document.BuscaEliminaUserForm.submit();
		}
	}

	function fncBuscarUser() {
		document.BuscaEliminaUserForm.action = "/CrudBase/BuscaEliminaUser.do";
		document.BuscaEliminaUserForm.submit();
	}

	function fncSelectUser(id) {
		document.getElementById('selectedUser').value = id;
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
				Id:
				<html:text name="BuscaEliminaUserForm" property="id"></html:text>
				Username:
				<html:text name="BuscaEliminaUserForm" property="username"></html:text>
				Password:
				<html:text name="BuscaEliminaUserForm" property="password"></html:text>
				<html:submit onclick="javascript: fncBuscarUser(); return false;"
					styleId="btnBuscar" property="botonFormulario" tabindex="23">
				Buscar
			</html:submit>
				<html:submit onclick="javascript: fncBuscarUser(); return false;"
					styleId="btnCrear" property="botonFormulario" tabindex="23">
				Crear
			</html:submit>
			</fieldset>
		</div>
		<div>
			<logic:notEmpty name="BuscaEliminaUserForm" property="userList">
				<fieldset>
					<legend>Resultados</legend>
					<table border="1" id="tablaInformacion">
						<thead>
							<tr>
								<td>Id</td>
								<td>Username</td>
								<td>Password</td>
							</tr>
						</thead>
						<!-- 				<tfoot> -->
						<!-- 					<tr> -->
						<!-- 						<td>Id</td> -->
						<!-- 						<td>Username</td> -->
						<!-- 						<td>Password</td> -->
						<!-- 					</tr> -->
						<!-- 				</tfoot> -->
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
					<html:submit onclick="javascript: fncEliminarUser(); return false;"
						styleId="btnEliminar" property="botonFormulario" tabindex="23">
			Eliminar
		</html:submit>
				</fieldset>
			</logic:notEmpty>
		</div>
		<html:hidden styleId="selectedUser" name="BuscaEliminaUserForm"
			property="selectedUser" />
	</html:form>
</body>
</html>