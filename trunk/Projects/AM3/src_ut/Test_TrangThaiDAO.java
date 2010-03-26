import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.TrangThaiEntity;
import hcmus.am.dao.TrangThaiDao;

import org.junit.Test;


public class Test_TrangThaiDAO {

	//@Test
	public void testSelect() {
		TrangThaiEntity ent = TrangThaiDao.select(0);
		assertTrue (ent == null);
	}
	@Test
	public void testSelect2() {
		TrangThaiEntity ent = TrangThaiDao.select(1);
		assertTrue (ent != null);
	}

}
