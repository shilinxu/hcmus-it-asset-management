package Test.NguoiDungDao;

import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.NguoiDungEntity;
import hcmus.am.dao.LoaiNguoiDungDao;
import hcmus.am.dao.NguoiDungDao;

import org.junit.Test;

public class update {

	@Test
	public void testSelectNguoiDungCuaNhom() {
		NguoiDungEntity ent  =  NguoiDungDao.selectById(6);
		ent.TenDangNhap = "z123";
		ent.MatKhau = "z ";
		ent.HinhAnh = "1d2.jpng";
		ent.TenHienThi = "ddiep den";
		ent.IdLoaiNguoiDung = 1;
		ent.Email = "gameloft@gdc.o";
		int rs  = NguoiDungDao.update(ent);
		assertTrue(rs  == 1);
		
	}

}
