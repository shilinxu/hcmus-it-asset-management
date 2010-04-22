package hcmus.am.client;

import java.util.ArrayList;

import hcmus.am.client.entity.ChuyenTrangThaiEntity;
import hcmus.am.client.entity.TrangThaiEntity;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TrangThaiServiceAsync {
	void select(Integer idTrangThai, AsyncCallback<TrangThaiEntity> callback);
	void selectAllChuyenTrangThaiFrom(Integer IDTrangThai1, AsyncCallback<ArrayList<ChuyenTrangThaiEntity>> callback); 
}
