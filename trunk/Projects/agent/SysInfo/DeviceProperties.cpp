// Document modified at : Friday, March 31, 2006 3:44:35 PM , by user : didier , from computer : SNOOPY-XP-PRO

//====================================================================================
// Open Computer and Software Inventory
// Copyleft Didier LIROULET 2006
// Web: http://ocsinventory.sourceforge.net

// This code is open source and may be copied and modified as long as the source
// code is always made freely available.
// Please refer to the General Public Licence http://www.gnu.org/ or Licence.txt
//====================================================================================

// DeviceProperties.cpp: implementation of the CDeviceProperties class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "sysinfo.h"
#include "../include/_common/utils.h"
#include "OcsCrypto.h"

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CDeviceProperties::CDeviceProperties()
{
	Clear();
}

CDeviceProperties::~CDeviceProperties()
{
	Clear();
}

void CDeviceProperties::Clear()
{
	COleDateTime oleTimeNow;

	m_csDeviceID.Empty();		// Device unique ID
	m_csDeviceName.Empty();		// Device netbios name
	m_csDomain.Empty();			// Domain or workgroup
	m_csUserDomain.Empty();			// Domain or workgroup
	m_csOSName.Empty();			// OS Name of the device (ex "Windows NT")
	m_csOSVersion.Empty();		// OS Version of the device (ex "4.0 Build 1381")
	m_csOSComment.Empty();		// OS Comment of the device (ex "Service Pack 6")
	m_csProcessorType.Empty();	// First Processor type of the device (ex "Intel Pentium II Model 1280 Stepping 2")
	m_csProcessorSpeed.Empty(); // Processor speed
	m_dwNumberOfProcessor = 0;	// Number of processor of the device
	m_ulPhysicalMemory = 0;		// Physical memory of the device
	m_ulSwapSize = 0;		// Page File Size of the device
	m_csIPAddress.Empty();		// IP Address of the device if available (ex "192.3.4.1" or "Unavailable")
	m_csExecutionDuration = _T( "00:00:00"); // Duration of the inventory check
	m_csLoggedOnUser.Empty();	// Logged on user when device has been checked
	m_csLastLoggedUser.Empty();	// Last user who'd been logged in
	m_csDescription.Empty();	// Device description extracted from OS
	m_csWinRegCompany.Empty();	// Windows registered company
	m_csWinRegOwner.Empty();	// Windows registered owner
	m_csWinRegProductID.Empty();// Windows registered product ID
	oleTimeNow.SetDate( 1970, 1, 1);
	m_csLastCheckDate = oleTimeNow.Format( _T( "%Y-%m-%d"));
	m_BIOS.Clear();
	m_CommentList.RemoveAll();
	m_DriveList.RemoveAll();
	m_InputList.RemoveAll();
	m_InventoryList.RemoveAll();
	m_MemoryList.RemoveAll();
	m_ModemList.RemoveAll();
	m_MonitorList.RemoveAll();
	m_NetworkList.RemoveAll();
	m_PortList.RemoveAll();
	m_PrinterList.RemoveAll();
	m_RegistryList.RemoveAll();
	m_RepairList.RemoveAll();
	m_SlotList.RemoveAll();
	m_SoftwareList.RemoveAll();
	m_SoundList.RemoveAll();
	m_StorageList.RemoveAll();
	m_SystemControllerList.RemoveAll();
	m_VideoList.RemoveAll();
	m_uType = NEW_DEVICE;
	m_ulChecksum = 0;			// No changes detected
}

void CDeviceProperties::GenerateUID()
{
	AddLog( _T( "Generating Unique ID for device <%s>..."), m_csDeviceName);
	COleDateTime myDate = COleDateTime::GetCurrentTime();

	m_csDeviceID.Format( _T( "%s-%s"),
						m_csDeviceName, 
						myDate.Format( _T( "%Y-%m-%d-%H-%M-%S")));
	AddLog( _T( "OK (%s)\n"), m_csDeviceID);
}

void CDeviceProperties::SetDeviceID(LPCTSTR lpstrDeviceID)
{
	m_csDeviceID = lpstrDeviceID;
	StrForSQL( m_csDeviceID);
}

void CDeviceProperties::SetDeviceName(LPCTSTR lpstrName)
{
	m_csDeviceName = lpstrName;
	StrForSQL( m_csDeviceName);
}

void CDeviceProperties::SetOS(LPCTSTR lpstrName, LPCTSTR lpstrVersion, LPCTSTR lpstrComment)
{
	m_csOSName = lpstrName;
	StrForSQL( m_csOSName);
	m_csOSVersion = lpstrVersion;
	StrForSQL( m_csOSVersion);
	m_csOSComment = lpstrComment;
	StrForSQL( m_csOSComment);
}

