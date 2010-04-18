package hcmus.am.dao;

import hcmus.am.client.entity.LoaiNguoiDungEntity;
import hcmus.am.client.entity.LoaiThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoaiThietBiDao {
	public static LoaiNguoiDungEntity selectById(Integer Id ) {
		return null;
	}
	
	public static Integer insert(LoaiThietBiEntity ent ) {
		return 0;
	}
	
	public static Integer update(LoaiThietBiEntity ent ) {
		return 0;
	}
	
	public static Integer delete(LoaiThietBiEntity ent ) {
		return 0;
	}
	public static LoaiThietBiEntity selectByName(String Name) {		
		LoaiThietBiEntity ent = null;
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdLoaiThietBi, Ten, MoTa, HinhAnh from LOAI_THIET_BI where LOWER(Ten) ='" + Name.toLowerCase() + "'";
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			if (rs.next()) {
				ent = new LoaiThietBiEntity();
				ent.IdLoaiThietBi = rs.getInt("IdLoaiThietBi");
				ent.Ten = rs.getString("Ten");
				ent.MoTa = rs.getString("MoTa");
				ent.HinhAnh = rs.getString("HinhAnh");
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception e) { }
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return ent;		
	}
}
