package Test.TrangThaiDAO;
import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.TrangThaiEntity;
import hcmus.am.dao.TrangThaiDao;

import org.junit.Test;


public class Test_TrangThaiDAO_select {

	//@Test
	public void testSelect() {
		TrangThaiEntity ent = TrangThaiDao.selectById(0);
		assertTrue (ent == null);
	}
	@Test
	public void testSelect2() {
		TrangThaiEntity ent = TrangThaiDao.selectById(1);
		assertTrue (ent.IdTrangThai == 1 && ent.HinhAnh  != null);
	}

}
