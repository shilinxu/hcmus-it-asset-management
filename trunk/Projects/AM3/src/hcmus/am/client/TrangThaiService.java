package hcmus.am.client;

import java.util.ArrayList;

import hcmus.am.client.entity.ChuyenTrangThaiEntity;
import hcmus.am.client.entity.TrangThaiEntity;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("trangthai")
public interface TrangThaiService extends RemoteService {
	TrangThaiEntity select(Integer idTrangThai);
	ArrayList<ChuyenTrangThaiEntity> selectAllChuyenTrangThaiFrom(Integer IDTrangThai1); 
}
