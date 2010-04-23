package hcmus.am.dao;

import hcmus.am.client.entity.ChiTietNhomNguoiDungEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ChiTietNhomNguoiDungDao {
	public static ArrayList<ChiTietNhomNguoiDungEntity> selectNguoiDungCuaNhom(Integer IdNhomNguoiDung ) {
		ArrayList<ChiTietNhomNguoiDungEntity> lst = new ArrayList<ChiTietNhomNguoiDungEntity>();
		
		
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdNguoiDung, IdNhomNguoiDung from CHI_TIET_NHOM_NGUOI_DUNG where IdNhomNguoiDung = " + IdNhomNguoiDung.toString();		
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			while(rs.next()) {
				ChiTietNhomNguoiDungEntity ent = new ChiTietNhomNguoiDungEntity();
			
				ent.IdNguoiDung = rs.getInt("IdNguoiDung");
				ent.IdNhomNguoiDung = rs.getInt("IdNhomNguoiDung");
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
	
	public static Integer insert(ChiTietNhomNguoiDungEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "insert into CHI_TIET_NHOM_NGUOI_DUNG(IdNguoiDung, IdNhomNguoiDung ) values(?,?)";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ent.IdNguoiDung);
			stmt.setInt(2, ent.IdNhomNguoiDung);
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
	 * Khong can thiet phai implement thang nay.
	 * @param ent
	 * @return
	 */
	public static Integer update(ChiTietNhomNguoiDungEntity ent ) {
		return 0;
	}
	
	public static Integer delete(ChiTietNhomNguoiDungEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "delete CHI_TIET_NHOM_NGUOI_DUNG where IdNhomNguoiDung = ? and IdNguoiDung = ?";
		
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);		
			stmt.setInt(1, ent.IdNhomNguoiDung);
			stmt.setInt(2, ent.IdNguoiDung);
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
