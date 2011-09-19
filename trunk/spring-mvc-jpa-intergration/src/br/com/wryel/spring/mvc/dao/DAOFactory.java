package br.com.wryel.spring.mvc.dao;

import java.io.Serializable;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class DAOFactory implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@SuppressWarnings("unchecked")
	public static <BEAN extends Serializable> BasicDAO<BEAN> getDAO(Class<BEAN> klass) {
		String daoName = StringUtils.uncapitalize(klass.getSimpleName()+"DAO");
		Object dao = applicationContext.getBean(daoName);
		return (BasicDAO<BEAN>) dao;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		DAOFactory.applicationContext = applicationContext;
	}
}
