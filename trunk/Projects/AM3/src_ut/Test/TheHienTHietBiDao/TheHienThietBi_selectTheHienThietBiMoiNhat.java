package Test.TheHienTHietBiDao;
import static org.junit.Assert.*;

import java.util.ArrayList;

import hcmus.am.client.entity.TheHienThietBiEntity;
import hcmus.am.dao.TheHienThietBiDao;

import org.junit.Test;


public class TheHienThietBi_selectTheHienThietBiMoiNhat {

	@Test
	public void testInsert() {
		
		//ent.IdTheHienThietBi = 1;
		//ent.IdTrangThai = 2;
		//ent.IdThietBi = 1;
		//ent.LaTheHienCapNhatTuClient = true;
		ArrayList<TheHienThietBiEntity> lst= TheHienThietBiDao.selectTheHienThietBiMoiNhatCuaNhomThietBi(3);
		assertTrue(lst.size() >= 2 );
	}

}
