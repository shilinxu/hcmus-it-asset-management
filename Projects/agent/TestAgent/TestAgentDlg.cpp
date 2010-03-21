// TestAgentDlg.cpp : implementation file
//

#include "stdafx.h"
#include "TestAgent.h"
#include "TestAgentDlg.h"
#include "SysInfo.h"
#ifdef _DEBUG
#define new DEBUG_NEW
#endif





// CAboutDlg dialog used for App About

class CAboutDlg : public CDialog
{
public:
	CAboutDlg();

// Dialog Data
	enum { IDD = IDD_ABOUTBOX };

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support

// Implementation
protected:
	DECLARE_MESSAGE_MAP()
};

CAboutDlg::CAboutDlg() : CDialog(CAboutDlg::IDD)
{
}

void CAboutDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
}

BEGIN_MESSAGE_MAP(CAboutDlg, CDialog)
END_MESSAGE_MAP()


// CTestAgentDlg dialog




CTestAgentDlg::CTestAgentDlg(CWnd* pParent /*=NULL*/)
	: CDialog(CTestAgentDlg::IDD, pParent)
{
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
}

void CTestAgentDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
}

BEGIN_MESSAGE_MAP(CTestAgentDlg, CDialog)
	ON_WM_SYSCOMMAND()
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	//}}AFX_MSG_MAP
	ON_BN_CLICKED(IDC_BUTTON1, &CTestAgentDlg::OnBnClickedButton1)
	ON_BN_CLICKED(IDC_BUTTON2, &CTestAgentDlg::OnBnClickedButton2)
END_MESSAGE_MAP()


// CTestAgentDlg message handlers

BOOL CTestAgentDlg::OnInitDialog()
{
	CDialog::OnInitDialog();

	// Add "About..." menu item to system menu.

	// IDM_ABOUTBOX must be in the system command range.
	ASSERT((IDM_ABOUTBOX & 0xFFF0) == IDM_ABOUTBOX);
	ASSERT(IDM_ABOUTBOX < 0xF000);

	CMenu* pSysMenu = GetSystemMenu(FALSE);
	if (pSysMenu != NULL)
	{
		CString strAboutMenu;
		strAboutMenu.LoadString(IDS_ABOUTBOX);
		if (!strAboutMenu.IsEmpty())
		{
			pSysMenu->AppendMenu(MF_SEPARATOR);
			pSysMenu->AppendMenu(MF_STRING, IDM_ABOUTBOX, strAboutMenu);
		}
	}

	// Set the icon for this dialog.  The framework does this automatically
	//  when the application's main window is not a dialog
	SetIcon(m_hIcon, TRUE);			// Set big icon
	SetIcon(m_hIcon, FALSE);		// Set small icon

	// TODO: Add extra initialization here

	return TRUE;  // return TRUE  unless you set the focus to a control
}

void CTestAgentDlg::OnSysCommand(UINT nID, LPARAM lParam)
{
	if ((nID & 0xFFF0) == IDM_ABOUTBOX)
	{
		CAboutDlg dlgAbout;
		dlgAbout.DoModal();
	}
	else
	{
		CDialog::OnSysCommand(nID, lParam);
	}
}

// If you add a minimize button to your dialog, you will need the code below
//  to draw the icon.  For MFC applications using the document/view model,
//  this is automatically done for you by the framework.

void CTestAgentDlg::OnPaint()
{
	if (IsIconic())
	{
		CPaintDC dc(this); // device context for painting

		SendMessage(WM_ICONERASEBKGND, reinterpret_cast<WPARAM>(dc.GetSafeHdc()), 0);

		// Center icon in client rectangle
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// Draw the icon
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialog::OnPaint();
	}
}

// The system calls this function to obtain the cursor to display while the user drags
//  the minimized window.
HCURSOR CTestAgentDlg::OnQueryDragIcon()
{
	return static_cast<HCURSOR>(m_hIcon);
}


