package hcmus.am.dao;

import hcmus.am.client.entity.LoaiNguoiDungEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoaiNguoiDungDao {
	public static LoaiNguoiDungEntity selectById(Integer Id ) {
		LoaiNguoiDungEntity ent  = null;
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		String sql = "select IdLoaiNguoiDung, Ten, MoTa from LOAI_NGUOI_DUNG where IdLoaiNguoiDung = " + Id.toString();
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				ent = new LoaiNguoiDungEntity();
				ent.IdLoaiNguoiDung = rs.getInt("IdLoaiNguoiDung");
				ent.Ten = rs.getString("Ten");
				ent.MoTa = rs.getString("MoTa");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			if (rs != null) try { rs.close(); } catch (Exception e) { }
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}
		return ent;
	}
	
	public static Integer insert(LoaiNguoiDungEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "insert into LOAI_NGUOI_DUNG( Ten, MoTa) values(?,?)";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ent.Ten);
			stmt.setString(2, ent.MoTa);
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;		
	}
	
	public static Integer update(LoaiNguoiDungEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "update LOAI_NGUOI_DUNG " +
				"set Ten = ? , MoTa = ? " +
				"where IdLoaiNguoiDung= ? ";
			try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ent.Ten);
			stmt.setString(2, ent.MoTa);
			stmt.setInt(3, ent.IdLoaiNguoiDung);			
					
			rs = stmt.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
	}
	
	public static Integer delete(LoaiNguoiDungEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "delete LOAI_NGUOI_DUNG where IdLoaiNguoiDung = ?";
		
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);		
			stmt.setInt(1, ent.IdLoaiNguoiDung);			
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
	}
}
