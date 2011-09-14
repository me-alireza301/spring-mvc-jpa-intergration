package br.com.wryel.spring.mvc.model;

import java.io.Serializable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.wryel.spring.mvc.dao.BasicDAO;

/**
 * 
 * @author wryel covo
 *
 */
@Component
public class ModelFactory implements BeanFactoryAware {

	private static BeanFactory beanFactory;
	
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		ModelFactory.beanFactory = beanFactory;
	}
	
	@SuppressWarnings("unchecked")
	public static <BEAN extends Serializable> BasicModel<BEAN, ? extends BasicDAO<BEAN>> getModel(Class<BEAN> klass) {
		String businessName = StringUtils.uncapitalize(klass.getSimpleName()+"Model");
		Object business = beanFactory.getBean(businessName);
		return (BasicModel<BEAN, ? extends BasicDAO<BEAN>>) business;
	}
}
