package hcmus.am.server;


import hcmus.am.client.ThietBiService;
import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.client.entity.TheHienThietBiEntity;
import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.client.entity.ThongSoThietBiEntity;
import hcmus.am.client.view.NhomThietBiTreeNode;
import hcmus.am.client.view.ThietBiView;
import hcmus.am.client.view.ThongSoThietBiView;
import hcmus.am.dao.NhomThietBiDAO;
import hcmus.am.dao.TheHienThietBiDao;
import hcmus.am.dao.ThietBiDao;
import hcmus.am.dao.ThongSoLoaiThietBiDAO;
import hcmus.am.dao.ThongSoThietBiDao;
import hcmus.am.dao.TrangThaiDao;

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

	@Override
	public ThietBiView[] selectThietBiView(Integer IdNhomThietBi) {
		/*//ArrayList<ThietBiEntity> lst = ThietBiDao.//
		ArrayList<TheHienThietBiEntity> lst= TheHienThietBiDao.selectTheHienThietBiMoiNhatCuaNhomThietBi(IdNhomThietBi);
		ThietBiView[] rs = new ThietBiView[lst.size()];
		for (int i = 0 ; i < lst.size(); i++) {
			TheHienThietBiEntity curr = lst.get(i);
			rs[i] = new ThietBiView();
			rs[i].theHienMoiNhat = curr;
			if (curr.IdThietBi != null)
				rs[i].thietBi = ThietBiDao.selectById(curr.IdThietBi);
			ArrayList<ThongSoThietBiEntity> thongsoList = ThongSoThietBiDao.selectThongSoCuaTheHienThietBi(curr.IdTheHienThietBi);
			ThongSoThietBiView[] lstThongSoView = new ThongSoThietBiView[thongsoList.size()];  
			for (int j = 0; j < thongsoList.size(); j++) {
				lstThongSoView[j] = new ThongSoThietBiView();
				lstThongSoView[j].thongSoThietBi = thongsoList.get(j);
				lstThongSoView[j].thongSoLoaiThietBi = ThongSoLoaiThietBiDAO.selectById(thongsoList.get(j).IdThongSoLoaiThietBi);
			}
			rs[i].lstThongSoThietBiView = lstThongSoView;
			if (curr.IdTrangThai != null)
				rs[i].trangThai = TrangThaiDao.selectById(curr.IdTrangThai);
		} 
		
		return rs;*/
		return ThietBiDao.selectThietBiView(IdNhomThietBi);
	}
	
}
