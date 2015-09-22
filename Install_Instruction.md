Mục lục nội dung

# Chuẩn bị #
  1. [hfam\_web\_v100.zip](http://code.google.com/p/hcmus-it-asset-management/downloads/list)
  1. [hfam\_database.zip](http://code.google.com/p/hcmus-it-asset-management/downloads/list)
  1. [Apache Tomcat](http://tomcat.apache.org/download-60.cgi)
  1. [Sql Server 2005 trở lên](http://www.microsoft.com/downloads/details.aspx?familyid=220549b5-0b07-4448-8848-dcc397514b41) (bao gồm gói giao diện quản trị cơ sở dữ liệu  SQL Server Management Studio)

# Cài đặt Java Web Server và publish trang web #
  * Download và cài đặt Apache tomcat server . Cấu hình để server tự động chạy mỗi khi khởi động máy chủ.
![http://lh4.ggpht.com/__Yv21HQis74/TGdQ8WbrD6I/AAAAAAAABUU/2mLgBFkWJyI/s800/tomcat_automatic.jpg](http://lh4.ggpht.com/__Yv21HQis74/TGdQ8WbrD6I/AAAAAAAABUU/2mLgBFkWJyI/s800/tomcat_automatic.jpg)

  * Nếu cài đặt vào thư mục mặc định thì thư mục publish web sẽ là `C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps`

  * Tiến hành test thử web server hoạt động được bằng cách truy cập vào đường dẫn web mặc định http://localhost:8080

  * Download gói cài đặt trang web hfam\_web\_v100.zip, Xóa hoặc đổi tên thư mục ROOT mặc định trong thư mục publish web của Apache Tomcat , Tạo một thư mục ROOT mới và giải nén và vào thư mục publish web. (lưu ý:   _Nếu không thể giải nén trực tiếp vào thư  mục này, Có thể thử cách giải nén hfam\_web\_v100.zip vào một thư mục khác rồi copy vào thư mục này (yêu cầu quyền administrator_ ).
![http://lh4.ggpht.com/__Yv21HQis74/TGdQ6CuENqI/AAAAAAAABUA/xbsKwtRqIO8/s800/hinh3.jpg](http://lh4.ggpht.com/__Yv21HQis74/TGdQ6CuENqI/AAAAAAAABUA/xbsKwtRqIO8/s800/hinh3.jpg)

  * Truy cập http://localhost:8080 để kiểm tra server hoạt động.

# Cài đặt cơ sở dữ liệu #

  * Cài đặt cơ sở dữ liệu SQL SERVER 2005 trở lên nếu chưa có (bao gồm  SQL Server Management Studio Express)

  * Khởi động SQL SERVER 2005 dưới quyền quản trị (Run as Administrator).

  * Download cơ sở dữ liệu hfam\_database.zip, giải nèn và tiến hành attach vào hệ quản trị cơ sở dữ liệu.

![http://lh5.ggpht.com/__Yv21HQis74/TGdQ7diMJmI/AAAAAAAABUM/3XiDXKEGRxQ/s800/attach%20database.jpg](http://lh5.ggpht.com/__Yv21HQis74/TGdQ7diMJmI/AAAAAAAABUM/3XiDXKEGRxQ/s800/attach%20database.jpg)

  * Cấu hình để SQL SERVER chấp nhận  kiểu server authentication là  SQL server and Windows Authentication mode (database >> properties>>Security).
![http://lh4.ggpht.com/__Yv21HQis74/TGdQ6Zv3Z_I/AAAAAAAABUE/U4KD7h6EZ10/s800/db_createuser.jpg](http://lh4.ggpht.com/__Yv21HQis74/TGdQ6Zv3Z_I/AAAAAAAABUE/U4KD7h6EZ10/s800/db_createuser.jpg)

  * Tạo tài khoản truy cập cơ sở dữ liệu mới có quyền read, write vào database **hcmuns-asset-manage**.
![http://lh6.ggpht.com/__Yv21HQis74/TGdQ69srGrI/AAAAAAAABUI/w1BeC0hfXUY/s800/db_phanquyen.jpg](http://lh6.ggpht.com/__Yv21HQis74/TGdQ69srGrI/AAAAAAAABUI/w1BeC0hfXUY/s800/db_phanquyen.jpg)

  * Cấu hình để SQL Server 2005 cho phép truy cập vào cơ sở dữ liệu bằng chứng thực dựa trên SQL authentication thông qua giao thức TCP/IP ở cổng 1433 (hoặc một cổng khác thỏa mãn yêu cầu).
![http://lh3.ggpht.com/__Yv21HQis74/TGdQ8Cm_1uI/AAAAAAAABUQ/nVsebEtJQqs/s800/tcp-ip.1433.jpg](http://lh3.ggpht.com/__Yv21HQis74/TGdQ8Cm_1uI/AAAAAAAABUQ/nVsebEtJQqs/s800/tcp-ip.1433.jpg)

# Thiết lập cấu hình trang web truy cập vào csdl #
  * File cấu hình truy cấp cơ sở dữ liệu đặt tại
```
C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps\ROOT\WEB-INF\classes\config.properties
```
  * Trong file config.properties, Chỉnh sửa lại các CONNECTION\_URL cho phù hợp với thông số của database server
```
CONNECTION_URL=jdbc:microsoft:sqlserver://localhost:1433;User=hfam_web_account;Password=password;DatabaseName=hcmuns-asset-manage
```

# Truy cập trang web #

  * Tiến hành restart lại Apache Tomcat server ( Click vào biểu tượng apache tomcat 6 trên file hệ thống , chọn stop, sau đó start)

  * Truy cập vào http://localhost:8080

  * Đăng nhập vào hệ thống bằng các tài khoản mặc định

|Tàikhoản| Mật khẩu| Quyền hạn|
|:-------|:--------|:---------|
|hhhung  | 123     | Quản lý thiết bị|
|lqvu    | 123     | Quản trị hệ thống|

# Xem log #
  * Nếu không thể đăng nhập được, có thể xác định lỗi dựa vào log được ghi lại tại
```
C:\Program Files\Apache Software Foundation\Tomcat 6.0\logs
```