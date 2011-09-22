package br.com.wryel.spring.mvc.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.wryel.spring.mvc.bean.Usuario;
import br.com.wryel.spring.mvc.controller.BasicController;
import br.com.wryel.spring.mvc.web.HttpSessionParams;

public class UsuarioLogadoFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		
		HttpSession httpSession = httpServletRequest.getSession(true);
		
		Usuario usuario = (Usuario) httpSession.getAttribute(HttpSessionParams.LOGGED_USER);
		
		if (httpServletRequest.getRequestURL().toString().indexOf("teste") > -1) {
			
			filterChain.doFilter(servletRequest, servletResponse);
			
		} else if (httpServletRequest.getRequestURI().contains(BasicController.LOGIN)) {
			
			filterChain.doFilter(servletRequest, servletResponse);
			
		} else if (usuario != null) {
			
			filterChain.doFilter(servletRequest, servletResponse);
			
			httpSession.setMaxInactiveInterval(60 * HttpSessionParams.SESSION_TIME_OUT);
			
		} else {
			
			HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
			
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/" + BasicController.LOGIN + BasicController.VIEW_EXTENSION);
			
		}		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}	
}
