// Document modified at : Friday, March 31, 2006 1:47:03 PM , by user : didier , from computer : SNOOPY-XP-PRO

//====================================================================================
// Open Computer and Software Inventory
// Copyleft Didier LIROULET 2006
// Web: http://ocsinventory.sourceforge.net

// This code is open source and may be copied and modified as long as the source
// code is always made freely available.
// Please refer to the General Public Licence http://www.gnu.org/ or Licence.txt
//====================================================================================

// BIOSInfo.h: interface for the CBios class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_BIOS_H__0769B90F_185D_424A_A8E9_121705E35122__INCLUDED_)
#define AFX_BIOS_H__0769B90F_185D_424A_A8E9_121705E35122__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "SysInfoClasses.h"


class DLL_CLASS CBios  
{
public: // Methods
	//////////////////////////////////
	// Standard contructor/destructor
	//////////////////////////////////
	CBios();
	virtual ~CBios();

	//////////////////////////////////
	// Get attributes values
	//////////////////////////////////

	// Return a string with the device unique ID
	LPCTSTR GetDeviceID();
	// Return a string with the device NetBIOS name
	LPCTSTR GetDeviceName();
	// Return the System manufacturer
	LPCTSTR GetSystemManufacturer();
	// Return the System model
	LPCTSTR GetSystemModel();
	// Return the System S/N
	LPCTSTR GetSystemSerialNumber();
	// Return the BIOS machine type
	LPCTSTR GetMachineType();
	// Return the BIOS manufacturer
	LPCTSTR GetBiosManufacturer();
	// Return the BIOS Version
	LPCTSTR GetBiosVersion();
	// Return the BIOS Date
	LPCTSTR GetBiosDate();
	// Return the BIOS Asset Tag
	LPCTSTR GetBiosAssetTag();
	// Format informations in a XML string
	BOOL FormatXML( CMarkup* pX );
	// Get hash code of data, to determine if changed since last inventory
	LPCTSTR GetHash();

	//////////////////////////////////
	// Set attributes values
	//////////////////////////////////

	// Read informations in a XML string
	BOOL ParseFromXML(CString &xml);
	// Set the device unique ID
	void SetDeviceID( LPCTSTR lpstrDeviceID);
	// Set the device NetBIOS name
	void SetDeviceName( LPCTSTR lpstrName);
	// Clear BIOS infos
	void Clear();
	// Set all BIOSInfo attributes
	void Set( LPCTSTR lpstrSystemManufacturer, LPCTSTR lpstrSystemModel, LPCTSTR lpstrSystemSerialNumber, LPCTSTR lpstrMachineType, LPCTSTR lpstrBiosManufacturer, LPCTSTR lpstrBiosVersion, LPCTSTR lpstrBiosDate, LPCTSTR lpstrBiosAssetTag);
	// Set System manufacturer
	void SetSystemManufacturer( LPCTSTR lpstrManufacturer);
	// Set System model
	void SetSystemModel( LPCTSTR lpstrModel);
	// Set System serial number
	void SetSystemSerialNumber( LPCTSTR lpstrSerialNumber);
	// Set BIOS machine type
	void SetMachineType( LPCTSTR lpstrMachineType);
	// Set BIOS manufacturer
	void SetBiosManufacturer( LPCTSTR lpstrManufacturer);
	// Set BIOS version
	void SetBiosVersion( LPCTSTR lpstrBiosVersion);
	// Set BIOS date
	void SetBiosDate( LPCTSTR lpstrBiosDate);
	// Set ASSET tag
	void SetBiosAssetTag( LPCTSTR lpstrBiosAssetTag);

protected: // Attributes
	CString		m_csDeviceID;			// Device unique ID
	CString		m_csDeviceName;			// Device netbios or DNS name
	CString		m_csSystemManufacturer;	// Device manufacturer
	CString		m_csSystemModel;		// Device model
	CString		m_csSystemSerialNumber;	// Device serial number
	CString		m_csMachineType;		// Device type (tower, mini-tower, pizza box...)
	CString		m_csBiosManufacturer;	// BIOS manufacturer
	CString		m_csBiosVersion;		// BIOS version
	CString		m_csBiosDate;			// BIOS date
	CString     m_csBiosAssetTag;           // ASSET tag
};
#endif // !defined(AFX_BIOS_H__0769B90F_185D_424A_A8E9_121705E35122__INCLUDED_)

