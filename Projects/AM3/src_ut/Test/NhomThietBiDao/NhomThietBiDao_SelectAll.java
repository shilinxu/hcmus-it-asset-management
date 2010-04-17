package Test.NhomThietBiDao;
import static org.junit.Assert.*;

import java.util.ArrayList;

import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.dao.NhomThietBiDAO;

import org.junit.Test;


public class NhomThietBiDao_SelectAll {

	@Test
	public void testSelectRoots() {
		ArrayList<NhomThietBiEntity> lst = NhomThietBiDAO.selectAll();		
		assertTrue(lst.size() >= 2);
	}

}
