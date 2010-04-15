package Test.ThongSoLoaiThietBiDao;
import static org.junit.Assert.*;

import java.util.ArrayList;

import hcmus.am.client.entity.ThongSoLoaiThietBiEntity;
import hcmus.am.dao.ThongSoLoaiThietBiDAO;

import org.junit.Test;


public class sellectAllThongSoOfLoaiThietBi {

	@Test
	public void testSelectByName() {
		ArrayList<ThongSoLoaiThietBiEntity> lst = ThongSoLoaiThietBiDAO.selectAllThongSoOfThietBi(1);
		assertTrue(lst.size() > 0);
	}

}
