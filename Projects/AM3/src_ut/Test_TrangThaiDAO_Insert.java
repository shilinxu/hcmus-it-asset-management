import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.TrangThaiEntity;
import hcmus.am.dao.TrangThaiDao;

import org.junit.Test;


public class Test_TrangThaiDAO_Insert {

	@Test
	public void testInsert() {
		TrangThaiEntity ent = new TrangThaiEntity();
		ent.Ten = "test";
		int rs = TrangThaiDao.insert(ent);
		assertTrue(rs == 1);
	}

}
