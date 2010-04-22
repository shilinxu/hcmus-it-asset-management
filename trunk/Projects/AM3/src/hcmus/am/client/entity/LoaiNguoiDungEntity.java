package hcmus.am.client.entity;

import java.io.Serializable;

public class LoaiNguoiDungEntity implements Serializable{
	//[IdLoaiNguoiDung] [bigint] IDENTITY(1,1) NOT NULL,
	public Integer IdLoaiNguoiDung;
	//[Ten] [nvarchar](50) NOT NULL,
	public Integer Ten;
	//[MoTa] [nvarchar](max) NULL,
	public Integer MoTa;
 
}
