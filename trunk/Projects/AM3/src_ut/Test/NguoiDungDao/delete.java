package Test.NguoiDungDao;

import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.NguoiDungEntity;
import hcmus.am.dao.LoaiNguoiDungDao;
import hcmus.am.dao.NguoiDungDao;

import org.junit.Test;

public class delete {

	@Test
	public void testSelectNguoiDungCuaNhom() {
		NguoiDungEntity ent  =  NguoiDungDao.selectById(6);
		
		int rs  = NguoiDungDao.delete(ent);
		assertTrue(rs  == 1);
		
	}

}
