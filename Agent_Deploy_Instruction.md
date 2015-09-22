# Chuẩn bị phần mềm #
  * [OCS Inventory NG Agents](http://www.ocsinventory-ng.org/index.php?page=downloads)

  * [OCS Inventory NG Packager](http://www.ocsinventory-ng.org/index.php?page=downloads)

# Cách 1: cài đặt thủ công #

Xem hướng dẫn chi tiết tại [OCS Inventory wiki](http://wiki.ocsinventory-ng.org/index.php/Documentation:Agent#Manually_installing_Service_version_of_Agent.)



![http://lh6.ggpht.com/__Yv21HQis74/TGdQ9C8-0VI/AAAAAAAABUc/lqlOOr4MQZk/s800/ocs_installthucong.jpg](http://lh6.ggpht.com/__Yv21HQis74/TGdQ9C8-0VI/AAAAAAAABUc/lqlOOr4MQZk/s800/ocs_installthucong.jpg)

Lưu ý về một số thông số:
|Thông số| Ghi chú|
|:-------|:-------|
|Server Address| Là IP hoặc domain  name của máy chủ cài đặt trang web. Ví dụ: 172.29.65.186|
|Server Port| Là port truy cập web của Apache tomcat. Mặc định là 8080|
|Immediately launch inventory| Chọn option này để hệ thống gửi ngay để agent gửi thông tin client về cho server ngay sau khi cài đặt.|


# Cách 2: Tạo gói cài đặt silent mode để cài đặt tự động #
  * Tạo gói cài đặt silent mode, xem hướng dẫn tại [OCS Inventory wiki (Tools:Packager)](http://wiki.ocsinventory-ng.org/index.php/Tools:Packager#Manual) , (_lưu ý: thông số cấu hình agent tương tự như cách 1_)
  * Khi đã có gói cài đặt silent mode, có thể sử dụng một số công cụ sau để cài đặt tự động.
    * Active Directory GPO.
    * Login Script
    * phần mềm Net Support.
    * ...