package hcmus.am.client;

import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.client.view.NhomThietBiTreeNode;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ThietBiServiceAsync {
	void SelectN(AsyncCallback<ArrayList<ThietBiEntity>> callback);
	void selectMenuNhomThietBi(AsyncCallback<ArrayList<NhomThietBiEntity>> callback);
	void selectTreeNhomThietBi(AsyncCallback<NhomThietBiTreeNode[]> callback);
}
