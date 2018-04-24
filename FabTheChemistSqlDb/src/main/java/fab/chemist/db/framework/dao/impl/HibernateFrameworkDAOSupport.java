package fab.chemist.db.framework.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Used to manager session factory + autowired injection
 * 
 * 
 */
public abstract class HibernateFrameworkDAOSupport {

	/**
	 * Hibernate SessionFactory
	 */
	private SessionFactory _sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		_sessionFactory = sessionFactory;
	}

	protected final Session getSession() {
		
		
		
		return getSession(false);
	}

	protected final Session getSession(boolean allowCreate) {
		return _sessionFactory.getCurrentSession();
	}	
}
