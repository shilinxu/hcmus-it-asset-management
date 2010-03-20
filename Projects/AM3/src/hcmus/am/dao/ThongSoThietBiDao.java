package hcmus.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import hcmus.am.client.entity.ThongSoThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

public class ThongSoThietBiDao {
	/**
	 * 
	 * @param ent
	 * @return if successful, return 1, otherwise, return 0.
	 * 		  
	 */
	public static Integer insert(ThongSoThietBiEntity ent) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;		
		String  sql = "insert into THONG_SO_THIET_BI values(?,?,?)";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ent.IdThongSoLoaiThietBi);
			stmt.setInt(2, ent.IdThietBi);
			stmt.setString(3, ent.GiaTri);
			result = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return result;
	}
}