void CDeviceProperties::SetProcessor(LPCTSTR lpstrName, LPCTSTR lpstrSpeed, DWORD dwNumber)
{
	m_csProcessorType = lpstrName;
	StrForSQL( m_csProcessorType);
	m_csProcessorSpeed = lpstrSpeed;
	StrForSQL( m_csProcessorSpeed);
	m_dwNumberOfProcessor = dwNumber;
}

void CDeviceProperties::SetMemory(ULONG ulPhysical, ULONG ulPageFile)
{
	m_ulPhysicalMemory = ulPhysical;
	m_ulSwapSize = ulPageFile;
}

void CDeviceProperties::SetIPAddress(LPCTSTR lpstrIP)
{
	m_csIPAddress = lpstrIP;
	StrForSQL( m_csIPAddress);
}

void CDeviceProperties::SetLastCheckDate( LPCTSTR lpstrDate)
{
	m_csLastCheckDate = lpstrDate;
	StrForSQL( m_csLastCheckDate);
}

void CDeviceProperties::SetExecutionDuration( CTime &cBeginTime, CTime &cEndTime)
{
	CTimeSpan	cTimeExec;				// Time of execution

	// Format time execution
	cTimeExec = cEndTime - cBeginTime;
	// Format SQL query
	m_csExecutionDuration.Format( _T( "%.02d:%.02d:%.02d"), cTimeExec.GetHours(), cTimeExec.GetMinutes(), cTimeExec.GetSeconds());
}

void CDeviceProperties::SetExecutionDuration( LPCTSTR lpstrDuration)
{
	m_csExecutionDuration = lpstrDuration;
	StrForSQL( m_csExecutionDuration);
}

void CDeviceProperties::SetLoggedOnUser( LPCTSTR lpstrUser)
{
	m_csLoggedOnUser = lpstrUser;
	StrForSQL( m_csLoggedOnUser);
}

void CDeviceProperties::SetLastLoggedUser( LPCTSTR lpstrLastLoggedUser)
{
	m_csLastLoggedUser = lpstrLastLoggedUser;
	StrForSQL( m_csLastLoggedUser);
}


void CDeviceProperties::SetDescription( LPCTSTR lpstrDescription)
{
	m_csDescription = lpstrDescription;
	StrForSQL( m_csDescription);
}

void CDeviceProperties::SetDomainOrWorkgroup( LPCTSTR lpstrDomain)
{
	m_csDomain = lpstrDomain;
	StrForSQL( m_csDomain);
}

void CDeviceProperties::SetUserDomain( LPCTSTR lpstrUserDomain)
{
	m_csUserDomain = lpstrUserDomain;
	StrForSQL( m_csUserDomain);
}

void CDeviceProperties::SetWindowsProductKey( LPCTSTR lpstrWindowsKey)
{
	m_csWinProductKey = lpstrWindowsKey;
	StrForSQL( m_csWinProductKey );
}

void CDeviceProperties::SetWindowsRegistration( LPCTSTR lpstrCompany, LPCTSTR lpstrOwner, LPCTSTR lpstrProductID)
{
	m_csWinRegCompany = lpstrCompany;
	StrForSQL( m_csWinRegCompany);
	m_csWinRegOwner = lpstrOwner;
	StrForSQL( m_csWinRegOwner);
	m_csWinRegProductID = lpstrProductID;
	StrForSQL( m_csWinRegProductID);
}

void CDeviceProperties::SetDeviceType( UINT uType)
{
	m_uType = uType;
}

void CDeviceProperties::SetChecksum( ULONG ulChecksum)
{
	m_ulChecksum = ulChecksum;
}

LPCTSTR CDeviceProperties::GetDeviceID()
{
	return m_csDeviceID;
}

LPCTSTR CDeviceProperties::GetDeviceName()
{
	return m_csDeviceName;
}

LPCTSTR CDeviceProperties::GetOSName()
{
	return m_csOSName;
}

LPCTSTR CDeviceProperties::GetOSVersion()
{
	return m_csOSVersion;
}

LPCTSTR CDeviceProperties::GetOSComment()
{
	return m_csOSComment;
}

LPCTSTR CDeviceProperties::GetProcessorType()
{
	return m_csProcessorType;
}

LPCTSTR CDeviceProperties::GetProcessorSpeed()
{
	return m_csProcessorSpeed;
}

DWORD CDeviceProperties::GetNumberOfProcessors()
{
	return m_dwNumberOfProcessor;
}

ULONG CDeviceProperties::GetPhysicalMemory()
{
	return m_ulPhysicalMemory;
}

ULONG CDeviceProperties::GetPageFileSize()
{
	return m_ulSwapSize;
}

