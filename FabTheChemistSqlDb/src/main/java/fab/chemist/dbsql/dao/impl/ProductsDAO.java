package fab.chemist.dbsql.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import fab.chemist.db.framework.dao.impl.GenericDAO;
import fab.chemist.dbsql.dao.interf.IProductsDAO;
import fab.chemist.dbsql.orm.impl.Products;
import fab.chemist.dbsql.orm.interf.IProducts;

@Service
@Component 
@Repository(IProductsDAO.BEAN_NAME)
public class ProductsDAO extends GenericDAO<Products, Long> implements IProductsDAO {

	private static Logger LOGGER = LoggerFactory.getLogger(ProductsDAO.class); 
	
	public String getEntityName() {
		return IProducts.ENTITY_NAME;
	}
	
	@Override
	public Class<Products> getEntityClass() {
		return Products.class;
	}
	
	public void getProducts () {

		
/*CriteriaBuilder builder = entityManager.getCriteriaBuilder();

CriteriaQuery<Person> criteria = builder.createQuery( Person.class );
Root<Person> root = criteria.from( Person.class );
criteria.select( root );
criteria.where( builder.equal( root.get( Person_.name ), "John Doe" ) );

List<Person> persons = entityManager.createQuery( criteria ).getResultList();*/


	}

	

	
}
