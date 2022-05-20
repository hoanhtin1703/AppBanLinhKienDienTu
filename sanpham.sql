-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 20, 2022 lúc 07:46 AM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `sanpham`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `email` varchar(500) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `password` varchar(500) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `level` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_nopad_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id`, `email`, `password`, `level`) VALUES
(1, 'admin', 'admin', 0),
(2, 'tin', 'tin123@gmail.com', 1),
(3, 'tin', 'tin123@gmail.com', 1),
(4, 'tin', 'tin123@gmail.com', 1),
(5, 'tin', 'tin123@gmail.com', 1),
(6, 'tin', 'tin123@gmail.com', 1),
(7, 'tin', 'tin123@gmail.com', 1),
(8, 'tin', 'tin123@gmail.com', 1),
(9, 'tin', 'tin123@gmail.com', 1),
(10, 'tin', 'tin123@gmail.com', 1),
(11, 'tin', 'tin123@gmail.com', 1),
(12, '123', '123', 1),
(13, '123', '123', 1),
(14, '123', '123', 1),
(15, '123', '123', 1),
(16, 'tin', '234', 1),
(17, '123', '123123', 1),
(18, '123', '123123', 1),
(19, '123', '123', 1),
(20, '1235', '123', 1),
(21, '12345', '123', 1),
(22, '123', '123', 1),
(23, '12312412', '123', 1),
(24, '123', '123', 1),
(25, '123123', '123123', 1),
(26, 'g123', '123', 1),
(27, 'a24', 'A@gmail.com', 1),
(28, 'cong', '123', 1),
(29, 'cong', '123', 1),
(30, 'thanh', '456', 1),
(31, 'Phuc@gmail.com', '123', 1),
(32, 'tin@gmail.com', '123', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `iddonhang` int(11) NOT NULL,
  `madonhang` varchar(500) NOT NULL,
  `masanham` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(11) NOT NULL,
  `soluongsanpham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `iddonhang`, `madonhang`, `masanham`, `tensanpham`, `giasanpham`, `soluongsanpham`) VALUES
(1, 7, '', 39, 'Phan Trường Huy', 42000, 3),
(2, 7, '', 40, 'Phan Trường Huy', 10000000, 1),
(3, 7, '', 12, 'Phan Xuân Hiệp', 14000, 1),
(4, 8, '', 39, 'Phan Trường Huy', 14000, 1),
(5, 9, '', 39, 'Phan Trường Huy', 14000, 1),
(6, 10, '', 40, 'Phan Trường Huy', 40000000, 4),
(7, 10, '', 37, 'Phan Trường Huy', 42000, 3),
(8, 11, '', 40, 'Bộ Kít Robot Tránh Vật Cản', 628200, 2),
(9, 11, '', 37, 'Bánh Xe LK-80-1', 2100000, 2),
(10, 12, '', 35, 'Xe 3 Bánh Điều Khiển Qua Bluetooth', 2645000, 5),
(11, 12, '', 38, 'Khung Xe Tank TP101', 1155000, 3),
(12, 13, '', 39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 1275000, 5),
(13, 14, '', 39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 255000, 1),
(14, 14, '', 11, 'Đo Nhiệt Độ Không Tiếp Xúc MLX90640', 2700000, 3),
(15, 14, '', 31, 'Core Snapper Robot', 3000000, 1),
(16, 15, '', 39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 2550000, 10),
(17, 16, '', 40, 'Bộ Kít Robot Tránh Vật Cản', 628200, 2),
(18, 16, '', 39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 1530000, 6),
(19, 17, '', 39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 255000, 1),
(20, 18, '', 38, 'Khung Xe Tank TP101', 770000, 2),
(21, 19, '', 39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 255000, 1),
(22, 20, '', 39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 1275000, 5),
(23, 21, '', 39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 1020000, 4),
(24, 24, '902571164', 0, 'tin1', 0, 2),
(25, 25, '1044455590', 0, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 0, 2),
(26, 26, '717016833', 0, 'Spider Arduino + Bluetooth', 0, 3),
(27, 27, '62044798', 0, 'Spider Arduino + Bluetooth', 0, 3),
(28, 28, '626850694', 0, 'Spider Arduino + Bluetooth', 0, 3),
(29, 29, '879891718', 0, '', 0, 0),
(30, 30, '1035277273', 0, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 0, 2),
(31, 31, '240562965', 0, 'Spider Arduino + Bluetooth', 0, 3),
(32, 32, '822633945', 0, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 0, 3),
(33, 33, '332365811', 0, '', 0, 0),
(34, 34, '977790212', 39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 0, 2),
(35, 35, '413867840', 51, 'tin1', 0, 3),
(36, 36, '627325374', 35, 'Xe 3 Bánh Điều Khiển Qua Bluetooth', 0, 2),
(37, 37, '748376925', 35, 'Xe 3 Bánh Điều Khiển Qua Bluetooth', 0, 2),
(38, 38, '1824658025', 35, 'Xe 3 Bánh Điều Khiển Qua Bluetooth', 0, 2),
(39, 39, '1814939602', 35, 'Xe 3 Bánh Điều Khiển Qua Bluetooth', 0, 2),
(40, 40, '2001907222', 51, 'tin1', 0, 4),
(41, 41, '309620345', 39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 0, 3),
(42, 42, '713811928', 51, 'tin1', 0, 2),
(43, 43, '1677463458', 39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 0, 2),
(44, 44, '1587363374', 39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa ', 0, 2),
(45, 45, '1475905343', 53, 'sanpham2', 0, 3),
(46, 46, '1989354345', 55, 'sanpham4', 0, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `tenkhachhang` varchar(500) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `sodienthoai` varchar(500) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `diachi` varchar(500) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `id_account` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_nopad_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `tenkhachhang`, `sodienthoai`, `diachi`, `id_account`) VALUES
(1, 'tin', '09123', 'to15,naihiendong', 1),
(2, 'tin', '09123', 'to15,naihiendong', 2),
(3, 'tin', '09123', 'to15,naihiendong', 3),
(4, 'tin', '09123', 'to15,naihiendong', 4),
(5, 'tin', '09123', 'to15,naihiendong', 5),
(6, 'tin', '09123', 'to15,naihiendong', 6),
(7, 'tin', '09123', 'to15,naihiendong', 7),
(8, 'tin', '09123', 'to15,naihiendong', 8),
(9, 'tin', '09123', 'to15,naihiendong', 9),
(10, 'tin', '09123', 'to15,naihiendong', 10),
(11, 'tin', '09123', 'to15,naihiendong', 11),
(12, '123', '123', '123', 12),
(13, '123', '123', '123', 13),
(14, '123', '123', '123', 14),
(15, '123', '123', '123', 15),
(16, 'tin', '123', '123', 16),
(17, '123', '123123', '123123', 17),
(18, '123', '123123', '123123', 18),
(19, '123', '123', '123', 19),
(20, '1235', '123', '123', 20),
(21, '12345', '123', '123123', 21),
(22, '123', '123123', '123123', 22),
(23, '12312412', '123', '123123', 23),
(24, '123', '123123123', '123123123123', 24),
(25, '123123', '123123', '123123123', 25),
(26, 'g123', '123', '123123', 26),
(27, 'a24', '923737', '838egev', 27),
(28, 'cong', '123', '123', 28),
(29, 'cong', '123', '123', 29),
(30, 'thanh', '123', '789', 30),
(31, 'phuc', 'đee', 'ddd', 31),
(32, 'tin', '0936153997', 'tổ 15,nại hiên ông', 32);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `madonhang` varchar(200) NOT NULL,
  `trangthai` int(11) NOT NULL,
  `idkhachhang` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `madonhang`, `trangthai`, `idkhachhang`) VALUES
