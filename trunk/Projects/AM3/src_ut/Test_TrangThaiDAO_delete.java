import static org.junit.Assert.*;
import hcmus.am.client.TrangThaiEntity;
import hcmus.am.dao.TrangThaiDao;

import org.junit.Test;


public class Test_TrangThaiDAO_delete {

	@Test
	public void testDelete() {
		TrangThaiEntity ent = new TrangThaiEntity();
		ent.IdTrangThai = 26;
		int rs = TrangThaiDao.delete(ent);
		assert(rs == 1);
		
	}

}
