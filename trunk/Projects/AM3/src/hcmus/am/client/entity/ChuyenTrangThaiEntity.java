package hcmus.am.client.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ChuyenTrangThaiEntity  implements Serializable {	
//	[IdChuyenTrangThai] [int] IDENTITY(1,1) NOT NULL,
	public Integer IdChuyenTrangThai;
	
//	[TrangThai1] [int] NOT NULL,
	public Integer TrangThai1;
	
//	[TrangThai2] [int] NOT NULL,
	public Integer TrangThai2;
	
//	[ManHinh] [nvarchar](50) NULL,
	public String ManHinh;
	
//	[MoTa] [nvarchar](max) NULL,
	public String Mota;

}
