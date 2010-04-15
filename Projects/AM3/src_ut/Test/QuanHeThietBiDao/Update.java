package Test.QuanHeThietBiDao;
import static org.junit.Assert.*;
import hcmus.am.client.entity.QuanHeThietBiEntity;
import hcmus.am.dao.QuanHeThietBiDao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;


public class Update {

	@Test
	public void test() {
		QuanHeThietBiEntity ent = new QuanHeThietBiEntity();
		ent.IdTheHienThietBiCha = 3;
		ent.IdTheHienThietBiCon = 4;
		Date d = new Date();
		//ent.ThoiGian = new Timestamp(d.getTime());
		int rs = QuanHeThietBiDao.insert(ent);		
		assertTrue(rs == 1);
	}
	

}
