package hcmus.am.server;


import java.util.ArrayList;

import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.client.entity.TrangThaiEntity;
import hcmus.am.client.ThietBiService;
import hcmus.am.client.TrangThaiService;
import hcmus.am.dao.NhomThietBiDAO;
import hcmus.am.dao.ThietBiDao;
import hcmus.am.dao.TrangThaiDao;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ThietBiServiceImpl  extends RemoteServiceServlet implements ThietBiService
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<ThietBiEntity> SelectN() {		
		return ThietBiDao.SelectN(0, 10);
	}

	@Override
	public ArrayList<NhomThietBiEntity> selectRootMenu() {
		return NhomThietBiDAO.selectRoots();		
	}
	
}
