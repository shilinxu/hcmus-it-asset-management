package Test.ThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.dao.ThietBiDao;

import org.junit.Test;


public class Test_ThietBiDao_insert {

	//@Test
	public void testInsert() {
		ThietBiEntity ent = new ThietBiEntity();
		ent.IdLoaiThietBi = 3;
		int ID = ThietBiDao.insert(ent);
		System.out.println(ID);
		assertTrue(ID > 1);
	}
/*	@Test
	public void testGetIdDesktopByMACAddress() {
		Integer i = ThietBiDao.GetIdDesktopByMACAddress("00:11:5B:AD:D4:7B");
		assertTrue(i == 3);
	}
	*/

	

}
