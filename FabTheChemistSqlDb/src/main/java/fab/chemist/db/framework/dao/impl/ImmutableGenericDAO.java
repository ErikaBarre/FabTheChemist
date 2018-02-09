package fab.chemist.db.framework.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.criterion.Projections;

import fab.chemist.db.framework.dao.interf.IImmutableGenericDAO;




/**
 * DAO implementation for the Immutable Hibernate Entity.
 * There is no WRITE access into the database.
 * 
 *
 * 
 */
public abstract class ImmutableGenericDAO <T extends Serializable,KEY extends Serializable> extends HibernateFrameworkDAOSupport implements IImmutableGenericDAO<T,KEY> {

	/**
	 * Get the Hibernate Entity Name for the <T> Persistent Object
	 * 
	 * @return Hibernate Entity Name
	 */
	protected abstract String getEntityName();	
	
	protected abstract Class<?> getEntityClass();
		
	/**
	 * Default false;
	 */
	private boolean _isCachedSupported = false;

	/**
	 * @see ec.ep.dit.rmsi.sdw.simple.sched.framework.hibernate.dao.interfaces.ImmutableGenericDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	public final List<T> findAll() {
		final Criteria criteria = getSession(false).createCriteria(getEntityClass());
		if (_isCachedSupported) {
			visitCacheGet(criteria);
		}
		return (List<T>) criteria.list();
	}

	/**
	 * @see ec.ep.dit.rmsi.sdw.simple.sched.framework.hibernate.dao.interfaces.ImmutableGenericDao#get(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	public final T get(KEY primaryKey) {
		return (T) getSession(false).get(getEntityClass(), primaryKey);
	}
	
	/**
	 * @see ec.ep.votes.framework.hibernate.dao.ImmutableGenericDAO#get(java.io.Serializable, org.hibernate.LockMode)
	 */
	@SuppressWarnings("unchecked")
	public T get(KEY primaryKey, LockOptions lockOptions) {
		return (T) getSession(false).get(getEntityName(), primaryKey,lockOptions);
	}

	/**
	 *	to implement in subclass to configure cache 
	 */
	protected void visitCacheGet(Criteria criteria) {
	}

	/**
	 *	to implement in subclass to configure cache 
	 */
	protected void visitCacheNormal(Criteria criteria) {
	}
	
	/**
	 * Default is false;
	 * 
	 * @param isCachedSupported the isCachedSupported to set
	 */
	public void setCachedSupported(boolean isCachedSupported) {
		_isCachedSupported = isCachedSupported;
	}

	/**
	 * @return the isCachedSupported
	 */
	protected final boolean isCachedSupported() {
		return _isCachedSupported;
	}
	
	public Long getRowCount() {		
		Criteria criteria = getSession().createCriteria(getEntityClass());		
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}
	
	
}