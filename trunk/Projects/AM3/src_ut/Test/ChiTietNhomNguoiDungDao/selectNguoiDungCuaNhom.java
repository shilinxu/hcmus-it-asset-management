package Test.ChiTietNhomNguoiDungDao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import hcmus.am.client.entity.ChiTietNhomNguoiDungEntity;
import hcmus.am.dao.ChiTietNhomNguoiDungDao;

import org.junit.Test;

public class selectNguoiDungCuaNhom {

	@Test
	public void testSelectNguoiDungCuaNhom() {
		ArrayList<ChiTietNhomNguoiDungEntity> lst = ChiTietNhomNguoiDungDao.selectNguoiDungCuaNhom(1);
		assertTrue(lst != null && lst.get(0).IdNguoiDung == 2 && lst.size() > 0);
	}

}