(6, 'hiep', 123456789, 0),
(7, 'Hiep', 123456789, 0),
(8, 'gf', 2147483647, 0),
(9, 'hiep', 123, 0),
(10, 'gjv', 123, 0),
(11, 'HIEP', 123, 0),
(12, 'hiep', 346056590, 0),
(13, 'gi', 123, 0),
(14, 'y8hui', 8185, 0),
(15, 'hOEP', 123, 0),
(16, 'Phan Xuan Hiep', 346056590, 0),
(17, 'hiep', 123, 0),
(18, 'hiep', 12345, 0),
(19, 'hiep', 346056590, 0),
(20, 'Phan Xuan Hiep', 346056590, 0),
(21, 'Hiep', 346056590, 0),
(22, '1677871816', 0, 26),
(23, '2033405649', 0, 26),
(24, '902571164', 0, 26),
(25, '1044455590', 0, 26),
(26, '717016833', 0, 26),
(27, '62044798', 0, 26),
(28, '626850694', 0, 26),
(29, '879891718', 0, 0),
(30, '1035277273', 0, 26),
(31, '240562965', 0, 26),
(32, '822633945', 0, 0),
(33, '332365811', 0, 0),
(34, '977790212', 0, 26),
(35, '413867840', 0, 26),
(36, '627325374', 0, 26),
(37, '748376925', 0, 26),
(38, '1824658025', 0, 26),
(39, '1814939602', 0, 26),
(40, '2001907222', 0, 26),
(41, '309620345', 0, 26),
(42, '713811928', 0, 26),
(43, '1677463458', 0, 26),
(44, '1587363374', 0, 26),
(45, '1475905343', 0, 26),
(46, '1989354345', 0, 32);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `id` int(11) NOT NULL,
  `idsanpham` int(11) NOT NULL,
  `iddonhang` int(11) NOT NULL,
  `tensanpham` varchar(500) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `giasanpham` varchar(500) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `soluongsanpham` varchar(500) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_nopad_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenloaisanpham` varchar(200) NOT NULL,
  `hinhanh` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenloaisanpham`, `hinhanh`) VALUES
