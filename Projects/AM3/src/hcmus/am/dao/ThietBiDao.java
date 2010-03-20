package hcmus.am.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

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
		String  sql = "insert into THIET_BI values(?, ?, ?, ?, ?, ?);select @@IDENTITY  as ID;";
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
}
