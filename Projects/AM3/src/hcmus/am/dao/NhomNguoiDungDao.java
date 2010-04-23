package hcmus.am.dao;

import hcmus.am.client.entity.NhomNguoiDungEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class NhomNguoiDungDao {
	public static NhomNguoiDungEntity selectById(Integer Id ) {
		NhomNguoiDungEntity ent = null;
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdNhomNguoiDung, Ten, MoTa, HinhAnh from NHOM_NGUOI_DUNG where IdNhomNguoiDung = " + Id.toString();		
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			if (rs.next()) {
				ent = new NhomNguoiDungEntity();
				ent.IdNhomNguoiDung = rs.getInt("IdNhomNguoiDung");
				ent.Ten = rs.getString("Ten");
				ent.MoTa= rs.getString("MoTa");				
				ent.HinhAnh= rs.getString("HinhAnh");							
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
	
	public static Integer insert(NhomNguoiDungEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "insert into NHOM_NGUOI_DUNG(Ten, MoTa, HinhAnh) values(?,?,?)";
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
	
	public static Integer update(NhomNguoiDungEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "update NHOM_NGUOI_DUNG " +
				"set Ten = ? , MoTa = ? , HinhAnh = ? " +
				"where IdNhomNguoiDung = ?";
			try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ent.Ten);
			stmt.setString(2, ent.MoTa);
			stmt.setString(3, ent.HinhAnh);
			stmt.setInt(4, ent.IdNhomNguoiDung);
					
			rs = stmt.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
	}
	
	public static Integer delete(NhomNguoiDungEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "delete NHOM_NGUOI_DUNG where IdNhomNguoiDung = ?";
		
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);		
			stmt.setInt(1, ent.IdNhomNguoiDung);			
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
