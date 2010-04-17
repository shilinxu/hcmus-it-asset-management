package hcmus.am.client;

import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.client.view.NhomThietBiTreeNode;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("thietbi")
public interface ThietBiService extends RemoteService {
	ArrayList<ThietBiEntity> SelectN();
	ArrayList<NhomThietBiEntity> selectMenuNhomThietBi();
	NhomThietBiTreeNode[] selectTreeNhomThietBi();
}
