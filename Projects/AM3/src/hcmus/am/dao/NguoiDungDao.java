package hcmus.am.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import hcmus.am.client.entity.LoaiNguoiDungEntity;
import hcmus.am.client.entity.NguoiDungEntity;
import hcmus.am.client.entity.TrangThaiEntity;
import hcmus.am.utils.ConnectionUtil;

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
		return 0;
	}
	
	public static Integer update(NguoiDungEntity ent ) {
		return 0;
	}
	
	public static Integer delete(NguoiDungEntity ent ) {
		return 0;
	}
}

