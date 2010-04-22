package Test.ThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.view.ThietBiView;
import hcmus.am.dao.ThietBiDao;

import org.junit.Test;


public class selectThietBiView {

	@Test
	public void testSelect() {
		ThietBiView[] lst = ThietBiDao.selectThietBiView(3);
		//System.out.println(lst[0].loaiThietBi.HinhAnh);
		assertTrue(lst.length > 1);
	}	

}
