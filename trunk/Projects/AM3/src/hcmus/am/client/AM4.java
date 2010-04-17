package hcmus.am.client;

/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

import hcmus.am.client.entity.NhomThietBiEntity;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class AM4 implements EntryPoint {
	private final ThietBiServiceAsync thietbiService = GWT.create(ThietBiService.class);
    public void onModuleLoad() {
        final TreeGrid treeGrid = new TreeGrid();
        treeGrid.setWidth(300);
        treeGrid.setHeight(400);

        TreeGridField field = new TreeGridField("Name", "Tree from local data");
        field.setCanSort(false);

        treeGrid.setFields(field);

        final Tree tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        tree.setNameProperty("Name");
        tree.setIdField("EmployeeId");
        tree.setParentIdField("ReportsTo");
        tree.setShowRoot(true);
        thietbiService.selectMenuNhomThietBi(new AsyncCallback<ArrayList<NhomThietBiEntity>>() {
			
			@Override
			public void onSuccess(ArrayList<NhomThietBiEntity> result) {

		        EmployeeTreeNode root = new EmployeeTreeNode("4", "1", "Charles Madigen");
		        EmployeeTreeNode node2 = new EmployeeTreeNode("188", "4", "Rogine Leger");
		        EmployeeTreeNode node3 = new EmployeeTreeNode("189", "4", "Gene Porter");
		        EmployeeTreeNode node4 = new EmployeeTreeNode("265", "189", "Olivier Doucet");
		        EmployeeTreeNode node5 = new EmployeeTreeNode("264", "189", "Cheryl Pearson");
		        tree.setData(new TreeNode[]{root, node2, node3, node4, node5});

		        treeGrid.addDrawHandler(new DrawHandler() {
		            public void onDraw(DrawEvent event) {
		                tree.openAll();
		            }
		        });
		        
		        treeGrid.setData(tree);

		        treeGrid.draw();
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
    }

    public static class EmployeeTreeNode extends TreeNode {

        public EmployeeTreeNode(String employeeId, String reportsTo, String name) {
            setEmployeeId(employeeId);
            setReportsTo(reportsTo);
            setName(name);
        }

        public void setEmployeeId(String value) {
            setAttribute("EmployeeId", value);
        }

        public void setReportsTo(String value) {
            setAttribute("ReportsTo", value);
        }

        public void setName(String name) {
            setAttribute("Name", name);
        }
    }

}
