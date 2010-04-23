package Test.TheHienTHietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.TheHienThietBiEntity;
import hcmus.am.dao.TheHienThietBiDao;

import org.junit.Test;


public class update {

	@Test
	public void testInsert() {
		TheHienThietBiEntity ent = new TheHienThietBiEntity();
		//ent.IdTheHienThietBi = 1;
		//ent.IdTrangThai = 2;
		//ent.IdThietBi = 1;
		//ent.LaTheHienCapNhatTuClient = true;
		ent  = TheHienThietBiDao.selectById(12);
		ent.IdNguoiDung = 2;
		ent.IdNhomThietBi = 7;
		ent.IdThietBi = 6;
		int rs = TheHienThietBiDao.update(ent);
		assertTrue(rs == 1);
	}

}
