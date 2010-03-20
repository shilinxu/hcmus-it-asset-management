import static org.junit.Assert.*;
import hcmus.am.client.entity.ThongSoThietBiEntity;
import hcmus.am.dao.ThongSoThietBiDao;

import org.junit.Test;


public class Test_ThongSoThietBi_Insert {

	@Test
	public void testInsert() {
		ThongSoThietBiEntity ent = new ThongSoThietBiEntity();
		ent.IdThongSoLoaiThietBi = 57;
		ent.IdThietBi = 17;
		ent.GiaTri = "XXX";
		int i = ThongSoThietBiDao.insert(ent);
		assertTrue(i == 1);
	}

}
