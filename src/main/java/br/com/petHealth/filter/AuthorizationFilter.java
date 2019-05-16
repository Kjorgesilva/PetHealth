package br.com.petHealth.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petHealth.bean.LoginBean;

public class AuthorizationFilter implements Filter{

	@Inject
	private LoginBean login;
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {


		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        if(login.getUsuario() == null || !login.isLogado()){
        	
        	if (!request.getRequestURI().contains("/login.xhtml")) {
        		response.sendRedirect(request.getContextPath() + "/login.xhtml");
        	}
        	
        }
        
        chain.doFilter(request, response);
		
	}

}
