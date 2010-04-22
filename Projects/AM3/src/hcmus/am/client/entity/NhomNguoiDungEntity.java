package hcmus.am.client.entity;

import java.io.Serializable;

public class NhomNguoiDungEntity implements Serializable {
//	[IdNhomNguoiDung] [bigint] IDENTITY(1,1) NOT NULL,
	public Integer IdNhomNguoiDung;
//	[Ten] [nvarchar](100) NULL,
	public String Ten;
//	[MoTa] [nvarchar](max) NULL,
	public String MoTa;
//	[HinhAnh] [nvarchar](100) NULL,
	public String HinhAnh;

}
