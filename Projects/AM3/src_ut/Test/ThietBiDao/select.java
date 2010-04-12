package Test.ThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.dao.ThietBiDao;

import org.junit.Test;


public class select {

	@Test
	public void testSelect() {
		ThietBiEntity ent = ThietBiDao.selectById(3);
		assertTrue(ent.IdThietBi == 3);
		
	}	

}
