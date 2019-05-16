package br.com.petHealth.core;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionManager {
	
	public void setVarSessao(String arg0, Object arg1){

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		session.setAttribute(arg0, arg1);
		
	}
	
	public Object getVarSessao(String arg0){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		return session.getAttribute(arg0);
	}

}
