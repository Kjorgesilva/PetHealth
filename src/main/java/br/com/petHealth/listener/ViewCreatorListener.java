package br.com.petHealth.listener;

import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ViewCreatorListener implements PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 592433463810338326L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
		final String url = request.getRequestURI();
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
		FacesContext context = event.getFacesContext();
		ExternalContext exContext = context.getExternalContext();
		HttpSession session = (HttpSession) exContext.getSession(false);
		
		if (session == null || session.isNew()) {
			loginRedirect(context);
		}
		
	}
	
	public void loginRedirect(FacesContext context) {

		ViewHandler viewHandler = context.getApplication().getViewHandler();
		UIViewRoot view = viewHandler.createView(context, "/login.xhtml");
		context.setViewRoot(view);
		context.renderResponse();
		try {

			viewHandler.renderView(context, view);
			context.responseComplete();

		} catch (Exception ex) {
			throw new FacesException("Sessão expirada!!!", ex);
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
