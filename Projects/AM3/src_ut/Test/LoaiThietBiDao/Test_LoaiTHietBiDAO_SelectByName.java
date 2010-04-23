package Test.LoaiThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.LoaiThietBiEntity;
import hcmus.am.dao.LoaiThietBiDao;

import org.junit.Test;


public class Test_LoaiTHietBiDAO_SelectByName {

	@Test
	public void testSelectByName() {
		LoaiThietBiEntity ent = LoaiThietBiDao.selectByName("DESKTOP");
		assertTrue (ent.IdLoaiThietBi == 1);
	}

}
