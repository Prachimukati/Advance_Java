package in.co.rays.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.Marksheet.Bean;
import in.co.rays.preparedstatement.MarksheetBean;

public class Test_JDBCDatasource {
	public static void main(String[] args) throws Exception {

		for (int i = 1; i <= 50; i++) {
			System.out.println("connection = " + i);
			testGet();
		}

	}

	private static void testGet() throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id = 1");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
		}

	}
}
