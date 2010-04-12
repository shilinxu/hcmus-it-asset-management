package Test.ThietBiDao;
import static org.junit.Assert.*;

import java.util.ArrayList;

import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.dao.ThietBiDao;

import org.junit.Test;


public class Test_ThietBiDAO_SelectN {

	@Test
	public void testSelectN() {
		ArrayList<ThietBiEntity> lst = ThietBiDao.SelectN(0,2);
		assertTrue(lst != null && lst.size() > 1);
	}

}
