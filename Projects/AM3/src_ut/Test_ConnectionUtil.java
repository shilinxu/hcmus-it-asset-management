import static org.junit.Assert.assertTrue;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;

import org.junit.Test;


public class Test_ConnectionUtil {

	@Test
	public void testGetConnection() {
		Connection conn = ConnectionUtil.getConnection();
		assertTrue(conn != null);
		
	}

}
