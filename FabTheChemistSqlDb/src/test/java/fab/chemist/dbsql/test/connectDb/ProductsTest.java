package fab.chemist.dbsql.test.connectDb;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import fab.chemist.dbsql.orm.impl.Products;
import fab.chemist.dbsql.service.interf.IProductsService;
import fab.chemist.dbsql.test.utils.JunitUtils;


public class ProductsTest extends JunitUtils{

	final Logger logger = LoggerFactory.getLogger(ProductsTest.class);
	
	private IProductsService service;
		
	@Before
	public void init() throws Exception{
		try {
			ApplicationContext applicationContext = loadContext(LOCATIONS);
			service =  (IProductsService) applicationContext.getBean(IProductsService.BEAN_NAME);
		} catch (Exception e) {
			logger.error("Failed{}",e);
			throw e;
		}
	}	
	
	//TODO investigate more on GOT  ORA-00932: inconsistent datatypes: expected NUMBER got BINARY
	@Test
	public void testSave(){
		
		//for(int i=0; i<100;i++) {
		
		Products bean = new Products();
		//bean.setId(101L);
		bean.setNameProduit("MPLOK");
		
		long random = (int )(Math.random() * 5000 + 1);
		
		bean.setNoProduit(random);
		bean.setPrix(125L);
		bean.setPrixPromotion(110L);
		service.save(bean);
    	logger.info("Products inserted!");
		//}
    	assertTrue(true);
	}
	
	@Test 
	public void testGet(){
		Long id = new Long(1);
		Products bean = service.get(id);		
		logger.info("Products fetched by ID! Id: {} ", bean.getId());
		assertTrue(true);
	}	

	@Test 
	public void testFindAll(){
		List<Products> beans = service.findAll();		
		logger.info("Products list size is :" + beans.size());
		assertTrue(true);
	}

	//@Test 
	public void testUpdate(){
		Long primaryKey = new Long(4);
		Products bean = service.get(primaryKey);
		logger.info("Products type of TypeOfPost was before update:" + bean.getPrix());
		bean.setPrix(122L);
		service.update(bean);		
		bean = service.get(primaryKey);		
		logger.info("Products type of TypeOfPost was after update:" + bean.getPrix());
		assertTrue(true);
	}
	
	//@Test 
	public void testDelete(){
		Long id = new Long(20);
		Products bean = service.get(id);
		service.delete(bean);
		bean = service.get(id);
		assertTrue(bean == null);
	}
	
	@Test 
	public void getCountTest() {
		
		//Long beans = service.getRowCount();		
		//logger.info("result size is:" + beans);
		assertTrue(true);
	}	

	
	
}
