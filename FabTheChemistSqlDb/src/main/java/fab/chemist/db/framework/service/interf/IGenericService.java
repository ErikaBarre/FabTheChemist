package fab.chemist.db.framework.service.interf;

import java.io.Serializable;
import java.util.List;


public interface IGenericService<E extends Serializable, KEY extends Serializable> extends IImmutableGenericService<E, KEY>{

	KEY save(E entity);

	void save(List<E> entities);

	void update(E entity);

	void delete(E entity);

	void delete(List<E> entity);

}
