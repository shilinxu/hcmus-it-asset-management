package Test.LoaiThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.LoaiThietBiEntity;
import hcmus.am.dao.LoaiThietBiDao;

import org.junit.Test;


public class update {

	@Test
	public void testSelectByName() {
		LoaiThietBiEntity ent  = LoaiThietBiDao.selectById(23);
		ent.Ten = "1Sach";
		ent.MoTa = "1sach dung de doc";
		ent.HinhAnh = "1sach.png";
		int rs = LoaiThietBiDao.update(ent);
		//.selectById(1);
		assertTrue (rs == 1);
	}

}
