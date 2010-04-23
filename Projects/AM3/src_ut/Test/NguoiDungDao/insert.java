package Test.NguoiDungDao;

import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.NguoiDungEntity;
import hcmus.am.dao.LoaiNguoiDungDao;
import hcmus.am.dao.NguoiDungDao;

import org.junit.Test;

public class insert {

	@Test
	public void testSelectNguoiDungCuaNhom() {
		NguoiDungEntity ent  =  new NguoiDungEntity();
		ent.TenDangNhap = "123";
		ent.MatKhau = " ";
		ent.HinhAnh = "12.jpng";
		ent.TenHienThi = "diep den";
		ent.IdLoaiNguoiDung = 2;
		ent.Email = "gameloft@gc.o";
		int rs  = NguoiDungDao.insert(ent);
		assertTrue(rs  == 1);
		
	}

}
