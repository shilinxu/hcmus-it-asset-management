package hcmus.am.client.view;

import hcmus.am.client.entity.ChuyenTrangThaiEntity;

import java.util.ArrayList;

import com.smartgwt.client.widgets.tree.TreeNode;

public class ContextTreeNode extends TreeNode {
	public ContextTreeNode(ChuyenTrangThaiEntity ent) {
		setAttribute("id", ent.IdChuyenTrangThai);
		setAttribute("ManHinh", ent.ManHinh);
		setAttribute("Mota", ent.Mota);
		setAttribute("TrangThai1", ent.TrangThai1);
		setAttribute("TrangThai2", ent.TrangThai2);
	}
	
	public static ContextTreeNode[] getArrContextTreeNode(ArrayList<ChuyenTrangThaiEntity> lst){
		ContextTreeNode[] rs  = new ContextTreeNode[lst.size()];
		for (int i = 0; i < rs.length; i++) {
			boolean manHinhDaXuatHien = false;
			for (int j = 0;j < i; j++)
				if (lst.get(i).ManHinh.equals(lst.get(j).ManHinh))
					manHinhDaXuatHien = true;
			if (!manHinhDaXuatHien)
				rs[i] = new ContextTreeNode(lst.get(i));
		}
		return rs;
		
	}

}
