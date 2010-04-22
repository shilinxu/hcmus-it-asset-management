package hcmus.am.client.view;


import hcmus.am.client.entity.LoaiNguoiDungEntity;
import hcmus.am.client.entity.LoaiThietBiEntity;
import hcmus.am.client.entity.NguoiDungEntity;
import hcmus.am.client.entity.TheHienThietBiEntity;
import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.client.entity.TrangThaiEntity;

import java.io.Serializable;
import java.util.ArrayList;

public class ThietBiView implements Serializable{
	public ThietBiEntity thietBi;
	public TheHienThietBiEntity theHienMoiNhat;
	public ThongSoThietBiView[] lstThongSoThietBiView;
	public NguoiDungEntity nguoiDung;
	public LoaiNguoiDungEntity loaiNguoiDung;
	public TrangThaiEntity trangThai;
	public LoaiThietBiEntity loaiThietBi;	
	public static ThietBiTileRecord[] getThietBiTileRecord(ThietBiView[] lstView) {
 		ThietBiTileRecord[] rs = new ThietBiTileRecord[lstView.length];
		for (int i = 0; i  < rs.length; i++) {
			rs[i] = new ThietBiTileRecord(lstView[i]);
		}
		return rs;
	}
	
	public static ThietBiTileRecord[] getThietBiTileRecordWithFilter(ThietBiView[] lstView, ArrayList<Integer> lstIdTrangThai) {
		ArrayList<ThietBiTileRecord> rs = new ArrayList<ThietBiTileRecord>();
		
 		//ThietBiTileRecord[] rs = new ThietBiTileRecord[lstView.length];
		for (int i = 0; i  < lstView.length; i++) {
			boolean flag = false;
			for (int j = 0; j < lstIdTrangThai.size(); j++) {
				if (lstIdTrangThai.get(j) == lstView[i].trangThai.IdTrangThai)
					flag = true;
			}
			if (flag) {
				ThietBiTileRecord tb = new ThietBiTileRecord(lstView[i]);
				rs.add(tb);
				
				}
		}
		ThietBiTileRecord[] temp = new ThietBiTileRecord[rs.size()];		
		rs.toArray(temp);
		return temp;
	}

}

