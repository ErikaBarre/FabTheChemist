package fab.chemist.db.framework.service.interf;

import java.io.Serializable;
import java.util.List;

/**
 * There is no WRITE access into the database.
 */
public interface IImmutableGenericService <E extends Serializable, KEY extends Serializable>{

	/**
	 * Get the entity by its primary key.
	 * @param primaryKey The primary key
	 * @return The entity or null if not found
	 */
	E get(KEY primaryKey);

	/**
	 * Find all entities.
	 * @return A list of entities
	 */
	List<E> findAll();
	
	Long getRowCount();

}