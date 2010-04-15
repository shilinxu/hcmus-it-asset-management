package Test.ThongSoThietBiDao;

import static org.junit.Assert.*;
import hcmus.am.client.entity.ThongSoThietBiEntity;
import hcmus.am.dao.ThongSoThietBiDao;

import org.junit.Test;

public class select {

	@Test
	public void testSelectById() {
		ThongSoThietBiEntity ent = ThongSoThietBiDao.selectById(9);
		assertTrue(ent.IdThongSoThietBi == 9);
	}

}
