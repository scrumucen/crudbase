package com.scrumucen.crudbase.struts.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.scrumucen.crudbase.dto.User;
import com.scrumucen.crudbase.logic.UserLogic;
import com.scrumucen.crudbase.struts.form.BuscaEliminaUserForm;

public class BuscaEliminaUserAction extends DispatchAction {
	private static final Log LOG = LogFactory.getLog(BuscaEliminaUserAction.class);
	public ActionForward unspecified(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LOG.info("ACTION unspecified");
		BuscaEliminaUserForm form = (BuscaEliminaUserForm) aform;
		ActionMessages keyMensajes = new ActionMessages();
		cargaForm(form);
		return mapping.findForward("success");
	}
	
	public ActionForward buscar(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LOG.info("ACTION buscar");
		BuscaEliminaUserForm form = (BuscaEliminaUserForm) aform;
		ActionMessages keyMensajes = new ActionMessages();
		cargaForm(form);
		
		return mapping.findForward("success");
	}
	
	public ActionForward eliminar(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LOG.info("ACTION eliminar");
		BuscaEliminaUserForm form = (BuscaEliminaUserForm) aform;
		ActionMessages keyMensajes = new ActionMessages();
		User user = new User();
		user.setId(Long.valueOf(form.getSelectedUser()));
		if (!UserLogic.eliminaUser(user)){
			keyMensajes.add("msj", new ActionMessage(
					"CrudBase.noSePudoEliminar"));
		}
		cargaForm(form);
		return mapping.findForward("success");
	}
	
	private void cargaForm(BuscaEliminaUserForm form) throws Exception{
		User user = new User();
		try {
			user.setId(Long.valueOf(form.getId()));
		} catch (NumberFormatException e) {
		}
		user.setUsername(form.getUsername());
		user.setPassword(form.getPassword());
		form.setUserList(UserLogic.buscaUsers(user));
	}
}
