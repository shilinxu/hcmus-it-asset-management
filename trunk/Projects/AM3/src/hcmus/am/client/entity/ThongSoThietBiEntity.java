package hcmus.am.client.entity;

import java.io.Serializable;

public class ThongSoThietBiEntity  implements Serializable {
//	[IdThongSoThietBi] [bigint] IDENTITY(1,1) NOT NULL,
	public Integer IdThongSoThietBi;
//	[IdThongSoLoaiThietBi] [bigint] NOT NULL,
	public Integer IdThongSoLoaiThietBi;
//	[IdTheHienThietBi] [bigint] NOT NULL,
	public Integer IdTheHienThietBi;
//	[GiaTri] [nvarchar](max) NOT NULL,
	public String GiaTri;	
}
