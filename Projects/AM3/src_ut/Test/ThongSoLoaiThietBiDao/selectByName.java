package Test.ThongSoLoaiThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.ThongSoLoaiThietBiEntity;
import hcmus.am.dao.ThongSoLoaiThietBiDAO;

import org.junit.Test;


public class selectByName {

	@Test
	public void testSelectByName() {
		ThongSoLoaiThietBiEntity ent = ThongSoLoaiThietBiDAO.selectByName(3, "Model");
		assertTrue(ent.IdThongSoLoaiThietBi == 7);
	}

}
