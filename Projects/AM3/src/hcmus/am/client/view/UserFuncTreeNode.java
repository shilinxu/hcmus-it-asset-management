package hcmus.am.client.view;

import com.smartgwt.client.widgets.tree.TreeNode;

public class UserFuncTreeNode extends TreeNode{
	public UserFuncTreeNode(String Name, String Id, String ManHinh) {
		setAttribute("id", Id);
		setAttribute("name", Name);
		setAttribute("ManHinh", ManHinh);
	}
}
