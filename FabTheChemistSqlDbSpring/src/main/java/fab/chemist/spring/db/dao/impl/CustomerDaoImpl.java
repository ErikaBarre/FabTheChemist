package fab.chemist.spring.db.dao.impl;

import org.springframework.stereotype.Repository;

import fab.chemist.spring.db.dao.interf.AbstractJpaDAO;
import fab.chemist.spring.db.dao.interf.CustomerDao;
import fab.chemist.spring.db.repository.impl.Customer;

@Repository
public class CustomerDaoImpl extends AbstractJpaDAO<Customer> implements CustomerDao{
 
	public CustomerDaoImpl(){
	 setClazz(Customer.class );
 }
}