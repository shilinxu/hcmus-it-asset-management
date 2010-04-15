package Test.NhomThietBiDao;
import static org.junit.Assert.*;

import java.util.ArrayList;

import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.dao.NhomThietBiDAO;

import org.junit.Test;


public class Test_NhomThietBiDao_SelectSubNhomThietBi {

	@Test
	public void testSelectRoots() {
		NhomThietBiEntity ent = NhomThietBiDAO.selectById(1);		
		assertTrue(ent.Ten.equals("Khoa CNTT"));
	}

}
