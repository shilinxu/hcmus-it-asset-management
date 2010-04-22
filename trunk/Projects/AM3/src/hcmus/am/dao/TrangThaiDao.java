package hcmus.am.dao;


import hcmus.am.client.entity.TrangThaiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TrangThaiDao {
	public static Integer update(TrangThaiEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "update Trang_THAI " +
				"set Ten = ? " +
				"where IdTrangThai= ? ";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ent.Ten);
			stmt.setInt(2, ent.IdTrangThai);
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
	}

	/**
	 * select de thi tu co so du lieu.
	 * @param IDDeThi IDDeThi = -1 thi se phat sinh de ngau nhien.
	 * @return
	 */
	public static TrangThaiEntity selectById(Integer IDDeThi){
		TrangThaiEntity ent = null;
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdTrangThai, Ten, HinhAnh from TRANG_THAI where IdTrangThai = " + IDDeThi.toString();
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			if (rs.next()) {
				ent = new TrangThaiEntity();
				ent.IdTrangThai = rs.getInt("IdTrangThai");
				ent.Ten = rs.getString("Ten");
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
	public static int insert(TrangThaiEntity ent){
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "insert into TRANG_THAI(Ten) values(?)";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ent.Ten);
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;		
	}
	public static int delete(TrangThaiEntity ent){		
		Connection conn = null;
		Statement stmt = null;		
		int rs = 0;
		String  sql = "delete TRANG_THAI where idTrangThai = " + ent.IdTrangThai;
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();			
			rs = stmt.executeUpdate(sql);			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;		
	}
}
