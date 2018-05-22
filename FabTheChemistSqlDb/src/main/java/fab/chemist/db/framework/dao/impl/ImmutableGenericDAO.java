package fab.chemist.db.framework.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Lock;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fab.chemist.db.framework.dao.interf.IImmutableGenericDAO;


/**
 * DAO implementation for the Immutable Hibernate Entity.
 * There is no WRITE access into the database.
 * 
 *
 * 
 */
public abstract class ImmutableGenericDAO <T extends Serializable,KEY extends Serializable> extends HibernateFrameworkDAOSupport implements IImmutableGenericDAO<T,KEY> {

	private final static Logger LOGGER = LoggerFactory.getLogger(ImmutableGenericDAO.class);
	/**
	 * Get the Hibernate Entity Name for the <T> Persistent Object
	 * 
	 * @return Hibernate Entity Name
	 */
	protected abstract String getEntityName();	
	
	protected abstract Class<T> getEntityClass();
		
	/**
	 * Default false;
	 */
	private boolean _isCachedSupported = false;
	
	public final List<T> findAll(Class<T> clazz, Order order, String... propertiesOrder) {
	    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
	    CriteriaQuery<T> cq = cb.createQuery(clazz);
	    Root<T> root = cq.from(clazz);
	         
	    List<javax.persistence.criteria.Order> orders = new ArrayList<>();
	    for (String propertyOrder : propertiesOrder) {
	        if (order.isAscending()) {
	            orders.add(cb.asc(root.get(propertyOrder)));
	        } else {
	            orders.add(cb.desc(root.get(propertyOrder)));
	        }
	    }
	    cq.orderBy(orders);
	 
	    return getEntityManager().createQuery(cq).getResultList();
	}

	public final List<T> findAll(Class<T> clazz) {
	    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
	    CriteriaQuery<T> cq = cb.createQuery(clazz);
	    Root<T> root = cq.from(clazz);
	 
	    return getEntityManager().createQuery(cq).getResultList();
	}
	
	public final List<T> findAll() {
	    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
	    CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
	    Root<T> root = cq.from(getEntityClass());
	 
	    return getEntityManager().createQuery(cq).getResultList();
	}
	
	
	/**
	 * @see ec.ep.dit.rmsi.sdw.simple.sched.framework.hibernate.dao.interfaces.ImmutableGenericDao#findAll()
	 */
//	@SuppressWarnings("unchecked")
//	public final List<T> findAll() {
////		final Criteria criteria = getSession(false).createCriteria(getEntityClass());
////		if (_isCachedSupported) {
////			visitCacheGet(criteria);
////		}
////		return (List<T>) criteria.list();
//		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
//		if (_isCachedSupported) {
//			visitCacheGet(criteriaBuilder);
//		}
////		CriteriaQuery<Person> criteria = builder.createQuery( Person.class );
////		Root<Person> root = criteria.from( Person.class );
////		criteria.select( root );
////		criteria.where( builder.equal( root.get( Person_.name ), "John Doe" ) );
//
//		//List<Person> persons = entityManager.createQuery( criteria ).getResultList();
//		getEntityClass() ;
//		CriteriaQuery<T> criteria = criteriaBuilder.createQuery(<T>.class);              
//		
//		return null ;
//	}
	
	

	/**
	 * @see ec.ep.dit.rmsi.sdw.simple.sched.framework.hibernate.dao.interfaces.ImmutableGenericDao#get(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	public final T get(KEY primaryKey) {
		//return (T) getEntityManager().getEntityName(primaryKey) ; //primaryKey);
		return null;
		//return (T) getSession(false).get(getEntityClass(), primaryKey);
	}
	
	/**
	 * @see ec.ep.votes.framework.hibernate.dao.ImmutableGenericDAO#get(java.io.Serializable, org.hibernate.LockMode)
	 */
	@SuppressWarnings("unchecked")
	public T get(KEY primaryKey, LockOptions lockOptions) {
		Session session = null ;
		
		session.get(getEntityName(), primaryKey,lockOptions);
		//return (T) getEntityManager().get     
		
		return (T) session.get(getEntityName(), primaryKey,lockOptions);
		//return (T) getEntityManager().get     
	}

	/**
	 *	to implement in subclass to configure cache 
	 */
	protected void visitCacheGet(CriteriaBuilder criteriaBuilder) {
	}

	/**
	 *	to implement in subclass to configure cache 
	 */
	protected void visitCacheNormal(CriteriaBuilder criteriaBuilder) {
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
	
	public Long getRowCount(Entity entity) {		
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder(); 
		CriteriaQuery<Long> query = cb.createQuery(Long.class);

		Root<T> root = query.from(getEntityClass());

		//Selecting the count
		query.select(cb.count(root));
		Long count = getEntityManager().createQuery(query).getSingleResult();

        // JPA Query Language is executed on your entities (Java Classess), not on your database tables;

        //Query query = getEntityManager().createQuery("SELECT count(*) FROM " + getEntityName() );
        //long count = (long) query.getSingleResult();
        return count;
	}
	
//	@Override
//	public void release() {
//	    final Lock lock = entityManager.find(Lock.class, applicationId, LockModeType.PESSIMISTIC_WRITE);
//
//	    if (lock == null) {
//	        return;
//	    }
//	    // Only the current owner can release the lock
//	    final String owner = lock.getUniqueId();
//	    if (uniqueId.equals(owner)) {
//	        lock.setUniqueId(null);
//	        lock.setExpirationDate(null);
//	        LOGGER.debug("Releasing {} lock held by {}.", applicationId, uniqueId);
//	        getEntityManager().persist(lock);
//	    } else {
//	        throw new IllegalStateException("Cannot release lock owned by " + owner);
//	    }
//	}
	 
	
	
}