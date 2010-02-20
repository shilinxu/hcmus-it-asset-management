// Document modified at : Wednesday, March 29, 2006 2:45:30 PM , by user : Didier LIROULET , from computer : SNOOPY-XP-PRO
//====================================================================================
// Open Computer and Software Inventory
// Copyleft Didier LIROULET 2006
// Web: http://ocsinventory.sourceforge.net
// This code is open source and may be copied and modified as long as the source
// code is always made freely available.
// Please refer to the General Public Licence http://www.gnu.org/ or Licence.txt
//====================================================================================
// StoragePeripheralList.cpp: implementation of the CStoragePeripheralList class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "StoragePeripheral.h"
#include "StoragePeripheralList.h"
#include "OcsCrypto.h"
#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////
CStoragePeripheralList::CStoragePeripheralList()
{
}
CStoragePeripheralList::~CStoragePeripheralList()
{
}
LPCTSTR CStoragePeripheralList::GetHash()
{
	COcsCrypto	myHash;
	CStoragePeripheral myObject;
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
		csToHash.Format( _T( "%s%s%s%s%s%s"), myObject.GetManufacturer(), myObject.GetModel(),
						 myObject.GetName(), myObject.GetDescription(), myObject.GetType(),
						 myObject.GetSizeString());
		myHash.HashUpdate( LPCTSTR( csToHash), csToHash.GetLength());
		bContinue = (pos != NULL);
		if (bContinue)
			myObject = GetNext( pos);
	}
	return myHash.HashFinal();
}
