import static org.junit.Assert.*;
import hcmus.am.client.entity.TrangThaiEntity;
import hcmus.am.dao.TrangThaiDao;

import org.junit.Test;


public class Test_TrangThaiDAO_delete {

	@Test
	public void testDelete() {
		TrangThaiEntity ent = new TrangThaiEntity();
		ent.IdTrangThai = 27;
		int rs = TrangThaiDao.delete(ent);
		assertTrue(rs == 1);
		
	}

}
