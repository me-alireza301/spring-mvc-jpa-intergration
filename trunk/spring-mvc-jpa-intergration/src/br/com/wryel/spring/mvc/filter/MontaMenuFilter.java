package br.com.wryel.spring.mvc.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.wryel.spring.mvc.ApplicationException;
import br.com.wryel.spring.mvc.bean.MenuCategoria;
import br.com.wryel.spring.mvc.bean.Usuario;
import br.com.wryel.spring.mvc.model.MenuCategoriaModel;
import br.com.wryel.spring.mvc.model.ModelFactory;

public class MontaMenuFilter implements Filter {
	
	public static final String MENU_KEY = "MENU";

	public void destroy() {
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		
		HttpSession httpSession = httpServletRequest.getSession();
		
		Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
		
		try {
			
			MenuCategoriaModel menuCategoriaModel = (MenuCategoriaModel) ModelFactory.getModel(MenuCategoria.class);
		
			List<MenuCategoria> menuCategorias = menuCategoriaModel.mountMenuByUser(usuario);
			
			servletRequest.setAttribute(MENU_KEY, menuCategorias);
			
		} catch (ApplicationException applicationException) {
			throw new ServletException(applicationException);
		}
		
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
