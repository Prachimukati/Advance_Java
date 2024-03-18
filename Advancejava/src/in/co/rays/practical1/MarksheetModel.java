package in.co.rays.practical1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;

public class MarksheetModel {

	public void add(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:localhost:3306/person", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?)");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRoll_num());

		int i = ps.executeUpdate();
		System.out.println("Data added=" + i);

	}

	public void update(MarksheetBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("update  marksheet set name =?,roll_num=? where id =?");
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getRoll_num());
		ps.setInt(3, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("Data Updated=" + i);

	}

	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id=? ");
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		System.out.println("Data deleted=" + i);
	}

	public MarksheetBean findById(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from Marksheet where id =?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		MarksheetBean bean = new MarksheetBean();

		while (rs.next()) {
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_num(rs.getInt(3));
		}
		conn.close();
		return bean;

	}

	public Integer nextId() throws Exception {

		int id = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			id = rs.getInt(1);
		}
		return id + 1;
	}

	public void Add(MarksheetBean bean) throws Exception {
		int id = nextId();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRoll_num());

		int i = ps.executeUpdate();
		System.out.println("Data Added=" + i);

	}

	public List SearchSimple() throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from marksheet ");
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			MarksheetBean bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_num(rs.getInt(3));
			list.add(bean);
		}
		conn.close();
		return list;
	}

	public List Search(MarksheetBean bean, int pageSize, int pageNo) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append("and id = " + bean.getId());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}
		System.out.println("sql ===>" + sql);

		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		
		while (rs.next()) {
		 bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_num(rs.getInt(3));
			list.add(bean);
		}
		conn.close();
		return list;
	}
}
