package hcmus.am.client.view;

import java.io.Serializable;
import java.util.ArrayList;

import hcmus.am.client.entity.ThietBiEntity;

import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class ThietBiRecord extends ListGridRecord  implements Serializable{
	public ThietBiRecord() {

	}
	public ThietBiRecord(ThietBiEntity ent) {
		setAttribute("IdLoaiThietBi", ent.IdLoaiThietBi);
		setAttribute("IdThietBi", ent.IdThietBi);		
		setAttribute("name", ent.IdThietBi.toString());
		setAttribute("picture", ent.IdThietBi.toString());
		setAttribute("price", ent.IdLoaiThietBi.toString());
		//	DetailViewerField nameField2 = new DetailViewerField("name");  
		//DetailViewerField priceField = new DetailViewerField("price");  
	}
	
	public static ThietBiRecord[] getThietBiRecord(ArrayList<ThietBiEntity> lst) {
		ThietBiRecord[] lstRecord = new ThietBiRecord[lst.size()];
		for (int i = 0; i < lst.size(); i++) {
			lstRecord[i] = new ThietBiRecord(lst.get(i));
		}
		return lstRecord;
	}
}
