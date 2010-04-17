package hcmus.am.server;


import hcmus.am.client.ThietBiService;
import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.client.view.NhomThietBiTreeNode;
import hcmus.am.dao.NhomThietBiDAO;
import hcmus.am.dao.ThietBiDao;

import java.util.ArrayList;

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
	public ArrayList<NhomThietBiEntity> selectMenuNhomThietBi() {
/*		ArrayList<NhomThietBiEntity> lst = new ArrayList<NhomThietBiEntity>();
		ArrayList<NhomThietBiEntity> root =  NhomThietBiDAO.selectRoots();
		for (int i = 0; i < root.size(); i++) {
			lst.add(root.get(i));
			lst.addAll(NhomThietBiDAO.selectSubNhomThietBi(root.get(i).IdNhomThietBi));			
		}*/
		
		//return lst;
		return NhomThietBiDAO.selectAll();
	}

	@Override
	public NhomThietBiTreeNode[] selectTreeNhomThietBi() {
		
		ArrayList<NhomThietBiEntity> lst = NhomThietBiDAO.selectAll();
		NhomThietBiTreeNode[] rs = new NhomThietBiTreeNode[lst.size()];
		for (int i = 0; i < lst.size(); i++)
			rs[i] = new NhomThietBiTreeNode(lst.get(i));
		return rs;
	}
	
}
