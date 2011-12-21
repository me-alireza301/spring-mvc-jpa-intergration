package br.com.wryel.spring.mvc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.wryel.spring.mvc.ApplicationException;
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
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ApplicationException.class)
	public void save(BEAN bean) throws ApplicationException {
		dao.save(bean);		
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
	public List<BEAN> list() throws ApplicationException {
		return this.list(new HashMap<String, Object>());
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
	public BEAN retrieve(BEAN bean) throws ApplicationException {
		BEAN findedBean = this.dao.retrieve(bean);
		return findedBean;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ApplicationException.class)
	public void delete(BEAN bean) throws ApplicationException {
		this.dao.delete(bean);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
	public List<BEAN> list(Map<String, Object> parametros) throws ApplicationException {
		List<BEAN> result = this.dao.list(parametros);
		return result;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
	public long count(Map<String, Object> parametros) throws ApplicationException {
		long count = this.dao.count(parametros);
		return count;
	}
}
