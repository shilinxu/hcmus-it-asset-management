package Test.ChiTietNhomNguoiDungDao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import hcmus.am.client.entity.ChiTietNhomNguoiDungEntity;
import hcmus.am.dao.ChiTietNhomNguoiDungDao;

import org.junit.Test;

public class delete {

	@Test
	public void testSelectNguoiDungCuaNhom() {
		ChiTietNhomNguoiDungEntity ent = new ChiTietNhomNguoiDungEntity();
		ent.IdNguoiDung = 3;
		ent.IdNhomNguoiDung = 1;
		int rs = ChiTietNhomNguoiDungDao.delete(ent);
		assertTrue(rs == 1);
	}

}
