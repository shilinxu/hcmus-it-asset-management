@echo off
if     exist "C:\OCS Inventory Agent\OCSInventory.exe"  (   
	echo OCSInventory installed before.
)else (
	echo Installing OCSInventory....
	call OCSPackage.exe
)
pause