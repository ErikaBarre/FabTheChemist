package fab.chemist.db.framework.service.impl;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fab.chemist.db.framework.dao.interf.IGenericDAO;
import fab.chemist.db.framework.service.interf.IGenericService;



/**
 * The Generic service.
 */
public class GenericService<T extends IGenericDAO<E,KEY>, E extends Serializable, KEY extends Serializable> extends ImmutableGenericService<T, E, KEY> implements IGenericService<E,KEY> {

	/**
	 * @see ec.ep.dit.simple.framework.service.GenericService#save(java.util.List)
	 */
	@Transactional(propagation = REQUIRED)
	public void save(List<E> entities) {
		_dao.save(entities);
	}

	/**
	 * @see ec.ep.dit.simple.framework.service.GenericService#save(ec.ep.dit.simple.framework.bo.rmsi.sdw.simple.sched.framework.hibernate.bo.interfaces.PersistentObject)
	 */
	@Transactional(propagation = REQUIRED)
	public KEY save(E entity) {
		return _dao.save(entity);
	}

	/**
	 * @see ec.ep.dit.simple.framework.service.GenericService#update(ec.ep.dit.simple.framework.bo.rmsi.sdw.simple.sched.framework.hibernate.bo.interfaces.PersistentObject)
	 */
	@Transactional(propagation = REQUIRED)
	public void update(E entity) {
		_dao.update(entity);
	}

	/**
	 * @see ec.ep.dit.simple.framework.service.GenericService#delete(ec.ep.dit.simple.framework.bo.rmsi.sdw.simple.sched.framework.hibernate.bo.interfaces.PersistentObject)
	 */
	@Transactional(propagation = REQUIRED)
	public void delete(E entity) {
		if (entity == null)
			return;
		_dao.delete(entity);
	}

	/**
	 * @see ec.ep.dit.simple.framework.service.GenericService#delete(java.util.List)
	 */
	@Transactional(propagation = REQUIRED)
	public void delete(List<E> entities) {
		if (entities == null)
			return;
		_dao.delete(entities);
	}

}