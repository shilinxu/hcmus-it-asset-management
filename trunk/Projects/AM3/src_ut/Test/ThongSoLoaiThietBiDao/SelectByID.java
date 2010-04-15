package Test.ThongSoLoaiThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.ThongSoLoaiThietBiEntity;
import hcmus.am.dao.ThongSoLoaiThietBiDAO;

import org.junit.Test;


public class SelectByID {

	@Test
	public void testSelectByName() {
		ThongSoLoaiThietBiEntity ent = ThongSoLoaiThietBiDAO.selectById(1);
		assertTrue(ent.IdLoaiThietBi == 1);
	}

}
