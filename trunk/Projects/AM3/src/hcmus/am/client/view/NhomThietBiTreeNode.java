package hcmus.am.client.view;

import java.io.Serializable;

import hcmus.am.client.entity.NhomThietBiEntity;

import com.smartgwt.client.widgets.tree.TreeNode;

public class NhomThietBiTreeNode extends TreeNode implements Serializable{  
	/**
	 * 
	 */
	private static final long serialVersionUID = -4917914796143181036L;
	public NhomThietBiTreeNode(){}
	public NhomThietBiTreeNode(NhomThietBiEntity ent) {
		setAttribute("Ten", ent.Ten);//"ent.Ten);
		setAttribute("IdNhomThietBi", ent.IdNhomThietBi);
		if (ent.IdNhomThietBiCha == null) 
			ent.IdNhomThietBiCha = 0;
		setAttribute("IdNhomThietBiCha", ent.IdNhomThietBiCha);
	}
}