void CTestAgentDlg::OnBnClickedButton1()
{
	// TODO: Add your control notification handler code here
	CWaitCursor		cWait;
	CDeviceProperties myPC;
	SysInfo			mySys;
	CString			str;
	POSITION		pos;
	BOOL			bContinue;

	myPC.RetrieveHardwareAndOS( &mySys, _T( ""));
	try {	
		WebForm wf;
		wf.setHost("http://nghdiep.appspot.com");
		wf.setScriptFile("/simple");	
		wf.putVariable("Mainboard", myPC.m_BIOS.GetDeviceName());
		char temp[1024];
		_itoa(myPC.GetNumberOfProcessors(), temp, 10);
		wf.putVariable("NumberOfProcessors", temp);

		wf.putVariable("IPAdress", myPC.GetIPAddress());
		wf.putVariable("OS", myPC.GetOSName());
		wf.putVariable("Speed", myPC.GetProcessorSpeed());
		wf.putVariable("BiosManufacturer", myPC.m_BIOS.GetBiosManufacturer());
		wf.putVariable("SystemManufacturer", myPC.m_BIOS.GetSystemManufacturer());
		

		//wf.putVariable("MOUSE", myPC.m_MemoryList.GetAt(0).GetDeviceName());
		//CMemorySlotList* lst = new CMemorySlotList();
		//mySys.getMemorySlots(lst);
		
		//wf.putVariable("RAM", lst->GetAt(0).GetDeviceName() );
		MessageBox(CString(wf.GetRequest().c_str()));		
		
		wf.sendRequest();		
		//SetTe(IDC_STATIC1, CString(wf.GetRequest().c_str()));
		char buff[1000 * 1024];
		if(wf.getResponse(buff,sizeof(buff)-1))
		{
			//MessageBox(CString(buff));// << endl;
			//cout << "Response length: " << strlen(buff) << endl;
		}
		else
		{
			MessageBox(_T("No response from server"));
		}
	}catch(WebFormException ex) {
		MessageBox(CString(ex.getMessage().c_str()));
	}
}

