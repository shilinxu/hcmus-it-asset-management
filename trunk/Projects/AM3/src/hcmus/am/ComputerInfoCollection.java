package hcmus.am;

import hcmus.am.client.entity.ThietBiEntity;
import hcmus.am.client.entity.ThongSoLoaiThietBiEntity;
import hcmus.am.client.entity.ThongSoThietBiEntity;
import hcmus.am.dao.LoaiThietBiDao;
import hcmus.am.dao.ThietBiDao;
import hcmus.am.dao.ThongSoLoaiThietBiDAO;
import hcmus.am.dao.ThongSoThietBiDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AC2
 */
public class ComputerInfoCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/***
	 * ThongSo[i][0]: name of thiet bi
	 * THongSo[i][1->n]: ThongSo of thiet bi 
	 */
	public static String[][] ThongSo = new String[][] {
		{"MAINBOARD",
		"MODEL"}
		,
		{"CPU",
		"SPEED"}
		,
		{"RAM",
		"CAPACITY",
		"TYPE",
		"SPEED",
		"SLOTID"}
		,
		{"GPU",
		"CHIPSET",
		"MEMORY"}
		,
		{"MONITOR",
		"TYPE",
		"SERIALNUMBER"}
		,
		{"SOUNDCARD"}
		,
		{"KEYBOARD"}
		,
		{"HARDDISK",
		"MODEL",
		"SIZE"}
		,
		{"CD,DVD",
		"MODEL"}
		,
		{"NETWORKADAPTER",
		"SPEED",
		"MAC",
		"IP"}
		,		
		{"PRINTER",
		"DRIVER"}
		,
		{"OS",
		"VERSION",
		"COMMENT"}
		,
		{"MOUSE"}		
		};

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComputerInfoCollection() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO: Kiem tra MAC address de lay ID may tinh da ton tai hay chua. 
		//		NEU da ton tai,  thi luu lai thong so nay, luu lai 1 cau hinh moi nhat, de sau nay so sanh.
		//con neu ko thi them 1 may tinh moi, trang thai la moi phat hien.
		
		//Tao mot Desktop moi ghi vao csdl.
		ThietBiEntity desktopEnt = new ThietBiEntity();

		desktopEnt.IdLoaiThietBi = LoaiThietBiDao.selectByName("DESKTOP").IdLoaiThietBi;
		desktopEnt.Name = "New"; //name of may tinh.
		desktopEnt.IdThietBi = ThietBiDao.insert(desktopEnt);

		if (desktopEnt.IdThietBi == -1 )
		{
			response.getWriter().println("Insert DESKTOP fail");
			return;
		}
		String szThongSo, szNumberThietBi;		
		int numberOfThietBi = 0;
		for (int iLoaiThietBi = 0; iLoaiThietBi < ThongSo.length; iLoaiThietBi++) {
			String szLoaiThietBi = ThongSo[iLoaiThietBi][0];
			szNumberThietBi =  request.getParameter(szLoaiThietBi);
			if (szNumberThietBi == null || szNumberThietBi.equals("")) {
				numberOfThietBi = 0;
			} else {
				numberOfThietBi = Integer.parseInt(szNumberThietBi);
			}
			
			for (int iThietBi = 0; iThietBi < numberOfThietBi; iThietBi++ ) {				
				ThietBiEntity ent = new ThietBiEntity();
				String  prefix = szLoaiThietBi + "_" + Integer.toString(iThietBi) +"_";
				
				ent.IdLoaiThietBi = LoaiThietBiDao.selectByName(szLoaiThietBi).IdLoaiThietBi;				
				ent.Caption = request.getParameter(prefix + "CAPTION");
				ent.Description = request.getParameter(prefix + "DESCRIPTION");
				ent.Manufacturer = request.getParameter(prefix + "MANUFACTURER");
				ent.Name = request.getParameter(prefix + "NAME");				
				ent.IdThietBi = ThietBiDao.insert(ent);

				for (int iThongSo = 1; iThongSo < ThongSo[iLoaiThietBi].length; iThongSo++) {					
					//szThongSo = ThongSo[iThietBi][iThongSo].replace('0',(char)('0'+ numberOfThietBi));					
					szThongSo = (String)request.getParameter(prefix + ThongSo[iLoaiThietBi][iThongSo]);
					ThongSoLoaiThietBiEntity ts = ThongSoLoaiThietBiDAO.selectByName(ent.IdLoaiThietBi, ThongSo[iLoaiThietBi][iThongSo]);					
					if ( ts == null) { // truong hop 1: khong tim thay loai thong so.
						System.out.println(prefix + ThongSo[iLoaiThietBi][iThongSo]);
						continue;
					}
					ThongSoThietBiEntity thongsoEnt = new ThongSoThietBiEntity();
					thongsoEnt.IdThietBi = ent.IdThietBi;
					thongsoEnt.IdThongSoLoaiThietBi = ts.IdThongSoLoaiThietBi;
					thongsoEnt.GiaTri = szThongSo;
					if (1 == ThongSoThietBiDao.insert(thongsoEnt)) { //chen thanh cong.
						//TODO: just debug, will delete it.
						response.getWriter().println(prefix + ThongSo[iLoaiThietBi][iThongSo] + "  " + szThongSo);						
					} else {
						System.out.println(prefix + ThongSo[iLoaiThietBi][iThongSo]);
					}
				}
				//TODO: chen xong 1 thiet bi cua desktop, add thiet bi nay nhu la mot thiet bi con cua desktop.				
			}	
		}
		Integer IdDesktop = ThietBiDao.GetIdDesktopByMACAddress(request.getParameter("NETWORKADAPTER_0_MAC"));
		//TODO: do het cac NETWORKADAPTER De tim ra duoc MAC ADDRESS. 
		//ThietBiEntity DesktopEnt = ThietBiDao.
	
		ThietBiEntity orginalDesktopEnt = null;
		if (IdDesktop != 0) {
			orginalDesktopEnt = ThietBiDao.selectById(IdDesktop);
			//delete tat cac cac the hien truoc do.
			ThietBiDao.SetThietBiGoc(desktopEnt, orginalDesktopEnt);
		} else {
			//danh dau la thiet bi moi.
			desktopEnt.Description = "new "; //blab blab blab...				
		}
		ThietBiDao.SetThietBiGoc(desktopEnt, orginalDesktopEnt);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ram = (String)request.getParameter("RAM");
		response.getWriter().println(ram);
	}

}
