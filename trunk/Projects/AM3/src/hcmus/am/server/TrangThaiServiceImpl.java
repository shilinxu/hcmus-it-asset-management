package hcmus.am.server;


import java.util.ArrayList;

import hcmus.am.client.entity.ChuyenTrangThaiEntity;
import hcmus.am.client.entity.TrangThaiEntity;
import hcmus.am.client.TrangThaiService;
import hcmus.am.dao.ChuyenTrangThaiDAO;
import hcmus.am.dao.TrangThaiDao;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class TrangThaiServiceImpl  extends RemoteServiceServlet implements TrangThaiService
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public TrangThaiEntity select(Integer idTrangThai) {
		// TODO Auto-generated method stub
		return TrangThaiDao.selectById(idTrangThai);
	}

	@Override
	public ArrayList<ChuyenTrangThaiEntity> selectAllChuyenTrangThaiFrom(
			Integer IDTrangThai1) {
		return ChuyenTrangThaiDAO.selectAllChuyenTrangThaiFrom(IDTrangThai1);	
	}

}