(1, 'Module', 'https://lambienled.com/wp-content/uploads/2020/04/module-led-1-619x400.jpg'),
(2, 'Cảm biến', 'https://salt.tikicdn.com/ts/tmp/4f/f3/54/9ae640598b787e358a8c367a2204fdfe.jpg'),
(3, 'Smart Home', 'https://noithatthanhthanh.vn/wp-content/uploads/2021/05/smart-home-1-1024x526-1.jpeg'),
(4, 'Mô hình, Robot', 'https://png.pngtree.com/element_origin_min_pic/16/07/10/2357826789cf803.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhanhsanpham` varchar(200) NOT NULL,
  `soluong` varchar(500) DEFAULT NULL,
  `motasanpham` mediumtext NOT NULL,
  `idsanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `soluong`, `motasanpham`, `idsanpham`) VALUES
(1, 'USB ARDUINO ATTINY85 USB', 56000, 'https://nshopvn.com/wp-content/uploads/2019/03/arduino-attiny85-usb-digispark-0IN0-2020.jpg', NULL, '+ Vi điều kiển chính: ATTiny85.\r\n+ Firmware: Arduino ATTiny85 USB Digispark\r\n+ Điện áp sử dụng: 5VDC từ cổng USB hoặc 6~12VDC từ chân Vin.\r\n+ Support for the Arduino IDE 1.0+ (OSX/Win/Linux)\r\n+ On-board 500ma 5V Regulator\r\n+ Built-in USB\r\n+ 6 I/O Pins (2 are used for USB only if your program actively communicates over USB, otherwise you can use all 6 even if you are programming via USB)\r\n8k Flash Memory (about 6k after bootloader)\r\n+ I2C and SPI (vis USI)PWM on 3 pins (more possible with Software PWM)\r\n+ ADC on 4 pins\r\n+ Power LED and Test/Status LED', 1),
(2, 'Module 8 Rơle 8 Relay 8 Role 5V', 125000, 'https://www.thegioiic.com/upload/large/7453.jpg', NULL, '+ Module 8 relay thích hợp cho các ứng dụng đóng ngắt điện thế cao AC hoặc DC, các thiết bị tiêu thụ dòng lớn, module thiết kế nhỏ gọn, có opto và transistor cách ly, kích đóng bằng mức thấp (0V) phù hợp với mọi loại MCU và thiết kế có thể sử dụng nguồn ngoài giúp cho việc sử dụng trở nên thật linh động và dễ dàng!\r\n+ Sử dụng điện áp nuôi 5VDC.\r\n+ 8 Relay đóng ngắt ở điện thế kích bằng 0V nên có thể sử dụng cho cả tín hiệu 5V hay 3v3 (cần cấp nguồn ngoài), mỗi Relay tiêu thụ dòng khoảng 80mA.\r\n+ Điện thế đóng ngắt tối đa: AC250V - 10A hoặc DC30V - 10A.\r\nCó đèn báo đóng ngắt trên mỗi Relay.', 1),
(3, 'Module Mosfet D4184 Có Opto Cách Ly', 55000, 'https://linhkienvn.com/uploads/pro/module-mosfet/hh003788/thumbs/250x0/bam-xung-4-kenh.jpg', NULL, '+ Với cách ly optocoupler, tín hiệu điều khiển và nguồn của thiết bị điều khiển được cách ly, điều này làm tăng đáng kể độ cứng của nhiễu.\r\n+ Tương thích với MCU và bảng điều khiển Arduino, tín hiệu 3V hoặc 5V\r\n+ Bắt đầu ở mức cao, dừng ở mức thấp, điều chỉnh tốc độ PWM\r\n+ Được sử dụng rộng rãi để điều khiển khởi động và dừng động cơ, van điện từ và các thiết bị phụ lưu khác\r\n+ Mặt đầu vào tín hiệu có thể được hàn với thiết bị đầu cuối hoặc chính chân, bảng mạch tương thích\r\n+ Đầu ra có thể được hàn vào thiết bị đầu cuối hoặc dây trực tiếp\r\n+ Kích thước mô-đun 23mm X 16mm Có hai lỗ vít đường kính 2mm, khoảng cách lỗ 8mm\r\n+ Thông số kỹ thuật của ống MOS: 40V 50A', 1),
(4, 'Module Đồng Hồ RTC PCF8563T', 45000, 'https://ae01.alicdn.com/kf/Hd990d2d9399945968a1ae7ca7f903dbes/TZT-IIC-ng-H-Th-i-Gian-Th-c-RTC-M-un-Ban-PCF8563-PCF8563T-8563.jpg', NULL, '+ Module thời gian thực PCF8563T cung cấp chức năng ngày, tháng, năm và thời gian thực. Với pin gắn trên board, module có khả năng làm việc độc lập ngay cả khi MCU ngừng hoạt động. Module có pin kết nối và connector với giao diện kết nối I2C, thuận tiện cho việc kết nối với MCU, và kết nối nhiều module trên I2C bus trong cùng một thời điểm.\r\n+ Cung cấp ngày tháng, năm và thời gian thực\r\n+ Có pin gắn trên board\r\n+ Giao diện kết nối I2C\r\n+ Dải điện áp hoạt động: 1.0 – 5.5V\r\n+ Tần số ngõ ra: 32.768 KHz, 1024Hz, 32Hz, 1Hz', 1),
(5, 'Module 2 Relay', 45000, 'https://felpower.com.pk/wp-content/uploads/2018/08/2relay-module-1.jpg', NULL, '+ Module 2 Relay với opto cách ly nhỏ gọn, có opto và transistor cách ly giúp cho việc sử dụng trở nên an toàn với board mạch chính, mạch được sử dụng để đóng ngắt nguồn điện công suất cao AC hoặc DC, có thể chọn đóng khi kích mức cao hoặc mức thấp bằng Jumper.\r\n+ Tiếp điểm đóng ngắt gồm 3 tiếp điểm NC (thường đóng), NO(thường mở) và COM(chân chung) được cách ly hoàn toàn với board mạch chính, ở trạng thái bình thường chưa kích NC sẽ nối với COM, khi có trạng thái kích COM sẽ chuyển sang nối với NO và mất kết nối với NC.', 1),
(6, 'Module 4 Relay', 60000, 'https://salt.tikicdn.com/ts/product/cf/d3/94/e154454ca9523ab206626b6f65189935.jpg', NULL, '+ Module 4 relay thích hợp cho các ứng dụng đóng ngắt điện thế cao AC hoặc DC, các thiết bị tiêu thụ dòng lớn, module thiết kế nhỏ gọn, có opto và transistor cách ly, kích đóng bằng mức thấp (0V) phù hợp với mọi loại MCU và thiết kế có thể sử dụng nguồn ngoài giúp cho việc sử dụng trở nên thật linh động và dễ dàng!\r\n+ Sử dụng điện áp nuôi 5VDC.\r\n+ 4 Relay đóng ngắt ở điện thế kích bằng 0V nên có thể sử dụng cho cả tín hiệu 5V hay 3v3 (cần cấp nguồn ngoài), mỗi Relay tiêu thụ dòng khoảng 80mA.\r\n+ Điện thế đóng ngắt tối đa: AC250V - 10A hoặc DC30V - 10A.\r\n+ Có thể kích mức 0 hoặc mức 1 thông qua Jupmer\r\n+ Có đèn báo đóng ngắt trên mỗi Relay.', 1),
(7, 'Module SG3525 + 772 + 882 ', 85000, 'https://ae01.alicdn.com/kf/HTB1FMSEdQfb_uJkSmLyq6AxoXXaV.jpg_q50.jpg', NULL, '+ Với cách ly optocoupler, tín hiệu điều khiển và nguồn của thiết bị điều khiển được cách ly, điều này làm tăng đáng kể độ cứng của nhiễu.\r\n+ Tương thích với MCU và bảng điều khiển Arduino, tín hiệu 3V hoặc 5V\r\n+ Bắt đầu ở mức cao, dừng ở mức thấp, điều chỉnh tốc độ PWM\r\n+ Được sử dụng rộng rãi để điều khiển khởi động và dừng động cơ, van điện từ và các thiết bị phụ lưu khác\r\n+ Mặt đầu vào tín hiệu có thể được hàn với thiết bị đầu cuối hoặc chính chân, bảng mạch tương thích\r\n+ Đầu ra có thể được hàn vào thiết bị đầu cuối hoặc dây trực tiếp\r\n+ Kích thước mô-đun 23mm X 16mm Có hai lỗ vít đường kính 2mm, khoảng cách lỗ 8mm\r\n+ Thông số kỹ thuật của ống MOS: 40V 50A', 1),
(8, 'Module Còi 5V', 12000, 'https://salt.tikicdn.com/ts/product/a0/96/98/0e56002c1d8bd7bb304bb938ce1f2751.jpg', NULL, '+ Với cách ly optocoupler, tín hiệu điều khiển và nguồn của thiết bị điều khiển được cách ly, điều này làm tăng đáng kể độ cứng của nhiễu.\r\n+ Tương thích với MCU và bảng điều khiển Arduino, tín hiệu 3V hoặc 5V\r\n+ Bắt đầu ở mức cao, dừng ở mức thấp, điều chỉnh tốc độ PWM\r\n+ Được sử dụng rộng rãi để điều khiển khởi động và dừng động cơ, van điện từ và các thiết bị phụ lưu khác\r\n+ Mặt đầu vào tín hiệu có thể được hàn với thiết bị đầu cuối hoặc chính chân, bảng mạch tương thích\r\n+ Đầu ra có thể được hàn vào thiết bị đầu cuối hoặc dây trực tiếp\r\n+ Kích thước mô-đun 23mm X 16mm Có hai lỗ vít đường kính 2mm, khoảng cách lỗ 8mm\r\n+ Thông số kỹ thuật của ống MOS: 40V 50A', 1),
(9, 'Mạch Điều Khiển Quạt 2 Món', 65000, 'https://vn-test-11.slatic.net/p/debb2a37fb7947e1a37557bf8ab1562f.png_800x800Q100.jpg', NULL, 'Dành cho các bạn nào thích tự sửa chữa, thay thế bộ điều khiển của các loại quạt điều khiển từ xa bị hỏng hoặc biến chiếc quạt bình thường thành quạt điều khiển từ xa.\r\n– Tắt bật quạt\r\n– Điều khiển 3 tốc độ\r\n– Chức năng gió trời (mạnh dần và yếu dần)\r\n– Điều khiển túp năng hoặc đèn\r\n– Hẹn giờ 1-2-4 giờ\r\n\r\n', 1),
(10, 'Module RTC DS1307 + 24C32', 20000, 'https://salt.tikicdn.com/cache/280x280/ts/product/7f/bd/4a/af9f850ccc3282aa9b285d33c694051a.jpg', NULL, '- Color: Blue\r\n- Quantity: 1\r\n- Material: Circuit board\r\n- Memory storage: 24C32 32K I2C EEPROM\r\n- With LIR2032 rechargeable lithium battery and rechargeable circuit\r\n- With reading and writing function\r\n- Using time: About 1 year (Fully charged)\r\n- Provide clock signal for microcontroller\r\n- Cascade other I2C devices\r\n- With full BCD clock calendar chip of 56byte non-volatile RAM\r\n- Address and data transmission via serial cable with dual-line dual-direction\r\n- The chip can provide second, minute, hour etc information.\r\n- AM/PM mark, for working 24-hour or 12-hour\r\n- Built-in power sensor circuit in the chip, with brownout detection and battery switch function\r\n- Under battery backup mode, power consumption is below 500uA\r\n- Accurate calendar up to year 2100\r\n- Great for DIY project', 1),
(11, 'Đo Nhiệt Độ Không Tiếp Xúc MLX90640', 900000, 'https://ae01.alicdn.com/kf/H8a5a293a6c91490eb672bda11a8d2b9a6/Waveshare-MLX90640-IR-Array-Nhi-t-In-H-nh-M-y-Ch-p-H-nh-32.jpg', NULL, '- Tổng quát\r\n+ Đo nhiệt độ bề mặt của một đối tượng mà không cần chạm vào nó, tùy thuộc vào sóng IR phát ra của mục tiêu\r\n+ Cũng đo nhiệt độ trung bình trên một khu vực\r\n+ Không tiếp xúc, độ chính xác cao, độ phân giải cao, phản hồi nhanh\r\n+ Hiệu chỉnh trước khi giao hàng, với bù nhiệt độ gradient\r\n+ Hoạt động trực tiếp với hệ thống MCU 3.3V / 5V nhờ tính năng dịch mức tích hợp\r\n- Thông số kỹ thuật\r\n+ Nguồn: 3.3V ~ 5V\r\n+ Phạm vi đo (khu vực): 40 ° C ~ 85 ° C\r\n+ Phạm vi đo (đối tượng): -70 ° C ~ 380 ° C\r\n+ Độ phân giải: 0,02 ° C\r\n+ Độ chính xác: ± 0,5 ° C (0 ~ 50 ° C)\r\n+ Trường nhìn (FOV): 35 °\r\n+ Kích thước: 28mm x 16 mm\r\n+ Kích thước lỗ lắp: 2.0mm', 2),
(12, 'Tự Động Sáng Khi Trời Tối AS-10 220V', 80000, 'https://nshopvn.com/wp-content/uploads/2019/03/cong-tac-cam-bien-anh-sang-as-10-220v-10a-Q6TL-2020.jpg', NULL, '- Tự động hóa hoàn toàn việc bật tắt hệ thống chiếu sáng ngoài trời của bạn: Tự động tắt đèn khi trời sáng và bật đèn khi trời tối.\r\n- Công tắc cảm ứng ánh sáng AS10 chuyên dụng bật đèn ngoài trời.\r\n- Đây là công tắc giúp bạn tự động hoàn toàn trong việc bật tắt hệ thống chiếu sáng ngoài trời, đèn đường, hành lang, ban công, đèn sân vườn, lối đi … mà bạn không cần bận tâm nhiều tới việc bật tắt hay quên tắt đèn thất thoát năng lượng.\r\n- Cơ chế hoạt động rất đơn giản, công tắc thông minh sử dụng cảm biến ánh sáng (cảm quang) để tự động nhận biết mức sáng môi trường: Khi trời tối thì tự động bật đèn và khi trời sáng thì tự động tắt đèn, mọi việc bật tắt đèn thực sự tự động hoàn toàn và tiết kiệm năng lượng cho bạn.', 2),
(13, 'Cảm Biến PIR Có Relay 12V', 121500, 'https://ae01.alicdn.com/kf/HTB12N4_Xh2rK1RkSnhJq6ykdpXaj/HC-SR501-SR501-Con-Ng-i-H-ng-Ngo-i-Pyroelectr-C-m-Bi-n-PIR.jpg', NULL, '+ Module điều khiển relay bằng cảm biến chuyển động 12VDC giá rẻ\r\n+ Cảm biến chuyển động là cảm biến thụ động sử dụng tia hồng ngoại để kích thích hoạt động.\r\n+ Module điều khiển relay bằng cảm biến chuyển động 12VDC một đầu được gắn với một mắt thu hồng ngoại, một đầu sẽ được kết nối vào thiết bị báo động: còi, loa ...\r\n+ Khi có vật hoặc người đến gần thì nhờ mắt thu hồng ngoại sẽ kích thích còi, loa ... phát ra tiếng để báo động là có vật sắp đến gần chúng ta.\r\n+ Thông số kỹ thuật của mạch điều khiển relay bằng pir:\r\n+ Điện áp: 12VDC\r\n+ Có 2 đầu dây: 1 đầu nối thiết bị báo động 1 đầu nối mắt thu hồng ngoại', 2),
(14, 'Cảm Biến Nhận Dạng Vân Tay R303', 858000, 'https://nshopvn.com/wp-content/uploads/2019/12/cam-bien-nhan-dang-van-tay-r305-W9DE-2020.jpg', NULL, '- Các Chức Năng chính:\r\n+ Giao diện truyền thông: USB và UART\r\n+ 1: N Xác Định (One-to-Nhiều)\r\n+ 1:1 Xác Minh (One-to-One)\r\n+ Tính năng vân tay dữ liệu đọc/ghi chức năng\r\n+ Có được Tính Năng Dữ Liệu của Bắt Giữ dấu vân tay và Kiểm Tra/Xác Định Tải Về Tính Năng withCaptured fingerprintIdentify Tải Về Tính Năng với Chụp vân tay\r\n+ Thiết lập Mức Độ An Ninh\r\n+ Có thể thiết lập Tốc Độ Baud/Thiết Bị ID/Mật Khẩu Thiết Bị\r\n+ Hệ điều hành: Windows 98, Me, NT4.0, 2000, XP, WIN 7 hoặc Android\r\n- Đặc điểm kỹ thuật:\r\n+ Công suất vân tay: 1000\r\n+ XA<0.001% (Mức Độ Bảo Mật: 3)\r\n+ FRR<0.1% (Mức Độ Bảo Mật: 3)\r\n+ Vân tay mẫu kích thước:512 Byte\r\n+ Mức độ bảo mật:1-5, mặc định là 3\r\n+ Đầu đọc dấu vân tay kích thước module: 20*32 (mm)\r\n+ Cảm biến mảng: 208*288 pixel\r\n+ Hiệu quả bộ sưu tập diện tích: 11*15 (mm)\r\n+ Độ phân giải: 508 dpi\r\n+ Thời gian Đáp Ứng:Vân tay tiền xử lý <0.2 s\r\n+ 1: N <0.3 s\r\n+ Chế độ liên lạc:USB2.0 UART (3.3V-TTL logic)\r\n+ UART Truyền Thông Chẵn lẻ = KHÔNG CÓ, Dừng Bit = 1,\r\n+ Tốc Độ Truyền : Mặc định là 57600BPS\r\n+ Điện áp DC4.2V-6V\r\n+ Dòng tiêu thụ : <55mA\r\n+ Nhiệt độ môi trường làm việc:-20-55\r\n+ Độ Ẩm: 20%-80%\r\n\r\n', 2),
(15, 'Cảm Biến Chữ U GK122', 8000, 'https://www.thegioiic.com/upload/large/9561.jpg', NULL, '+ Mô tả: Cảm biến quang Omron EE-SX671A\r\n+ Photomicro Sensors with Built-in Amplifier EE-SX671A\r\n+ Loại cảm biến có tích hợp sẵn bộ khuếch đại, nút chuyển mạch giữa dark-ON và light-ON.\r\n+ Tần số đáp ứng cao 1kHz.\r\n+ Loại cảm biến không có đèn báo sự cố.\r\n+ Khoảng cách phát hiện: 5 mm (slot width)\r\n+ Ngõ ra loại NPN, Dark ON và light-ON.\r\n+ Connector: EE-1001, EE-1006, EE-1006A.\r\n+ Đối tượng phát hiện: Loại vật đục (chắn sáng) kích thước nhỏ nhất 2 × 0.8 mm min.\r\n+ Nguồn cung cấp: 5 to 24 VDC ±10%.', 2),
(16, 'EE-SY672 Made In Japan', 325000, 'https://www.distrelec.de/Web/WebShopImages/landscape_medium/1-/01/Omron-EE-SY672-30162881-01.jpg', NULL, '+ Đầu ra cảm biến: NPN\r\n+ Điện áp cung cấp: 5 - 24VDC\r\n+ Phạm vi tối đa: 5mm\r\n+ Dòng đầu ra: 100mA\r\n+ Dòng đầu vào Max: 40mA', 2),
(17, 'Cảm Biến Vật Cản Hồng Ngoại', 57000, 'https://nshopvn.com/wp-content/uploads/2019/03/cam-bien-vat-can-hong-ngoai-FM52-2020.jpg', NULL, '- Module cảm biến phát hiện vật cản :\r\n+ Điện áp hoạt động 12-24VDC -  Dòng không tải 10mA\r\n+ Dòng tải lên đến 30A\r\n+ Dùng nguyên lý thu phát hồng ngoại có xử lý nhiễu môi trường bằng chương trình\r\n+ Có tự động ngắt tải từ 1 đến 10s - tùy vào vặn biến trở\r\n- Ứng dụng trong :\r\n+ Máy rửa tay tự động\r\n+ Đèn tự động trong nội thất,độ bền cao hơn so với nút cơ vật lý\r\n+ Tự xả nước trong các thiết bị vệ sinh tự động\r\n+ tự động sáng khi mở cửa hành lang', 2),
(18, 'Cảm Biến Độ Ẩm Đất', 29000, 'https://dochoistem.com/cam-bien-do-am-dat.jpg', NULL, '- Đầu kết nối sừ dung 3 dây\r\n+ VCC: cấp nguồn bên ngoài 3.3V ~ 5V\r\n+ GND: Nối vối GND của nguồn ngoài\r\n+ DO: Đầu ra số (0 và 1)\r\n- Đầu ra DO có thể kết nối trực tiếp với Chip vi xử lý hoặc kích transistor (điều khiển relay...)\r\n- Trọn bộ bao gồm:\r\n+ 1 đầu dò độ ẩm đất\r\n+ 1 module cảm biến\r\n+ 2 dây Dupont dài 20cm', 2),
(19, 'Cảm Biến LAZER 5V', 45000, 'https://nshopvn.com/wp-content/uploads/2019/03/module-lazer-5v-ky-008-DU3Q-2020.jpg', NULL, '- Kích thước PCB: 1.5*1.9 cm\r\n- Làm việc điện áp: 5 V\r\n- Đầu ra:\r\n+ Đầu ra cao cấp khi nhận được Laser tín hiệu;\r\n+ Đầu ra thấp nước khi không nhận được Laser tín hiệu.\r\n*LƯU Ý:\r\nCảm biến sử dụng không được điều chế Laser đầu thu, xin vui lòng sử dụng trong nhà mà không có ánh sáng, ánh sáng mặt trời hoặc các đồ đạc có thể can thiệp, dành cho sử dụng trong môi trường tối.\r\n ', 2),
(20, 'Cảm Biến Thu Phát Hồng Ngoại TCRT5000 ', 595000, 'https://nshopvn.com/wp-content/uploads/2019/03/module-cam-bien-do-line-don-tcrt5000-4-chan-C5W4-2020-600x600.jpg', NULL, '- Tính năng:\r\n+ Số lượng: 1pc\r\n+ Kích thước: 3.5 x 1cm\r\n+ Nguồn cung cấp: 5V DC\r\n+ Khoảng cách dò: 10mm\r\n+ Tích hợp cảm biến Tcrt5000 NSOR\r\n+ Áp dụng cho nhiều nền tảng bao gồm Arduino / AVR / ARM / PIC', 2),
(21, 'BVsmart Rolling Door V2', 595000, 'https://bizweb.dktcdn.net/100/354/184/products/img-0327-chinhsua.jpg', NULL, 'KHÔNG SỢ chìa Remote cửa cuốn bị “vô nước” 🆗\r\n❌❌ KHÔNG SỢ bỏ quên trong túi để vào máy giặt🆗\r\n❌❌ KHÔNG SỢ đi mưa bị ướt do treo trên chìa khóa xe🆗\r\n❌❌ KHÔNG SỢ rơi rớt va đập mạnh làm hỏng linh kiện 🆗\r\n❌❌ KHÔNG SỢ lâu quá không sử dụng bị chảy Pin dẩn đến hư mạch 🆗\r\n❌❌ KHÔNG SỢ sơ ý đánh rơi không kiếm lại được🆗', 3),
(22, 'Điều Khiển Cửa Cuốn', 355500, 'https://media3.scdn.vn/img4/2020/02_01/yyQNqw3Vlo7Cnop0ZZfl_simg_de2fe0_500x500_maxb.png', NULL, '- CHỈ CẦN KẾT NỐI WIFI nhà bạn là có thể sử dụng điều khiển cửa cuốn bằng mọi Smart phone \r\n- Có thể điều khiển bằng GIỌNG NÓI\r\n- Điều khiển KHÔNG GIỚI HẠN KHOẢNG CÁCH, mọi lúc mọi nơi\r\n- Sử dụng được trên TẤT CẢ MỌI LOẠI CỬA CUỐN hiện nay trên thị trường \r\n- Mọi tính năng bảo mật cửa cuốn cũ được GIỮ NGUYÊN không thay đổi\r\n- Server Mỹ đảm bảo AN TOÀN, ỔN ĐỊNH \r\n- Dễ dàng sử dụng, chỉ cần điện thoại kết nối internet ( wifi, 3g) \r\n- Không sợ mất, lạc, hư remote nữa ', 3),
(24, 'BVSMART 4 WIFI - Nhiệt Độ + Độ Ẩm', 270000, 'https://salt.tikicdn.com/cache/280x280/ts/product/f6/9d/96/fd6b4675ee562ba0ad118e4fc63317fc.jpg', NULL, '- Điều khiển thiết bị điện ở mọi nơi trên thế giới\r\n- Hẹn giờ bật tắt thiết bị theo lịch đặt sẵn\r\n- Theo dõi nhiệt độ và độ ẩm không khí\r\n- Cài đặt bật tắt tự động thiết bị theo nhiệt độ và độ ẩm\r\n- Bảo hành chính hãng 6 tháng', 3),
(25, 'BVsmart Rolling Door V3', 445500, 'https://salt.tikicdn.com/ts/product/dd/4b/cf/3d3e2cb8764ed0370b6cce20aa7384c6.png', NULL, '- CHỈ CẦN KẾT NỐI WIFI nhà bạn là có thể sử dụng điều khiển cửa cuốn bằng mọi Smart phone\r\n- Có thể điều khiển bằng GIỌNG NÓI\r\n- Điều khiển KHÔNG GIỚI HẠN KHOẢNG CÁCH, mọi lúc mọi nơi\r\n- Sử dụng được trên TẤT CẢ MỌI LOẠI CỬA CUỐN hiện nay trên thị trường\r\n- Mọi tính năng bảo mật cửa cuốn cũ được GIỮ NGUYÊN không thay đổi\r\n- Server Mỹ đảm bảo AN TOÀN, ỔN ĐỊNH\r\n- Dễ dàng sử dụng, chỉ cần điện thoại kết nối internet ( wifi, 3g)\r\n- Không sợ mất, lạc, hư remote ', 3),
(26, '40mét - BVSmart 2 RF', 205000, 'https://bizweb.dktcdn.net/100/354/184/products/2-kenh-3km.jpg', NULL, '- Ứng dụng trong hệ thống Smart Home : Điều khiển bật tắt từ xa các thiết bị điện trong nhà như bóng đèn, quạt, cửa cuốn v.v...\r\n- Ứng dụng để điều khiển và giám sát các thiết bị điện trong hệ thống tưới tiêu, chăm sóc cây trồng vật nuôi trong các trang trại, nhà vườn, đồn điền của nền nông nghiệp\r\n- Giải pháp theo dõi, điều khiển, giám sát điện năng cho các mô hình kinh doanh villa, hotel, homestay\r\n- Ứng dụng làm smartkey chống trộm cho xe máy.\r\nThông số kĩ Thuật :\r\n-   Điện áp hoạt động: Tùy mạch bạn dùng có thể 12VDC hoặc 110 – 220VAC\r\n-   Tiếp điểm chịu tải:  250VAC – 10A hoặc 30V – 10A\r\n-   Chú ý: khi điều khiển động cơ AC lưu ý mắc thêm tụ 104 400VAC để bảo vệ tiếp điểm', 3),
(27, 'Cảm Biến Vật Cản Hồng Ngoại', 57000, 'http://product.hstatic.net/1000292825/product/module-hong-ngoai-434153f13324_grande.jpg', NULL, '- Module cảm biến phát hiện vật cản :\r\n+ Điện áp hoạt động 12-24VDC -  Dòng không tải 10mA\r\n+ Dòng tải lên đến 30A\r\n+ Dùng nguyên lý thu phát hồng ngoại có xử lý nhiễu môi trường bằng chương trình\r\n+ Có tự động ngắt tải từ 1 đến 10s - tùy vào vặn biến trở\r\n- Ứng dụng trong :\r\n+ Máy rửa tay tự động\r\n+ Đèn tự động trong nội thất,độ bền cao hơn so với nút cơ vật lý\r\n+ Tự xả nước trong các thiết bị vệ sinh tự động\r\n+ tự động sáng khi mở cửa hành lang', 3),
(28, 'Mạch Cảm Ứng Đèn Nội Thất 12VDC 30A', 96000, 'https://bizweb.dktcdn.net/100/354/184/products/20200701-171817.jpg', NULL, '- Module cảm biến phát hiện vật cản :\r\n+ Điện áp hoạt động 12-24VDC -  Dòng không tải 10mA\r\n+ Dòng tải lên đến 30A\r\n+ Dùng nguyên lý cảm ứng điện dung xuyên phi kim dày nhất 8mm\r\n+ Có tự động sáng dần và tắt dần chỉnh từ 1 đến 4s\r\n- Ứng dụng trong :\r\n+ Nội thất giường tủ -  gương soi\r\n+ Đèn tự động trong nội thất,độ bền cao hơn so với nút cơ vật lý\r\n+ không lộ nút cơ cho thẩm mỹ cao', 3),
(29, 'BVSMART 4 WIFI - Nhiệt Độ + Độ Ẩm', 270000, 'https://salt.tikicdn.com/cache/280x280/ts/product/f6/9d/96/fd6b4675ee562ba0ad118e4fc63317fc.jpg', NULL, '- Điều khiển thiết bị điện ở mọi nơi trên thế giới\r\n- Hẹn giờ bật tắt thiết bị theo lịch đặt sẵn\r\n- Theo dõi nhiệt độ và độ ẩm không khí\r\n- Cài đặt bật tắt tự động thiết bị theo nhiệt độ và độ ẩm\r\n- Bảo hành chính hãng 6 tháng', 3),
(30, 'Điều Khiển Cửa Cuốn', 355500, 'https://media3.scdn.vn/img4/2020/02_01/yyQNqw3Vlo7Cnop0ZZfl_simg_de2fe0_500x500_maxb.png', NULL, '- CHỈ CẦN KẾT NỐI WIFI nhà bạn là có thể sử dụng điều khiển cửa cuốn bằng mọi Smart phone \r\n- Có thể điều khiển bằng GIỌNG NÓI\r\n- Điều khiển KHÔNG GIỚI HẠN KHOẢNG CÁCH, mọi lúc mọi nơi\r\n- Sử dụng được trên TẤT CẢ MỌI LOẠI CỬA CUỐN hiện nay trên thị trường \r\n- Mọi tính năng bảo mật cửa cuốn cũ được GIỮ NGUYÊN không thay đổi\r\n- Server Mỹ đảm bảo AN TOÀN, ỔN ĐỊNH \r\n- Dễ dàng sử dụng, chỉ cần điện thoại kết nối internet ( wifi, 3g) \r\n- Không sợ mất, lạc, hư remote nữa ', 3),
(31, 'Core Snapper Robot', 3000000, 'https://www.trossenrobotics.com/Shared/images/PImages/snappercore/snapper-core-new-a.jpg', NULL, 'Bộ kit này là hoàn hảo cho tất cả những người mới bắt đầu với lĩnh vực robot. Bộ cánh tay robot RobotGeek Snapper Core bao gồm Vòng bi xoay 120mm, rô bốt 180 độ RobotGeek, Servo Servo FS90 (cho bộ kẹp) và tất cả các giá đỡ, giá treo, bộ phận cơ thể, đai ốc, bu lông và dây cho cánh tay robot. Điều tốt hơn với điều này là nó có thể được sửa đổi và được nâng cấp cho các dự án của bạn. Nó có thể dễ dàng gỡ bỏ và gắn vào các tấm RobotGeek khác vì nó được xây dựng theo mô hình lưới 1 X1cm. Bộ này không có bảng Arduino hoặc bất kỳ điều khiển nào và phải được mua riêng.\r\n\r\n', 4),
(32, 'Arduino Robot Kit', 65000, 'https://product.hstatic.net/1000197080/product/arduino__3__7dd587dd3c7449f5a2c1e2fecb614f45_master.png', NULL, '- Chi tiết sản phẩm\r\n+ Bộ linh kiện đầy đủ và hoàn chỉnh giúp trẻ nghiên cứu và phát triển robot điều khiển bằng bluetooth điện thoại (hệ điều hành Android) hoặc xe tránh vật cản dùng kỹ thuật siêu âm để nhận diện vật cản.\r\n- Xuất xứ: Việt Nam\r\n- Kích thước: 25x20x10cm\r\n- Bao gồm: Bo mạch Arduino UNO R3, module điều khiển motor L293D, bộ khung xe, motor SG90 và module siêu âm HC-SR04\r\n- Màu: Nhiều màu\r\n- Độ tuổi: 8+', 4),
(33, 'Arduino Starter Kit', 400000, 'https://giadungnhaviet.com/wp-content/uploads/2018/09/giadungnhaviet_bo-kit-tu-hoc-lap-trinh-dieu-khien-arduino-starter-kit-4.jpg', NULL, '- Bộ Arduino Starter Kit (Bộ Kit Arduino Cơ Bản) gồm: Một mạch Arduino Uno R3 và một số lượng linh kiện đi kèm sẽ giúp bạn xây dựng các Dự án sáng tạo. Đặc biệt là các bạn mới Bắt đầu tiếp xúc và Làm quen với Arduino.\r\n- Ngoài ra các bạn sẽ được tặng kèm bộ tài liệu hướng dẫn thực hành Arduino do Gia Dụng Nhà Việt biên soạn', 4),
(34, 'Spider Arduino + Bluetooth', 900000, '/server/picture/34.jpeg', '50', '- Combo xe điều khiển từ xa dùng Arduino và mạch Bluetooth HC-05 + Arduino UNO + Mạch L298 để điều khiển động cơ + Mạch bluetooth HC-05 để điều khiển bằng điện thoại + Pin 18650 với dung lượng 2200mAh', 4),
(35, 'Xe 3 Bánh Điều Khiển Qua Bluetooth', 529000, 'https://bizweb.dktcdn.net/100/048/138/files/dsc00003.jpg', NULL, '- Combo xe điều khiển từ xa dùng Arduino và mạch Bluetooth HC-05 + Arduino UNO + Mạch L298 để điều khiển động cơ + Mạch bluetooth HC-05 để điều khiển bằng điện thoại + Pin 18650 với dung lượng 2200mAh', 4),
(36, 'Xe 4 Bánh Điều Khiển Qua Bluetooth', 650000, '/server/picture/36.jpeg', '', '- Combo xe điều khiển từ xa dùng Arduino và mạch Bluetooth HC-05\r\n+ Arduino UNO\r\n+ Mạch L298 để điều khiển động cơ\r\n+ Mạch bluetooth HC-05 để điều khiển bằng điện thoại\r\n+ Pin 18650 với dung lượng 2200mAh', 4),
(37, 'Bánh Xe LK-80-1', 1050000, '/server/picture/37.jpeg', '', '+ LK-CS là thương hiệu Bánh Cao su Lương Ký thuộc dòng phân khúc bánh xe tải trọng nhẹ. Được sử dụng phổ biến trong thiết bị nội thất, bàn ghế gỗ, tủ gỗ,\r\nxe đẩy inox, tủ nhôm.\r\n+ Càng bánh xe được làm từ thép mạ kẽm\r\n+ Bánh xe được làm từ Cao su lõi Thép\r\n+ Kiểu dáng : Đế xoay và xoay khóa\r\n+ Màu sắc : Đen', 1),
(39, 'Mô Hình Xe Tăng Điều Khiển Từ Xa', 255000, '/server/picture/39.jpeg', '', '- Kích Thước: 190 * 160 * 55mm\r\n- Tích hợp sẵn 2 động cơ có hộp số\r\n- Chất liệu: nhựa cứng đen sơn bóng', 4),
(52, 'sanphammoi1', 1588888, '/server/picture/52.jpeg', '15', 'sanphammoi', 3),
(53, 'sanpham2', 5000, '/server/picture/53.jpeg', '412', 'mota', 2),
(54, 'sanpham3', 5000, '/server/picture/54.jpeg', '20', 'mota', 3),
(55, 'sanpham4', 40000, '/server/picture/55.jpeg', '50', 'mô tả4', 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Person_id` (`id_account`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FK_Person_id` FOREIGN KEY (`id_account`) REFERENCES `account` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
