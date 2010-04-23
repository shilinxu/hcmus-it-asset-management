package Test.LoaiNguoiDungDao;

import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.ChiTietNhomNguoiDungEntity;
import hcmus.am.client.entity.LoaiNguoiDungEntity;
import hcmus.am.dao.ChiTietNhomNguoiDungDao;
import hcmus.am.dao.LoaiNguoiDungDao;

import org.junit.Test;

public class update {

	@Test
	public void testSelectNguoiDungCuaNhom() {
		LoaiNguoiDungEntity ent = LoaiNguoiDungDao.selectById(4);
		ent.MoTa = "loai thu 4";
		int rs = LoaiNguoiDungDao.update(ent);
		assertTrue(rs == 1);
		
	}

}
