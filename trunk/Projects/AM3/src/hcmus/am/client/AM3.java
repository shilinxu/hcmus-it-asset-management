package hcmus.am.client;


import java.util.ArrayList;

import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.client.entity.TrangThaiEntity;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Margins;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.core.XTemplate;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.DataView;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.DataView.Data;
import com.gwtext.client.widgets.event.DataViewListenerAdapter;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AM3 implements EntryPoint {
	/*private final TrangThaiServiceAsync trangthaiService = GWT.create(TrangThaiService.class); 
	@Override
	public void onModuleLoad() {	
		RootPanel root = RootPanel.get();
		final Button b = new Button();
		b.setText("Click to me");
	//	Viewport v = new Viewport();
		final HTML html = new HTML();
		b.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (b.getText().equals("Click to me")) {
					//b.setText();
					trangthaiService.select(1, new AsyncCallback<TrangThaiEntity>() {
						public void onSuccess(TrangThaiEntity result) {
							if (result != null) {								
								b.setText(result.Ten);
							} else {
								b.setText("NULL");
							}
						};
						public void onFailure(Throwable caught) {
							//b.setText(caught.getMessage());
							html.setHTML(caught.getMessage());
						}; 
					});
				} else {
					b.setText("Click to me");
				}
			}
		});
		com.gwtext.client.widgets.Button  d = new com.gwtext.client.widgets.Button();
		root.add(b);
		root.add(d);
		root.add(html);
	}*/
	private final TrangThaiServiceAsync trangthaiService = GWT.create(TrangThaiService.class);
	private final ThietBiServiceAsync thietbiService = GWT.create(ThietBiService.class);
	public void onModuleLoad() {  
		//mot panel co layout thuoc loai FITLayout o ngoai cung.
		Panel panel = new Panel();  
		panel.setBorder(false);  
		panel.setPaddings(15);  
		panel.setLayout(new FitLayout());  

		//Mot Panel CO layout Border
		Panel borderPanel = new Panel();  
		borderPanel.setLayout(new BorderLayout());  


		//add north panel vao panel border o mat NORTH.  
		Panel northPanel = new Panel();  
		northPanel.setHtml("<h2>Trường đại học KHOA HỌC TỰ NHIÊN HCM</h2><h2>Khoa CNTT</h2>" +
		"<h2>Hcmus-Asset-Manager-v0.1  : Hệ thống giám sát & quản lý thiết bị khoa CNTT</h2>");  
		northPanel.setHeight(80);  
		northPanel.setBodyStyle("background-color:FFFF88");  
		northPanel.setCollapsible(true);         
		borderPanel.add(northPanel, new BorderLayoutData(RegionPosition.NORTH));  

		//add south panel  
		Panel southPanel = new Panel();  
		southPanel.setHtml(
				"<h3>Copyright 2010 HCMUS</h3>" +
		"<h3>Developed by diep.nguyenhong@gameloft.com & hung.hoanghai@gameloft.com<h3>");  
		southPanel.setHeight(70);  
		southPanel.setBodyStyle("background-color:CDEB8B");  
		southPanel.setCollapsible(true);  
		//southPanel.setTitle("South");  

		BorderLayoutData southData = new BorderLayoutData(RegionPosition.SOUTH);  
		southData.setMinSize(100);  
		southData.setMaxSize(200);  
		southData.setMargins(new Margins(0, 0, 0, 0));  
		southData.setSplit(true);  
		borderPanel.add(southPanel, southData);  

		//add east panel  
		Panel eastPanel = new Panel();  
		eastPanel.setHtml("<p>east panel</p>");  
		eastPanel.setTitle("East Side");  
		eastPanel.setCollapsible(true);  
		eastPanel.setWidth(225);  

		BorderLayoutData eastData = new BorderLayoutData(RegionPosition.EAST);  
		eastData.setSplit(true);  
		eastData.setMinSize(175);  
		eastData.setMaxSize(400);  
		eastData.setMargins(new Margins(0, 0, 5, 0));  

		borderPanel.add(eastPanel, eastData);  
		/*Bat dau menu ben trai*/
		Panel westPanel = new Panel();  
		//westPanel.setHtml("<p>Danh mục chức năng</p>");  
		westPanel.setTitle("Danh mục chức năng");  
		westPanel.setBodyStyle("background-color:EEEEEE");  
		westPanel.setCollapsible(true);  
		westPanel.setWidth(200);  
		westPanel.setLayout(new AccordionLayout(true));

		BorderLayoutData westData = new BorderLayoutData(RegionPosition.WEST);

		westData.setSplit(true);
		westData.setMinSize(175);  
		westData.setMaxSize(400);  
		westData.setMargins(new Margins(0, 5, 0, 0));  

		borderPanel.add(westPanel, westData);

		//Them menu Nghiep vu
		/*         Panel navigationPanel = new Panel();  
         navigationPanel.setHtml("123");  
         navigationPanel.setTitle("Nghiệp vụ");  
         navigationPanel.setAutoScroll(true);  
         navigationPanel.setBorder(false);  
         navigationPanel.setIconCls("folder-icon");
		 */
		final TreePanel treePanel = new OutlookTreePanel();
		treePanel.setTitle("Nghiệp vụ");  
		treePanel.setAutoScroll(true);  
		treePanel.setBorder(false);  
		treePanel.setIconCls("folder-icon");
		// navigationPanel.add(treePanel);
		westPanel.add(treePanel);



		//them menu setting.
		TreePanel settingsPanel = new SettingTreePanel();
		settingsPanel.setTitle("Cấu hình");  
		settingsPanel.setAutoScroll(true);  
		settingsPanel.setBorder(false);  
		settingsPanel.setIconCls("settings-icon");  
		westPanel.add(settingsPanel);  

		/*Ket thuc menu*/

		//center panel thuoc loai tab panel, tao them vai panel con roi at vo thang nay 
		TabPanel centerPanel = new TabPanel();
		centerPanel.setBodyStyle("background-color:C3D9FF");  
		Panel tab0 = new Panel("Danh sách sản phẩm");
		Panel tab1 = new Panel("Giới thiệu", "<span style=\"font-family: 'Lucida Grande',arial,tahoma,verdana,serif,'Courier New'; font-size: 13px; line-height: 20px;\" class=\"Apple-style-span\"><strong style=\"margin: 0px; padding: 0px; border-width: 0px; outline-width: 0px; font-size: 13px; vertical-align: baseline; background-color: transparent;\">Khoa Công Nghệ Thông Tin (CNTT) - Trường ĐH KHTN TP.HCM<span class=\"Apple-converted-space\">&nbsp;</span></strong>được thành lập vào tháng 2 năm 1995 trên cơ sở của Bộ môn Tin học của Khoa Toán Trường Đại học Tổng hợp TP.HCM.<br>" +
		"	<br>	Trải qua 15 năm hoạt&nbsp; động, Khoa CNTT đã phát triển vững chắc và được chính phủ bảo trợ để trở thành một trong những khoa CNTT hàng đầu trong hệ thống giáo dục đại học của Việt Nam.</span>");
		Panel tab2 = new Panel("Sa2wks2015", "<h2>Owner: Nguyễn Hồng Điệp</h2>");
		Panel tab3 = new Panel("Sa2wks1043", "unknown");		

		centerPanel.add(tab0);
		centerPanel.add(tab1);
		centerPanel.add(tab2);
		centerPanel.add(tab3);
		centerPanel.activate(0);
		
		final TextBox b = new TextBox();
		{
			//load test
			
			trangthaiService.select(1, new AsyncCallback<TrangThaiEntity>() {
				public void onSuccess(TrangThaiEntity result) {
					if (result != null) {								
						b.setText(result.Ten);
					} else {
						b.setText("NULL");
					}
				};
				public void onFailure(Throwable caught) {
					//b.setText(caught.getMessage());
					b.setText(caught.getMessage());
				}; 
			});
			tab0.add(b);
			//end load test
		}
		 MemoryProxy dataProxy = new MemoryProxy(getData());  
         RecordDef recordDef = new RecordDef(new FieldDef[]{  
                 new StringFieldDef("name"),  
                 new IntegerFieldDef("size"),  
                 new DateFieldDef("lastmod", "timestamp"),  
                 new StringFieldDef("url")  
         });  
   
        ArrayReader reader = new ArrayReader(recordDef);  
        
        final Store store = new Store(dataProxy, reader, true);  
        store.load();  
  
        XTemplate template = new XTemplate(new String[]{  
                "<tpl for='.'>",  
                "<div class='thumb-wrap'>",  
                "<div class='thumb'><img src='{url}' ext:qtip='{name}'></div>",  
                "<span class='x-editable' ext:qtip='{name}'>{shortName}</span></div>",  
                "</tpl>",  
                "<div class='x-clear'></div>"  
        });  
  
        Panel inner = new Panel();  
       // inner.setWidth(535);  
        inner.setId("images-view");  
        inner.setFrame(true);  
        inner.setAutoHeight(true);  
        //inner.setCollapsible(true);  
        inner.setLayout(new FitLayout());  
       // inner.setTitle("Simple DataView");  
  
        DataView dataView = new DataView("div.thumb-wrap") {  
            public void prepareData(Data data) {  
                data.setProperty("shortName", Format.ellipsis(data.getProperty("name"), 15));  
            }  
        };  
        dataView.setWidth(535);  
  
        dataView.addListener(new DataViewListenerAdapter() {  
            public boolean doBeforeClick(DataView source, int index, Element node, EventObject e) {  
  
                System.out.println("doBeforeClick::" + getSelectedMovies(source));  
                return true;  
            }  
  
            public boolean doBeforeSelect(DataView source, Element node, Element[] selections) {  
                System.out.println("doBeforeSelect::" + getSelectedMovies(source));  
                return super.doBeforeSelect(source, node, selections);  
            }  
  
            public void onClick(DataView source, int index, Element node, EventObject e) {  
                System.out.println("onClick::" + getSelectedMovies(source));  
                super.onClick(source, index, node, e);  
                Window.alert("Da click");
            }  
  
            public void onContainerClick(DataView source, EventObject e) {  
                System.out.println("onContainerClick");  
                super.onContainerClick(source, e);  
            }  
  
            public void onContextMenu(DataView source, int index, Element node, EventObject e) {  
                System.out.println("onContextMenu");  
                super.onContextMenu(source, index, node, e);  
            }  
  
            public void onDblClick(DataView source, int index, Element node, EventObject e) {  
                System.out.println("onDblClick");  
                super.onDblClick(source, index, node, e);  
            }  
  
            public void onSelectionChange(DataView view, Element[] selections) {  
                System.out.println("onSelectionChange");  
                super.onSelectionChange(view, selections);  
            }  
        });  
  
        dataView.setStore(store);  
        dataView.setTpl(template);  
        dataView.setAutoHeight(true);  
        dataView.setMultiSelect(true);  
        dataView.setOverCls("x-view-over");  
        dataView.setEmptyText("No Images to display");  
  
        inner.add(dataView);
        tab0.add(inner);
        
        
         
		final TextBox c = new TextBox();
		{
			thietbiService.SelectN(new AsyncCallback<ArrayList<ThietBiEntity>>() {
				
				@Override
				public void onSuccess(ArrayList<ThietBiEntity> result) {
					c.setText(c.getText() + result.get(0).IdThietBi.toString());
					//TODO: load grid.
					
				}
				
				@Override
				public void onFailure(Throwable caught) {
					c.setText(caught.getMessage());
					
				}
			});
		}
		tab0.add(c);
		borderPanel.add(centerPanel, new BorderLayoutData(RegionPosition.CENTER));  

		panel.add(borderPanel);  

		Viewport viewport = new Viewport(panel);  
	}  
	
	class OutlookTreePanel extends TreePanel {  

		public OutlookTreePanel() {  

			TreeNode root = new TreeNode("Đề nghị");  
			root.setIconCls("email-icon");  
			root.setExpanded(true);  

			TreeNode inbox = new TreeNode("Đề nghị thiết bị");  
			inbox.setIconCls("inbox-icon");  
			root.appendChild(inbox);  

			TreeNode drafts = new TreeNode("Đề nghị thanh lý");  
			drafts.setIconCls("drafts-icon");  
			root.appendChild(drafts);  

			TreeNode sent = new TreeNode("Đề nghị sửa");  
			sent.setIconCls("sent-icon");  
			root.appendChild(sent);  

			/* TreeNode junk = new TreeNode("Spam");  
    		 junk.setIconCls("spam-icon");  
    		 root.appendChild(junk);  

    		 TreeNode folders = new TreeNode("Folders");  
    		 folders.setIconCls("folders-icon");  
    		 folders.setExpanded(true);  

    		 TreeNode todo = new TreeNode("ToDo");  
    		 todo.setIconCls("folders-icon");  
    		 folders.appendChild(todo);  

    		 TreeNode resumes = new TreeNode("Resumes");  
    		 resumes.setIconCls("folders-icon");  
    		 folders.appendChild(resumes);  

    		 TreeNode sales = new TreeNode("Sales");  
    		 sales.setIconCls("folders-icon");  
    		 folders.appendChild(sales);  

    		 root.appendChild(folders);  
			 */
			setTitle("E-Mail");  
			setIconCls("email-icon");  
			setWidth(200);  
			setHeight(400);  
			setEnableDD(true); 
			setRootNode(root);    
			setRootVisible(false);
			//setHideParent(true);
		}  
	}  
	class SettingTreePanel extends TreePanel {  

		public SettingTreePanel() {  

			TreeNode root = new TreeNode("Đề nghị");  
			root.setIconCls("email-icon");  
			root.setExpanded(true);  

			TreeNode inbox = new TreeNode("Agent");  
			inbox.setIconCls("inbox-icon");  
			root.appendChild(inbox);  

			TreeNode drafts = new TreeNode("Bảo mật");  
			drafts.setIconCls("drafts-icon");  
			root.appendChild(drafts);  

			TreeNode sent = new TreeNode("Quy trình nghiệp vụ");  
			sent.setIconCls("sent-icon");  
			root.appendChild(sent);  

			/* TreeNode junk = new TreeNode("Spam");  
    		 junk.setIconCls("spam-icon");  
    		 root.appendChild(junk);  

    		 TreeNode folders = new TreeNode("Folders");  
    		 folders.setIconCls("folders-icon");  
    		 folders.setExpanded(true);  

    		 TreeNode todo = new TreeNode("ToDo");  
    		 todo.setIconCls("folders-icon");  
    		 folders.appendChild(todo);  

    		 TreeNode resumes = new TreeNode("Resumes");  
    		 resumes.setIconCls("folders-icon");  
    		 folders.appendChild(resumes);  

    		 TreeNode sales = new TreeNode("Sales");  
    		 sales.setIconCls("folders-icon");  
    		 folders.appendChild(sales);  

    		 root.appendChild(folders);  
			 */
			setTitle("E-Mail");  
			setIconCls("email-icon");  
			setWidth(200);  
			setHeight(400);  
			setEnableDD(true); 
			setRootNode(root);    
			setRootVisible(false);
			//setHideParent(true);
		}  
	}  
	private Object[][] getData() {  
        return new Object[][]{  
                new Object[]{"Pirates of the Caribbean", new Integer(2120),  
                        new Long(1180231870000l), "images/view/carribean.jpg"},  
                new Object[]{"Resident Evil", new Integer(2120),  
                        new Long(1180231870000l), "images/view/resident_evil.jpg"},  
                new Object[]{"Blood Diamond", new Integer(2120),  
                        new Long(1180231870000l), "images/view/blood_diamond.jpg"},  
                new Object[]{"No Reservations", new Integer(2120),  
                        new Long(1180231870000l), "images/view/no_reservations.jpg"},  
                new Object[]{"Casino Royale", new Integer(2120),  
                        new Long(1180231870000l), "images/view/casino_royale.jpg"},  
                new Object[]{"Good Shepherd", new Integer(2120),  
                        new Long(1180231870000l), "images/view/good_shepherd.jpg"},  
                new Object[]{"Ghost Rider", new Integer(2120),  
                        new Long(1180231870000l), "images/view/ghost_rider.jpg"},  
                new Object[]{"Batman Begins", new Integer(2120),  
                        new Long(1180231870000l), "images/view/batman_begins.jpg"},  
                new Object[]{"Last Samurai", new Integer(2120),  
                        new Long(1180231870000l), "images/view/last_samurai.jpg"},  
                new Object[]{"Italian Job", new Integer(2120),  
                        new Long(1180231870000l), "images/view/italian_job.jpg"},  
                new Object[]{"Mission Impossible III", new Integer(2120),  
                        new Long(1180231870000l), "images/view/mi3.jpg"},  
                new Object[]{"Mr & Mrs Smith", new Integer(2120),  
                        new Long(1180231870000l), "images/view/smith.jpg"},  
                new Object[]{"Inside Man", new Integer(2120),  
                        new Long(1180231870000l), "images/view/inside_man.jpg"}
        };  
    }  
	  private String getSelectedMovies(DataView view) {  
	         Record[] records = view.getSelectedRecords();  
	         String msg = "";  
	         for (int i = 0; i < records.length; i++) {  
	             Record record = records[i];  
	             msg += record.getAsString("name") + " ";  
	         }  
	         return msg;  
	     }  
	   
}