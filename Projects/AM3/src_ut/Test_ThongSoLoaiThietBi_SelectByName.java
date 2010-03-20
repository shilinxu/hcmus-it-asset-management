import static org.junit.Assert.*;
import hcmus.am.client.entity.ThongSoLoaiThietBiEntity;
import hcmus.am.dao.ThongSoLoaiThietBiDAO;

import org.junit.Test;


public class Test_ThongSoLoaiThietBi_SelectByName {

	@Test
	public void testSelectByName() {
		ThongSoLoaiThietBiEntity ent = ThongSoLoaiThietBiDAO.selectByName(3, "Model");
		assertTrue(ent.IdThongSoLoaiThietBi == 7);
	}

}
