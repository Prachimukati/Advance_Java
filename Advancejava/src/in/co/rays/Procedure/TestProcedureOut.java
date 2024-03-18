
package in.co.rays.Procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import com.mysql.cj.xdevapi.Type;

public class TestProcedureOut {
public static void main(String[] args) throws Exception {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","root");
		CallableStatement callstmt = conn.prepareCall("{CALL empOUT(?)}");
		callstmt.registerOutParameter(1, Types.INTEGER);
		callstmt.execute();
		
		int resultValue = callstmt.getInt(1);
		System.out.println("Result from empOut stored procedure :"+resultValue);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}
}
