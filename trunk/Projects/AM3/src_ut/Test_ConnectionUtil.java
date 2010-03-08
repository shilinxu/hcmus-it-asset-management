import static org.junit.Assert.*;

import java.sql.Connection;

import hcmus.am.utils.ConnectionUtil;

import org.junit.Test;


public class Test_ConnectionUtil {

	@Test
	public void testGetConnection() {
		Connection conn = ConnectionUtil.getConnection();
		assert(conn != null);
		
	}

}
