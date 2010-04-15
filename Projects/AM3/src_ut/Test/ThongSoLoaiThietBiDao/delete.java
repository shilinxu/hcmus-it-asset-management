package Test.ThongSoLoaiThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.ThongSoLoaiThietBiEntity;
import hcmus.am.dao.ThongSoLoaiThietBiDAO;

import org.junit.Test;


public class delete {

	@Test
	public void testSelectByName() {
		ThongSoLoaiThietBiEntity ent = ThongSoLoaiThietBiDAO.selectByName( 1, "Can nang");
		int rs = ThongSoLoaiThietBiDAO.delete(ent);
		
		assertTrue(rs == 1);
	}

}
