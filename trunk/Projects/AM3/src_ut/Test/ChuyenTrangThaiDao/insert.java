package Test.ChuyenTrangThaiDao;
import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.ChuyenTrangThaiEntity;
import hcmus.am.dao.ChuyenTrangThaiDAO;

import org.junit.Test;


public class insert {

	@Test
	public void testSelectAllChuyenTrangThaiFrom() {
		/*ArrayList<ChuyenTrangThaiEntity> lst = ChuyenTrangThaiDAO.selectAllChuyenTrangThaiFrom(1);
		assertFalse(lst.size() != 2);*/
		ChuyenTrangThaiEntity ent = new ChuyenTrangThaiEntity();
		ent.TrangThai1 = 22;
		ent.TrangThai2 = 23;
		ent.ManHinh = "xyz";
		ent.Mota = "Just test";
		
		assertTrue(1 == ChuyenTrangThaiDAO.insert(ent));
		
	}
	

}
