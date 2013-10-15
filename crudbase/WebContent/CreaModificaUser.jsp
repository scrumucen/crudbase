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
	function fncVolver() {
		document.CreaModificaUserForm.action = "/CrudBase/";
		document.CreaModificaUserForm.submit();
	}

	function fncCreaUser() {
		document.CreaModificaUserForm.action = "/CrudBase/CreaModificaUser.do?do=crear";
		document.CreaModificaUserForm.submit();
	}

	function fncModificaUser() {
		document.getElementById("id").disabled = false;
		document.CreaModificaUserForm.action = "/CrudBase/CreaModificaUser.do?do=modificar";
		document.CreaModificaUserForm.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busca-Elimina User</title>
</head>
<body>
	<html:form action="/CreaModificaUser">
<!-- 		Si la operacion es crear muestra formulario de creación -->
		<logic:equal value="CREAR" name="CreaModificaUserForm" property="operacion">
		<div>
			<fieldset>
				<legend>Crear nuevo</legend>
				Id:
				<html:text name="CreaModificaUserForm" property="id" disabled="true"></html:text>
				Username:
				<html:text name="CreaModificaUserForm" property="username"></html:text>
				Password:
				<html:text name="CreaModificaUserForm" property="password"></html:text>
				<html:submit onclick="javascript: fncCreaUser(); return false;"
					styleId="btnCrear" property="botonFormulario" tabindex="23" value="Crear"/>
				<html:submit onclick="javascript: fncVolver(); return false;"
					styleId="btnVolver" property="botonFormulario" tabindex="23" value="Volver"/>
			</fieldset>
		</div>
		</logic:equal>
		
<!-- 		Si la operacion es modificar muestra formulario de modificación -->
		<logic:equal value="MODIFICAR" name="CreaModificaUserForm" property="operacion">
		<div>
			<fieldset>
				<legend>Modificar existente</legend>
				Id:
				<html:text styleId="id" name="CreaModificaUserForm" property="id" disabled="true"></html:text>
				Username:
				<html:text name="CreaModificaUserForm" property="username"></html:text>
				Password:
				<html:text name="CreaModificaUserForm" property="password"></html:text>
				<html:submit onclick="javascript: fncModificaUser(); return false;"
					styleId="btnCrear" property="botonFormulario" tabindex="23" value="Modificar"/>
				<html:submit onclick="javascript: fncVolver(); return false;"
					styleId="btnVolver" property="botonFormulario" tabindex="23" value="Volver"/>
			</fieldset>
		</div>
		</logic:equal>
	</html:form>
</body>
</html>