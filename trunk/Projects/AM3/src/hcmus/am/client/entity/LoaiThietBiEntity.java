package hcmus.am.client.entity;

import java.io.Serializable;

public class LoaiThietBiEntity  implements Serializable {
//	[IdLoaiThietBi] [bigint] IDENTITY(1,1) NOT NULL,
	public Integer IdLoaiThietBi;
//	[Ten] [nvarchar](50) NOT NULL,
	public String Ten;
//	[MoTa] [nvarchar](max) NULL,
	public String MoTa;
}
