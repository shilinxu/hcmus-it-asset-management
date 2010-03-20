import static org.junit.Assert.*;
import hcmus.am.dao.TrangThaiDao;
import hcmus.am.client.entity.TrangThaiEntity;

import org.junit.Test;


public class Test_TrangThaiDAO {

	//@Test
	public void testSelect() {
		TrangThaiEntity ent = TrangThaiDao.select(0);
		assert (ent == null);
	}
	@Test
	public void testSelect2() {
		TrangThaiEntity ent = TrangThaiDao.select(1);
		assert (ent != null);
	}

}
