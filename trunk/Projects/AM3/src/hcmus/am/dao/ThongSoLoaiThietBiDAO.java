package hcmus.am.dao;

import hcmus.am.client.entity.LoaiNguoiDungEntity;
import hcmus.am.client.entity.ThongSoLoaiThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ThongSoLoaiThietBiDAO {
	public static LoaiNguoiDungEntity selectById(Integer Id ) {
		return null;
	}
	
	public static Integer insert(ThongSoLoaiThietBiEntity ent ) {
		return 0;
	}
	
	public static Integer update(ThongSoLoaiThietBiEntity ent ) {
		return 0;
	}
	
	public static Integer delete(ThongSoLoaiThietBiEntity ent ) {
		return 0;
	}
	public static ArrayList<ThongSoLoaiThietBiEntity> selectAllThongSoOfThietBi(Integer IdLoaiThietBi) {
		return null;
	
	}
	public static ThongSoLoaiThietBiEntity selectByName(Integer IdLoaiThietBi, String thongso) {
		ThongSoLoaiThietBiEntity ent = null;
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = 	"select IdThongSoLoaiThietBi, IdLoaiThietBi, Name, Meaning, beUsedForChecking from " +
						"THONG_SO_LOAI_THIET_BI " +
						"where IdLoaiThietBi = " + IdLoaiThietBi.toString() +" and Name = '" + thongso + "'";
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
				ent.IdThongSoLoaiThietBi= rs.getInt("IdThongSoLoaiThietBi");
				
//				[YNghia] [nvarchar](max) NULL,
				ent.Ten= rs.getString("Ten");
				
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
