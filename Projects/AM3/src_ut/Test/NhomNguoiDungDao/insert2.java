package Test.NhomNguoiDungDao;

import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.NguoiDungEntity;
import hcmus.am.client.entity.NhomNguoiDungEntity;
import hcmus.am.dao.NguoiDungDao;
import hcmus.am.dao.NhomNguoiDungDao;

import org.junit.Test;

public class insert2 {

	@Test
	public void testSelectNguoiDungCuaNhom() {
		NhomNguoiDungEntity ent  =  new NhomNguoiDungEntity();
		ent.Ten = "Nhom quan ly Giang duong 2";
		ent.MoTa = "xxx ";
		ent.HinhAnh = "12.jpng";
		
		int rs  = NhomNguoiDungDao.insert(ent);
		assertTrue(rs  == 1);
		
	}

}
