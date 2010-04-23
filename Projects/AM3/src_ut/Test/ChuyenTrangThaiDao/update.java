package Test.ChuyenTrangThaiDao;
import static org.junit.Assert.assertTrue;
import hcmus.am.client.entity.ChuyenTrangThaiEntity;
import hcmus.am.dao.ChuyenTrangThaiDAO;

import org.junit.Test;


public class update {

	@Test
	public void testSelectAllChuyenTrangThaiFrom() {
		/*ArrayList<ChuyenTrangThaiEntity> lst = ChuyenTrangThaiDAO.selectAllChuyenTrangThaiFrom(1);
		assertFalse(lst.size() != 2);*/
		ChuyenTrangThaiEntity ent = new ChuyenTrangThaiEntity();
		ent = ChuyenTrangThaiDAO.selectById(31);
		
		ent.TrangThai1 = 23;
		ent.TrangThai2 = 23;
		ent.ManHinh = "xyzz";
		ent.Mota = "Just tes3t";
		
		assertTrue(1 == ChuyenTrangThaiDAO.update(ent));
		
	}
	

}
