package Test.ThongSoThietBiDao;

import static org.junit.Assert.*;
import hcmus.am.client.entity.ThongSoThietBiEntity;
import hcmus.am.dao.ThongSoThietBiDao;

import org.junit.Test;

public class update {

	@Test
	public void testSelectById() {
		ThongSoThietBiEntity ent = ThongSoThietBiDao.selectById(9);
		ent.GiaTri = "Gia tri moi";
		int rs = ThongSoThietBiDao.update(ent);
		assertTrue(rs == 1);
		ent = ThongSoThietBiDao.selectById(9);
		assertTrue(ent.GiaTri.equals("Gia tri moi"));	
	}	

}
