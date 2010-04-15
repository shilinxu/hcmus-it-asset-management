package hcmus.am.client;

import java.util.ArrayList;

import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.client.entity.ThietBiEntity;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ThietBiServiceAsync {
	void SelectN(AsyncCallback<ArrayList<ThietBiEntity>> callback);
	void selectRootMenu(AsyncCallback<ArrayList<NhomThietBiEntity>> callback);	
}
