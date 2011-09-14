package br.com.wryel.spring.mvc.dao;

import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EmbeddedId;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;

/**
 * 
 * @author wryel covo
 *
 */
public abstract class BasicDAO<BEAN> extends AbstractPropertiesDAO<BEAN> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public static final String ORDER_BY = "orderBy";
	
	public static final String FIRST_RESULT = "firstResult";
	
	public static final String MAX_RESULT = "maxResult";	
	
	public BasicDAO() {
		
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(BEAN bean) {
		if (isNew(bean)) {
			insert(bean);
		} else {
			update(bean);
		}
	}
	
	public BEAN retrieve(BEAN bean) {
		bean = entityManager.find(beanClass, getPrimaryKey(bean));
		return bean;
	}
	
	protected void insert(BEAN bean) {
		entityManager.persist(bean);
		entityManager.flush();
	}
	
	protected void update(BEAN bean) {
		BEAN localBean = retrieve(bean);
		BeanUtils.copyProperties(bean, localBean);
		entityManager.merge(localBean);
		entityManager.flush();
	}
	
	protected boolean isNew(BEAN bean) {
		return getPrimaryKey(bean) == null;
	}
	
	protected Object getPrimaryKey(BEAN bean) {
		
		Field[] fields = bean.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			if (field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(EmbeddedId.class)) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				try {
					Object primatyKey = field.get(bean);
					return primatyKey;
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}
		}
		
		return null;
	}
	
	public void delete(BEAN bean) {
		BEAN findedBean = retrieve(bean);
		entityManager.remove(findedBean);
		entityManager.flush();
	}
	
	public long count(Map<String, Object> parametros) {
		
		String selectKey = beanClass.getSimpleName() + "." + SELECT_KEY;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(properties.get(selectKey));
		
		boolean adicionouWhere = false;
		
		for (String key : parametros.keySet()) {
			
			if (FIRST_RESULT.equals(key) || MAX_RESULT.equals(key)) {
				continue;
			}
			
			if (!adicionouWhere) {
				sql.append(" WHERE ");				
			} else {
				sql.append(" AND ");
			}
			
			sql.append(properties.get(selectKey + "." + key));
		}
		
		
		final String patternString = "(SELECT\\s)(.*?)(\\sFROM\\s.*)";
		
		Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = pattern.matcher(sql);
		
		if (matcher.matches()) {
			sql = new StringBuilder(matcher.group(1) + "COUNT(*)" + matcher.group(3));
		} else {
			throw new InvalidParameterException("Padrão inválido");
		}
		
		TypedQuery<Long> typedQuery = entityManager.createQuery(sql.toString(), Long.class);
		
		for (String key : parametros.keySet()) {
			typedQuery.setParameter(key, parametros.get(key));
		}
		
		long contador = typedQuery.getSingleResult();
		
		return contador;
		
	}
	
	public List<BEAN> list(Map<String, Object> parametros) {
		
		String selectKey = beanClass.getSimpleName() + "." + SELECT_KEY;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(properties.get(selectKey));
		
		boolean adicionouWhere = false;
		
		for (String key : parametros.keySet()) {
			
			if (FIRST_RESULT.equals(key) || MAX_RESULT.equals(key)) {
				continue;
			}
			
			if (!adicionouWhere) {
				sql.append(" WHERE ");				
			} else {
				sql.append(" AND ");
			}
			
			sql.append(properties.get(selectKey + "." + key));
		}
		
		TypedQuery<BEAN> typedQuery = entityManager.createQuery(sql.toString(), beanClass);

		if (parametros.containsKey(FIRST_RESULT)) {
			typedQuery.setFirstResult((Integer) parametros.get(FIRST_RESULT));
		}
		
		if (parametros.containsKey(MAX_RESULT)) {
			typedQuery.setMaxResults((Integer) parametros.get(MAX_RESULT));
		}
		
		for (String key : parametros.keySet()) {
			typedQuery.setParameter(key, parametros.get(key));
		}
		
		List<BEAN> list = typedQuery.getResultList();
		
		return list;		
	}
	
	public List<BEAN> executeNamedQuery(String key, Object...parametros) {
		
		String sql = properties.getProperty(NAMED_KEY + "." + key);
		
		TypedQuery<BEAN> query = entityManager.createQuery(sql, beanClass);
		
		int posicao = 1;
		
		for (Object object : parametros) {
			query.setParameter(posicao++, object);
		}
		
		List<BEAN> list = query.getResultList();
		
		return list;
	}
	
	public List<BEAN> executeNamedQuery(String name, Map<String, Object> parametros) {
		
		String sql = properties.getProperty(NAMED_KEY + "." + name);
		
		if (parametros.containsKey(ORDER_BY)) {
			sql = sql + " " + parametros.get(ORDER_BY);
		}
		
		TypedQuery<BEAN> query = entityManager.createQuery(sql, beanClass);
		
		for (String key : parametros.keySet()) {
			query.setParameter(key, parametros.get(key));
		}
		
		List<BEAN> list = query.getResultList();
		
		return list;
	}
}