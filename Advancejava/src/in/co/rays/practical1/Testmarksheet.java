package in.co.rays.practical1;

import java.util.Iterator;
import java.util.List;

public class Testmarksheet {
	public static void main(String[] args) throws Exception {
		// testadd();
		// testupdate();
		//testdelete();
		// testAdd();
		// testfindById();
		///testSearchSimple();
		testSearch();
	}

private static void testSearch() throws Exception {
	MarksheetBean bean = new MarksheetBean();
	bean.setId(4);
	bean.setName("b");
	
	MarksheetModel model = new MarksheetModel();
	List list = model.Search(bean, 5, 2);
	Iterator it =  list.iterator();
	
	while (it.hasNext()) {
		bean = (MarksheetBean) it.next();
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getRoll_num());
	}
	
}

private static void testSearchSimple() throws Exception {
	MarksheetModel model = new MarksheetModel();
	List list = model.SearchSimple();
	Iterator it = list.iterator();
	
	while (it.hasNext()) {
		MarksheetBean bean = (MarksheetBean) it.next();
		System.out.print("\t"+bean.getId());
		System.out.print("\t"+bean.getName());
		System.out.println("\t"+bean.getRoll_num());
	}
	}


	private static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setName("lavish");
		bean.setRoll_num(117);

		MarksheetModel model = new MarksheetModel();
		model.Add(bean);
	}

	private static void testfindById() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findById(15);

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getRoll_num());
	}

	private static void testdelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.delete(0);
	}

	private static void testupdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(14);
		bean.setName("Ankit");
		bean.setRoll_num(114);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);
	}

	private static void testadd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(15);
		bean.setName("Anmol");
		bean.setRoll_num(115);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);
	}
}