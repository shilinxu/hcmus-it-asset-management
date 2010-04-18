package Test.ThietBiDao;
import static org.junit.Assert.*;

import java.util.ArrayList;

import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.dao.ThietBiDao;

import org.junit.Test;


public class selectThietBiTuNhomThietBi {

	@Test
	public void testSelect() {
		ArrayList<ThietBiEntity> lst = ThietBiDao.selectThietBiTuNhomThietBi(1,0,2);
		assertTrue(lst != null && lst.size() > 1);
		
	}	

}
