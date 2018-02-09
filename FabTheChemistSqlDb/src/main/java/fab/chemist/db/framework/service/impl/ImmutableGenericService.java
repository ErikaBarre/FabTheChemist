package fab.chemist.db.framework.service.impl;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;



import fab.chemist.db.framework.dao.interf.IImmutableGenericDAO;
import fab.chemist.db.framework.service.interf.IImmutableGenericService;



/**
 * Service implementation for the Immutable Hibernate Entity.
 * This DAO is only use for the Immutable Hibernate Entity.
 * There is no WRITE access into database.
 * 
 * 
 *
 * 
 */
public class ImmutableGenericService <T extends IImmutableGenericDAO<E,KEY>, E extends Serializable,KEY extends Serializable> implements IImmutableGenericService<E,KEY> {

	/** 
	 * The DAO.
	 */
    protected T _dao;
    
    /**
     * Sets the DAO.
     * 
     * @param dao the new DAO
     */
    @Required
    public void setDAO(T dao) {
        _dao = dao;
    }
	
	/**
	 * @see eeu.ep.dit.framework.service.IImmutableGenericService#findAll()
	 */
    @Transactional(propagation = REQUIRED)
	public List<E> findAll() {
		return _dao.findAll();
	}

	/**
	 * @see eeu.ep.dit.framework.service.IImmutableGenericService#get(java.lang.Long)
	 */
	@Transactional(propagation = REQUIRED)
	public E get(KEY primaryKey) {
		return _dao.get(primaryKey);
	}

	@Transactional
	public Long getRowCount() {
		// TODO Auto-generated method stub
		return _dao.getRowCount();
	}
}