package com.scrumucen.crudbase.logic;

import java.util.List;

import com.scrumucen.crudbase.dao.UserDAO;
import com.scrumucen.crudbase.dto.User;

public class UserLogic {

	public static List<User> buscaUsers(User filtros) throws Exception {
		return UserDAO.buscaUsers(filtros);
	}
	public static boolean eliminaUser(User user) throws Exception {
		return UserDAO.eliminaUsers(user);
	}
	public static User creaUser(User user) throws Exception {
		return UserDAO.creaUser(user);
	}
	public static User modificaUser(User user) throws Exception {
		return UserDAO.modificaUser(user);
	}
}
