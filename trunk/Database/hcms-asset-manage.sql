select * from THONG_SO_THIET_BI
select * from THE_HIEN_Thiet_BI
select * from Thiet_BI

--Tim The hien moi nhat cua thiet bi co id = 1
select * from THE_HIEN_THIET_BI 
where idThietbi = 1 
and idTheHienThietBi >= all(
	 select t2. Idthehienthietbi
	from the_hien_thiet_bi t2
	where t2.idThietBi = 1)

--cac thong so thiet bi hien tai cua thiet bi.
--Tạo stored-procedure sp_tong 
Drop PROCEDURE TheHienMoiNhatCuaThietBi
go
CREATE PROCEDURE TheHienMoiNhatCuaThietBi
  @IdThietBi  int, @IdTheHienThietBi int out 
AS 
Begin 
    SET @IdTheHienThietBi = (
		select max(IdTheHienThietBi)
		from THE_HIEN_THIET_BI	
		where idThietBi = 1 
	);
End 
 
--Biên dịch stored-procedure  F5 
 
--Kiểm tra 
Declare @IdTheHienThietBi int 
Exec TheHienMoiNhatCuaThietBi 1, @IdTheHienThietBi
Select @IdTheHienThietBi

