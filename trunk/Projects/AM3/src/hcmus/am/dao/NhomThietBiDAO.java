package hcmus.am.dao;

import hcmus.am.client.entity.LoaiNguoiDungEntity;
import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

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
		String  sql = "select IdNhomThietBi, Ten,Mota,HinhAnh,LaPhongMay,IdPhanCong from NHOM_THIET_BI where IdNhomThietBiCha is null";
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
		String  sql = "select IdNhomThietBi, Ten,Mota,HinhAnh,LaPhongMay,IdPhanCong from NHOM_THIET_BI where IdNhomThietBiCha = " + id.toString();
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
	public static LoaiNguoiDungEntity selectById(Integer Id ) {
		return null;
	}
	
	public static Integer insert(NhomThietBiEntity ent ) {
		return 0;
	}
	
	public static Integer update(NhomThietBiEntity ent ) {
		return 0;
	}
	
	public static Integer delete(NhomThietBiEntity ent ) {
		return 0;
	}
}