LPCTSTR CDeviceProperties::GetIPAddress()
{
	return m_csIPAddress;
}
LPCTSTR CDeviceProperties::GetExecutionDuration()
{
	return m_csExecutionDuration;
}

LPCTSTR CDeviceProperties::GetLastCheckDate()
{
	return m_csLastCheckDate;
}

LPCTSTR CDeviceProperties::GetLoggedOnUser()
{
	return m_csLoggedOnUser;
}

LPCTSTR CDeviceProperties::GetLastLoggedUser()
{
	return m_csLastLoggedUser;
}

LPCTSTR CDeviceProperties::GetDescription()
{
	return m_csDescription;
}

LPCTSTR CDeviceProperties::GetDomainOrWorkgroup()
{
	return m_csDomain;
}

LPCTSTR CDeviceProperties::GetUserDomain()
{
	return m_csUserDomain;
}

LPCTSTR CDeviceProperties::GetWindowsRegisteredCompany()
{
	return m_csWinRegCompany;
}

LPCTSTR CDeviceProperties::GetWindowsRegisteredOwner()
{
	return m_csWinRegOwner;
}

LPCTSTR CDeviceProperties::GetWindowsProductID()
{
	return m_csWinRegProductID;
}

LPCTSTR CDeviceProperties::GetWindowsProductKey()
{
	return m_csWinProductKey;
}

UINT CDeviceProperties::GetDeviceType()
{
	return m_uType;
}

ULONG CDeviceProperties::GetChecksum()
{
	return m_ulChecksum;
}

BOOL CDeviceProperties::RetrieveHardwareAndOS(SysInfo * myPC, LPCSTR cmdL)
{
	// Get logged on user
	CUtils::trace("USERNAME",cmdL);
	myPC->getUserName( m_csLoggedOnUser);

	// Get the last user who'd been logged in
	myPC->getLastLoggedUser( m_csLastLoggedUser);

	// Get OS informations and device type (windows station or windows server)
	CUtils::trace("OS",cmdL);
	m_uType = myPC->getOS( m_csOSName, m_csOSVersion, m_csOSComment, m_csDescription);

	// Check if it is a notebook
	/*CUtils::trace("NOTEBOOK",cmdL);
	if (myPC->isNotebook())
		m_uType = WINDOWS_NOTEBOOK;
	AddLog( _T( "Detected device type: %u.\n"), m_uType);*/

	// Get NT Domain or Workgroup
	CUtils::trace("NT_DOMAIN",cmdL);
	myPC->getDomainOrWorkgroup( m_csDomain);

	// Get NT user Domain
	CUtils::trace("NT_USER_DOMAIN",cmdL);
	myPC->getUserDomain( m_csUserDomain);
	

	// Get BIOS informations
	CUtils::trace("BIOS",cmdL);
	myPC->getBiosInfo( &m_BIOS);

	// Get Processor infos
	CUtils::trace("CPU",cmdL);
	m_dwNumberOfProcessor = myPC->getProcessors( m_csProcessorType, m_csProcessorSpeed);

	// Get memory informations
	CUtils::trace("RAM",cmdL);
	myPC->getMemory( &m_ulPhysicalMemory, &m_ulSwapSize);
	myPC->getMemorySlots( &m_MemoryList);

	// Get Input Devices
	CUtils::trace("INPUT",cmdL);
	myPC->getInputDevices( &m_InputList);

	// Get System ports
	CUtils::trace("PORTS",cmdL);
	myPC->getSystemPorts( &m_PortList);

	// Get System Slots
	CUtils::trace("SLOTS",cmdL);
	myPC->getSystemSlots( &m_SlotList);

	// Get System controlers
	CUtils::trace("CONTROLLERS",cmdL);
	myPC->getSystemControllers( &m_SystemControllerList);

	// Get Physical storage devices
	CUtils::trace("STORAGE",cmdL);
	myPC->getStoragePeripherals( &m_StorageList);

	// Get Sound Devices
	CUtils::trace("SOUND",cmdL);
	myPC->getSoundDevices( &m_SoundList);

	// Get Modems
	CUtils::trace("MODEMS",cmdL);
	myPC->getModems( &m_ModemList);

	// Get network adapter(s) hardware and IP informations
	CUtils::trace("NETWORK",cmdL);
	myPC->getNetworkAdapters( &m_NetworkList);

	// Get Printer(s) informations
	CUtils::trace("PRINTER",cmdL);
	myPC->getPrinters( &m_PrinterList);

	// Get Video adapter(s) informations
	CUtils::trace("VIDEO",cmdL);
	myPC->getVideoAdapters( &m_VideoList);
	CUtils::trace("MONITORS",cmdL);
	myPC->getMonitors( &m_MonitorList);

	// Get the primary local IP Address 
	CUtils::trace("IP",cmdL);
	m_csIPAddress = myPC->getLocalIP();

	// Get Windows registration infos
	CUtils::trace("REGISTRATION",cmdL);
	myPC->getWindowsRegistration( m_csWinRegCompany, m_csWinRegOwner, m_csWinRegProductID);

	// Get Windows product key
	CUtils::trace("PRODUCT KEY",cmdL);
	myPC->getWindowsProductKey( m_csWinProductKey );

	// Get apps from registry
	CUtils::trace("REGAPPS",cmdL);
	myPC->getRegistryApplications( &m_SoftwareList, CUtils::IsRequired(cmdL,"hkcu"));
	return TRUE;
}
BOOL CDeviceProperties::FormatXML(CMarkup* pX)
{

// HARDWARE keys are unique. I do a look up to see an external script
// already created them.
// I've to scan every key from the begining of the section
#define GO_IN_HARDWARE pX->ResetPos();pX->FindElem("REQUEST"); \
	pX->IntoElem();pX->FindElem("CONTENT");pX->IntoElem();	if \
	(!pX->FindElem("HARDWARE")) {pX->AddElem("HARDWARE");} \
	pX->IntoElem();


GO_IN_HARDWARE
		if (!pX->FindElem("LASTLOGGEDUSER"))
			pX->AddElemNV("LASTLOGGEDUSER",m_csLastLoggedUser);

GO_IN_HARDWARE
		if (!pX->FindElem("NAME"))
			pX->AddElemNV("NAME",m_csDeviceName);

				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("WORKGROUP"))
			pX->AddElemNV("WORKGROUP",m_csDomain);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("USERDOMAIN"))
			pX->AddElemNV("USERDOMAIN",m_csUserDomain);
		if (!pX->FindElem("OSNAME"))
			pX->AddElemNV("OSNAME",m_csOSName);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("OSVERSION"))
			pX->AddElemNV("OSVERSION",m_csOSVersion);
