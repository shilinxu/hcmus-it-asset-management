import static org.junit.Assert.*;
import hcmus.am.client.entity.TheHienThietBiEntity;
import hcmus.am.dao.TheHienThietBiDao;

import org.junit.Test;


public class Test_TheHienThietBi_Insert {

	@Test
	public void testInsert() {
		TheHienThietBiEntity ent = new TheHienThietBiEntity();
		//ent.IdTheHienThietBi = 1;
		ent.IdTrangThai = 2;
		ent.IdThietBi = 1;
		//ent.LaTheHienCapNhatTuClient = true;
		Integer Id = TheHienThietBiDao.insert(ent);
		assertTrue(Id > 5);
	}

}
