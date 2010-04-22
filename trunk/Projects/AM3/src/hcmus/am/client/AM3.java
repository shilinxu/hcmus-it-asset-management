package hcmus.am.client;


import hcmus.am.client.entity.ChuyenTrangThaiEntity;
import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.client.entity.TrangThaiEntity;
import hcmus.am.client.view.ContextTreeNode;
import hcmus.am.client.view.NhomThietBiTreeNode;
import hcmus.am.client.view.ThietBiView;
import hcmus.am.client.view.UserFuncTreeNode;

import java.util.ArrayList;

import Test.ThietBiDao.select;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SliderItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.events.SelectionChangedEvent;
import com.smartgwt.client.widgets.tile.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.viewer.DetailViewerField;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AM3 implements EntryPoint {	
	private final TrangThaiServiceAsync trangthaiService = GWT.create(TrangThaiService.class);
	private final ThietBiServiceAsync thietbiService = GWT.create(ThietBiService.class);
	ThietBiView[] thietBiView;
	ArrayList<TrangThaiEntity> lstTrangThai;
	TreeGrid treeGrid;
	TileGrid tileGrid;
	DynamicForm filterForm;
	TreeGrid contextGrid;
	Tree contextTree ;
	TreeGrid userfuncMenu;
	Tree userfuncTree;
	public void onModuleLoad() {	
		
		contextGrid = new TreeGrid();
		contextGrid.setWidth(300);
		contextGrid.setHeight(200);

		
		contextTree = new Tree();
		contextTree.setModelType(TreeModelType.PARENT);  
		contextTree.setIdField("IdTrangThai2");
		TreeGridField formattedField2 = new TreeGridField();  
		formattedField2.setCellFormatter(new CellFormatter() {  
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
				return record.getAttributeAsString("Mota");
			}		
		}); 
		contextGrid.setFields(formattedField2);	
		//contextTree.setParentIdField("IdNhomThietBiCha");
		
		userfuncMenu = new TreeGrid();
		userfuncMenu.setWidth(300);
		userfuncMenu.setHeight(300);
		
		
		treeGrid = new TreeGrid();
		tileGrid = new TileGrid();
		//tileGrid.setTitle("Danh sách thiết bị");		
		treeGrid.setWidth(300);  
		treeGrid.setHeight(400);  

		TreeGridField formattedField = new TreeGridField("Nhóm thiết bị");  
		formattedField.setCellFormatter(new CellFormatter() {  
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
				return record.getAttributeAsString("Ten");
			}  
		});  
		treeGrid.setFields(formattedField);	
		treeGrid.addCellClickHandler(new CellClickHandler() {

			@Override
			public void onCellClick(CellClickEvent event) {
				//Window.alert(Integer.toString(event.getRowNum()));
				Integer IdNhomThietBi = event.getRecord().getAttributeAsInt("IdNhomThietBi");
				thietbiService.selectThietBiView(IdNhomThietBi, new AsyncCallback<ThietBiView[]>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("error loading .... thiet bi view");
						
					}

					@Override
					public void onSuccess(ThietBiView[] result) {
						UpdateThietBiview(result);
					}
				});
			}
		});
		final Tree tree = new Tree();  
		tree.setModelType(TreeModelType.PARENT);  
		tree.setNameProperty("Ten");  
		tree.setIdField("IdNhomThietBi");
		tree.setParentIdField("IdNhomThietBiCha");
		
		thietbiService.selectMenuNhomThietBi(new AsyncCallback<ArrayList<NhomThietBiEntity>>() {
			@Override
			public void onSuccess(ArrayList<NhomThietBiEntity> result) {
				treeGrid.addDrawHandler(new DrawHandler() {  
					public void onDraw(DrawEvent event) {  
						tree.openAll();  
					}  
				}); 
				TreeNode[] treeNodes = new TreeNode[result.size()];

				for (int i = 0; i < result.size(); i++) {					
					treeNodes[i] = new NhomThietBiTreeNode(result.get(i));
				}
				tree.setData(treeNodes);

				treeGrid.setData(tree);  
				//treeGrid.draw();	
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("ko the load menu");

			}
		});
		
		tileGrid.setTileWidth(120);  
		tileGrid.setTileHeight(120);  
		tileGrid.setHeight(400);  
		tileGrid.setWidth(650);  
		tileGrid.setShowAllRecords(true);  
		/*thietbiService.SelectN(new AsyncCallback<ArrayList<ThietBiEntity>>() {
			
			@Override
			public void onSuccess(ArrayList<ThietBiEntity> result) {
				//tileGrid.setData(ThietBiRecord.getThietBiRecord(result));
				tileGrid.setData(ThietBiView.getThietBiTileRecord(result));
				//getNewRecords());  
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		})
		;*/
		thietbiService.selectThietBiView(3, new AsyncCallback<ThietBiView[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("error loading .... thiet bi view");
				
			}

			@Override
			public void onSuccess(ThietBiView[] result) {
				UpdateThietBiview(result);
			}
		});
		DetailViewerField nameField2 = new DetailViewerField("name");	
		DetailViewerField pictureField = new DetailViewerField("picture");  
		pictureField.setType("image");  
		pictureField.setImageURLPrefix("LOAI_THIET_BI/");  
		pictureField.setImageWidth(60);  
		pictureField.setImageHeight(60);  

	
		DetailViewerField trangthaiField = new DetailViewerField("trangthai");
		trangthaiField.setType("image");  
		trangthaiField.setImageURLPrefix("TRANG_THAI/");  
		trangthaiField.setImageWidth(36);  
		trangthaiField.setImageHeight(36);
		
		DetailViewerField nguoidungField = new DetailViewerField("nguoidung");

		tileGrid.setFields(nameField2, pictureField, trangthaiField, nguoidungField);  

		tileGrid.addSelectionChangedHandler(new SelectionChangedHandler() {
			
			@Override
			public void onSelectionChanged(SelectionChangedEvent event) {
				if (event.getState() == true) {
					Integer IdTrangThai = event.getRecord().getAttributeAsInt("IdTrangThai");
					if(IdTrangThai != null)
						{
					//	Window.alert(IdTrangThai.toString());
						UpdateContextMenu(event.getRecord().getAttributeAsInt("IdTrangThai"));
						}
					else 
						Window.alert("trang thai null");
				}
				
			}
		});
		//filter panel.
		
		HLayout navLayout = new HLayout();
			VLayout mainLayout = new VLayout();
			mainLayout.setWidth(650);
			
				filterForm = new DynamicForm();
			 	/*CheckboxItem TrangThai1 = new CheckboxItem("TrangThai1", "Đề nghị thanh lý");
				TrangThai1.setValue(true);
				
				CheckboxItem TrangThai2 = new CheckboxItem("TrangThai2", "Đã bàn giao");
				CheckboxItem TrangThai3 = new CheckboxItem("TrangThai3", "Đang sử dụng");
		
				filterForm.setFields(TrangThai1, TrangThai2, TrangThai3);

		        filterForm.addItemChangedHandler(new ItemChangedHandler() {
		            public void onItemChanged(ItemChangedEvent event) {
		                FormItem item = event.getItem();
		                if (item instanceof CheckboxItem || item instanceof SliderItem) {
		                    updateTiles();
		                }
		            }
		        });*/

		        mainLayout.addMember(filterForm);
				mainLayout.addMember(tileGrid);				
				
				VLayout contextLayout = new VLayout();
				contextLayout.setWidth(300);
				
					contextLayout.addMember(contextGrid);
										
					contextLayout.addMember(userfuncMenu);
					ViewUserFunc();
				
			navLayout.setMembers(treeGrid, mainLayout, contextLayout);
							
		RootPanel.get().add(navLayout);		
	}
	private CheckboxItem[] fields;
	/**
	 * Update Menu context when click, select another  ThietBi.
	 * @param IdTrangThai
	 */
	public void UpdateContextMenu(Integer IdTrangThai){
		trangthaiService.selectAllChuyenTrangThaiFrom(IdTrangThai, new AsyncCallback<ArrayList<ChuyenTrangThaiEntity>>() {
			
			@Override
			public void onSuccess(ArrayList<ChuyenTrangThaiEntity> result) {
				contextTree = new Tree();
				contextTree.setModelType(TreeModelType.PARENT);  
				contextTree.setNameProperty("ManHinh");  
				contextTree.setIdField("IdTrangThai2");
				contextTree.setData(ContextTreeNode.getArrContextTreeNode(result));
				
				contextGrid.setData(contextTree);
			}
			
			@Override
			public void onFailure(Throwable caught) {
								
			}
		})	;
	}
	public void ViewUserFunc() {
		userfuncTree = new Tree();		
		//for (int i = 0; i < )
		userfuncTree.setModelType(TreeModelType.PARENT);  
		userfuncTree.setNameProperty("name");  
		userfuncTree.setIdField("id");
		
		UserFuncTreeNode[] nodes = new UserFuncTreeNode[5];
		nodes[0] = new UserFuncTreeNode("Đề nghị mua thiết bị", "1", "#de-nghi-mua-thiet-bi");
		nodes[1] = new UserFuncTreeNode("Xem cấu hình thiết bị con", "2", "#xem-cau-hinh-thiet-bi-con");
		nodes[2] = new UserFuncTreeNode("Tách thiết bị", "3", "#tach-thiet-bi");
		nodes[3] = new UserFuncTreeNode("Ghép thiết bị", "4", "#ghep-thiet-bi");
		nodes[4] = new UserFuncTreeNode("Nhập mới thiết bị", "5", "#nhap-moi-thiet-bi");
		userfuncTree.setData(nodes);
		
		userfuncMenu.setData(userfuncTree);
		userfuncMenu.addCellClickHandler(new CellClickHandler() {
			
			@Override
			public void onCellClick(CellClickEvent event) {
				String ManHinh = event.getRecord().getAttribute("ManHinh");
				OpenWindow(ManHinh);
			}
			
		});
		
		
	}
	String manHinhs[] = {
			"#nhap-moi-thiet-bi"
	};
	public void OpenWindow(String manHinh) {

		int idxManHinh = -1;
		for (int i = 0; i < manHinhs.length;i ++) {
			if (manHinhs[i].equals(manHinh))
				idxManHinh = i;
		}
		switch(idxManHinh) {
		case 0:
			Window.alert("man hinh nhap moi thiet bi");
			break;
		}
		
	}
	
	/**
	 * Update Main panel viewing Thiet bi when choose another Nhom Thiet Bi.
	 * @param rs
	 */
	public void UpdateThietBiview(ThietBiView[] rs){
		thietBiView = rs;
		tileGrid.setData(ThietBiView.getThietBiTileRecord(rs));
		lstTrangThai = new ArrayList<TrangThaiEntity>(); 
		for (int i = 0 ; i < thietBiView.length; i++) {
			boolean flag = false;
			for (int j = 0; j < lstTrangThai.size(); j++)
				if (thietBiView[i].trangThai == null || thietBiView[i].trangThai.IdTrangThai == lstTrangThai.get(j).IdTrangThai)
				{
					flag = true;
					break;
				}
			if (!flag)
				lstTrangThai.add(thietBiView[i].trangThai);
		}
		//
		fields = new CheckboxItem[lstTrangThai.size()];
		for (int i = 0; i < lstTrangThai.size(); i++) {
			TrangThaiEntity curr = lstTrangThai.get(i);
			fields[i] = new CheckboxItem(curr.IdTrangThai.toString(), curr.Ten);
			fields[i].setValue(true);
			
		}
		filterForm.setFields(fields);
		filterForm.addItemChangedHandler(new ItemChangedHandler() {
	            public void onItemChanged(ItemChangedEvent event) {
	                FormItem item = event.getItem();
	                if (item instanceof CheckboxItem || item instanceof SliderItem) {
	                	ArrayList<Integer> lstIdTrangThai = new ArrayList<Integer>();
	                	for(int i = 0; i < fields.length; i++) {
	                		if (fields[i].getValueAsBoolean())
	                			lstIdTrangThai.add(Integer.parseInt(fields[i].getName()));
	                	}
	                	tileGrid.setData(ThietBiView.getThietBiTileRecordWithFilter(thietBiView, lstIdTrangThai));
	                }
	            }
	        });
	}
}