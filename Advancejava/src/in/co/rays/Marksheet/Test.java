package in.co.rays.Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import in.co.rays.preparedstatement.MarksheetBean;
import in.co.rays.preparedstatement.MarksheetModel;

public class Test {
	public static void main(String[] args) throws Exception {

		// testupdate();
		// testadd();
		///testAdd();
		//testfindbyid();
		 testsearch();

//		 testdelete();
	}

	private static void testdelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.delete(15);

	}

	private static void testupdate() throws Exception {

		Bean bean = new Bean();
		bean.setId(10);
		bean.setName("chandu");
		bean.setRoll_num(110);

		Model model = new Model();
		model.update(bean);
	}

	private static void testAdd() throws Exception {

		Bean bean = new Bean();
		bean.setName("vedant");
		bean.setRoll_num(121);
		Model md = new Model();
		md.add1(bean);
		
	}

	private static void testadd() throws Exception {
		Bean bean = new Bean();
		bean.setId(13);
		bean.setName("dip");
		bean.setRoll_num(114);

		Model model = new Model();
		model.add(bean);
	}

	private static void testsearch() throws Exception {
		Model md = new Model();
		Bean bean = new Bean();
		bean.setId(5);
		bean.setName("p");
		List list = md.search();
		Iterator it = list.iterator();
		Bean bn = null;
		while (it.hasNext()) {
			bn = (Bean) it.next();
			System.out.println(bn.getId());
			System.out.println(bn.getName());
			System.out.println(bn.getRoll_num());

		}

	}

	private static void testfindbyid() throws Exception {
		Model md = new Model();
		Bean bn = (Bean) md.findbyId(6);
		if (bn != null) {

			System.out.print(bn.getId());
			System.out.print("\t" + bn.getName());
			System.out.print("\t" + bn.getRoll_num());

		} else {
			System.out.println("Id does not exist....!");
		}

	}
}
