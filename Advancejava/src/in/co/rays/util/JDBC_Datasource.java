package in.co.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBC_Datasource {

		private static JDBC_Datasource jds=null;

		private ComboPooledDataSource ds = null;

		private JDBC_Datasource() {
					
				try {

				ds = new ComboPooledDataSource();

				ds.setDriverClass("com.mysql.jdbc.Driver"); 

				ds.setJdbcUrl("jdbc:mysql://localhost/st_adv_java");

				ds.setUser("root");

				ds.setPassword("root");

				ds.setInitialPoolSize (5);

				ds.setAcquireIncrement (5);

				ds.setMaxPoolSize (50);

				} catch (PropertyVetoException e) {

				e.printStackTrace();
				}
				}

		public static JDBC_Datasource getInstance() {
			
				if (jds == null) {

				jds = new JDBC_Datasource(); 
				
				}

				return jds;

				}

		public static Connection getConnection() {

			try {
				return getInstance().ds.getConnection();

			} catch (SQLException e) {
				return null;
			}
		}
	}