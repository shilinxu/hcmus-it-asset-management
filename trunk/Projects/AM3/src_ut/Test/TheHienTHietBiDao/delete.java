package Test.TheHienTHietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.TheHienThietBiEntity;
import hcmus.am.dao.TheHienThietBiDao;

import org.junit.Test;


public class delete {

	@Test
	public void testInsert() {
		TheHienThietBiEntity ent = new TheHienThietBiEntity();
		//ent.IdTheHienThietBi = 1;
		//ent.IdTrangThai = 2;
		//ent.IdThietBi = 1;
		//ent.LaTheHienCapNhatTuClient = true;
		ent.IdTheHienThietBi = 11;
		Integer rs = TheHienThietBiDao.delete(ent);
		assertTrue(rs == 1);
	}

}
