package Test.ThongSoThietBiDao;

import static org.junit.Assert.*;
import hcmus.am.client.entity.ThongSoThietBiEntity;
import hcmus.am.dao.ThongSoThietBiDao;

import org.junit.Test;

public class delete {

	@Test
	public void testSelectById() {
		ThongSoThietBiEntity ent =  new ThongSoThietBiEntity();
		ent.IdThongSoThietBi = 9;
		int rs = ThongSoThietBiDao.delete(ent);
		ent = ThongSoThietBiDao.selectById(9);
		assertTrue(rs == 1 && ent == null);
	}

}
