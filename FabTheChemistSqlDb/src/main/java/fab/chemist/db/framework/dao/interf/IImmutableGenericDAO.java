package fab.chemist.db.framework.dao.interf;

import java.io.Serializable;
import java.util.List;

import org.hibernate.LockOptions;

/**
 * This DAO is only use for the Immutable Hibernate Entity.
 * There is no WRITE access into the database.
 * 
 *
 * 
 */
public interface IImmutableGenericDAO <T extends Serializable, KEY extends Serializable>{


    /**
     * Return the persistent instance of the given named entity with the given identifier,
     * or null if there is no such persistent instance. (If the instance, or a proxy for the
     * instance, is already associated with the session, return that instance or proxy.)
     *
     * @param primaryKey an identifier
     * @return a persistent instance or null
     * @throws org.hibernate.HibernateException
     *
     */
    T get(KEY primaryKey);

    T get(KEY primaryKey, LockOptions lockOptions);

    /**
     * Execute a criteria to fecth all entities
     * @return The list of entities
     */
    List<T> findAll();
    
	public Long getRowCount();

}