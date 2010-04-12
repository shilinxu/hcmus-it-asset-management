package hcmus.am.client.entity;

public class NguoiDungEntity {
//	[IdNguoiDung] [bigint] IDENTITY(1,1) NOT NULL,
	public Integer IdNguoiDung;
//	[TenDangNhap] [nchar](50) NOT NULL,
	public String TenDangNhap;
//	[MatKhau] [nchar](50) NOT NULL,
	public String MatKhau;
//	[TenHienThi] [nvarchar](50) NULL,/
	public String TenHienThi;
//	[Email] [nvarchar](100) NULL,
	public String Email;
//	[HinhAnh] [nvarchar](100) NULL,
	public String HinhAnh;
//	[IdLoaiNguoiDung] [bigint] NULL,
	public Integer IdLoaiNguoiDung;

}
