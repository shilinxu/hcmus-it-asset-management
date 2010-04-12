package hcmus.am.dao;

import hcmus.am.client.entity.TheHienThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TheHienThietBiDao {
	public static Integer update(TheHienThietBiEntity ent ) {
		return 0;
	}
	
	public static Integer delete(TheHienThietBiEntity ent ) {
		return 0;
	}
	public static Integer insert(TheHienThietBiEntity ent) {
		Connection conn = null;
		CallableStatement stmt = null;		
		int ID = -1; // id of ThietBi.
		ResultSet resultSet = null;
		String  sql = "insert into THE_HIEN_THIET_BI(IdThietBi, IdTrangThai, LaTheHienCapNhatTuClient) values (?, ?, ?);select @@IDENTITY  as ID;";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareCall(sql);
			stmt.setInt(1, ent.IdThietBi);
			if (ent.IdTrangThai == null) 
				stmt.setNull(2, java.sql.Types.NUMERIC); 
			else
				stmt.setInt(2, ent.IdTrangThai);
			
			if (ent.LaTheHienCapNhatTuClient == null) 
				stmt.setNull(3, java.sql.Types.BIT);
			else
				stmt.setBoolean(3, ent.LaTheHienCapNhatTuClient);

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
	public static TheHienThietBiEntity selectById(Integer id) {
		TheHienThietBiEntity  ent = null;
		Connection conn = null;
		PreparedStatement stmt = null;		
		ResultSet rs = null;					
		String  sql = "select * from THE_HIEN_THIET_BI where idTheHienThietBi = ?";				
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();			
			if (rs.next()) {
				ent = new TheHienThietBiEntity();
//				[IdThietBi] [bigint] IDENTITY(1,1) NOT NULL,
				ent.IdTheHienThietBi= rs.getInt("IdTheHienThietBi");
				
//				[IdLoaiThietBi] [bigint] NOT NULL,
				ent.IdThietBi= rs.getInt("IdThietBi");
				
//				[IdNhomThietBi] [bigint] NULL,
				ent.IdTrangThai = rs.getInt("IdTrangThai");
				
//				[IdPhanCong] [bigint] NULL,
				ent.LaTheHienCapNhatTuClient = rs.getBoolean("LaTheHienCapNhatTuClient");
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
