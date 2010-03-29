package hcmus.am.client.entity;

import java.io.Serializable;

public class ThongSoLoaiThietBiEntity  implements Serializable {
//	[IdThongSoLoaiThietBi] [bigint] IDENTITY(1,1) NOT NULL,
	public Integer IdThongSoLoaiThietBi;
//	[IdLoaiThietBi] [bigint] NOT NULL,
	public Integer IdLoaiThietBi;
//	[Name] [nvarchar](50) NOT NULL,
	public String Name;
//	[Meaning] [nvarchar](max) NULL,
	public String Meaning;
//	[beUsedForChecking] [bit] NULL CONSTRAINT [DF_THONG_SO_LOAI_THIET_BI_beUsedForChecking]  DEFAULT ((0)),
	public boolean beUsedForChecking;
	
	public ThongSoLoaiThietBiEntity() {
		IdThongSoLoaiThietBi = null;
		IdLoaiThietBi = null;
	}
}
