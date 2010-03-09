import static org.junit.Assert.*;
import hcmus.am.client.TrangThaiEntity;
import hcmus.am.dao.TrangThaiDao;

import org.junit.Test;


public class Test_TrangThaiDAO_Insert {

	@Test
	public void testInsert() {
		TrangThaiEntity ent = new TrangThaiEntity();
		ent.Ten = "test";
		int rs = TrangThaiDao.insert(ent);
		assert(rs == 1);
	}

}
