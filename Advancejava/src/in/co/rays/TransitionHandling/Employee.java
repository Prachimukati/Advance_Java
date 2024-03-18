package in.co.rays.TransitionHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employee {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);

			int i = stmt.executeUpdate("insert into marksheet values(8,'shruti',89)");
			i = stmt.executeUpdate("insert into marksheet values(9,'chetna',90)");
			i = stmt.executeUpdate("insert into marksheet values(10,'anushka',90)");

			conn.commit();
			System.out.println("Data inserted=" + i);
		} catch (Exception e) {
			conn.rollback();
			System.out.println(e.getMessage());
		} finally {
			conn.close();
		}

	}
}
