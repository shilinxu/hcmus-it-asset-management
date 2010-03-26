package hcmus.am.client.entity;

public class ThietBiEntity {
//	[IdThietBi] [bigint] IDENTITY(1,1) NOT NULL,
	public Integer IdThietBi;
//	[IdLoaiThietBi] [bigint] NOT NULL,
	public Integer IdLoaiThietBi;
//	[Name] [nvarchar](max) NULL,
	public String Name;
//	[Caption] [nvarchar](max) NULL,
	public String Caption;
//	[Description] [nvarchar](max) NULL,
	public String Description;
//	[Manufacturer] [nvarchar](max) NULL,
	public String Manufacturer;
//	[Price] [int] NULL,
	public Integer Price;
//	[IdThietBiCha] [bigint] NULL,
	public Integer IdThietBiCha;
//	[IdThietBiGoc] [bigint] NULL,
	public Integer IdThietBiGoc;
}
