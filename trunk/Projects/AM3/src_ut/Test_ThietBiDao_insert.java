import static org.junit.Assert.*;
import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.dao.ThietBiDao;

import org.junit.Test;


public class Test_ThietBiDao_insert {

	@Test
	public void testInsert() {
		ThietBiEntity ent = new ThietBiEntity();
		ent.IdLoaiThietBi = 3;
		ent.Name = "CPU Pentium 5";
		ent.Caption = "CPU";
		ent.Description= "PressCot";
		ent.Manufacturer = "Intel";
		ent.Price = 1000000;
		int ID = ThietBiDao.Insert(ent);
		System.out.println(ID);
		assertTrue(ID > 1);
	}

}
