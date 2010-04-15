package Test.ThongSoThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.ThongSoThietBiEntity;
import hcmus.am.dao.ThongSoThietBiDao;

import org.junit.Test;


public class insert {

	@Test
	public void testInsert() {
		ThongSoThietBiEntity ent = new ThongSoThietBiEntity();
		ent.IdThongSoLoaiThietBi = 57;
		ent.IdTheHienThietBi= 1;
		ent.GiaTri = "XXX";
		int i = ThongSoThietBiDao.insert(ent);
		assertTrue(i == 1);
	}

}
