package hcmus.am.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import hcmus.am.client.entity.LoaiThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

public class LoaiThietBiDao {
	public static LoaiThietBiEntity selectByName(String Name) {		
		LoaiThietBiEntity ent = null;
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		String  sql = "select IdLoaiThietBi, Ten, MoTa from LOAI_THIET_BI where LOWER(Ten) ='" + Name.toLowerCase() + "'";
		try {
			
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			if (rs.next()) {
				ent = new LoaiThietBiEntity();
				ent.IdLoaiThietBi = rs.getInt("IdLoaiThietBi");
				ent.Ten = rs.getString("Ten");
				ent.MoTa = rs.getString("MoTa");
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
}
