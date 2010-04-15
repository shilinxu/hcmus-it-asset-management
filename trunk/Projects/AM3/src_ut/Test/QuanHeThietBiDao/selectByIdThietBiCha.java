package Test.QuanHeThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.QuanHeThietBiEntity;
import hcmus.am.dao.QuanHeThietBiDao;

import java.util.ArrayList;

import org.junit.Test;


public class selectByIdThietBiCha {

	@Test
	public void test() {
		ArrayList<QuanHeThietBiEntity> lst = QuanHeThietBiDao.selectByIdThietBiCha(1);
		assertTrue(lst.size() > 2);		
	}
	

}
