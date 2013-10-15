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
import com.scrumucen.crudbase.struts.form.CreaModificaUserForm;

public class CreaModificaUserAction extends DispatchAction {
	private static final Log LOG = LogFactory.getLog(BuscaEliminaUserAction.class);
	
	/**
	 * Acci—n llamada al entrar en la pantalla por primera vez.
	 * (non-Javadoc)
	 * @see org.apache.struts.actions.DispatchAction#unspecified(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward unspecified(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LOG.info("ACTION unspecified");
		CreaModificaUserForm form = (CreaModificaUserForm) aform;
		ActionMessages keyMensajes = new ActionMessages();
		//carga datos del formulario
		cargaForm(form, request);
		return mapping.findForward("success");
	}
	
	/**
	 * Acci—n de bot—n crear.
	 * @param mapping .
	 * @param aform .
	 * @param request .
	 * @param response .
	 * @return .
	 * @throws Exception .
	 */
	public ActionForward crear(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LOG.info("ACTION crear");
		CreaModificaUserForm form = (CreaModificaUserForm) aform;
		ActionMessages keyMensajes = new ActionMessages();
		
		//crea user
		try {
			userToForm(form,UserLogic.creaUser(formToUser(form)));
			form.setOperacion("MODIFICAR");
		} catch (Exception e) {
			// muestra mensaje en pantalla
			LOG.error("Error al crear user: ", e);
			keyMensajes.add("msj", new ActionMessage(
					"CrudBase.noSePudoCrear"));
		}
		
		return mapping.findForward("success");
	}
	
	/**
	 * Acci—n de b—ton modificar.
	 * @param mapping .
	 * @param aform .
	 * @param request .
	 * @param response .
	 * @return .
	 * @throws Exception .
	 */
	public ActionForward modificar(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LOG.info("ACTION modificar");
		CreaModificaUserForm form = (CreaModificaUserForm) aform;
		ActionMessages keyMensajes = new ActionMessages();
		
		//modifica user
		try {
			userToForm(form,UserLogic.modificaUser(formToUser(form)));
			form.setOperacion("MODIFICAR");
		} catch (Exception e) {
			// muestra mensaje en pantalla
			LOG.error("Error al modificar user: ", e);
			keyMensajes.add("msj", new ActionMessage(
					"CrudBase.noSePudoModificar"));
		}
		
		return mapping.findForward("success");
	}
	
	/**
	 * Carga el formulario con los datos del user seleccionado.
	 * S—lo cuando operacion == "MODIFICAR".
	 * @param form CreaModificaForm actual.
	 * @param request HttpServletRequest que contiene parametros de url.
	 */
	private void cargaForm(CreaModificaUserForm form, HttpServletRequest request){
		form.setOperacion(request.getParameter("operacion"));
		User user = new User();
		//si se modifica obtiene user seleccionado
		if ("MODIFICAR".equals(form.getOperacion().toUpperCase())) {
			user.setId(Long.valueOf(request.getParameter("id")));
			try {
				user = UserLogic.buscaUsers(user).get(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			userToForm(form,user);
		}
	}
	
	/**
	 * Llena el formulario a partir de un DTO User.
	 * @param form CreaModificaForm actual.
	 * @param user User que se quiere mostrar en pantalla.
	 */
	private void userToForm(CreaModificaUserForm form, User user) {
		LOG.info("Desde user" + user);
		form.setId(user.getId().toString());
		form.setUsername(user.getUsername());
		form.setPassword(user.getPassword());
		LOG.info("Hacia form" + form);
	}
	
	/**
	 * Crea un DTO user a partir del formulario.
	 * @param form CreaModificaForm actual.
	 * @return User obtenido desde la pantalla.
	 */
	private User formToUser(CreaModificaUserForm form) {
		LOG.info("Desde form: " + form);
		User user = new User();
		if (form.getId() != null) {
			user.setId(Long.valueOf(form.getId()));
		}
		user.setUsername(form.getUsername());
		user.setPassword(form.getPassword());
		LOG.info("Hacia user" + user);
		return user;
	}
	
}
