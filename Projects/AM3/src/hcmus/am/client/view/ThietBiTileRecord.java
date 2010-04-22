package hcmus.am.client.view;

import com.smartgwt.client.widgets.tile.TileRecord;

public class ThietBiTileRecord extends TileRecord {
	public ThietBiTileRecord (ThietBiView view) {
		String name = "unknown";
		for (int i = 0; i < view.lstThongSoThietBiView.length; i++) 
		{
			if (view.lstThongSoThietBiView[i].thongSoLoaiThietBi.Ten.toLowerCase().equals("name"))
			{
				name = view.lstThongSoThietBiView[i].thongSoThietBi.GiaTri;
				break;
			}
		}

		setAttribute("name",name);		
		if (view.loaiThietBi != null)
			setAttribute("picture",view.loaiThietBi.HinhAnh);
		if (view.trangThai != null){
			setAttribute("trangthai",view.trangThai.HinhAnh);
			setAttribute("IdTrangThai",view.trangThai.IdTrangThai);
		}
		String NguoiDung = "Anonymous";
		if (view.nguoiDung != null) 
			NguoiDung = view.nguoiDung.TenDangNhap;
		setAttribute("nguoidung",NguoiDung);
		//setAttribute("nhomnguoidung",view.loaiThietBi.HinhAnh);
		//setAttribute("price", view.lstThongSoThietBiView[], allowPostCreate)
	}
}
