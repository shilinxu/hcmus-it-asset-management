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

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.LeafClickEvent;
import com.smartgwt.client.widgets.tree.events.LeafClickHandler;

public class AM5 implements EntryPoint {

	private TabSet mainTabSet;
	private TreeGrid sideNav;
	public void onModuleLoad() {
		//start addcode
		VLayout main = new VLayout();
		main.setWidth100();
		main.setHeight100();
		ToolStrip topBar = new ToolStrip();
		topBar.setHeight(33);
		topBar.setWidth100();

		topBar.addSpacer(6);
		ImgButton sgwtHomeButton = new ImgButton();
		sgwtHomeButton.setSrc("interface/logo.jpg");
		sgwtHomeButton.setWidth(25);
		sgwtHomeButton.setHeight(33);
		sgwtHomeButton.setPrompt("");
		sgwtHomeButton.setHoverStyle("interactImageHover");
		sgwtHomeButton.setShowRollOver(false);
		sgwtHomeButton.setShowDownIcon(false);
		sgwtHomeButton.setShowDown(false);
		sgwtHomeButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			public void onClick(ClickEvent event) {
				com.google.gwt.user.client.Window.open("http://code.google.com/p/smartgwt/", "sgwt", null);
			}
		});
		topBar.addMember(sgwtHomeButton);
		topBar.addSpacer(6);

		Label title = new Label("FIT-HCMUS ASSET MANAGEMENT SYSTEM");
		title.setStyleName("sgwtTitle");
		title.setWidth(400);
		topBar.addMember(title);

		topBar.addFill();

		ToolStripButton devConsoleButton = new ToolStripButton();
		devConsoleButton.setTitle("Thoát");
		devConsoleButton.setIcon("interface/logout.png");
		devConsoleButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			public void onClick(ClickEvent event) {
				SC.showConsole();
			}
		});

		topBar.addButton(devConsoleButton);
		topBar.addSeparator();
		topBar.addSpacer(6);

		main.addMember(topBar);
		
	    HLayout center = new HLayout();
	    center.setLayoutMargin(5);
	    center.setWidth100();
        center.setHeight100();

        VLayout sideNavLayout = new VLayout();
        sideNavLayout.setHeight100();
        sideNavLayout.setWidth(185);
        sideNavLayout.setShowResizeBar(true);

       		//end addcode
		
		
		sideNav = new TreeGrid();
		sideNav.setWidth100();
		sideNav.setHeight100();

		TreeGridField field = new TreeGridField("Name", "Nhóm thiết bị");
		field.setCanSort(false);

		sideNav.setFields(field);

		final Tree tree = new Tree();
		tree.setModelType(TreeModelType.PARENT);
		tree.setNameProperty("Name");
		tree.setIdField("EmployeeId");
		tree.setParentIdField("ReportsTo");
		tree.setShowRoot(true);

		EmployeeTreeNode root = new EmployeeTreeNode("4", "1", "Charles Madigen");
		EmployeeTreeNode node2 = new EmployeeTreeNode("188", "4", "Rogine Leger");
		EmployeeTreeNode node3 = new EmployeeTreeNode("189", "4", "Gene Porter");
		EmployeeTreeNode node4 = new EmployeeTreeNode("265", "189", "Olivier Doucet");
		EmployeeTreeNode node5 = new EmployeeTreeNode("264", "189", "Cheryl Pearson");
		tree.setData(new TreeNode[]{root, node2, node3, node4, node5});

		sideNav.setData(tree);


        sideNav.addLeafClickHandler(new LeafClickHandler() {
            public void onLeafClick(LeafClickEvent event) {
                TreeNode node = event.getLeaf();
              //  showSample(node);
            }
        });

        sideNavLayout.addMember(sideNav);
        center.addMember(sideNavLayout);


        mainTabSet = new TabSet();
        

        Layout paneContainerProperties = new Layout();
        paneContainerProperties.setLayoutMargin(0);
        paneContainerProperties.setLayoutTopMargin(1);
        mainTabSet.setPaneContainerProperties(paneContainerProperties);

        mainTabSet.setWidth100();
        mainTabSet.setHeight100();
        
        Tab tab = new Tab();
        tab.setTitle("Danh sách thiết bị&nbsp;&nbsp;");
        tab.setIcon("interface/house.png");
        tab.setWidth(120);

        HLayout mainPanel = new HLayout();
        mainPanel.setHeight100();
        mainPanel.setWidth100();

        //noi dung o giua
        HomeTabView tileView = new HomeTabView(mainPanel);
        mainPanel.addMember(tileView);

        tab.setPane(mainPanel);

        mainTabSet.addTab(tab);
        
        center.addMember(mainTabSet);
        
        //botPanel.
      
		main.addMember(center);
		
		ToolStrip botBar = new ToolStrip();
		botBar.setHeight(25);
		botBar.setWidth100();
	
		Label bottom = new Label("&nbsp;&nbsp;&nbsp;© FIT-HCMUS 2010. All right reserved ");
        //bottom.setStyleName("sgwtTitle");
        bottom.setWidth(400);
        botBar.addMember(bottom);
		main.addMember(botBar);
		main.draw();
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
