package hcmus.am.dao;

import hcmus.am.client.entity.ChuyenTrangThaiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ChuyenTrangThaiDAO {
	public static ChuyenTrangThaiEntity selectById(Integer Id ) {
		return null;
	}
	
	public static Integer insert(ChuyenTrangThaiEntity ent ) {
		return 0;
	}
	
	public static Integer update(ChuyenTrangThaiEntity ent ) {
		return 0;
	}
	
	public static Integer delete(ChuyenTrangThaiEntity ent ) {
		return 0;
	}
	public static ArrayList<ChuyenTrangThaiEntity> selectAllChuyenTrangThaiFrom(Integer IDTrangThai1) {
		ArrayList<ChuyenTrangThaiEntity> lst = new ArrayList<ChuyenTrangThaiEntity>();
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		String sql = "Select IdChuyenTrangThai, TrangThai1, TrangThai2, ManHinh, MoTa " +
				"from CHUYEN_TRANG_THAI where TrangThai1 = " + IDTrangThai1.toString();
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ChuyenTrangThaiEntity ent = new ChuyenTrangThaiEntity();
				ent.IdChuyenTrangThai = rs.getInt("IdChuyenTrangThai");
				ent.TrangThai1 = rs.getInt("TrangThai1");
				ent.TrangThai2 = rs.getInt("TrangThai2");
				ent.ManHinh = rs.getString("ManHinh");
				ent.Mota = rs.getString("Mota");
				lst.add(ent);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			if (rs != null) try { rs.close(); } catch (Exception e) { }
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}
		return lst;
	}
}
