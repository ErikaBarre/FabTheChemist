package fab.chemist.dbsql.dao.interf;

import fab.chemist.db.framework.dao.interf.IGenericDAO;
import fab.chemist.dbsql.orm.impl.Products;

public interface IProductsDAO extends IGenericDAO<Products, Long>{
	
	String BEAN_NAME = "productsDao";

}
