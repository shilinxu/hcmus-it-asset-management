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


select * from CHI_TIET_NHOM_NGUOI_DUNG
select * from CHI_TIET_NHOM_NGUOI_DUNG
select * from NHOM_NGUOI_DUNG
select * from NGUOI_DUNG

insert into CHI_TIET_NHOM_NGUOI_DUNG values (1,2)



update CHUYEN_TRANG_THAI 
set TrangThai1 = 18 , TrangThai2 = 23, ManHinh = '#huy-de-nghi', MoTa = 'Hủy đề nghị sửa'
where IdChuyenTrangThai= 30 
select * from CHUYEN_TRANG_THAI


select IdLoaiNguoiDung, Ten, MoTa from LOAI_NGUOI_DUNG

select IdLoaiThietBi, Ten, MoTa, HinhAnh from LOAI_THIET_BI

select * from Nguoi_dung
Update Nguoi_dung 
set TenDS

update NGUOI_DUNG
set TenDangNhap = 'diep3' , MatKhau = '123' , TenHienThi = 'Diep',  Email = 'xxx@yy.com', HinhAnh = '123.png', IdloaiNguoiDung = 1
where IdNguoiDung = 2


select * from NHOM_NGUOI_DUNG
select * from ThoNG_SO_THIET_BI