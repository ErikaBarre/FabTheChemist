package fab.chemist.dbsql.test.connectDb;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class connectDbTest {

	Logger LOGGER = LoggerFactory.getLogger(connectDbTest.class.getName());
	
	@Test
	public void testJDBCConnectPostGreSql() {
		
		try { 
			Class.forName("org.postgresql.Driver");
			//System.out.println("Driver O.K.");
		} catch (ClassNotFoundException e) {
			LOGGER.error("DRIVER ERROR" , e);
		}
		//5432
		String url = "jdbc:postgresql://192.168.178.25:5432/fabthechemistdb";
		//String url = "jdbc:postgresql://127.0.0.1:5432/madb";pi@raspberrypipostgressql
		//String url = "jdbc:postgresql://raspberrypi:5432/fabthechemistdb";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","");
		
		String sqlRequest = "SELECT table_name FROM information_schema.tables WHERE table_schema='public'";
		Statement stmt = null;
	    
		
		//props.setProperty("ssl","true");
		try {
			Connection connection = DriverManager.getConnection(url, props);
			
			stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(sqlRequest);
	        while (rs.next()) {
	            String coffeeName = rs.getString("table_name");
	           
	            LOGGER.info(coffeeName);
	        }
	            connection.close();
			LOGGER.info("fin de connection [{}]", "testdb");
			
		} catch (SQLException e) {
			LOGGER.error("CONNECTION ERROR", e);
		}
	}
	
	@Test
	public void testHibernateConnectPostGresSql() {
		
		
	}
	

}
