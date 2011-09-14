package br.com.wryel.spring.mvc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.wryel.spring.mvc.dao.BasicDAO;

public abstract class BasicModel<BEAN, DAO extends BasicDAO<BEAN>> {
	
	protected DAO dao;
	
	public BasicModel() {
		
	}
	
	public BasicModel(DAO dao) {
		this.dao = dao;
	}

	public DAO getDao() {
		return dao;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ModelException.class)
	public void save(BEAN bean) throws ModelException {
		try {
			dao.save(bean);
		} catch (Exception exception) {
			throw new ModelException(exception);
		}
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_UNCOMMITTED)
	public List<BEAN> list() throws ModelException {
		try {
			return this.list(new HashMap<String, Object>());
		} catch (Exception exception) {
			throw new ModelException(exception);
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_UNCOMMITTED)
	public BEAN retrieve(BEAN bean) throws ModelException {
		try {
			BEAN findedBean = this.dao.retrieve(bean);
			return findedBean;
		} catch (Exception exception) {
			throw new ModelException(exception);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ModelException.class)
	public void delete(BEAN bean) throws ModelException {
		try {
			this.dao.delete(bean);
		} catch (Exception exception) {
			throw new ModelException(exception);
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_UNCOMMITTED)
	public List<BEAN> list(Map<String, Object> parametros) throws ModelException {
		try {
			List<BEAN> result = this.dao.list(parametros);
			return result;
		} catch (Exception exception) {
			throw new ModelException(exception);
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_UNCOMMITTED)
	public long count(Map<String, Object> parametros) throws ModelException {
		try {
			long count = this.dao.count(parametros);
			return count;
		} catch (Exception exception) {
			throw new ModelException(exception);
		}
	}
}
