package hcmus.am.dao;

import hcmus.am.client.entity.QuanHeThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class QuanHeThietBiDao {
	public static ArrayList<QuanHeThietBiEntity> selectByIdThietBiCha(Integer IdThietBiCha ) {
		ArrayList<QuanHeThietBiEntity> lst = new ArrayList<QuanHeThietBiEntity>();
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdTheHienTHietBiCha, IdTHeHienThietBiCon, ThoiGian " +
				"from QUAN_HE_THIET_BI " +
				"where IdTheHienTHietBiCha = " + IdThietBiCha.toString();
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			while (rs.next()) {
				QuanHeThietBiEntity ent = new QuanHeThietBiEntity();				
				ent.IdTheHienThietBiCha = rs.getInt("IdTheHienThietBiCha");
				ent.IdTheHienThietBiCon = rs.getInt("IdTheHienThietBiCon");
				ent.ThoiGian= rs.getTimestamp("ThoiGian");
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
	
	public static Integer insert(QuanHeThietBiEntity ent ) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		int rs = 0;
		String  sql = "insert into QUAN_HE_THIET_BI(IdTheHienTHietBiCha, IdTHeHienThietBiCon, ThoiGian) " +
				"values (?,?,?)";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ent.IdTheHienThietBiCha);
			stmt.setInt(2, ent.IdTheHienThietBiCon);
			if (ent.ThoiGian == null)
				stmt.setNull(3, java.sql.Types.TIMESTAMP);
			else
				stmt.setTimestamp(3, ent.ThoiGian);
			rs = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return rs;		
	}
	
	public static Integer update(QuanHeThietBiEntity ent ) {
		return 0;
	}
	
	public static Integer delete(QuanHeThietBiEntity ent ) {
		return 0;
	}
}
