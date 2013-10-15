package com.scrumucen.crudbase.struts.form;

import org.apache.struts.action.ActionForm;

public class CreaModificaUserForm extends ActionForm {

	private static final long serialVersionUID = -4220223811564012984L;
	private String id;
	private String username;
	private String password;
	private String operacion;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	@Override
	public String toString() {
		return "CreaModificaUserForm [id=" + id + ", username=" + username
				+ ", password=" + password + ", operacion=" + operacion + "]";
	}
	
}