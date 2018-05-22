package fab.chemist.db.framework.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 * Used to manager session factory + autowired injection
 * 
 * 
 */
public abstract class HibernateFrameworkDAOSupport {
	
	@PersistenceContext
	  private EntityManager entityManager;
	
	@PersistenceUnit(
			unitName = "CRM"
	)
	private EntityManagerFactory entityManagerFactory;

	public EntityManager getEntityManager () {
		// EntityManager entityManager = entityManagerFactory.createEntityManager( );
		 return entityManager;
	}
	

	//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
}


