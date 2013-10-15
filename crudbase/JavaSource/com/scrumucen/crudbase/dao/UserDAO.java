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
	private static List<User> getInstance() {
		if (instance == null) {
			instance = obtenerUsuarios();
		}
		return instance;
	}
	public static List<User> buscaUsers(User filtros) throws SQLException {
		ArrayList<User> retorno = new ArrayList<User>();
		LOG.info("DAO buscaUsers");
		getInstance();
		LOG.info(filtros);
		for(Iterator<User> iter = getInstance().iterator();iter.hasNext();){
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
		
		//simula un "delete users where id = ?" 
		for(Iterator<User> iter = getInstance().iterator();iter.hasNext();){
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

	public static User creaUser(User user) {
		LOG.info("DAO creaUsers");
		
		//simula un "insert into users values (?,?,?)"
		user.setId(getNextId());
		getInstance().add(user);
		
		return user;
	}

	public static User modificaUser(User user) {
		LOG.info("DAO modificaUsers");

		//simula un "update users set username=?,password=? where id=?"
		for(Iterator<User> iter = getInstance().iterator();iter.hasNext();){
			User actual = iter.next();
			LOG.info(actual.getId() + " " + user.getId());
			if (actual.getId().equals(user.getId())) {
				actual.setUsername(user.getUsername());
				actual.setPassword(user.getPassword());
			}
		}
		return user;
	}
	
	/**
	 * Simula una secuencia de BD.
	 * @return id siguiente de la secuencia.
	 */
	private static Long getNextId(){
		Long maxId = 0L;
		for(Iterator<User> iter = getInstance().iterator();iter.hasNext();){
			User actual = iter.next();
			if (actual.getId() > maxId) {
				maxId = actual.getId();
			}
		}
		return ++maxId;
	}
}
