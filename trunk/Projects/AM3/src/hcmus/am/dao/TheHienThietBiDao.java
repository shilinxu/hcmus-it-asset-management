package hcmus.am.dao;

import hcmus.am.client.entity.TheHienThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
		String  sql = "insert into THE_HIEN_THIET_BI(IdThietBi,IdTrangThai,LaTheHienCapNhatTuClient,IdNhomThietBi,IdNguoiDung,IdNhomNguoiDung,LaTheHienHienTai) values (?, ?, ?, ?, ?, ?,?);select @@IDENTITY  as ID;";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareCall(sql);
			//1
			if (ent.IdThietBi == null) 
				stmt.setNull(1, java.sql.Types.NUMERIC); 
			else
				stmt.setInt(1, ent.IdThietBi);
						
			if (ent.IdTrangThai == null) 
				stmt.setNull(2, java.sql.Types.NUMERIC); 
			else
				stmt.setInt(2, ent.IdTrangThai);
			
			if (ent.LaTheHienCapNhatTuClient == null) 
				stmt.setNull(3, java.sql.Types.BIT);
			else
				stmt.setBoolean(3, ent.LaTheHienCapNhatTuClient);

			if (ent.IdNhomThietBi == null) 
				stmt.setNull(4, java.sql.Types.NUMERIC); 
			else
				stmt.setInt(4, ent.IdNhomThietBi);
			
			if (ent.IdNguoiDung == null) 
				stmt.setNull(5, java.sql.Types.NUMERIC); 
			else
				stmt.setInt(5, ent.IdNguoiDung);
			
			if (ent.IdNhomNguoiDung == null) 
				stmt.setNull(6, java.sql.Types.NUMERIC); 
			else
				stmt.setInt(6, ent.IdNhomNguoiDung);
			
			if (ent.LaTheHienHienTai == null) 
				stmt.setNull(7, java.sql.Types.BIT); 
			else
				stmt.setInt(7, ent.LaTheHienHienTai);
			
			
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

				ent.IdTheHienThietBi= rs.getInt("IdTheHienThietBi");

				ent.IdThietBi= rs.getInt("IdThietBi");
				

				ent.IdTrangThai = rs.getInt("IdTrangThai");
				
				ent.LaTheHienHienTai = rs.getInt("LaTheHienHienTai");

				ent.LaTheHienCapNhatTuClient = rs.getBoolean("LaTheHienCapNhatTuClient");
				
				ent.IdNhomThietBi = rs.getInt("IdNhomThietBi");
				
				ent.IdNguoiDung = rs.getInt("IdNguoiDung");
				
				ent.IdNhomNguoiDung = rs.getInt("IdNhomNguoiDung");
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
	
	public static TheHienThietBiEntity selectTheHienThietBiMoiNhat(Integer idThietBi) {
		TheHienThietBiEntity  ent = null;
		Connection conn = null;
		PreparedStatement stmt = null;		
		ResultSet rs = null;					
/*		String  sql = "select th.IdTheHienThietBi, th.IdThietBi, th.IdTrangThai,th.LaTheHienHienTai, th.LaTheHienCapNhatTuClient, th.IdNhomThietBi, th.IdNguoiDung, th.IdNhomNguoiDung " +
				"from THE_HIEN_THIET_BI th " +
				"where (th.LaTheHienCapNhatTuClient = 'false' " +
				"or th.LaTheHienCapNhatTuClient is null) " +
				"	and  th.IdThietBi = ? " +
				"	and th.IdTheHienThietBi >= all ( " +
				"		select th2.IdTheHienThietBi	" +
				"	from THE_HIEN_THIET_BI th2 " +
				"		where  th2.IdThietBi = ? " +
						" and (th2.LaTheHienCapNhatTuClient = 'false' " +
						"			or th2.LaTheHienCapNhatTuClient is null) " +
						"	)";		*/
		String sql = "select * from THE_HIEN_THIET_BI " +
				"		where LaTheHienHienTai = 'true' " +
				"		and IdThietBi = ? ";
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idThietBi);			
			rs = stmt.executeQuery();			
			if (rs.next()) {
				ent = new TheHienThietBiEntity();

				ent.IdTheHienThietBi= rs.getInt("IdTheHienThietBi");

				ent.IdThietBi= rs.getInt("IdThietBi");
				

				ent.IdTrangThai = rs.getInt("IdTrangThai");
				
				ent.LaTheHienHienTai = rs.getInt("LaTheHienHienTai");

				ent.LaTheHienCapNhatTuClient = rs.getBoolean("LaTheHienCapNhatTuClient");
				
				ent.IdNhomThietBi = rs.getInt("IdNhomThietBi");
				
				ent.IdNguoiDung = rs.getInt("IdNguoiDung");
				
				ent.IdNhomNguoiDung = rs.getInt("IdNhomNguoiDung");
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
	public static ArrayList<TheHienThietBiEntity> selectTheHienThietBiMoiNhatCuaNhomThietBi(Integer idNhomThietBi) {
		ArrayList<TheHienThietBiEntity>  lst = new ArrayList<TheHienThietBiEntity>();
		Connection conn = null;
		PreparedStatement stmt = null;		
		ResultSet rs = null;					
/*		String  sql = "select th.IdTheHienThietBi, th.IdThietBi, th.IdTrangThai,th.LaTheHienHienTai, th.LaTheHienCapNhatTuClient, th.IdNhomThietBi, th.IdNguoiDung, th.IdNhomNguoiDung " +
				"from THE_HIEN_THIET_BI th " +
				"where (th.LaTheHienCapNhatTuClient = 'false' " +
				"or th.LaTheHienCapNhatTuClient is null) " +
				"	and  th.IdThietBi = ? " +
				"	and th.IdTheHienThietBi >= all ( " +
				"		select th2.IdTheHienThietBi	" +
				"	from THE_HIEN_THIET_BI th2 " +
				"		where  th2.IdThietBi = ? " +
						" and (th2.LaTheHienCapNhatTuClient = 'false' " +
						"			or th2.LaTheHienCapNhatTuClient is null) " +
						"	)";		*/
		String sql = "select * from THE_HIEN_THIET_BI " +
				"		where LaTheHienHienTai = 'true' " +
				"		and IdNhomThietBi = ? ";
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idNhomThietBi);			
			rs = stmt.executeQuery();			
			while (rs.next()) {
				TheHienThietBiEntity ent =  new TheHienThietBiEntity();

				ent.IdTheHienThietBi= rs.getInt("IdTheHienThietBi");

				ent.IdThietBi= rs.getInt("IdThietBi");
				

				ent.IdTrangThai = rs.getInt("IdTrangThai");
				
				ent.LaTheHienHienTai = rs.getInt("LaTheHienHienTai");

				ent.LaTheHienCapNhatTuClient = rs.getBoolean("LaTheHienCapNhatTuClient");
				
				ent.IdNhomThietBi = rs.getInt("IdNhomThietBi");
				
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

}
