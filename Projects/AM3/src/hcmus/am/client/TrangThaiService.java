package hcmus.am.client;

import hcmus.am.client.entity.TrangThaiEntity;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("trangthai")
public interface TrangThaiService extends RemoteService {
	TrangThaiEntity select(Integer idTrangThai);
}
