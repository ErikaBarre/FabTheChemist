package fab.chemist.db.framework.dao.interf;

import java.io.Serializable;
import java.util.List;

import javax.persistence.LockModeType;

import org.hibernate.LockOptions;


public interface IGenericDAO<T extends Serializable, KEY extends Serializable> extends IImmutableGenericDAO<T,KEY>{

    /**
     * Persist the given transient instance, first assigning a generated identifier. (Or
     * using the current value of the identifier property if the <tt>assigned</tt>
     * generator is used.)  This operation cascades to associated instances if the
     * association is mapped with <tt>cascade="save-update"</tt>.
     *
     * @param t a transient instance of a persistent class
     * @return the generated identifier
     * @throws org.hibernate.HibernateException
     *
     */
	void save(T t);

    void save(List<T> t);

    void persist(T t);

    /**
     * Update the persistent instance with the identifier of the given detached
     * instance. If there is a persistent instance with the same identifier,
     * an exception is thrown. This operation cascades to associated instances
     * if the association is mapped with <tt>cascade="save-update"</tt>.
     *
     * @param t a detached instance containing updated state
     * @throws org.hibernate.HibernateException
     *
     */
    void update(T t);

    /**
     * Copy the state of the given object onto the persistent object with the same
     * identifier. If there is no persistent instance currently associated with
     * the session, it will be loaded. Return the persistent instance. If the
     * given instance is unsaved, save a copy of and return it as a newly persistent
     * instance. The given instance does not become associated with the session.
     * This operation cascades to associated instances if the association is mapped
     * with <tt>cascade="merge"</tt>.<br>
     * <br>
     * The semantics of this method are defined by JSR-220.
     *
     * @param t a detached instance with state to be copied
     * @return an updated persistent instance
     */
    T merge(T t);

    /**
     * Remove a persistent instance from the datastore. The argument may be
     * an instance associated with the receiving <tt>Session</tt> or a transient
     * instance with an identifier associated with existing persistent state.
     * This operation cascades to associated instances if the association is mapped
     * with <tt>cascade="delete"</tt>.
     *
     * @param t the instance to be removed
     * @throws org.hibernate.HibernateException
     *
     */
    void delete(T t);

    void delete(List<T> t);

    /**
     * Remove this instance from the session cache. Changes to the instance will
     * not be synchronized with the database. This operation cascades to associated
     * instances if the association is mapped with <tt>cascade="evict"</tt>.
     *
     * @param entity a persistent instance
     * @throws org.hibernate.HibernateException
     *
     */
    void evict(T entity);

    void flush();
    
    void clear();
	
	/**
	 * Build a LockRequest that specifies the LockMode, pessimistic lock timeout
	 * and lock scope. timeout and scope is ignored for optimistic locking.
	 * After building the LockRequest, call LockRequest.lock to perform the
	 * requested locking. Use: session.buildLockRequest().
	 * setLockMode(LockMode.PESSIMISTIC_WRITE).setTimeOut(1000 *
	 * 60).lock(entity);
	 * 
	 * @param entita persistent or transient instance
	 * @param lockOptions the lock level
	 */
    //void lock(T entity, LockOptions lockOptions);
    
    
    void lock(T entity, LockModeType lockOptions);
    
	//Long getRowCount();

}