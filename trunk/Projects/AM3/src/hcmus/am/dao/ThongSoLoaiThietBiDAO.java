package hcmus.am.dao;

import hcmus.am.client.entity.ThongSoLoaiThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ThongSoLoaiThietBiDAO {
	public static ThongSoLoaiThietBiEntity selectById(Integer Id ) {
		ThongSoLoaiThietBiEntity ent = null;
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdThongSoLoaiThietBi, IdLoaiThietBi,	Ten, YNghia, SuDungDeKiemTraThietBi " +
						"from THONG_SO_LOAI_THIET_BI " +
						"where IdThongSoLoaiThietBi = " + Id.toString();
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			if (rs.next()) {
				ent = new ThongSoLoaiThietBiEntity();				
				ent.IdThongSoLoaiThietBi = rs.getInt("IdThongSoLoaiThietBi");
				ent.IdLoaiThietBi = rs.getInt("IdLoaiThietBi");
				ent.Ten = rs.getString("Ten");
				ent.YNghia = rs.getString("YNghia");
				ent.SuDungDeKiemTraThietBi = rs.getBoolean("SuDungDeKiemTraThietBi");
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
	
	public static Integer insert(ThongSoLoaiThietBiEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "insert into THONG_SO_LOAI_THIET_BI(IdLoaiThietBi,	Ten, YNghia, SuDungDeKiemTraThietBi ) " +
				"values (?,?,?,?)";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ent.IdLoaiThietBi);
			stmt.setString(2, ent.Ten);
			stmt.setString(3, ent.YNghia);
			stmt.setBoolean(4, ent.SuDungDeKiemTraThietBi);
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
	}
	
	public static Integer update(ThongSoLoaiThietBiEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "update THONG_SO_LOAI_THIET_BI " +
				"set IdLoaiThietBi = ?,	Ten = ?, YNghia = ?, SuDungDeKiemTraThietBi = ? " +
				"where IdThongSoLoaiThietBi = ?";		
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ent.IdLoaiThietBi);
			stmt.setString(2, ent.Ten);
			stmt.setString(3, ent.YNghia);
			stmt.setBoolean(4, ent.SuDungDeKiemTraThietBi);
			stmt.setInt(5, ent.IdThongSoLoaiThietBi);
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;	
	}
	
	public static Integer delete(ThongSoLoaiThietBiEntity ent ) {
		Connection conn = null;
		Statement stmt = null;		
		int rs = 0;
		String  sql = "delete THONG_SO_LOAI_THIET_BI where IdThongSoLoaiThietBi = " + ent.IdThongSoLoaiThietBi;
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
	public static ArrayList<ThongSoLoaiThietBiEntity> selectAllThongSoOfThietBi(Integer IdLoaiThietBi) {
		ArrayList<ThongSoLoaiThietBiEntity> lst = new ArrayList<ThongSoLoaiThietBiEntity>();
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdThongSoLoaiThietBi, IdLoaiThietBi,	Ten, YNghia, SuDungDeKiemTraThietBi " +
						"from THONG_SO_LOAI_THIET_BI " +
						"where IdLoaiThietBi = " + IdLoaiThietBi.toString();
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			while (rs.next()) {
				ThongSoLoaiThietBiEntity ent = new ThongSoLoaiThietBiEntity();				
				ent.IdThongSoLoaiThietBi = rs.getInt("IdThongSoLoaiThietBi");
				ent.IdLoaiThietBi = rs.getInt("IdLoaiThietBi");
				ent.Ten = rs.getString("Ten");
				ent.YNghia = rs.getString("YNghia");
				ent.SuDungDeKiemTraThietBi = rs.getBoolean("SuDungDeKiemTraThietBi");
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
	public static ThongSoLoaiThietBiEntity selectByName(Integer IdLoaiThietBi, String thongso) {
		ThongSoLoaiThietBiEntity ent = null;
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = 	"select IdThongSoLoaiThietBi, IdLoaiThietBi, Ten, YNghia, SuDungDeKiemTraThietBi from " +
						"THONG_SO_LOAI_THIET_BI " +
						"where IdLoaiThietBi = " + IdLoaiThietBi.toString() +" and Ten = '" + thongso + "'";
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			if (rs.next()) {
				ent = new ThongSoLoaiThietBiEntity();
				
//				[IdThongSoLoaiThietBi] [bigint] IDENTITY(1,1) NOT NULL,
				ent.IdThongSoLoaiThietBi= rs.getInt("IdThongSoLoaiThietBi");
				
//				[IdLoaiThietBi] [bigint] NOT NULL,
				ent.IdLoaiThietBi= rs.getInt("IdLoaiThietBi");
				
//				[Ten] [nvarchar](50) NOT NULL,
				ent.Ten= rs.getString("Ten");
				
//				[YNghia] [nvarchar](max) NULL,
				ent.YNghia= rs.getString("YNghia");
				
//				[SuDungDeKiemTraThietBi] [bit] NULL,
				ent.SuDungDeKiemTraThietBi= rs.getBoolean("SuDungDeKiemTraThietBi");
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
	/***
	 * 
	 * @return
	 * 	-1: if fail.
	 *   0: if successful.
	 */
	public static int SelectIdThongSoMACAdress() {
		int id = -1;
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = 	"select IdThongSoLoaiThietBi from Thong_SO_LOAI_THIET_BI where name = 'MAC'";
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			if (rs.next()) {
				id = rs.getInt("IdThongSoLoaiThietBi");
			}			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception e) { }
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return id;
	}
}
