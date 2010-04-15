package hcmus.am.client;

import java.util.ArrayList;

import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.client.entity.ThietBiEntity;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("thietbi")
public interface ThietBiService extends RemoteService {
	ArrayList<ThietBiEntity> SelectN();
	ArrayList<NhomThietBiEntity> selectRootMenu();	
}
