package hcmus.am.client;

import hcmus.am.client.TrangThaiEntity;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TrangThaiServiceAsync {
	void select(Integer idTrangThai, AsyncCallback<TrangThaiEntity> callback);
}
