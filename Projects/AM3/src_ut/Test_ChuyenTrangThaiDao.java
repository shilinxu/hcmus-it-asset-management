import static org.junit.Assert.*;

import java.util.ArrayList;

import hcmus.am.dao.ChuyenTrangThaiDAO;
import hcmus.am.client.ChuyenTrangThaiEntity;

import org.junit.Test;


public class Test_ChuyenTrangThaiDao {

	@Test
	public void testSelectAllChuyenTrangThaiFrom() {
		ArrayList<ChuyenTrangThaiEntity> lst = ChuyenTrangThaiDAO.selectAllChuyenTrangThaiFrom(1);
		assertFalse(lst.size() != 2);
	}

}