GO_IN_HARDWARE
		if (!pX->FindElem("OSCOMMENTS"))
			pX->AddElemNV("OSCOMMENTS",m_csOSComment);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("PROCESSORT"))
			pX->AddElemNV("PROCESSORT",m_csProcessorType);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("PROCESSORS"))
			pX->AddElemNV("PROCESSORS",m_csProcessorSpeed);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("PROCESSORN"))
			pX->AddElemNV("PROCESSORN",m_dwNumberOfProcessor);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("MEMORY"))
			pX->AddElemNV("MEMORY",m_ulPhysicalMemory);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("SWAP"))
			pX->AddElemNV("SWAP",m_ulSwapSize);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("IPADDR"))
			pX->AddElemNV("IPADDR",m_csIPAddress);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("ETIME"))
			pX->AddElemNV("ETIME",m_csExecutionDuration);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("LASTDATE"))
			pX->AddElemNV("LASTDATE",m_csLastCheckDate);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("USERID"))
			pX->AddElemNV("USERID",m_csLoggedOnUser);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("TYPE"))
			pX->AddElemNV("TYPE",m_uType);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("DESCRIPTION"))
			pX->AddElemNV("DESCRIPTION",m_csDescription);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("WINCOMPANY"))
			pX->AddElemNV("WINCOMPANY",m_csWinRegCompany);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("WINOWNER"))
			pX->AddElemNV("WINOWNER",m_csWinRegOwner);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("WINPRODID"))
			pX->AddElemNV("WINPRODID",m_csWinRegProductID);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("WINPRODKEY"))
			pX->AddElemNV("WINPRODKEY",m_csWinProductKey);
				pX->ResetPos();
GO_IN_HARDWARE
		if (!pX->FindElem("CHECKSUM"))
			pX->AddElemNV("CHECKSUM",m_ulChecksum);

	pX->OutOfElem();
	return TRUE;
}
LPCTSTR CDeviceProperties::GetHash()
{
	COcsCrypto	myHash;
	static CString		csToHash;

	if (!myHash.HashInit())
		return NULL;
	csToHash.Format( _T( "%s%s%s%s%s%s%s%u%lu%s%s%s"), m_csDeviceName, m_csDomain, m_csOSName,
					 m_csOSVersion, m_csOSComment, m_csProcessorType,
					 m_csProcessorSpeed,m_dwNumberOfProcessor,m_ulPhysicalMemory,
					 m_csWinRegCompany, m_csWinRegOwner, m_csWinRegProductID);
	myHash.HashUpdate( LPCTSTR( csToHash), csToHash.GetLength());
	return myHash.HashFinal();
}
