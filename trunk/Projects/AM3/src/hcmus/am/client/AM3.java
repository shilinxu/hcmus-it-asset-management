package hcmus.am.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AM3 implements EntryPoint {
	private final TrangThaiServiceAsync trangthaiService = GWT.create(TrangThaiService.class); 
	@Override
	public void onModuleLoad() {	
		RootPanel root = RootPanel.get();
		final Button b = new Button();
		b.setText("Click to me");
	//	Viewport v = new Viewport();
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
							b.setText(caught.getMessage());
						}; 
					});
				} else {
					b.setText("Click to me");
				}
			}
		});
		root.add(b);
		
	}
}