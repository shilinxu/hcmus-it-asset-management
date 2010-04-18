package hcmus.am.client;


import hcmus.am.client.entity.NhomThietBiEntity;
import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.client.view.NhomThietBiTreeNode;
import hcmus.am.client.view.ThietBiRecord;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.TileRecord;
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
	public void onModuleLoad() {	
		final TreeGrid treeGrid = new TreeGrid();  
		treeGrid.setWidth(300);  
		treeGrid.setHeight(400);  

		TreeGridField formattedField = new TreeGridField("Name");  
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
				Integer a = event.getRecord().getAttributeAsInt("IdNhomThietBi");
				if (a != null)
					Window.alert(a.toString());
				else
					Window.alert("cho ma that");
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
		final TileGrid tileGrid = new TileGrid();  
		tileGrid.setTileWidth(194);  
		tileGrid.setTileHeight(165);  
		tileGrid.setHeight(400);  
		tileGrid.setWidth(800);  
		tileGrid.setShowAllRecords(true);  
		thietbiService.SelectN(new AsyncCallback<ArrayList<ThietBiEntity>>() {
			
			@Override
			public void onSuccess(ArrayList<ThietBiEntity> result) {
				tileGrid.setData(ThietBiRecord.getThietBiRecord(result));
				//getNewRecords());  
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		})
		;

		DetailViewerField pictureField = new DetailViewerField("picture");  
		pictureField.setType("image");  
		pictureField.setImageURLPrefix("cars/");  
		pictureField.setImageWidth(186);  
		pictureField.setImageHeight(120);  

		DetailViewerField nameField2 = new DetailViewerField("name");  
		DetailViewerField priceField = new DetailViewerField("price");  

		tileGrid.setFields(pictureField, nameField2, priceField);  

		HLayout navLayout = new HLayout();  
		navLayout.setMembers(treeGrid, tileGrid);  
		RootPanel.get().add(navLayout);		
	}

	public static CarRecord[] getNewRecords() {  
		return new CarRecord[]{  
				new CarRecord("2006 Bugatti Veyron 16.4", "£839,285", "bugatti_veyron.jpg", "It's the most expensive production car in the world, but many would argue that the Veyron is still a bargain, being the most powerful and the fastest. Not only does the Bugatti have a top speed of 253mph but it would out accelerate an F1 car to 100mph. There are just too many astonishing facts and figures to take in; the 16-cylinder engine alone with its four turbochargers and 10 radiators is a marvel. But perhaps the most crucial figure is its mind-bending 1001bhp maximum power. Although the Veyron is unspeakably expensive, it cost the VW Group (which owns Bugatti) more to design and build than it's ever likely to return in profit. It's simply a magnificent engineering achievement."),  
				new CarRecord("1931 Bugatti Royale Kellner Coupe", "£4.25 million at auction in 1987", "bugatti_royale.jpg", "In the beginning, Ettore Bugatti told the world that his cars would better those built by the likes of Rolls-Royce and Mercedes Benz. This Royale was his ultimate model and, as the name suggests, it was really only royalty of the day who could afford one. Just six were built, complete with 12.7 litre engines, but only four were sold during the 1930s. Bugatti kept the other two hidden on his French estate during World War II, safe from German invaders who would have had them requisitioned. In 1951, an American called Briggs Cunningham bought the two hidden Royales, exchanging them for cash and a couple of refrigerators. Both were displayed in Cunningham's California museum for 30 years. One was auctioned to an anonymous Japanese buyer at Christies in London in 1987 setting a new record for most valuable car, which hasn't been topped since."),  
				new CarRecord("2006 Pagani Zonda C12 F ", "£450,000", "pagani.jpg", "The ultimate version of Pagani's mid-engined supercar, and also the most costly. The 'F' stands for Fangio, the Formula One legend who had a hand in the original Zonda's development. Powered by a mid-mounted Mercedes V12 engine, the Zonda F is lighter and tauter than previous models, with a top speed of 199mph. Buy one and you'll also get a pair of driving shoes hand made by the Pope's cobbler."),  
				new CarRecord("2007 Shelby SSC Ultimate Aero TT", "£320,000", "shelby.jpg", "Built by Shelby as a direct rival for the Bugatti Veyron, the SSC has a top speed in excess of 250mph and a 0-60mph time of just 2.78 seconds. It recently set the official world record for fastest production car, after reaching 255mph on a timed run - although the Veyron is yet to attempt such a feat. Very occasionally you can even get a bargain on an SSC - one was sold recently on eBay for 'only' £210,000."),  
				new CarRecord("2007 Saleen S7 Twin Turbo", "Price: £400,000", "saleen.jpg", "Another American-built hypercar with excessive power - the S7's got a twin-turbo V8 which pumps out 750bhp. It's made entirely from carbon fibre and is mid-engined but despite these credentials, the S7 has been criticised for its sloppy handling and questionable quality of finish. After all it is 'handbuilt' which can too often mean 'shoddy'. Still, while it may not seem like good value for money, the Saleen is still one of the most expensive cars on the market today."),  
				new CarRecord("1929 Mercedes-Benz 8/250 SSK", " £3.6 million at auction in 2004", "benz-skk.jpg", "Race-bred SSKs dominated motorsport in the 1920s taking first, second and third place at the 1927 German Grand Prix and earning a reputation as the fastest sports cars in the world. It was the Bugatti Veyron of its day, hitting higher speeds and accelerating faster than had previously been thought possible of a motorcar. Most were destroyed during dramatic racing careers, making a mint SSK very rare now and pushing values up. Many have been rebuilt using some genuine parts from wrecked and rotten examples, but experts reckon there are only one or two original and perfect SSKs left in the world. This example, sold for £3.6 million was one of those rare cars."),  
				new CarRecord("2007 Lamborghini Reventon", "£795,000", "lamborghini_reventon.jpg", "With looks inspired by the Stealth Bomber, the Reventon is the most expensive Lamborghini ever built. Although the styling and interior are all new, mechanically it's very similar to the Murcielago LP640 - it gets the same 6.5 litre V12 and has identical performance, hitting 62mph in 3.4 seconds - which has caused many commentators to question the validity of the Reventon's stratospheric price tag. Only 20 will ever be built though and plenty of collectors, particularly in America, have been impressed enough to part with the cash."),  
				new CarRecord("1962 Ferrari 250 GTO", "£2.7 million at auction in 1991", "ferrari_gto.jpg", "It's the quintessential Italian supercar - front-engined, rear drive and stunningly beautiful. GTO stands for Gran Turismo Omologata (meaning homologation) because this 250 was built for GT racing, and manufacturers had to enter a race-spec version of a real production car. So the 250 GTO was designed to be as competitive on the track as it was accomplished on the road, and was also the last in a long line of Ferraris to use the classic 3.0 litre V12. Only 33 250 GTOs were ever built, even though the minimum for production car status was 100. The regulations were, as they so often have been, bent by the weight of Maranello. But it meant the 250 GTO is now not only a stunning, but also a rare performance car, which has only made it more valuable. Now most commentators reckon that, should one be sold again, the 250 GTO would be the most valuable Ferrari in the world."),  
				new CarRecord("1937 Alfa-Romeo 8C-2900", "£2 million at auction in 1999", "alfa_romeo.jpg", "Many consider the original 8C to be the greatest pre-war sports car of them all and so it's extremely rare that one comes up for sale. This example of the roadster was auctioned in 1999, and has a proper racing heritage, finishing third at the Mille Miglia in 1939. The 8C-2900 is powered by an 8-cylinder 2.9 litre engine, which produced 180bhp in production form and 220bhp in race spec. There are even more valuable examples than this one, which have a special Mille Miglia bodystyling."),  
				new CarRecord("2007 Rolls-Royce Phantom Drophead Coupe", "£305,500", "rolls_royce_phantom.jpg", "That's the starting price and for it, you'll have to do without the optional 'teak decking'. The Phantom is considered to be one of the finest cars in the world, but this convertible version is just a bit more flash. It's got a 6.5 litre V12 that's silky smooth in its power delivery and cossets all occupants from the moment they climb through its huge doors. A high price, but seen as worth every penny by some - Rolls-Royce sales are steadily creeping up."),  
				new CarRecord("2007 McLaren-Mercedes SLR 722 GTR", "£334,300", "mclaren.jpg", "This is a racing version of the McLaren-Mercedes supercar, which owners could potentially race in the GT1 sports car championship if they were so inclined. Developed in secret, the 722 GTR popped up at a German dealership with a £450,000 price tag earlier this year. Only 21 of these stripped-down, track-prepared SLRs will be built and each sports a massive ring wing and front diffuser for extra downforce as well as a roll cage for added protection. The engine still produces 650bhp but the GTR is 300kg lighter, dramatically improving performance. So if you're mega-rich and want to be a McLaren racing driver, this is the car for you."),  
				new CarRecord("1994 McLaren F1", "£540,000 new, upwards of £850.000 today", "mclaren-f1.jpg", "For many years this was the fastest production cars in the world, fabled for its 242mph top speed and its ability to change direction quicker than a Gordon Brown election plan. The F1 uses a BMW 6.1 litre V12 which was naturally aspirated at the insistence of the car's legendary chief designer Gordon Murray. It still produced 624bhp though, and was mid-mounted in the featherweight chassis. The materials used to build the F1 went some way towards justifying its high price. Carbon fibre was used extensively to keep the weight down and the most efficient heat reflector, gold lining, was used as a film to insulate the engine bay. The philosophy was light weight and efficiency. Now it's extremely rare to see an F1 on the road let alone for sale, but that means the McLaren has gone up in value (even after taking inflation into account) since it was first built in 1994."),  
				new CarRecord("2007 Maybach 62 S", "£345,867", "maybach.jpg", "Luxurious and opulent, this is the world's greatest car according to Mercedes, which revived the Maybach brand back in 2001. Unfortunately, the rest of the world didn't agree. The Maybachs and their huge price tag are now seen as vulgar and ostentatious compared with the elegance of a Rolls-Royce Phantom or Bentley Arnarge. It's a car for 'new money' potential owners say, but that still makes it pricey enough for us - particularly when you consider the terrible residuals. Some owners have lost up to £150,000 in three years."),  
				new CarRecord("2006 Koenigsegg CCR", "£400,000", "koenigsegg-ccr.jpg", "The most powerful version of the Swedish supercar and - before the arrival of the Veyron and SSC Aero - the CCR was the fastest production car in the world. It topped out at 240mph at the Nardo proving grounds - the first car to break the McLaren F1's previous record, which had stood for 10 years. Incredibly, Koenigsegg has managed to coax over 800bhp from a Ford V8 for this CCR, one of the reasons why it's the company's ultimate and most expensive model. It was even considered worthy of the 'ghost' fighter badge, worn only by the planes of Swedish Jet Fighter Squadron No.1."),  
				new CarRecord("1953 GM Futurliner", "£2 million in 2006", "gm_futurliner.jpg", "A bit of an anomaly this - the Futurliner's value was thought to be more like £300,000 until it was auctioned. This was a concept vehicle that was paraded across America before the War as an example of General Motor's engineering prowess. Strong interest in pre-war prototypes like this, and one collectors' desire to own the oddity led to an unexpectedly high price."),  
				new CarRecord("2005 Porsche Carrera GT", "£310,000", "carrera_gt.jpg", "A thoroughbred from Stuttgart, the production Carrera GT could trace its lineage back to the 911- GT1 98 and LMP1 race cars. The 5.5 litre V10 used by the GT was originally designed for a Footworks Formula One car before the project was canned, and powers this ultimate Porsche from 0-62mph in 3.6 seconds and on to 205mph. But the Carrerra GT was not only fast but comfortable true, with a bespoke leather interior and Bose sound system. It was the ultimate autobahn basher before the model was discontinued in 2006, having sold over 1000 examples.")  
		}; 
	}


}
class CarRecord extends TileRecord{
	public CarRecord(String  str1, String  str2, String  str3, String  str4 )
	{
		setAttribute("name", str1);
		setAttribute("image", str3);
		setAttribute("price", str2);
	}
}

