package br.com.wryel.spring.mvc.dao;

import java.io.Serializable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class DAOFactory implements BeanFactoryAware {

	private static BeanFactory beanFactory;
	
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		DAOFactory.beanFactory = beanFactory;
	}
	
	@SuppressWarnings("unchecked")
	public static <BEAN extends Serializable> BasicDAO<BEAN> getDAO(Class<BEAN> klass) {
		String daoName = StringUtils.uncapitalize(klass.getSimpleName()+"DAO");
		Object dao = beanFactory.getBean(daoName);
		return (BasicDAO<BEAN>) dao;
	}
}
