// Document modified at : Wednesday, March 29, 2006 3:00:32 PM , by user : Didier LIROULET , from computer : SNOOPY-XP-PRO


//====================================================================================
// Open Computer and Software Inventory
// Copyleft Didier LIROULET 2006
// Web: http://ocsinventory.sourceforge.net

// This code is open source and may be copied and modified as long as the source
// code is always made freely available.
// Please refer to the General Public Licence http://www.gnu.org/ or Licence.txt
//====================================================================================

// NetworkAdapterList.cpp: implementation of the CNetworkAdapterList class.
//
//////////////////////////////////////////////////////////////////////
#include "stdafx.h"
#include "NetworkAdapter.h"
#include "NetworkAdapterList.h"
#include "OcsCrypto.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif
//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////
CNetworkAdapterList::CNetworkAdapterList()
{
}

CNetworkAdapterList::~CNetworkAdapterList()
{
}

BOOL CNetworkAdapterList::SetIpAddrEntry(LONG lIfIndex, LPCTSTR lpstrIPAddr, LPCTSTR lpstrIPNetMask, LPCTSTR lpstrNetNumber)
{
	CNetworkAdapter cAdapter;
	POSITION	 pPosCur,
				 pPosNext;

	pPosNext = GetHeadPosition();
	pPosCur = GetHeadPosition();
	while (pPosNext != NULL)
	{
		cAdapter = GetNext( pPosNext);
		if (cAdapter.GetIfIndex() == lIfIndex)
		{
			// That's the adapter to update
			cAdapter.SetIPAddress( lpstrIPAddr);
			cAdapter.SetIPNetMask( lpstrIPNetMask);
			cAdapter.SetNetNumber( lpstrNetNumber );
			SetAt( pPosCur, cAdapter);
			return TRUE;
		}
		// Browse the next adapter and save the adapter position in the list
		pPosCur = pPosNext;
	}
	return FALSE;
}

// Didier LIROULET 2005-10-17 BEGIN
BOOL CNetworkAdapterList::SetIpRouteEntry(LONG lIfIndex, LPCTSTR lpstrGateway)
{
	CNetworkAdapter cAdapter;
	POSITION	 pPosCur,
				 pPosNext;

	pPosNext = GetHeadPosition();
	pPosCur = GetHeadPosition();
	while (pPosNext != NULL)
	{
		cAdapter = GetNext( pPosNext);
		if (cAdapter.GetIfIndex() == lIfIndex)
		{
			// That's the adapter to update
			cAdapter.SetGateway( lpstrGateway);
			SetAt( pPosCur, cAdapter);
			return TRUE;
		}
		// Browse the next adapter and save the adapter position in the list
		pPosCur = pPosNext;
	}
	return FALSE;
}
// Didier LIROULET 2005-10-17 END

BOOL CNetworkAdapterList::SetIpAddrEntry(LPCTSTR lpstrMAC, LPCTSTR lpstrIPAddr, LPCTSTR lpstrIPNetMask , LPCTSTR lpstrGateway, LPCTSTR lpstrDhcpServer, LPCTSTR lpstrNetNumber)
{
	CNetworkAdapter cAdapter;
	POSITION	 pPosCur,
				 pPosNext;

	pPosNext = GetHeadPosition();
	pPosCur = GetHeadPosition();
	while (pPosNext != NULL)
	{
		cAdapter = GetNext( pPosNext);
		if (_tcscmp( cAdapter.GetMACAddress(), lpstrMAC) ==0)
		{
			// That's the adapter to update
			cAdapter.SetIPAddress( lpstrIPAddr);
			cAdapter.SetIPNetMask( lpstrIPNetMask);
			cAdapter.SetGateway( lpstrGateway);
			cAdapter.SetDhcpServer( lpstrDhcpServer);
			cAdapter.SetNetNumber( lpstrNetNumber );
			SetAt( pPosCur, cAdapter);
			return TRUE;
		}
		// Browse the next adapter and save the adapter position in the list
		pPosCur = pPosNext;
	}
	return FALSE;
}

CString CNetworkAdapterList::GetMaskByGateway(CString gtw)
{
	CNetworkAdapter cAdapter;
	POSITION	pPosNext;

	pPosNext = GetHeadPosition();
	while (pPosNext != NULL)
	{
		cAdapter = GetNext( pPosNext);
		if (gtw.Compare(cAdapter.GetGateway()) == 0 )
		{
			return cAdapter.GetIPNetMask();
		}		
	}
	return _T("");
}

CString CNetworkAdapterList::GetMaskByNetNumber(CString nbr)
{
	CNetworkAdapter cAdapter;
	POSITION	pPosNext;

	pPosNext = GetHeadPosition();
	while (pPosNext != NULL)
	{
		cAdapter = GetNext( pPosNext);
		if (nbr.Compare(cAdapter.GetNetNumber()) == 0 )
		{
			return cAdapter.GetIPNetMask();
		}		
	}
	return _T("");
}
CString CNetworkAdapterList::GetIpByGateway(CString gtw)
{
	CNetworkAdapter cAdapter;
	POSITION	pPosNext;

	pPosNext = GetHeadPosition();
	while (pPosNext != NULL)
	{
		cAdapter = GetNext( pPosNext);
		if (gtw.Compare(cAdapter.GetGateway()) == 0 )
		{
			return cAdapter.GetIPAddress();
		}		
	}
	return _T("");
}
LPCTSTR CNetworkAdapterList::GetHash()
{
	COcsCrypto	myHash;
	CNetworkAdapter myObject;
	POSITION	pos;
	BOOL		bContinue;
	CString		csToHash;

	if (!myHash.HashInit())
		return NULL;
	pos = GetHeadPosition();
	bContinue = (pos != NULL);
	if (bContinue)
		// There is one record => get the first
		myObject = GetNext( pos);
	while (bContinue)
	{
		csToHash.Format( _T( "%s%s%s%s%s%s%s%s%s%s"), myObject.GetDescription(), myObject.GetType(),
						 myObject.GetTypeMIB(), myObject.GetSpeed(), myObject.GetMACAddress(),
						 myObject.GetOperationalStatus(), myObject.GetIPAddress(), myObject.GetIPNetMask(),
						 myObject.GetGateway(), myObject.GetDhcpServer());
		myHash.HashUpdate( LPCTSTR( csToHash), csToHash.GetLength());
		bContinue = (pos != NULL);
		if (bContinue)
			myObject = GetNext( pos);
	}
	return myHash.HashFinal();
}
