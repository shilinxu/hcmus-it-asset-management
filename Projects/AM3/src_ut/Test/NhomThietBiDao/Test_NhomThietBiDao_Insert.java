package Test.NhomThietBiDao;
import static org.junit.Assert.*;

import java.util.ArrayList;

import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.dao.NhomThietBiDAO;

import org.junit.Test;


public class Test_NhomThietBiDao_Insert {

	@Test
	public void testSelectRoots() {
		NhomThietBiEntity ent = new NhomThietBiEntity();
		ent.Ten = "xxx";
		int rs = NhomThietBiDAO.insert(ent);		
		assertTrue(rs >= 3);
	}

}
