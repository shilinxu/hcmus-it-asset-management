package hcmus.am.dao;

import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NhomThietBiDAO {
	public static ArrayList<NhomThietBiEntity> selectRoots(){
		ArrayList<NhomThietBiEntity> lst = new ArrayList<NhomThietBiEntity>();
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdNhomThietBi, Ten,Mota,HinhAnh,LaPhongMay,IdNhomThietBiCha, IdPhanCong from NHOM_THIET_BI where IdNhomThietBiCha is null";
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			while (rs.next()) {
				NhomThietBiEntity ent = new NhomThietBiEntity();
				ent.IdNhomThietBi = rs.getInt("IdNhomThietBi");
				ent.Ten = rs.getString("Ten");
				ent.MoTa = rs.getString("Mota");
				ent.HinhAnh = rs.getString("HinhAnh");
				ent.LaPhongMay = rs.getBoolean("LaPhongMay");
				ent.IdNhomThietBiCha = rs.getInt("IdNhomThietBiCha");
				ent.IdPhanCong = rs.getInt("IdPhanCong");
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
	
	public static ArrayList<NhomThietBiEntity> selectSubNhomThietBi(Integer id) {
		ArrayList<NhomThietBiEntity> lst = new ArrayList<NhomThietBiEntity>();
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdNhomThietBi, Ten,Mota,HinhAnh,LaPhongMay,IdNhomThietBiCha, IdPhanCong from NHOM_THIET_BI where IdNhomThietBiCha = " + id.toString();
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			while (rs.next()) {
				NhomThietBiEntity ent = new NhomThietBiEntity();
				ent.IdNhomThietBi = rs.getInt("IdNhomThietBi");
				ent.Ten = rs.getString("Ten");
				ent.MoTa = rs.getString("Mota");
				ent.HinhAnh = rs.getString("HinhAnh");
				ent.LaPhongMay = rs.getBoolean("LaPhongMay");
				ent.IdNhomThietBiCha = rs.getInt("IdNhomThietBiCha");
				ent.IdPhanCong = rs.getInt("IdPhanCong");
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
	public static NhomThietBiEntity selectById(Integer Id ) {
		NhomThietBiEntity ent = null;
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdNhomThietBi, Ten,Mota,HinhAnh,LaPhongMay,IdNhomThietBiCha, IdPhanCong from NHOM_THIET_BI where IdNhomThietBi = " + Id.toString();
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			if (rs.next()) {
				ent = new NhomThietBiEntity();
				ent.IdNhomThietBi = rs.getInt("IdNhomThietBi");
				ent.Ten = rs.getString("Ten");
				ent.MoTa = rs.getString("Mota");
				ent.HinhAnh = rs.getString("HinhAnh");
				ent.LaPhongMay = rs.getBoolean("LaPhongMay");
				ent.IdNhomThietBiCha = rs.getInt("IdNhomThietBiCha");
				ent.IdPhanCong = rs.getInt("IdPhanCong");			
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
	
	public static Integer insert(NhomThietBiEntity ent ) {
		Connection conn = null;
		CallableStatement stmt = null;		
		int ID = -1; // id of ThietBi.
		ResultSet resultSet = null;
		String  sql = "insert into NHOM_THIET_BI(Ten,Mota,HinhAnh,LaPhongMay,IdPhanCong) " +
				"values (?, ?, ?, ?,?); " +
				"select @@IDENTITY  as ID;";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareCall(sql);
			stmt.setString(1, ent.Ten);
			stmt.setString(2, ent.MoTa);
			stmt.setString(3, ent.HinhAnh);
			if (ent.LaPhongMay == null)
				stmt.setNull(4, java.sql.Types.BIT);			
			else
				stmt.setBoolean(4, ent.LaPhongMay);
			if (ent.IdPhanCong == null)
				stmt.setNull(5, java.sql.Types.INTEGER);
			else
				stmt.setInt(5, ent.IdPhanCong);
			
			stmt.execute();	
			int iUpdCount = stmt.getUpdateCount();
			if (iUpdCount != 1) { //if ko insert thanh cong.
				ID = -1;
			} else {				
				stmt.getMoreResults(); //thuc thi lenh tiep theo, select @@IDentity.
				resultSet = stmt.getResultSet();
				if (resultSet.next()) {
					ID = resultSet.getInt("ID");
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (resultSet != null) try { resultSet.close(); } catch (Exception e) { }
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}
		return ID;		
	}
	
	public static Integer update(NhomThietBiEntity ent ) {
		return 0;
	}
	
	public static Integer delete(NhomThietBiEntity ent ) {
		return 0;
	}
	public static ArrayList<NhomThietBiEntity> selectAll() {
		ArrayList<NhomThietBiEntity> lst = new ArrayList<NhomThietBiEntity>();
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdNhomThietBi, Ten,Mota,HinhAnh,LaPhongMay,IdNhomThietBiCha, IdPhanCong from NHOM_THIET_BI";
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				NhomThietBiEntity ent = new NhomThietBiEntity();
				ent.IdNhomThietBi = rs.getInt("IdNhomThietBi");
				ent.Ten = rs.getString("Ten");
				ent.MoTa = rs.getString("Mota");
				ent.HinhAnh = rs.getString("HinhAnh");
				ent.LaPhongMay = rs.getBoolean("LaPhongMay");
				ent.IdNhomThietBiCha = rs.getInt("IdNhomThietBiCha");
				ent.IdPhanCong = rs.getInt("IdPhanCong");
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
