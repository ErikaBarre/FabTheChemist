package connectDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnectDb {
	
	public static void main(String[] args) {
		try { 
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver O.K.");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
			System.out.println("dfdfsdsfdsf");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
