package in.co.rays.Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.preparedstatement.MarksheetBean;

public class Model {
	public Bean findbyId(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from prachi where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Bean bn = null;

		while (rs.next()) {
			bn = new Bean();
			bn.setId(rs.getInt(1));
			bn.setName(rs.getString(2));
			bn.setRoll_num(rs.getInt(3));
		}
		return bn;
	}

	public List search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet ");
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			MarksheetBean bn = new MarksheetBean();
			bn.setId(rs.getInt(1));
			bn.setName(rs.getString(2));
			bn.setRoll_num(rs.getInt(3));
			list.add(bn);

		}
		return list;
	}

	public Integer nextid() throws Exception {
		
		int id = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from prachi");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			id = rs.getInt(1);
		}

		return id + 1;

	}

	public void add1(Bean bean) throws Exception {
		int id = nextid();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values (?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRoll_num());
		int i = ps.executeUpdate();
		System.out.println("data inserted " + i);

	}

	public List search1(Bean bean, int pageNo, int pagesize) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1 ");
		// StringBuffer is mutable

		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + " %'");
			}
			if (bean.getRoll_num() > 0) {
				sql.append(" and roll_no = " + bean.getRoll_num());
			}
		}

		if (pagesize > 0) {
			pageNo = (pageNo - 1) * pagesize;
			sql.append("limit" + pageNo + "," + pagesize);
		}

		System.out.println(" sql =======> " + sql);

		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {

			MarksheetBean bn = new MarksheetBean();
			bn.setId(rs.getInt(1));
			bn.setName(rs.getString(2));
			bn.setRoll_num(rs.getInt(3));
			list.add(bn);

		}
		return list;
	}

	public void add(Bean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into prachi values(?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRoll_num());
		int i = ps.executeUpdate();
		System.out.println("Data inserted=" + i);

	}

	public void update(Bean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33306/person", "root", "root");
		PreparedStatement ps = conn.prepareStatement("update prachi set name = ?,roll_no=? where id =?");
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getRoll_num());
		ps.setInt(3, bean.getId());

		int i = ps.executeUpdate();
		System.out.println("Data Updated=" + i);
	}

	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");

		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");
		ps.setInt(1, id);

		int i = ps.executeUpdate();
		System.out.println("Data deleted = " + i);

	}
}
