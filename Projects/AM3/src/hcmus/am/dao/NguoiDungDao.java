package hcmus.am.dao;

import hcmus.am.client.entity.NguoiDungEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NguoiDungDao {
	public static NguoiDungEntity selectById(Integer Id ) {
		NguoiDungEntity ent = null;
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdNguoidung, TenDangNhap, TenHienThi, Email, HinhAnh, IdLoaiNguoiDung from NGUOI_DUNG where IdNguoiDung = " + Id.toString();		
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			if (rs.next()) {
				ent = new NguoiDungEntity();
				ent.IdNguoiDung = rs.getInt("IdNguoiDung");
				ent.TenDangNhap = rs.getString("TenDangNhap");
				ent.TenHienThi= rs.getString("TenHienThi");
				ent.Email = rs.getString("Email");
				ent.HinhAnh= rs.getString("HinhAnh");
				ent.IdLoaiNguoiDung = rs.getInt("IdLoaiNguoiDung");				
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
	
	public static Integer insert(NguoiDungEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "insert into NGUOI_DUNG(TenDangNhap,MatKhau, TenHienThi, Email, HinhAnh, IdLoaiNguoiDung) values(?,?,?,?,?,?)";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ent.TenDangNhap);
			stmt.setString(2, ent.MatKhau);			
			stmt.setString(3, ent.TenHienThi);
			stmt.setString(4, ent.Email);
			stmt.setString(5, ent.HinhAnh);
			if (ent.IdLoaiNguoiDung != null)
				stmt.setInt(6, ent.IdLoaiNguoiDung);
			else 
				stmt.setNull(6, java.sql.Types.INTEGER);
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
	}
	
	public static Integer update(NguoiDungEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "update NGUOI_DUNG " +
				"set TenDangNhap = ? , MatKhau = ? ," +
				"TenHienThi = ?,  Email = ?, HinhAnh = ?, IdloaiNguoiDung = ? " +
				"where IdNguoiDung = ?";
			try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ent.TenDangNhap);
			stmt.setString(2, ent.MatKhau);
			stmt.setString(3, ent.TenHienThi);
			stmt.setString(4, ent.Email);
			stmt.setString(5, ent.HinhAnh);
			if (ent.IdLoaiNguoiDung != null)
				stmt.setInt(6, ent.IdLoaiNguoiDung);
			else 
				stmt.setNull(6, java.sql.Types.INTEGER);
			stmt.setInt(7, ent.IdNguoiDung);		
			rs = stmt.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
	}
	
	public static Integer delete(NguoiDungEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "delete NGUOI_DUNG where IdNguoiDung = ?";
		
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);		
			stmt.setInt(1, ent.IdNguoiDung);			
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
	}
	@Deprecated
	public static ArrayList<NguoiDungEntity> selectNguoiDungThuocLoaiNguoiDung(Integer IdLoaiNguoiDung ) {
		ArrayList<NguoiDungEntity> lst = new ArrayList<NguoiDungEntity>();
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdNguoidung, TenDangNhap, TenHienThi, Email, HinhAnh, IdLoaiNguoiDung from NGUOI_DUNG " +
				"where IdLoaiNguoiDung = " + IdLoaiNguoiDung.toString();		
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			while (rs.next()) {
				NguoiDungEntity ent = new NguoiDungEntity();
				ent.IdNguoiDung = rs.getInt("IdNguoiDung");
				ent.TenDangNhap = rs.getString("TenDangNhap");
				ent.TenHienThi= rs.getString("TenHienThi");
				ent.Email = rs.getString("Email");
				ent.HinhAnh= rs.getString("HinhAnh");
				ent.IdLoaiNguoiDung = rs.getInt("IdLoaiNguoiDung");
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

