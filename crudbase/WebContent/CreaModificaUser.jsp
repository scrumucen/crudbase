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
	function fncSelectUser(id) {
		document.getElementById('selectedUser').value = id;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busca-Elimina User</title>
</head>
<body>
	<html:form action="/CreaModificaUser">
		<div>
			<fieldset>
				<legend>Crear nuevo</legend>
				Id:
				<html:text name="CreaModificaUserForm" property="id" disabled="true"></html:text>
				Username:
				<html:text name="CreaModificaUserForm" property="username"></html:text>
				Password:
				<html:text name="CreaModificaUserForm" property="password"></html:text>
				<html:submit onclick="javascript: fncBuscarUser(); return false;"
					styleId="btnBuscar" property="botonFormulario" tabindex="23">
				Crear
			</html:submit>
			</fieldset>
		</div>
		<div>
			<fieldset>
				<legend>Modificar existente</legend>
				Id:
				<html:text name="CreaModificaUserForm" property="id" ></html:text>
				Username:
				<html:text name="BuscaEliminaUserForm" property="username"></html:text>
				Password:
				<html:text name="BuscaEliminaUserForm" property="password"></html:text>
				<html:submit onclick="javascript: fncBuscarUser(); return false;"
					styleId="btnBuscar" property="botonFormulario" tabindex="23">
				Crear
			</html:submit>
			</fieldset>
		</div>
	</html:form>
</body>
</html>