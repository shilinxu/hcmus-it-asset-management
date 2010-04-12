package hcmus.am.client.entity;

public class NhomThietBiEntity {
//	[IdNhomThietBi] [bigint] IDENTITY(1,1) NOT NULL,
	public Integer IdNhomThietBi;
	
//	[Ten] [nvarchar](max) NOT NULL,
	public String Ten ;
	
//	[Mota] [nvarchar](max) NULL,
	public String MoTa ;
	
//	[HinhAnh] [nvarchar](max) NULL,
	public String HinhAnh ;
	
//	[LaPhongMay] [bit] NULL,
	public Boolean LaPhongMay;
	
//	[IdNhomThietBiCha] [bigint] NULL,
	public Integer IdNhomThietBiCha;
	
//	[IdPhanCong] [bigint] NULL,
	public Integer IdPhanCong;
}
