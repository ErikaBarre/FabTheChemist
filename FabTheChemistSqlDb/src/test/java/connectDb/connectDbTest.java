package connectDb;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
		//props.setProperty("ssl","true");
		try {
			Connection conn = DriverManager.getConnection(url, props);
			conn.close();
			LOGGER.info("fin de connection [{}]", "testdb");
			
		} catch (SQLException e) {
			LOGGER.error("CONNECTION ERROR", e);
		}
	}

}
