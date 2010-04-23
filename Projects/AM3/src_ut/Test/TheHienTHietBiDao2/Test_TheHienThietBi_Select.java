package Test.TheHienTHietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.TheHienThietBiEntity;
import hcmus.am.dao.TheHienThietBiDao;

import org.junit.Test;


public class Test_TheHienThietBi_Select {

	@Test
	public void testSelect() {
		TheHienThietBiEntity ent = TheHienThietBiDao.selectById(4);
		assertTrue(ent.IdTrangThai == 2);
	}

}