void CTestAgentDlg::OnSysInfo() 
{
	CWaitCursor		cWait;
	CDeviceProperties myPC;
	SysInfo			mySys;
	CString			str;
	POSITION		pos;
	BOOL			bContinue;

	/*remove( "c:\\TestSysInfo_trace.log");
	OpenLog( "c:\\TestSysInfo_trace", "-DEBUG");*/
	myPC.RetrieveHardwareAndOS( &mySys, _T( ""));
	try {	
		WebForm wf;
		wf.setHost("http://nghdiep.appspot.com");
		wf.setScriptFile("/simple");	
		wf.putVariable("Mainboard", myPC.m_BIOS.GetDeviceName());
		char temp[1024];
		_itoa(myPC.GetNumberOfProcessors(), temp, 10);

		//wf.putVariable("NumberOfProcessors", temp);
		//wf.putVariable("IPAdress", myPC.GetIPAddress());
		//wf.putVariable("OS", myPC.GetOSName());
		//wf.putVariable("Speed", myPC.GetProcessorSpeed());
		//wf.putVariable("BiosManufacturer", myPC.m_BIOS.GetBiosManufacturer());
		//wf.putVariable("SystemManufacturer", myPC.m_BIOS.GetSystemManufacturer());


		//wf.putVariable("MOUSE", myPC.m_MemoryList.GetAt(0).GetDeviceName());
		//CMemorySlotList* lst = new CMemorySlotList();
		//mySys.getMemorySlots(lst);

		//wf.putVariable("RAM", lst->GetAt(0).GetDeviceName() );

	/*	SysInfoLog( "------------------------------------------------------");
		SysInfoLog( "BIOS infos");
		SysInfoLog( "------------------------------------------------------");*/
		//wf.putVariable("System Manufacturer: %s", myPC.m_BIOS.GetSystemManufacturer());
		wf.putVariable("MAINBOARD_0_MANUFACTORER", myPC.m_BIOS.GetSystemManufacturer());
		
		//wf.putVariable("System Model: %s", myPC.m_BIOS.GetSystemModel());
		wf.putVariable("MAINBOARD_0_MODEL", myPC.m_BIOS.GetSystemModel());
		//wf.putVariable("System S/N: %s", myPC.m_BIOS.GetSystemSerialNumber());
		
		wf.putVariable("COMPUTER_TYPE", myPC.m_BIOS.GetMachineType());
		
		//wf.putVariable("BIOS Manufacturer: %s", myPC.m_BIOS.GetBiosManufacturer());
		//wf.putVariable("BIOS Version: %s", myPC.m_BIOS.GetBiosVersion());		
		//wf.putVariable("BIOS Date: %s", myPC.m_BIOS.GetBiosDate());		
		//wf.putVariable("Bios Hash: %s", myPC.m_BIOS.GetHash());	
		
		/*SysInfoLog( "------------------------------------------------------");
		SysInfoLog( "Processors infos");
		SysInfoLog( "------------------------------------------------------");*/
		//wf.putVariable("Number of Processors: %u", myPC.GetNumberOfProcessors());
		
		wf.putVariable("CPU_0_NAME", myPC.GetProcessorType());		
		wf.putVariable("CPU_0_SPEED", myPC.GetProcessorSpeed());

		/*SysInfoLog( "------------------------------------------------------");
		SysInfoLog( "Memory Slots infos");
		SysInfoLog( "------------------------------------------------------");*/
		CMemorySlot myMemSlot;
		pos = myPC.m_MemoryList.GetHeadPosition();
		bContinue = (pos != NULL);
		int count = 0;
		if (bContinue)
			// There is one record => get the first
			myMemSlot = myPC.m_MemoryList.GetNext( pos);
		while (bContinue)
		{
			bContinue = (pos != NULL);
			if (myMemSlot.GetType() != "" || myMemSlot.GetType() != "Empty slot") 
			{
				str.Format("RAM_%d_CAPTION", count);
				wf.putVariable(str, myMemSlot.GetCaption());

				str.Format("RAM_%d_DESCRIPTION", count);
				wf.putVariable(str , myMemSlot.GetDescription());

				str.Format("RAM_%d_CAPACITY", count);
				wf.putVariable(str, myMemSlot.GetCapacity());

				/*wf.putVariable("Usage: %s", myMemSlot.GetUsage());*/

				str.Format("RAM_%d_TYPE", count);
				wf.putVariable(str, myMemSlot.GetType());

				str.Format("RAM_%d_SPEED", count);
				wf.putVariable(str, myMemSlot.GetSpeed());

				str.Format("RAM_%d_SLOTID", count);
				_itoa(myMemSlot.GetSlotNumber(), temp, 10);
				wf.putVariable(str, temp);
				count++;
			}			
			if (pos != NULL)
			{
				myMemSlot = myPC.m_MemoryList.GetNext( pos);				
			}
		}
		count = 0;
		//wf.putVariable("Memory Slots Hash: %s", myPC.m_MemoryList.GetHash());
				
		/*SysInfoLog( "------------------------------------------------------");
		SysInfoLog( "Video Controlers infos");
		SysInfoLog( "------------------------------------------------------");*/
		CVideoAdapter myVideo;
		pos = myPC.m_VideoList.GetHeadPosition();
		bContinue = (pos != NULL);
		if (bContinue)
			// There is one record => get the first
			myVideo = myPC.m_VideoList.GetNext( pos);
		while (bContinue)
		{
			bContinue = (pos != NULL);
			
			str.Format("GPU_%d_NAME", count);
			wf.putVariable(str, myVideo.GetName());
			
			str.Format("GPU_%d_CHIPSET", count);
			wf.putVariable("Chipset: %s", myVideo.GetChipset());
			
			str.Format("GPU_%d_MEMORY", count);
			wf.putVariable(str, myVideo.GetMemory());

			count++;
			//wf.putVariable("Resolution: %s", myVideo.GetScreenResolution());
			
			if (pos != NULL)
			{
				myVideo = myPC.m_VideoList.GetNext( pos);
				
			}
		}
		count = 0;
		
		//wf.putVariable("Video Controlers Hash: %s", myPC.m_VideoList.GetHash());
		


		
		//SysInfoLog( "------------------------------------------------------");
		//SysInfoLog( "Desktop Monitors infos");
		//SysInfoLog( "------------------------------------------------------");
		CMonitor myMonitor;
		pos = myPC.m_MonitorList.GetHeadPosition();
		bContinue = (pos != NULL);
		if (bContinue)
			// There is one record => get the first
			myMonitor = myPC.m_MonitorList.GetNext( pos);
		while (bContinue)
		{
			bContinue = (pos != NULL);
			str.Format("MONITOR_%d_MANUFACTURER", count);
			wf.putVariable(str, myMonitor.GetManufacturer());
			
			str.Format("MONITOR_%d_CAPTION", count);
			wf.putVariable(str, myMonitor.GetCaption());
			
			str.Format("MONITOR_%d_DESCRIPTION", count);
			wf.putVariable(str, myMonitor.GetDescription());
			
			str.Format("MONITOR_%d_TYPE", count);
			wf.putVariable(str, myMonitor.GetType());
			
			str.Format("MONITOR_%d_SERIALNUMBER", count);
			wf.putVariable(str, myMonitor.GetSerial());
			count++;
			if (pos != NULL)
			{
				myMonitor = myPC.m_MonitorList.GetNext( pos);
				
			}
		}
		count = 0;
		
		//wf.putVariable("Monitors Hash: %s", myPC.m_MonitorList.GetHash());
		
		//SysInfoLog( "------------------------------------------------------");
		//SysInfoLog( "Sound Devices infos");
		//SysInfoLog( "------------------------------------------------------");
		CSoundDevice mySound;
		pos = myPC.m_SoundList.GetHeadPosition();
		bContinue = (pos != NULL);
		if (bContinue)
			// There is one record => get the first
			mySound = myPC.m_SoundList.GetNext( pos);
		while (bContinue)
		{
			bContinue = (pos != NULL);
			str.Format("SOUNDCARD_%d_MANUFACTURER", count);
			wf.putVariable("Manufacturer: %s", mySound.GetManufacturer());
			str.Format("SOUNDCARD_%d_NAME", count);
			wf.putVariable("Name: %s", mySound.GetName());
			str.Format("SOUNDCARD_%d_DESCRIPTION", count);
			wf.putVariable("Description: %s", mySound.GetDescription());
			count++;
			if (pos != NULL)
			{
				mySound = myPC.m_SoundList.GetNext( pos);
				
			}
		}
		count = 0;
		//IMPORTANT: delete System Port infos// System Slots infos

		/*SysInfoLog( "------------------------------------------------------");
		SysInfoLog( "Input Devices infos");
		SysInfoLog( "------------------------------------------------------");*/

		CInputDevice myInput;
		pos = myPC.m_InputList.GetHeadPosition();
		bContinue = (pos != NULL);
		if (bContinue)
			// There is one record => get the first
			myInput = myPC.m_InputList.GetNext( pos);
		int keyboardNo = 0, mouseNo = 0;
		CString prefix;
		bool valid = true;
		while (bContinue)
		{
			bContinue = (pos != NULL);			
			if (myInput.GetPointingType() == "Keyboard")
			{
				prefix.Format("KEYBOARD_%d_", keyboardNo);
				keyboardNo++;
			}else if (myInput.GetPointingType() == "Pointing"){
				prefix.Format("MOUSE_%d_", mouseNo);
				mouseNo++;
			} else {
				valid = false;
			}
			//wf.putVariable("Type: %s", myInput.GetType());
			if (valid) {
				str.Format("%sMANUFACTURER", prefix);
				wf.putVariable(str, myInput.GetManufacturer());

				str.Format("%sCAPTION", prefix);
				wf.putVariable(str, myInput.GetCaption());

				str.Format("%sDESCRIPTION", prefix);
				wf.putVariable(str, myInput.GetDescription());

		/*		wf.putVariable("PointingType: %s", myInput.GetPointingType());
				wf.putVariable("Pointing Interface: %s", myInput.GetPointingInterface());*/
			}
			if (pos != NULL)
			{
				myInput = myPC.m_InputList.GetNext( pos);
			}
		}

		wf.putVariable("Input Devices Hash: %s", myPC.m_InputList.GetHash());

		//** IMPORTANT: delete System Controlers infos
		/*SysInfoLog( "------------------------------------------------------");
		SysInfoLog( "Storage Peripherals infos");
		SysInfoLog( "------------------------------------------------------");*/
		CStoragePeripheral myStorage;
		pos = myPC.m_StorageList.GetHeadPosition();
		bContinue = (pos != NULL);
		if (bContinue)
			// There is one record => get the first
			myStorage = myPC.m_StorageList.GetNext( pos);
		int hardDiskNo = 0, CDNo = 0;
		while (bContinue)
		{
			bContinue = (pos != NULL);
			valid = true;
			if ("Fixed" == myStorage.GetType()){
				prefix.Format("HARDDISK_%d_", hardDiskNo);
				hardDiskNo++;				
			} else if ("CD-ROM" == myStorage.GetType()) {
				prefix.Format("CD,DVD_%d_", CDNo);
				CDNo++;				
			} else {
				valid = false;
			}
			if (valid) {
				str.Format("%sMANUFACTURER", prefix);
				wf.putVariable(str, myStorage.GetManufacturer());

				str.Format("%sNAME", prefix);
				wf.putVariable("Name: %s", myStorage.GetName());
				
				str.Format("%sMODEL", prefix);
				wf.putVariable("Model: %s", myStorage.GetModel());

				str.Format("%sDESCRIPTION", prefix);
				wf.putVariable("Description: %s", myStorage.GetDescription());
				
				str.Format("%sSIZE", prefix);
				_itoa(myStorage.GetSize(),temp, 10);
				wf.putVariable(str, temp);
			}
			if (pos != NULL)
			{
				myStorage = myPC.m_StorageList.GetNext( pos);
				
			}
		}
		
		//wf.putVariable("Storage Peripherals Hash: %s", myPC.m_StorageList.GetHash());
		


		/*
		SysInfoLog( "------------------------------------------------------");
		SysInfoLog( "Network Adapters infos");
		SysInfoLog( "------------------------------------------------------");*/
		CNetworkAdapter myNetwork;
		pos = myPC.m_NetworkList.GetHeadPosition();
		bContinue = (pos != NULL);
		if (bContinue)
			// There is one record => get the first
			myNetwork = myPC.m_NetworkList.GetNext( pos);
		while (bContinue)
		{
			//NETWORKADAPTER_0_DESCRIPTION
			//NETWORKADAPTER_0_SPEED
			//NETWORKADAPTER_0_MAC
			//NETWORKADAPTER_0_IP
			bContinue = (pos != NULL);

			//wf.putVariable(str, myNetwork.GetType());
			str.Format("NETWORKADAPTER_0_DESCRIPTION", count);
			wf.putVariable(str, myNetwork.GetDescription());
			
			str.Format("NETWORKADAPTER_0_SPEED", count);
			wf.putVariable(str, myNetwork.GetSpeed());
			
			str.Format("NETWORKADAPTER_0_MAC", count);
			wf.putVariable(str, myNetwork.GetMACAddress());

			str.Format("NETWORKADAPTER_%d_IP", count);
			wf.putVariable(str, myNetwork.GetIPAddress());
			count++;
			//wf.putVariable("IP mask: %s", myNetwork.GetIPNetMask());
			//wf.putVariable("IP Gateway: %s", myNetwork.GetGateway());
			//wf.putVariable("DHCP Server: %s", myNetwork.GetDhcpServer());
			//wf.putVariable("Status: %s", myNetwork.GetOperationalStatus());			
			//wf.putVariable("MIB Type: %s", myNetwork.GetTypeMIB());
			
			if (pos != NULL)
			{
				myNetwork = myPC.m_NetworkList.GetNext( pos);
				
			}
		}
		count = 0;
		//wf.putVariable("Network Adapters Hash: %s", myPC.m_NetworkList.GetHash());
		


		
		
		//delete "Telephony Modems infos");
		
		
		/*SysInfoLog( "------------------------------------------------------");
		SysInfoLog( "Printers infos");
		SysInfoLog( "------------------------------------------------------");
		*/
		CPrinter myPrinter;
		pos = myPC.m_PrinterList.GetHeadPosition();
		bContinue = (pos != NULL);
		if (bContinue)
			// There is one record => get the first
			myPrinter = myPC.m_PrinterList.GetNext( pos);
		while (bContinue)
		{
			bContinue = (pos != NULL);
			str.Format("PRINTER_%d_NAME", count);
			wf.putVariable(str, myPrinter.GetName());

			str.Format("PRINTER_%d_DRIVER", count);
			wf.putVariable(str, myPrinter.GetDriver());
			count++;
			//wf.putVariable("Port: %s", myPrinter.GetPort());
			
			if (pos != NULL)
			{
				myPrinter = myPC.m_PrinterList.GetNext( pos);
				
			}
		}
		count = 0;
		
		//wf.putVariable("Printers Hash: %s", myPC.m_PrinterList.GetHash());

/*
		
		SysInfoLog( "------------------------------------------------------");
		SysInfoLog( "OS infos");
		SysInfoLog( "------------------------------------------------------");
		*/
		wf.putVariable("OS_0_NAME", myPC.GetOSName());
		
		wf.putVariable("OS_0_VERSION", myPC.GetOSVersion());
		
		wf.putVariable("OS_0_COMMENT", myPC.GetOSComment());

		/*switch (myPC.GetDeviceType())
		{
		case WINDOWS_SERVER:
			str = _T( "Windows Server");
			break;
		case WINDOWS_NOTEBOOK:
			str = _T( "Windows Notebook");
			break;
		default:
			str = _T( "Windows Workstation");
			break;
		}
		
		wf.putVariable("Domain or Workgroup: %s", myPC.GetDomainOrWorkgroup());
		
		wf.putVariable("OS Registered Company: %s", myPC.GetWindowsRegisteredCompany());
		
		wf.putVariable("OS Registered Owner: %s", myPC.GetWindowsRegisteredOwner());
		
		wf.putVariable("OS Product ID : %s", myPC.GetWindowsProductID());
		
		
		wf.putVariable("Device Hash: %s", myPC.GetHash());
		*/

		
		MessageBox(wf.GetRequest().c_str());
		wf.sendRequest();		
		//SetTe(IDC_STATIC1, CString(wf.GetRequest().c_str()));
		char buff[1000 * 1024];
		if(wf.getResponse(buff,sizeof(buff)-1))
		{
			//MessageBox(CString(buff));// << endl;
			//cout << "Response length: " << strlen(buff) << endl;
		}
		else
		{
			MessageBox(_T("No response from server"));
		}
	}catch(WebFormException ex) {
		MessageBox(CString(ex.getMessage().c_str()));
	}
}
void CTestAgentDlg::OnBnClickedButton2()
{
	OnSysInfo();
	// TODO: Add your control notification handler code here
}
