package Test.NhomThietBiDao;
import hcmus.am.client.entity.TheHienThietBiEntity;
import hcmus.am.client.entity.ThongSoThietBiEntity;
import hcmus.am.client.view.ThietBiView;
import hcmus.am.client.view.ThongSoThietBiView;
import hcmus.am.dao.TheHienThietBiDao;
import hcmus.am.dao.ThietBiDao;
import hcmus.am.dao.ThongSoLoaiThietBiDAO;
import hcmus.am.dao.ThongSoThietBiDao;
import hcmus.am.dao.TrangThaiDao;

import java.util.ArrayList;

import org.junit.Test;


public class ThietBIServiceImpl {

	@Test
	public void testSelectRoots() {
	
			//ArrayList<ThietBiEntity> lst = ThietBiDao.//
			ArrayList<TheHienThietBiEntity> lst= TheHienThietBiDao.selectTheHienThietBiMoiNhatCuaNhomThietBi(2);
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

	}

}
