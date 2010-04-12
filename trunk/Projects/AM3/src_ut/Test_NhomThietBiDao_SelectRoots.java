import static org.junit.Assert.*;

import java.util.ArrayList;

import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.dao.NhomThietBiDAO;

import org.junit.Test;


public class Test_NhomThietBiDao_SelectRoots {

	@Test
	public void testSelectRoots() {
		//ArrayList<NhomThietBiEntity> lst = NhomThietBiDAO.selectRoots();
		ArrayList<NhomThietBiEntity> lst = NhomThietBiDAO.selectSubNhomThietBi(1);
		assertTrue(lst.size() >= 1);
	}

}
