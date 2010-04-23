package Test.NhomNguoiDungDao;

import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.NguoiDungEntity;
import hcmus.am.client.entity.NhomNguoiDungEntity;
import hcmus.am.dao.NguoiDungDao;
import hcmus.am.dao.NhomNguoiDungDao;

import org.junit.Test;

public class delete {

	@Test
	public void testSelectNguoiDungCuaNhom() {
		
		
		NhomNguoiDungEntity ent  = NhomNguoiDungDao.selectById(2);
		
		int rs = NhomNguoiDungDao.delete(ent);
		assertTrue(rs ==1);
		
	}

}
