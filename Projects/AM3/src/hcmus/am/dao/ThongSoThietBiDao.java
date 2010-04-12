package hcmus.am.dao;

import hcmus.am.client.entity.LoaiNguoiDungEntity;
import hcmus.am.client.entity.ThongSoThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ThongSoThietBiDao {
	public static LoaiNguoiDungEntity selectById(Integer Id ) {
		return null;
	}
	
	public static Integer update(ThongSoThietBiEntity ent ) {
		return 0;
	}
	
	public static Integer delete(ThongSoThietBiEntity ent ) {
		return 0;
	}
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
		String  sql = "insert into THONG_SO_THIET_BI(IdThongSoLoaiThietBi, IdTheHienThietBi, GiaTri) values(?,?,?)";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ent.IdThongSoLoaiThietBi);
			stmt.setInt(2, ent.IdTheHienThietBi);
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
