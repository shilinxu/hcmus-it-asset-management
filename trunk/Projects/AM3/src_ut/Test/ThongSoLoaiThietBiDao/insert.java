package Test.ThongSoLoaiThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.ThongSoLoaiThietBiEntity;
import hcmus.am.dao.ThongSoLoaiThietBiDAO;

import org.junit.Test;


public class insert {

	@Test
	public void testSelectByName() {
		ThongSoLoaiThietBiEntity ent =new ThongSoLoaiThietBiEntity();
		ent.IdLoaiThietBi = 1;
		ent.Ten = "Can nang";
		ent.SuDungDeKiemTraThietBi = false;
		int rs = ThongSoLoaiThietBiDAO.insert(ent);
		ent = ThongSoLoaiThietBiDAO.selectByName( 1, "Can nang");
		assertTrue(rs == 1 && ent.IdThongSoLoaiThietBi > 65);
	}

}
