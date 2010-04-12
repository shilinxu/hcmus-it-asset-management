package Test.TrangThaiDAO;
import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.TrangThaiEntity;
import hcmus.am.dao.TrangThaiDao;

import org.junit.Test;


public class Test_TrangThaiDAO_update {

	@Test
	public void test1() {
		TrangThaiEntity ent = new TrangThaiEntity();//
		ent.IdTrangThai = 28;
		ent.Ten = "123";
		int rs = TrangThaiDao.update(ent);
		assertTrue (rs ==1 && ent.Ten.equals("123"));
	}
}
