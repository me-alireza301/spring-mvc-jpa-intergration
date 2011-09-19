package br.com.wryel.spring.mvc.model;

import java.io.Serializable;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.wryel.spring.mvc.dao.BasicDAO;

/**
 * 
 * @author wryel covo
 *
 */
@Component
public class ModelFactory implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@SuppressWarnings("unchecked")
	public static <BEAN extends Serializable> BasicModel<BEAN, ? extends BasicDAO<BEAN>> getModel(Class<BEAN> klass) {
		String businessName = StringUtils.uncapitalize(klass.getSimpleName()+"Model");
		Object business = applicationContext.getBean(businessName);
		return (BasicModel<BEAN, ? extends BasicDAO<BEAN>>) business;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ModelFactory.applicationContext = applicationContext;
	}
}
