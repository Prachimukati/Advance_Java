package in.co.rays.preparedstatement;

public class MarksheetTest {
public static void main(String[] args) throws Exception {
	testupdate();
	testadd();
	testdelete();
}

private static void testupdate() throws Exception {
	
	MarksheetBean bean = new MarksheetBean();
	bean.setId(14);
	bean.setName("madhu");
	bean.setRoll_num(20);
	
	MarksheetModel model = new MarksheetModel();
	model.update(bean);
	
}

private static void testdelete() throws Exception {
	MarksheetModel model = new MarksheetModel();
	model.delete(11);
	
}

private static void testadd() throws Exception {
	MarksheetBean bean = new MarksheetBean();
	bean.setId(14);
	bean.setName("prachi");
	bean.setRoll_num(19);
	
	MarksheetModel model = new MarksheetModel();
	model.add(bean);
}	
}