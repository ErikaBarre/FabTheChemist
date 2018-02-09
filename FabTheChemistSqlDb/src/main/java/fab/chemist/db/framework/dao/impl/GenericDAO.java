package fab.chemist.db.framework.dao.impl;

import java.io.Serializable;
import java.util.List;

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

	@SuppressWarnings("unchecked")
	public final KEY save(T entity) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Save entity [{}] - [{}]", getEntityName(), entity);
		}
		return (KEY) getSession(false).save(getEntityName(), entity);
	}

	public void save(List<T> entities) {
		Session session = getSession(false);
		int count = 0;
		for (T entity : entities) {
			session.save(getEntityName(), entity);
			if (++count % 20 == 0) {
				// flush a batch of updates and release memory:
				session.flush();
				session.clear();
			}
		}
	}

	public void persist(T entity) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Persist entity [{}] - [{}]", getEntityName(), entity);
		}
		getSession(false).persist(getEntityName(), entity);
	}

	public final void update(T entity) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Update entity [{}] - [{}]", getEntityName(), entity);
		}
		getSession(false).update(getEntityName(), entity);
	}

	@SuppressWarnings("unchecked")
	public final T merge(T entity) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Merge entity [{}] - [{}]", getEntityName(), entity);
		}
		return (T) getSession(false).merge(getEntityName(), entity);
	}

	public void delete(T entity) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Delete entity [{}] - [{}]", getEntityName(), entity);
		}
		getSession(false).delete(getEntityName(), entity);
	}

	public final void delete(final List<T> entities) {
		Session session = getSession(false);
		int count = 0;
		for (T entity : entities) {
			session.delete(getEntityName(), entity);
			if (++count % 20 == 0) {
				// flush a batch of updates and release memory:
				session.flush();
				session.clear();
			}
		}
	}

	public final void evict(T entity) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Evict entity [{}] - [{}]", getEntityName(), entity);
		}
		getSession(false).evict(entity);
	}

	public final void flush() {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Flush ...");
		}
		getSession(false).flush();
	}

	public void clear() {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Clear ...");
		}
		getSession(false).clear();
	}

	public void lock(T entity, LockOptions lockOptions) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Lock entity [{}] - [{}]", entity, lockOptions.getLockMode());
		}
		getSession(false).buildLockRequest(lockOptions).lock(getEntityName(), entity);
	}

}
