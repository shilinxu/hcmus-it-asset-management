package hcmus.am.dao;

import hcmus.am.client.entity.LoaiThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoaiThietBiDao {
	public static LoaiThietBiEntity selectById(Integer Id ) {
		LoaiThietBiEntity ent = null;
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdLoaiThietBi, Ten, MoTa, HinhAnh from LOAI_THIET_BI where IdLoaiThietBi = " + Id.toString();
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
	
	public static Integer insert(LoaiThietBiEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "insert into LOAI_THIET_BI(Ten, MoTa, HinhAnh) values(?,?,?)";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ent.Ten);
			stmt.setString(2, ent.MoTa);
			stmt.setString(3, ent.HinhAnh);
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;		
	}
	
	public static Integer update(LoaiThietBiEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "update LOAI_THIET_BI " +
				"set Ten = ? , MoTa = ?, HinhAnh = ? " +
				"where IdLoaiThietBi= ? ";
			try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ent.Ten);
			stmt.setString(2, ent.MoTa);
			stmt.setString(3, ent.HinhAnh);
			stmt.setInt(4, ent.IdLoaiThietBi);			
					
			rs = stmt.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
	}
	
	public static Integer delete(LoaiThietBiEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "delete LOAI_THIET_BI where IdLoaiThietBi = ?";
		
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);		
			stmt.setInt(1, ent.IdLoaiThietBi);			
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
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
