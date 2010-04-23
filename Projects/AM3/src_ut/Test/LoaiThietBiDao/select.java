package Test.LoaiThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.LoaiThietBiEntity;
import hcmus.am.dao.LoaiThietBiDao;

import org.junit.Test;


public class select {

	@Test
	public void testSelectByName() {
		LoaiThietBiEntity ent = LoaiThietBiDao.selectById(1);
		assertTrue (ent.Ten.equals("Desktop"));
	}

}
