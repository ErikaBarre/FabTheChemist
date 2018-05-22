package fab.chemist.dbsql.test.utils;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitUtils {
	
	protected static ApplicationContext APPLICATION_CONTEXT;
	//public static final String[] LOCATIONS = {"spring-hibernate.xml","spring-aspect.xml", "spring-instantiate.xml"};
	//public static final String[] LOCATIONS = {"spring-config-db-activiti-test.xml", "spring-service-dao.xml"};
	public static final String[] LOCATIONS = {"spring-config-db-test.xml", "spring-service-dao.xml"};
	//public static final String[] LOCATIONS = {"spring-config-db-ITG-activiti-test.xml", "spring-service-dao.xml"};
	
	public ApplicationContext loadContext(String... locations) throws Exception {
		if (APPLICATION_CONTEXT == null) {
			if (locations == null || locations.length == 0) {
				APPLICATION_CONTEXT = new ClassPathXmlApplicationContext(LOCATIONS);
			} else {
				APPLICATION_CONTEXT = new ClassPathXmlApplicationContext(locations);
			}
		}
		return APPLICATION_CONTEXT;
	}
	
	
	public static byte[] makeBinContent(String path) {
		File file = new File(path);
		byte[] content = new byte[(int) file.length()];
		 
		try {
		    FileInputStream fileInputStream = new FileInputStream(file);
		    fileInputStream.read(content);
		    fileInputStream.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return content;
	}


	/*public static PersonalMember getPersonalMember() {
		PersonalMemberService service =  (PersonalMemberService) APPLICATION_CONTEXT.getBean(PersonalMemberService.BEAN_NAME);		
		return service.get(2L);
	}*/


	
}
