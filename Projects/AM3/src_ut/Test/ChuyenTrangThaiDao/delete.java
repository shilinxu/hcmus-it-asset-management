package Test.ChuyenTrangThaiDao;
import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.ChuyenTrangThaiEntity;
import hcmus.am.dao.ChuyenTrangThaiDAO;

import org.junit.Test;


public class delete {

	@Test
	public void testSelectAllChuyenTrangThaiFrom() {
		/*ArrayList<ChuyenTrangThaiEntity> lst = ChuyenTrangThaiDAO.selectAllChuyenTrangThaiFrom(1);
		assertFalse(lst.size() != 2);*/
		ChuyenTrangThaiEntity ent = new ChuyenTrangThaiEntity();
		ent = ChuyenTrangThaiDAO.selectById(31);
		
	
		
		assertTrue(1 == ChuyenTrangThaiDAO.delete(ent));
		
	}
	

}
