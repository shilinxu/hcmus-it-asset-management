package Test.LoaiThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.LoaiThietBiEntity;
import hcmus.am.dao.LoaiThietBiDao;

import org.junit.Test;


public class delete {

	@Test
	public void testSelectByName() {
		LoaiThietBiEntity ent  = LoaiThietBiDao.selectById(23);
		int rs = LoaiThietBiDao.delete(ent);
		//.selectById(1);
		assertTrue (rs == 1);
	}

}
