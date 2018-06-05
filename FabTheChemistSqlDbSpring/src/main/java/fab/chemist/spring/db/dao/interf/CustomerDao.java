package fab.chemist.spring.db.dao.interf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fab.chemist.spring.db.repository.impl.Customer;

public interface CustomerDao extends JpaRepository< Customer, Long >{
	
	Customer findByName( String name);
	
	@Query("SELECT c FROM Customer c WHERE LOWER(c.name) = LOWER(:name)")
	Customer retrieveByName(@Param("name") String name);
	
}


