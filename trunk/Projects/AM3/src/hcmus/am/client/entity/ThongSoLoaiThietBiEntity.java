package hcmus.am.client.entity;

import java.io.Serializable;

public class ThongSoLoaiThietBiEntity  implements Serializable {
//	[IdThongSoLoaiThietBi] [bigint] IDENTITY(1,1) NOT NULL,
	public Integer IdThongSoLoaiThietBi;
	
//	[IdLoaiThietBi] [bigint] NOT NULL,
	public Integer IdLoaiThietBi;
	
//	[Ten] [nvarchar](50) NOT NULL,
	public String Ten;
	
//	[YNghia] [nvarchar](max) NULL,
	public String YNghia;
	
//	[SuDungDeKiemTraThietBi] [bit] NULL,
	public Boolean SuDungDeKiemTraThietBi;
}
