// Document modified at : Wednesday, March 29, 2006 2:59:14 PM , by user : Didier LIROULET , from computer : SNOOPY-XP-PRO

//====================================================================================
// Open Computer and Software Inventory
// Copyleft Didier LIROULET 2006
// Web: http://ocsinventory.sourceforge.net

// This code is open source and may be copied and modified as long as the source
// code is always made freely available.
// Please refer to the General Public Licence http://www.gnu.org/ or Licence.txt
//====================================================================================

// LogicalDriveList.cpp: implementation of the CLogicalDriveList class.
//
//////////////////////////////////////////////////////////////////////
#include "stdafx.h"
#include "LogicalDrive.h"
#include "LogicalDriveList.h"
#include "OcsCrypto.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif
//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////
CLogicalDriveList::CLogicalDriveList()
{
}

CLogicalDriveList::~CLogicalDriveList()
{
}

LPCTSTR CLogicalDriveList::GetHash()
{
	COcsCrypto	myHash;
	CLogicalDrive myObject;
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
		csToHash.Format( _T( "%s%s%s%ld%ld%s"), myObject.GetDriveLetter(), myObject.GetDriveType(),
						 myObject.GetFileSystem(), myObject.GetTotalMB(), myObject.GetFreeMB(), 
						 myObject.GetVolumName());
		myHash.HashUpdate( LPCTSTR( csToHash), csToHash.GetLength());
		bContinue = (pos != NULL);
		if (bContinue)
			myObject = GetNext( pos);
	}
	return myHash.HashFinal();
}
