package fab.chemist.dbsql.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fab.chemist.db.framework.service.impl.GenericService;
import fab.chemist.dbsql.dao.interf.IProductsDAO;
import fab.chemist.dbsql.orm.impl.Products;
import fab.chemist.dbsql.service.interf.IProductsService;

@Service(IProductsService.BEAN_NAME)
public class ProductsService extends GenericService<IProductsDAO, Products, Long> implements IProductsService {

	@Resource(name = IProductsDAO.BEAN_NAME)
	@Override
	public void setDAO(IProductsDAO dao) {
		super.setDAO(dao);
	}
	
	

}
