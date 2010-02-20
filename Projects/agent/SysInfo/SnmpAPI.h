// Document modified at : Tuesday, March 28, 2006 12:57:35 PM , by user : Didier LIROULET , from computer : SNOOPY-XP-PRO

//====================================================================================
// Open Computer and Software Inventory
// Copyleft Didier LIROULET 2006
// Web: http://ocsinventory.sourceforge.net

// This code is open source and may be copied and modified as long as the source
// code is always made freely available.
// Please refer to the General Public Licence http://www.gnu.org/ or Licence.txt
//====================================================================================

// This code is open source and may be copied and modified as long as the source

// code is always made freely available.

// Please refer to the General Public Licence http://www.gnu.org/ or Licence.txt

//====================================================================================



#ifndef _SNMPAPI_HEADER_

#define _SNMPAPI_HEADER_



//******************************************************************

//*

//*      Copyright (C) Stas Khirman 1998.  All rights reserved.         

//*                                                                     

//*       This program is distributed WITHOUT ANY WARRANTY

//*

//******************************************************************



static SNMPAPI SNMP_FUNC_TYPE UtilOidCpy(OUT AsnObjectIdentifier *DstObjId,

	IN AsnObjectIdentifier *SrcObjId);



static VOID SNMP_FUNC_TYPE UtilOidFree(IN OUT AsnObjectIdentifier *ObjId);

	

static SNMPAPI SNMP_FUNC_TYPE UtilOidNCmp(IN AsnObjectIdentifier *ObjIdA,

	IN AsnObjectIdentifier *ObjIdB, IN UINT Len);



static VOID SNMP_FUNC_TYPE UtilVarBindFree(IN OUT RFC1157VarBind *VarBind);



//******************************************************************

//*

//*      End of Copyright (C) Stas Khirman 1998

//*                                                                     

//******************************************************************



#define ETHERNET_ADAPTER	_T( "Ethernet")

#define TOKENBUS_ADAPTER	_T( "Token Bus")

#define TOKENRING_ADAPTER	_T( "Token Ring")

#define ATM_ADAPTER			_T( "ATM")

#define DIALUP_ADAPTER		_T( "Dialup")

#define LOOPBACK_ADAPTER	_T( "Loopback")

#define OTHER_ADAPTER		_T( "Other (see MIB)")



LPCTSTR GetIfType( UINT uType);

BOOL IsEthernet( UINT uType);

BOOL IsTokenRing( UINT uType);

BOOL IsTokenBus( UINT uType);

BOOL IsISDN( UINT uType);

BOOL IsDialup( UINT uType);

BOOL IsATM( UINT uType);

BOOL IsLAN( UINT uType);

BOOL IsDSL( UINT uType);

BOOL IsLoopback( UINT uType);

LPCTSTR GetAdapterType( UINT uType);



#endif // _SNMPAPI_HEADER_

