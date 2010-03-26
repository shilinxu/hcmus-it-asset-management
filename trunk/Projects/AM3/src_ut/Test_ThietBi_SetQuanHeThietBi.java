import static org.junit.Assert.*;
import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.dao.ThietBiDao;

import org.junit.Test;


public class Test_ThietBi_SetQuanHeThietBi {

	@Test
	public void testSetQuanHeThietBi() {
		ThietBiEntity tbCha = new ThietBiEntity();
		tbCha.IdThietBi = 3;
		ThietBiEntity tbCon = new ThietBiEntity();
		tbCon.IdThietBi = 2;
		int rs = ThietBiDao.SetQuanHeThietBi(tbCha, tbCon);
		assertTrue(rs == 1);
	}	
	@Test
	public void testSettheHienThietBi() {
		ThietBiEntity thietbi = new ThietBiEntity();
		thietbi.IdThietBi = 3;
		ThietBiEntity ThietBiGoc  = new ThietBiEntity();
		ThietBiGoc.IdThietBi = 2;
		int rs = ThietBiDao.SetThietBiGoc(thietbi, ThietBiGoc);
		
		assertTrue(rs == 1);
	}

}
