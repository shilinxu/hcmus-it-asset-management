package Test.LoaiNguoiDungDao;

import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.ChiTietNhomNguoiDungEntity;
import hcmus.am.client.entity.LoaiNguoiDungEntity;
import hcmus.am.dao.ChiTietNhomNguoiDungDao;
import hcmus.am.dao.LoaiNguoiDungDao;

import org.junit.Test;

public class selectById {

	@Test
	public void testSelectNguoiDungCuaNhom() {
		LoaiNguoiDungEntity ent = LoaiNguoiDungDao.selectById(1);
		assertTrue(ent != null && ent.Ten.equals("BQL Khoa"));
	}

}
