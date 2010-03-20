package hcmus.am.server;


import hcmus.am.client.entity.TrangThaiEntity;
import hcmus.am.client.TrangThaiService;
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
		return TrangThaiDao.select(idTrangThai);
	}

}
