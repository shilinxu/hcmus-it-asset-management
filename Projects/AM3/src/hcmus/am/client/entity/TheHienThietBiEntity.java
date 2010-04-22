package hcmus.am.client.entity;

import java.io.Serializable;

public class TheHienThietBiEntity implements Serializable {
//	[IdTheHienThietBi] [bigint] IDENTITY(1,1) NOT NULL,
	public Integer IdTheHienThietBi;
	//	[IdThietBi] [bigint] NOT NULL,
	public Integer IdThietBi;
	//	[IdTrangThai] [int] NULL,
	public Integer IdTrangThai;
//	[LaTheHienCapNhatTuClient] [bit] NULL,
	public Boolean LaTheHienCapNhatTuClient;
	
	//LaTheHienHienTai
	public Integer LaTheHienHienTai;
	//[IdNhomThietBi] [bigint] NULL,
	public Integer IdNhomThietBi;
	//[IdNguoiDung] [bigint] NULL,
	public Integer IdNguoiDung;
	//[IdNhomNguoiDung] [bigint] NULL,
	public Integer IdNhomNguoiDung;
}