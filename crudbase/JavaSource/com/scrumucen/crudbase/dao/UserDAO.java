package com.scrumucen.crudbase.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.scrumucen.crudbase.dto.User;

public class UserDAO {
	private static final Log LOG = LogFactory.getLog(UserDAO.class);
	private static List<User> instance;
	public static List<User> buscaUsers(User filtros) throws SQLException {
		ArrayList<User> retorno = new ArrayList<User>();
		LOG.info("DAO buscaUsers");
		if (instance == null) {
			instance = obtenerUsuarios();
		}
		LOG.info(filtros);
		for(Iterator<User> iter = instance.iterator();iter.hasNext();){
			User actual = iter.next();
			if (!((filtros.getId() != null && !actual.getId().equals(filtros.getId())) ||
					(filtros.getUsername() != null && filtros.getUsername() != "" && !actual.getUsername().toLowerCase().contains(filtros.getUsername().toLowerCase()))  ||
					(filtros.getPassword() != null && filtros.getPassword() != "" && !actual.getPassword().toLowerCase().contains(filtros.getPassword().toLowerCase())))) {
				LOG.info("Eliminado: "+actual);
				retorno.add(actual);
			}
		}
		
		return retorno;
	}

	public static boolean eliminaUsers(User user) {
		LOG.info("DAO eliminaUsers");
		for(Iterator<User> iter = instance.iterator();iter.hasNext();){
			User actual = iter.next();
			LOG.info(actual.getId() + " " + user.getId());
			if (actual.getId().equals(user.getId())) {
				iter.remove();
			}
		}
		return true;
	}
	
	private static ArrayList<User> obtenerUsuarios(){
		ArrayList<User> retorno = new ArrayList<User>();
		for (Integer i = 0; i < 5; i++) {
			User actual = new User();
			actual.setId(i.longValue());
			actual.setUsername("User " + i);
			actual.setPassword(String.valueOf(i*27 + 62535));
			retorno.add(actual);
		}
		return retorno;
	}
}
