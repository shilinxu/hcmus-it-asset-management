package hcmus.am.dao;

import hcmus.am.client.entity.ThongSoThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ThongSoThietBiDao {
	public static ThongSoThietBiEntity selectById(Integer Id ) {
		ThongSoThietBiEntity ent = null;
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select [IdThongSoThietBi] ,	[IdThongSoLoaiThietBi] ,[IdTheHienThietBi], [GiaTri] " +
				"from THONG_SO_THIET_BI " +
				"where IdThongSoThietBi = " + Id.toString();
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			if (rs.next()) {
				ent = new ThongSoThietBiEntity();				
				ent.IdThongSoThietBi = rs.getInt("IdThongSoThietBi");
				ent.IdThongSoLoaiThietBi = rs.getInt("IdThongSoLoaiThietBi");
				ent.IdTheHienThietBi = rs.getInt("IdTheHienThietBi");
				ent.GiaTri = rs.getString("GiaTri");
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
	
	public static Integer update(ThongSoThietBiEntity ent ) {	
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "update THONG_SO_THIET_BI " +
				"set IdThongSoLoaiThietBi = ? ,IdTheHienThietBi = ?, GiaTri = ? " +
				"where IdThongSoThietBi = ? ";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ent.IdThongSoLoaiThietBi);
			stmt.setInt(2, ent.IdTheHienThietBi);
			stmt.setString(3, ent.GiaTri);
			stmt.setInt(4, ent.IdThongSoThietBi);			
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
	}
	
	public static Integer delete(ThongSoThietBiEntity ent ) {
		Connection conn = null;
		Statement stmt = null;		
		int rs = 0;
		String  sql = "delete THONG_SO_THIET_BI where IdThongSoThietBi = " + ent.IdThongSoThietBi;
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
	public static ArrayList<ThongSoThietBiEntity> selectThongSoCuaTheHienThietBi(Integer IdTheHienThietBi ) {
		ArrayList<ThongSoThietBiEntity> lst = new ArrayList<ThongSoThietBiEntity>();
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select [IdThongSoThietBi] ,	[IdThongSoLoaiThietBi] ,[IdTheHienThietBi], [GiaTri] " +
				"from THONG_SO_THIET_BI " +
				"where IdTheHienThietBi = " + IdTheHienThietBi.toString();
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			while (rs.next()) {
				ThongSoThietBiEntity ent = new ThongSoThietBiEntity();
				ent = new ThongSoThietBiEntity();				
				ent.IdThongSoThietBi = rs.getInt("IdThongSoThietBi");
				ent.IdThongSoLoaiThietBi = rs.getInt("IdThongSoLoaiThietBi");
				ent.IdTheHienThietBi = rs.getInt("IdTheHienThietBi");
				ent.GiaTri = rs.getString("GiaTri");
				lst.add(ent);
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception e) { }
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return lst;		
	}
}
