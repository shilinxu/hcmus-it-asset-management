package hcmus.am.client;

 import java.util.LinkedHashMap;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SliderItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.viewer.CellStyleHandler;
import com.smartgwt.client.widgets.viewer.DetailFormatter;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
   
 public class TestTileView implements EntryPoint {  
   
     public void onModuleLoad() {  
   
    	 
    	 VLayout main = new VLayout();
    	 
    	 ToolStrip topBar = new ToolStrip();
         topBar.setHeight(33);
         topBar.setWidth100();

         topBar.addSpacer(6);
         ImgButton fitHomeButton = new ImgButton();
         fitHomeButton.setSrc("icons/cubes_green.png");
         fitHomeButton.setWidth(24);
         fitHomeButton.setHeight(24);
         fitHomeButton.setPrompt("FIT - HCMUS");
         fitHomeButton.setHoverStyle("interactImageHover");
         fitHomeButton.setShowRollOver(false);
         fitHomeButton.setShowDownIcon(false);
         fitHomeButton.setShowDown(false);
         fitHomeButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
             public void onClick(ClickEvent event) {
                 com.google.gwt.user.client.Window.open("http://fit.hcmus.edu.vn", "fit-hcmus", null);
             }
         });
         topBar.addMember(fitHomeButton);
         topBar.addSpacer(6);

         Label title = new Label("The University of Science - Ho Chi Minh city");
         title.setStyleName("sgwtTitle");
         title.setWidth(800);
         topBar.addMember(title);

         topBar.addFill();

         topBar.addSeparator();

         ImgButton imgButton = new ImgButton();
         imgButton.setWidth(18);
         imgButton.setHeight(18);
         imgButton.setSrc("icons/emoticon.png");
         imgButton.setShowFocused(false);
         imgButton.setShowFocusedIcon(false);
         imgButton.setPrompt("Log out");
         imgButton.setHoverWidth(110);
         imgButton.setHoverStyle("interactImageHover");

         topBar.addMember(imgButton);

         topBar.addSpacer(6);

         main.addMember(topBar);

         main.setWidth100();
         main.setHeight100();
         //main.setStyleName("tabSetContainer");
    	 
    	 //////////////////////////////////////////////////////////////////////////////////////////////////
    	 // End title
         
         
        HLayout hLayout = new HLayout();
 		hLayout.setLayoutMargin(5);
 		hLayout.setWidth100();
 		hLayout.setHeight100();


 		VLayout sideNavLayout = new VLayout();
 		sideNavLayout.setHeight100();
 		sideNavLayout.setWidth(185);
 		sideNavLayout.setShowResizeBar(true);

 		TreeGrid sideNav = new TreeGrid();  
 		sideNav.setWidth(300);  
 		sideNav.setHeight(800);  

 		TreeGridField field = new TreeGridField("Name", "Danh sach phong");  
 		field.setCanSort(false);  

 		sideNav.setFields(field);  

 		final Tree tree = new Tree();  
 		tree.setModelType(TreeModelType.PARENT);  
 		tree.setNameProperty("Name");  
 		tree.setShowRoot(true);  

 		RoomTreeNode root = new RoomTreeNode("Phong may I51");  
 		RoomTreeNode node2 = new RoomTreeNode("Phong may I52");  
 		RoomTreeNode node3 = new RoomTreeNode("Thu vien");  
 		RoomTreeNode node4 = new RoomTreeNode("Nha de xe");  
 		RoomTreeNode node5 = new RoomTreeNode("Toilet");  
 		tree.setData(new TreeNode[]{root, node2, node3, node4, node5});  

 		sideNav.addDrawHandler(new DrawHandler() {  
 			public void onDraw(DrawEvent event) {  
 				tree.openAll();  
 			}  
 		});  

 		sideNav.setData(tree);  
 		sideNavLayout.addMember(sideNav);
 		hLayout.addMember(sideNavLayout);
         
        main.addMember(hLayout);
         
         
         ///////////////////////////////////////////////////////////////////////////////////////////////
    	 
         VStack vStack = new VStack(20);  
         vStack.setWidth100();  
   
         final TileGrid tileGrid = new TileGrid();  
         tileGrid.setTileWidth(150);  
         tileGrid.setTileHeight(205);  
         tileGrid.setHeight(400);  
         tileGrid.setShowAllRecords(true);  
         tileGrid.setDataSource(EquipmentXmlDS.getInstance());  
         tileGrid.setAutoFetchData(true);  
         tileGrid.setAnimateTileChange(true);  
   
         DetailViewerField pictureField = new DetailViewerField("picture");  
         DetailViewerField commonNameField = new DetailViewerField("commonName");  
         commonNameField.setCellStyle("commonName");  
   
         DetailViewerField lifeSpanField = new DetailViewerField("lifeSpan");  
         lifeSpanField.setCellStyle("lifeSpan");  
         lifeSpanField.setDetailFormatter(new DetailFormatter() {  
             public String format(Object value, Record record, DetailViewerField field) {  
                 return "Lifespan: " + value;  
             }  
         });  
   
         DetailViewerField statusField = new DetailViewerField("status");
         statusField.setCellStyleHandler(new CellStyleHandler() {
             public String execute(Object value, DetailViewerField field, Record record) {
                 if("Available".equals(value)) {
                     return "available";
                 } else if ("Borrowed".equals(value)) {
                     return "borrowed";
                 } else if ("Repaired".equals(value)) {
                     return "repaired";
                 } else {
                     return null;
                 }
             }
         });
         tileGrid.setFields(pictureField, commonNameField, lifeSpanField, statusField);  
   
         vStack.addMember(tileGrid);  
   
         final DynamicForm filterForm = new DynamicForm();  
         filterForm.setIsGroup(true);  
         filterForm.setGroupTitle("Search");  
         filterForm.setNumCols(6);  
         filterForm.setDataSource(EquipmentXmlDS.getInstance());  
         filterForm.setAutoFocus(false);  
   
         TextItem commonNameItem = new TextItem("commonName");  
         SliderItem lifeSpanItem = new SliderItem("lifeSpan");  
         lifeSpanItem.setTitle("Max Life Span");  
         lifeSpanItem.setMinValue(1);  
         lifeSpanItem.setMaxValue(60);  
         lifeSpanItem.setDefaultValue(60);  
         lifeSpanItem.setHeight(50);  
         lifeSpanItem.setOperator(OperatorId.LESS_THAN);  
   
         SelectItem statusItem = new SelectItem("status");  
         statusItem.setOperator(OperatorId.EQUALS);  
         statusItem.setAllowEmptyValue(true);  
   
         filterForm.setFields(commonNameItem, lifeSpanItem, statusItem);  
   
         filterForm.addItemChangedHandler(new ItemChangedHandler() {  
             public void onItemChanged(ItemChangedEvent event) {  
                 tileGrid.fetchData(filterForm.getValuesAsCriteria());  
             }  
         });  
   
         vStack.addMember(filterForm);  
   
         final DynamicForm sortForm = new DynamicForm();  
         sortForm.setIsGroup(true);  
         sortForm.setGroupTitle("Sort");  
         sortForm.setAutoFocus(false);  
         sortForm.setNumCols(6);  
   
         SelectItem sortItem = new SelectItem();  
         sortItem.setName("sortBy");  
         sortItem.setTitle("Sort By");  
   
         LinkedHashMap valueMap = new LinkedHashMap();  
         valueMap.put("commonName", "Equipment");  
         valueMap.put("lifeSpan", "Life Span");  
         valueMap.put("status", "Available Status");  
   
         sortItem.setValueMap(valueMap);
   
         final CheckboxItem ascendingItem = new CheckboxItem("chkSortDir");  
         ascendingItem.setTitle("Ascending");  
   
         sortForm.setFields(sortItem, ascendingItem);  
   
         sortForm.addItemChangedHandler(new ItemChangedHandler() {  
             public void onItemChanged(ItemChangedEvent event) {  
                 String sortVal = sortForm.getValueAsString("sortBy");  
                 Boolean sortDir = (Boolean) ascendingItem.getValue();  
                 if(sortDir == null) sortDir = false;  
                 if(sortVal != null) {  
                    tileGrid.sortByProperty(sortVal, sortDir);  
                 }  
             }  
         });  
         vStack.addMember(sortForm);  
   
         HLayout hLayout1 = new HLayout(10);  
         hLayout.setHeight(22);  
   
         IButton filterButton = new IButton("Filter");  
         filterButton.addClickHandler(new ClickHandler() {  
             public void onClick(ClickEvent event) {  
                 tileGrid.fetchData(filterForm.getValuesAsCriteria());  
             }  
         });  
         filterButton.setAutoFit(true);  
   
         IButton clearButton = new IButton("Clear");  
         clearButton.setAutoFit(true);  
         clearButton.addClickHandler(new ClickHandler() {  
             public void onClick(ClickEvent event) {  
                 tileGrid.fetchData();  
                 filterForm.clearValues();  
                 sortForm.clearValues();  
             }  
         });  
   
         hLayout1.addMember(filterButton);  
         hLayout1.addMember(clearButton);  
         vStack.addMember(hLayout1);  
   
         hLayout.addMember(vStack);
         
         ////////////////////////////////////////////////////////////
         
         final IButton cssButton = new IButton("Check repair");  
                 cssButton.setShowRollOver(true);  
                 cssButton.setShowDisabled(true);  
                 cssButton.setShowDown(true);  
                 cssButton.setIcon("icons/icon_add_files.png");
         
         final IButton btn1 = new IButton("Test");  
         btn1.setShowRollOver(true);  
 
         
         
         VLayout contextMenu = new VLayout();
         contextMenu.setAutoHeight();  
         contextMenu.setMembersMargin(30);   
         contextMenu.addMember(cssButton);  
         contextMenu.addMember(btn1);  
         
         hLayout.addMember(contextMenu);
         main.addMember(hLayout);

         
    	Label foot = new Label("Student : Hoang Hai Hung, Nguyen Hong Diep");
      	foot.setStyleName("footer");
        main.addMember(foot);
        main.draw();
         //vStack.draw();  
     }  
   ///////////////////////////////////////////////////////////////////////////////////////////////////////    
     //////////////////////////////////////
     
     public static class RoomTreeNode extends TreeNode {  

 		public RoomTreeNode(String name) {    
 			setName(name);  
 		}  
 		public void setName(String name) {  
 			setAttribute("Name", name);  
 		}  
 	}  
     
 }   