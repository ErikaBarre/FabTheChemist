package fab.chemist.dbsql.service.interf;

import fab.chemist.db.framework.service.interf.IGenericService;
import fab.chemist.dbsql.orm.impl.Products;

public interface IProductsService extends IGenericService<Products, Long>{
	
	String BEAN_NAME = "productsService";

}
