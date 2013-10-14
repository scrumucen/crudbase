package com.scrumucen.crudbase.struts.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.scrumucen.crudbase.dto.User;

public class BuscaEliminaUserForm extends ActionForm {

		private static final long serialVersionUID = 1L;
		//resultados
		private List<User> userList;
		
		//seleccionado para eliminar (o editar)
		private String selectedUser;
		
		//busqueda
		private String id;
		private String username;
		private String password;
		
		public List<User> getUserList() {
			return userList;
		}

		public void setUserList(List<User> userList) {
			this.userList = userList;
		}

		public String getSelectedUser() {
			return selectedUser;
		}

		public void setSelectedUser(String selectedUser) {
			this.selectedUser = selectedUser;
		}
		
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

		@Override
		public String toString() {
			return "BuscaEliminaUserForm [userList=" + userList
					+ ", selectedUser=" + selectedUser + "]";
		}
		
}