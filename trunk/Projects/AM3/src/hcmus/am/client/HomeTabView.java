package hcmus.am.client;


import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.FormItemIcon;
import com.smartgwt.client.widgets.form.fields.PickerIcon;
import com.smartgwt.client.widgets.form.fields.SliderItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.IconClickEvent;
import com.smartgwt.client.widgets.form.fields.events.IconClickHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.viewer.DetailFormatter;
import com.smartgwt.client.widgets.viewer.DetailViewerField;


public class HomeTabView extends HLayout {

    private CheckboxItem featuredCB;
    private CheckboxItem newSamplesCB;
    private CheckboxItem comboBoxCB;
    private CheckboxItem gridsCB;
    private CheckboxItem treeCB;
    private CheckboxItem calendarCB;
    private CheckboxItem tilesCB;
    private CheckboxItem formsCB;
    private CheckboxItem layoutCB;
    private CheckboxItem windowsCB;
    private CheckboxItem tabsCB;
    private CheckboxItem accordionCB;
    private CheckboxItem buttonsCB;
    private CheckboxItem menusCB;
    private CheckboxItem otherControlsCB;
    private CheckboxItem dataIntegrationCB;
    private CheckboxItem dragDropCB;
    private CheckboxItem basicsCB;
    private CheckboxItem effectsCB;
    private CheckboxItem ascendingItem;
    private CheckboxItem disabledModeCB;
    private TextItem searchItem;

	public HomeTabView(Canvas parentPanel) {
		//TileGrid san pham.
		TileGrid tileGrid = new TileGrid();
		tileGrid.setShowEdges(true);
		tileGrid.setTileWidth(140);
		tileGrid.setTileHeight(120);
		tileGrid.setWidth100();
		tileGrid.setHeight100();
		tileGrid.setShowAllRecords(true);

		tileGrid.setAutoFetchData(false);
		tileGrid.setAnimateTileChange(true);

		DetailViewerField nameField = new DetailViewerField("name");
		nameField.setDetailFormatter(new DetailFormatter() {
			public String format(Object value, Record record, DetailViewerField field) {
				return value.toString();
			}
		});
		nameField.setCellStyle("thumbnailTitle");

		DetailViewerField iconField = new DetailViewerField("thumbnail");
		iconField.setType("image");
		iconField.setImageHeight(89);
		iconField.setImageWidth(119);
		iconField.setCellStyle("thumbnail");


		tileGrid.setFields(iconField, nameField);
		
		

		DynamicForm filterForm = new DynamicForm();
        filterForm.setBorder("1px solid #9C9C9C");
        filterForm.setNumCols(8);
        filterForm.setAutoFocus(false);
        filterForm.setPadding(5);

        TextItem searchItem = new TextItem("description", "Search");
        searchItem.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if("enter".equalsIgnoreCase(event.getKeyName())) {
                   // updateTiles();
                }
            }
        });
        final PickerIcon findIcon = new PickerIcon(PickerIcon.SEARCH);
        final PickerIcon cancelIcon = new PickerIcon(PickerIcon.CLEAR);
        searchItem.setIcons(findIcon, cancelIcon);

        searchItem.addIconClickHandler(new IconClickHandler() {
            public void onIconClick(IconClickEvent event) {
                FormItemIcon icon = event.getIcon();
                if(icon.getSrc().equals(cancelIcon.getSrc())) {
                  //  filterForm.reset();
                    featuredCB.setValue(true);
                }
              //  updateTiles();
            }
        });

        SliderItem numSamplesItem = new SliderItem("numSamples");
        numSamplesItem.setTitle("# of Samples");
        numSamplesItem.setMinValue(1);
        numSamplesItem.setMaxValue(100);
        numSamplesItem.setDefaultValue(100);
        numSamplesItem.setHeight(50);
        numSamplesItem.setOperator(OperatorId.LESS_THAN);
        
        featuredCB = new CheckboxItem("featuredCB", "Featured Samples");
        featuredCB.setValue(true);

        newSamplesCB = new CheckboxItem("newSamplesCB", "New Samples");
        comboBoxCB = new CheckboxItem("comboBoxCB", "ComboBox &amp; Family");
        



        filterForm.setFields(searchItem, numSamplesItem, ascendingItem, disabledModeCB, featuredCB, newSamplesCB, comboBoxCB);
	}

}
