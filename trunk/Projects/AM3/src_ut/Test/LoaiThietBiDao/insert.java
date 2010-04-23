package Test.LoaiThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.LoaiThietBiEntity;
import hcmus.am.dao.LoaiThietBiDao;

import org.junit.Test;


public class insert {

	@Test
	public void testSelectByName() {
		LoaiThietBiEntity ent = new LoaiThietBiEntity();
		ent.Ten = "Sach";
		ent.MoTa = "sach dung de doc";
		ent.HinhAnh = "sach.png";
		int rs = LoaiThietBiDao.insert(ent);
		//.selectById(1);
		assertTrue (rs == 1);
	}

}
