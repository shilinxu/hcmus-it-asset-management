package Test.ThongSoLoaiThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.dao.ThongSoLoaiThietBiDAO;

import org.junit.Test;


public class SelectIdThongSoMACAdress {

	@Test
	public void testSelectIdThongSoMACAdress() {
		Integer i = ThongSoLoaiThietBiDAO.SelectIdThongSoMACAdress();
		assertTrue(i == 48);
	}

}
