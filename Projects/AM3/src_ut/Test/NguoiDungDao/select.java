package Test.NguoiDungDao;

import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.NguoiDungEntity;
import hcmus.am.dao.LoaiNguoiDungDao;
import hcmus.am.dao.NguoiDungDao;

import org.junit.Test;

public class select {

	@Test
	public void testSelectNguoiDungCuaNhom() {
		NguoiDungEntity ent = NguoiDungDao.selectById(2);
		assertTrue(ent != null && ent.IdNguoiDung == 2);
		
	}

}
