package Test.ThongSoLoaiThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.ThongSoLoaiThietBiEntity;
import hcmus.am.dao.ThongSoLoaiThietBiDAO;

import org.junit.Test;


public class update {

	@Test
	public void testSelectByName() {
		ThongSoLoaiThietBiEntity ent = ThongSoLoaiThietBiDAO.selectById(2);
		ent.YNghia = "xxx";
		int rs = ThongSoLoaiThietBiDAO.update(ent);
		ent = ThongSoLoaiThietBiDAO.selectById(2);
		assertTrue(rs == 1 && ent.YNghia.equals("xxx"));
	}

}
