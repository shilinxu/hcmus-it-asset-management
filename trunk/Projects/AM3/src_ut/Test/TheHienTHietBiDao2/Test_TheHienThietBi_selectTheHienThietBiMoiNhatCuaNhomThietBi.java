package Test.TheHienTHietBiDao;
import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.TheHienThietBiEntity;
import hcmus.am.dao.TheHienThietBiDao;

import java.util.ArrayList;

import org.junit.Test;


public class Test_TheHienThietBi_selectTheHienThietBiMoiNhatCuaNhomThietBi {

	@Test
	public void testInsert() {
		TheHienThietBiEntity ent = new TheHienThietBiEntity();
		//ent.IdTheHienThietBi = 1;
		//ent.IdTrangThai = 2;
		//ent.IdThietBi = 1;
		//ent.LaTheHienCapNhatTuClient = true;
		ArrayList<TheHienThietBiEntity >lst = TheHienThietBiDao.selectTheHienThietBiMoiNhatCuaNhomThietBi(2);
		assertTrue(lst.size() > 2);
		
	}

}
