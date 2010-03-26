import static org.junit.Assert.*;
import hcmus.am.dao.ThongSoLoaiThietBiDAO;

import org.junit.Test;


public class Test_ThongSoLoaiTHietBi_SelectIdThongSoMACAdress {

	@Test
	public void testSelectIdThongSoMACAdress() {
		Integer i = ThongSoLoaiThietBiDAO.SelectIdThongSoMACAdress();
		assertTrue(i == 48);
	}

}
