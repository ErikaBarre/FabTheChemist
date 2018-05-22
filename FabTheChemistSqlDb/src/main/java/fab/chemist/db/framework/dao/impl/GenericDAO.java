package fab.chemist.db.framework.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fab.chemist.db.framework.dao.interf.IGenericDAO;



/**
 * @author fbadis
 * 
 *         Generic DAO for all Hibernate Entity.
 * @param <T>
 * @param <KEY>
 */
public abstract class GenericDAO<T extends Serializable, KEY extends Serializable> extends ImmutableGenericDAO<T, KEY> implements IGenericDAO<T, KEY> {

	/**
	 * The SLF4J Logger.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(GenericDAO.class);

	public abstract Class<T> getEntityClass();

	public abstract String getEntityName();

//	@SuppressWarnings("unchecked")
//	public final KEY save(T entity) {
//		if (LOGGER.isTraceEnabled()) {
//			LOGGER.trace("Save entity [{}] - [{}]", getEntityName(), entity);
//		}
//		return (KEY) getEntityManager().persist(entity); //save(getEntityName(), entity);
//	}
//
//	public <T extends Entity<PK>, PK extends Serializable> PK save(T entity) {
//		getEntityManager().persist(entity);
//		return entity.getId();
//	}
	public final void save(T entity) {
		LOGGER.info("save [{}]", entity.getClass().getName());
		//EntityTransaction entityTransaction = getEntityManager().getTransaction();
		//entityTransaction.begin();
		
		//LOGGER.info("active [{}]", entityTransaction.isActive());
		
		getEntityManager().persist(entity);
		
		//LOGGER.info("active2 [{}]", entityTransaction.isActive());
		//getEntityManager().flush();
		//entityTransaction.commit();

	}
	
	
	public void save(List<T> entities) {
		EntityManager entityManager = getEntityManager();
		int count = 0;
		for (T entity : entities) {
			entityManager.persist(entity);
			if (++count % 20 == 0) {
				// flush a batch of updates and release memory:
				entityManager.flush();
				entityManager.clear();
			}
		}
	}

	public void persist(T entity) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Persist entity [{}] - [{}]", getEntityName(), entity);
		}
		getEntityManager().persist(entity);
	}

	public final void update(T entity) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Update entity [{}] - [{}]", getEntityName(), entity);
		}
		getEntityManager().merge(entity);
	}

	@SuppressWarnings("unchecked")
	public final T merge(T entity) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Merge entity [{}] - [{}]", getEntityName(), entity);
		}
		return (T) getEntityManager().merge(entity);
	}

	public void delete(T entity) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Delete entity [{}] - [{}]", getEntityName(), entity);
		}
		getEntityManager().remove(entity);  //delete(getEntityName(), entity);
	}
	
	public final void delete(final List<T> entities) {
		EntityManager entityManager = getEntityManager();
		int count = 0;
		for (T entity : entities) {
			entityManager.remove(entity);
			if (++count % 20 == 0) {
				// flush a batch of updates and release memory:
				entityManager.flush();
				entityManager.clear();
			}
		}
	}

	public final void evict(T entity) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Evict entity [{}] - [{}]", getEntityName(), entity);
		}
		getEntityManager().detach(entity);
	}

	public final void flush() {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Flush ...");
		}
		getEntityManager().flush();
	}

	public void clear() {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Clear ...");
		}
		getEntityManager().clear();
	}

	public void lock(T entity, LockModeType lockOptions) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Lock entity [{}] - [{}]", entity, lockOptions);
		}
		getEntityManager().lock(entity, lockOptions);
	}

//	public Entity get (Object id) {
////		
//		Entity entity = getEntityManager().getReference(getEntityClass(), id);
////
//		return entity;
//		
//	}
	
}
