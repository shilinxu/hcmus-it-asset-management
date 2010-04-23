package hcmus.am.dao;

import hcmus.am.client.entity.ChuyenTrangThaiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ChuyenTrangThaiDAO {
	@Deprecated
	public static ChuyenTrangThaiEntity selectById(Integer Id ) {
		ChuyenTrangThaiEntity ent  = null;
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		String sql = "Select IdChuyenTrangThai, TrangThai1, TrangThai2, ManHinh, MoTa " +
				"from CHUYEN_TRANG_THAI where IdChuyenTrangThai = " + Id.toString();
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				ent = new ChuyenTrangThaiEntity();
				ent.IdChuyenTrangThai = rs.getInt("IdChuyenTrangThai");
				ent.TrangThai1 = rs.getInt("TrangThai1");
				ent.TrangThai2 = rs.getInt("TrangThai2");
				ent.ManHinh = rs.getString("ManHinh");
				ent.Mota = rs.getString("Mota");
				
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
	
	public static Integer insert(ChuyenTrangThaiEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "insert into CHUYEN_TRANG_THAI(TrangThai1, TrangThai2, ManHinh, MoTa ) values(?,?,?,?)";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ent.TrangThai1);
			stmt.setInt(2, ent.TrangThai2);
			stmt.setString(3, ent.ManHinh);
			stmt.setString(4, ent.Mota);
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;		
	}
	
	public static Integer update(ChuyenTrangThaiEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "update CHUYEN_TRANG_THAI " +
				"set TrangThai1 = ? , TrangThai2 = ?, ManHinh = ?, MoTa = ? " +
				"where IdChuyenTrangThai= ? ";
			try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ent.TrangThai1);
			stmt.setInt(2, ent.TrangThai2);
			stmt.setString(3, ent.ManHinh);
			stmt.setString(4, ent.Mota);
			
			stmt.setInt(5, ent.IdChuyenTrangThai);
			
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
	}
	
	public static Integer delete(ChuyenTrangThaiEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "delete CHUYEN_TRANG_THAI where IdChuyenTrangThai = ?";
		
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);		
			stmt.setInt(1, ent.IdChuyenTrangThai);			
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;		
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
