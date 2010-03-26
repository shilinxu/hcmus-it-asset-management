package hcmus.am.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import hcmus.am.client.entity.LoaiThietBiEntity;
import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.utils.ConnectionUtil;

public class ThietBiDao {
	/**
	 * insert a ThietBi into DB.
	 * @param ent
	 * @return if insert successful return Id of ThietBi, else return -1;
	 */
	public static Integer Insert(ThietBiEntity ent) {
		Connection conn = null;
		CallableStatement stmt = null;		
		int ID = -1; // id of ThietBi.
		ResultSet resultSet = null;
		String  sql = "insert into THIET_BI(IdLoaiThietBi, Name, Caption, Description, Manufacturer, Price) values(?, ?, ?, ?, ?, ?);select @@IDENTITY  as ID;";
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareCall(sql);
			stmt.setInt(1, ent.IdLoaiThietBi);
			stmt.setString(2, ent.Name);
			stmt.setString(3, ent.Caption);
			stmt.setString(4, ent.Description);			
			stmt.setString(5, ent.Manufacturer);
			stmt.setInt(6, ent.Price);
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
	/***
	 * 
	 * @param tbCha
	 * @param tbCon
	 * @return successful: return 1
	 * 			fail: return 0
	 */
	public static Integer SetQuanHeThietBi(ThietBiEntity tbCha, ThietBiEntity tbCon) {
		int result = 0;
		Connection conn = null;
		String sql = "update  Thiet_Bi set IdThietBiCha = ? where idThietBi = ?";
		PreparedStatement stmt = null;		
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tbCon.IdThietBi);
			stmt.setInt(2, tbCha.IdThietBi);
			result = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}
		return result;
	}
	/***
	 * 
	 * @param thietbi
	 * @param thehienThietBi
	 * @return successful: return 1
	 * 			fail: return 0
	 */
	public static Integer SetThietBiGoc(ThietBiEntity thietbi, ThietBiEntity ThietBiGoc) {
		int result = 0;
		Connection conn = null;
		String sql = "update  Thiet_Bi set IdThietBiGoc = ? where idThietBi = ?";
		PreparedStatement stmt = null;		
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ThietBiGoc.IdThietBi);
			stmt.setInt(2, thietbi.IdThietBi);
			result = stmt.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {			
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}
		return result;
	}
	
	/***
	 * 
	 * @param ent
	 * @return
	 * fail: return 0
	 * successful: return #0
	 */
	public static Integer GetIdDesktopByMACAddress(String macAddress) {
		Integer idDesktop = 0;
		Connection conn = null;
		PreparedStatement stmt = null;		
		ResultSet rs = null;
					
		String  sqlIdDesktop = "select TB.IdThietBiCha as IdDesktop " +
				"from THIET_BI AS TB, THONG_SO_THIET_BI TSTB " +
				"where TSTB.IdThongSoLoaiThietBi = ? and GiaTri = ? " +
				"and TB.IdThietBi = TSTB.IdThietBi ";
		//get id of Thong So MAC address
		int idTSMAC = ThongSoLoaiThietBiDAO.SelectIdThongSoMACAdress();		
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sqlIdDesktop);
			stmt.setInt(1, idTSMAC);
			stmt.setString(2, macAddress);
			rs = stmt.executeQuery();			
			if (rs.next()) {
				idDesktop = rs.getInt("IdDesktop");			
			}			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception e) { }
			if (stmt != null) try { stmt.close(); } catch (Exception e) { }
			if (conn != null) try { conn.close(); } catch (Exception e) { }
		}		
		return idDesktop;		
	}
	
	public static ThietBiEntity Select(Integer id) {
		ThietBiEntity  ent = new ThietBiEntity();
		Connection conn = null;
		PreparedStatement stmt = null;		
		ResultSet rs = null;					
		String  sql = "select * from THIET_BI where idThietBi = ?";				
		try {			
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();			
			if (rs.next()) {
				ent = new ThietBiEntity();
//				public Integer IdThietBi;
				ent.IdThietBi = rs.getInt("IdThietBi");

////			[IdLoaiThietBi] [bigint] NOT NULL,
				ent.IdLoaiThietBi = rs.getInt("IdLoaiThietBi");
				
////			[Name] [nvarchar](max) NULL,
				ent.Name = rs.getString("Name");
				
////			[Caption] [nvarchar](max) NULL,
				ent.Caption = rs.getString("Caption");
				
////			[Description] [nvarchar](max) NULL,
				ent.Description = rs.getString("Description");
				
////			[Manufacturer] [nvarchar](max) NULL,
				ent.Manufacturer = rs.getString("Manufacturer");
				
////			[Price] [int] NULL,
				ent.Price = rs.getInt("Price");
				
//				[IdThietBiCha] [bigint] NULL,
				ent.IdThietBiCha = rs.getInt("IdThietBiCha");
				
//				[IdTheHienThietBiMoiNhat] [bigint] NULL,
				ent.IdThietBiGoc = rs.getInt("IdThietBiGoc");
				
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
	public static Integer Update(ThietBiEntity ent) {
		//TODO: implements it.
		return 0;
	}
	public static Integer Delete(ThietBiEntity ent) {
		//TODO: implements it.
		return 0;
	}
}
