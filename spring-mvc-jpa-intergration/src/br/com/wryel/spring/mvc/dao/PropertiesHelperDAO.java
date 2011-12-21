package br.com.wryel.spring.mvc.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * @author wryel covo
 *
 */
@SuppressWarnings("unchecked")
public abstract class PropertiesHelperDAO<BEAN> {
	
	protected static final String SELECT_KEY = "select";
	
	protected static final String NAMED_KEY = "named";

	protected Properties properties;
	
	protected Class<BEAN> beanClass;
	
	protected Logger logger = Logger.getLogger(beanClass);

	public PropertiesHelperDAO() {
		try {
			ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
			beanClass = (Class<BEAN>) parameterizedType.getActualTypeArguments()[0];
			properties = new Properties();
			properties.load(getClass().getResourceAsStream("/dao/" + beanClass.getSimpleName() + ".properties"));
		} catch (Exception exception) {
			logger.error(exception);
		}
	}
	
	protected Properties getProperties() {
		return this.properties;
	}
	
	public final Class<BEAN> getBeanClass() {
		return beanClass;
	}

	protected String getKey(String...keys) {
		StringBuilder sql = new StringBuilder();
		for (String key : keys) {
			sql.append(getProperties().getProperty(key));
		}
		return sql.toString();
	}
	
	protected String getNamedKey(String name) {
		return getProperties().getProperty(NAMED_KEY + "." + name);
	}
}