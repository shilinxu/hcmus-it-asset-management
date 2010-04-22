package hcmus.am.client.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class QuanHeThietBiEntity implements Serializable {
	//[IdTheHienThietBiCha] [bigint] NOT NULL,
	public Integer IdTheHienThietBiCha;
	//[IdTheHienThietBiCon] [bigint] NOT NULL,
	public Integer IdTheHienThietBiCon;
	//[ThoiGian] [datetime] NULL,
	public Timestamp ThoiGian;
}
