-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2025 at 06:10 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `game_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKhachHang` int(11) NOT NULL,
  `Ten` varchar(255) DEFAULT NULL,
  `SDT` varchar(50) DEFAULT NULL,
  `TongChi` int(11) DEFAULT NULL,
  `DiemTichLuy` int(11) DEFAULT NULL,
  `HangThanhVien` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKhachHang`, `Ten`, `SDT`, `TongChi`, `DiemTichLuy`, `HangThanhVien`) VALUES
(1, 'vy234', '0984759385', 20000000, 600007, 'Kim cương'),
(2, 'quan123', '9485739895', 1000000, 6000, 'Kim cương'),
(3, 'helo1245', '0888369348', 10129100, 500000, 'Kim cương'),
(10, 'hehe234', '0999475629', 20000, 5, 'Đồng'),
(11, 'kaka286', '0846396837', 20000000, 5000, 'Kim cương'),
(12, 'songoku', '0999475837', 30000, 10, 'Đồng'),
(13, 'ganacho', '0999375638', 300000, 100, 'Bạc'),
(14, 'acquy234', '0888375840', 400000, 150, 'Bạc'),
(15, 'j97', '0555959595', 5000000, 2000, 'Kim cương'),
(16, 'TrịnhPt', '0999375649', 35467, 46, 'Kim cương'),
(17, 'nên123', '0375837564', 937564, 350, 'Vàng'),
(18, '1convit', '0485738566', 296847, 169, 'Bạc'),
(19, 'rose', '0999485738', 9375837, 4003, 'Vàng'),
(22, 'nake234', '0837563857', 93857, 48, 'Đồng'),
(24, 'lala123', '0993756385', 903756, 1000, 'Vàng'),
(25, 'nano123', '0444756284', 184759, 2085, 'Vàng'),
(26, 'sontungmtp', '0999375357', 20000000, 10000, 'Kim cương'),
(33, 'dylanxclarice', '0941390850', 65500, 50, 'Vàng'),
(34, 'quan536', '0888369348', 126000, 20, 'Đồng'),
(35, 'huhu', '0123456789', 345000, 5, 'Đồng'),
(36, 'bulma112', '0931946065', 666000, 58, 'Đồng'),
(37, 'luffy123', '0941390990', 50000, 15, 'Đồng'),
(38, 'kaio246', '0868549886', 127000, 2, 'Đồng');

-- --------------------------------------------------------

--
-- Table structure for table `maytinh`
--

CREATE TABLE `maytinh` (
  `MaMay` int(11) NOT NULL,
  `TenMay` varchar(50) NOT NULL,
  `TrangThai` varchar(50) NOT NULL DEFAULT 'Ngừng hoạt động',
  `ThoiGianBatDau` datetime DEFAULT NULL,
  `ThoiGianConLai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `monan`
--

CREATE TABLE `monan` (
  `id` int(11) NOT NULL,
  `tenmonan` varchar(100) DEFAULT NULL,
  `dongia` int(11) DEFAULT NULL,
  `hinhanh` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `monan`
--

INSERT INTO `monan` (`id`, `tenmonan`, `dongia`, `hinhanh`) VALUES
(1, 'Bánh tráng trộn', 25000, NULL),
(2, 'Cá viên chiên', 35000, NULL),
(3, 'Cơm cháy', 20000, NULL),
(4, 'Cơm tấm', 25000, NULL),
(5, 'Hamburger', 20000, NULL),
(6, 'Phô mai que', 35000, NULL),
(7, 'Mì tôm trứng', 15000, NULL),
(8, 'Mì tôm xào', 15000, NULL),
(9, 'Sushi', 40000, NULL),
(10, 'Thèo lèo', 15000, NULL),
(11, 'Tokboki', 25000, NULL),
(12, 'Xúc xích', 15000, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` int(11) NOT NULL,
  `Ten` varchar(255) DEFAULT NULL,
  `CCCD` varchar(255) DEFAULT NULL,
  `GioiTinh` varchar(255) DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `SDT` varchar(50) DEFAULT NULL,
  `ChucVu` varchar(50) DEFAULT NULL,
  `Luong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `Ten`, `CCCD`, `GioiTinh`, `NgaySinh`, `SDT`, `ChucVu`, `Luong`) VALUES
(5, 'Nguyễn Đăng Quân', '045206001468', 'Nam', '2006-03-05', '0888369348', 'Quản lý', 1000000),
(6, 'Phạm Triều Vỹ', '123456789', 'Nam', '2006-01-15', '1234567890', 'Bảo vệ', 2000000),
(9, 'Trần Trung Việt', '857239500264', 'Nam', '2006-02-06', '1746592759', 'Nhân viên', 5000000),
(13, 'Phạm Triều Vỹ', '045207195847', 'Nam', '2006-02-06', '0988475639', 'Nhân viên', 5000000),
(14, 'Phạm Đắc Thịnh', '045839884756', 'Nam', '2006-06-15', '0993756396', 'Nhân viên', 5000000),
(15, 'Võ Phước Nguyên Khôi', '045202857395', 'Nam', '2006-06-14', '0663548698', 'Nhân viên', 4000000),
(16, 'Phan Hữu Phúc', '045206948576', 'Nam', '2006-07-19', '0666348674', 'Nhân viên', 5000000),
(17, 'Nguyễn Minh Huy', '045206993758', 'Nam', '2006-03-20', '0999264875', 'Bảo vệ', 3000000),
(18, 'Bùi Anh Quân', '045206364596', 'Nam', '2006-08-29', '0266475663', 'Bảo vệ', 3000000),
(19, 'Huỳnh Thị Thanh Uyên', '045206994857', 'Nữ', '2006-06-14', '0888364857', 'Nhân viên', 5000000),
(20, 'Đào Hoàng Thảo Vi', '045206994857', 'Nữ', '2006-08-15', '0999375648', 'Nhân viên', 6000000),
(21, 'Đồng Trần Diệu Hiền', '045206994758', 'Nữ', '2006-10-18', '0557364876', 'Nhân viên', 7000000),
(22, 'Trần Văn Tri', '045206883957', 'Nam', '2006-11-15', '0444758364', 'Nhân viên', 3000000),
(23, 'Trần Thanh Đức', '045206994585', 'Nam', '2006-11-15', '0444758573', 'Nhân viên', 5000000),
(24, 'Nguyễn Đăng Khoa', '045206225364', 'Nam', '2006-11-14', '0444657385', 'Nhân viên', 5000000),
(26, 'Lê Ngọc Uyên Thư', '045206334756', 'Nữ', '2006-08-16', '0888356235', 'Nhân viên', 6000000),
(27, 'Bùi Đức Hoàng', '045206882947', 'Nam', '2006-01-26', '0337465837', 'Nhân viên', 5000000),
(29, 'Lê Đăng Nhật', '045206002857', 'Nam', '2006-11-14', '0888384628', 'Nhân viên', 6000000),
(30, 'Đặng Trần Hạo Nam', '045206993756', 'Nam', '2006-01-26', '0333857438', 'Quản lý', 20000000),
(31, 'Nguyễn Công Thành', '045206883756', 'Nam', '2006-07-18', '0444758364', 'Quản lý', 10000000),
(32, 'Đặng Văn Nhật Trường', '045206883657', 'Nam', '2006-10-11', '0333648573', 'Nhân viên', 7000000),
(33, 'Nguyễn Ngọc Châu', '045206993758', 'Nữ', '2006-10-11', '0844857375', 'Nhân viên', 8000000),
(34, 'Võ Lệ Huyền', '045206994857', 'Nữ', '2006-01-19', '0444758364', 'Nhân viên', 6000000),
(35, 'Võ Tiến Đạt', '045206883958', 'Nam', '2006-06-20', '0993746583', 'Nhân viên', 5000000),
(36, 'Ngô Gia Bảo', '045206993495', 'Nam', '2006-01-10', '0333857463', 'Nhân viên', 7000000),
(37, 'Trần Thế Đức', '045206994756', 'Nam', '2006-01-18', '0575636453', 'Nhân viên', 6000000),
(38, 'Nguyễn Đăng Quân', '089465778767', 'Nữ', '2006-04-05', '0999576845', 'Nhân viên', 5000000),
(39, 'quân', '045987556287', 'Nam', '2025-01-10', '0999375684', 'Nhân viên', 4000000),
(40, 'hello', '098465998675', 'Nữ', '2025-01-03', '0999375638', 'Nhân viên', 20000),
(41, 'Nguyễn Sĩ Thìn', '045986773467', 'Nam', '1890-04-17', '0888374653', 'Quản lý', 50000000),
(42, 'Phạm Uyên', '098364775845', 'Nữ', '2025-01-02', '0999384756', 'Nhân viên', 5000000),
(43, 'Nguyễn Quân', '045208998576', 'Nam', '2006-03-05', '0868549886', 'Nhân viên', 5000000),
(44, 'Ngô Gia Bảo ', '045206009867', 'Nam', '2025-01-01', '0123456789', 'Bảo vệ', 2000000);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan_admin`
--

CREATE TABLE `taikhoan_admin` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoan_admin`
--

INSERT INTO `taikhoan_admin` (`username`, `password`) VALUES
('a', 'c4ca4238a0b923820dcc509a6f75849b'),
('hehe', '289dff07669d7a23de0ef88d2f7129e7'),
('khoi', '202cb962ac59075b964b07152d234b70'),
('nn', 'eab71244afb687f16d8c4f5ee9d6ef0e'),
('quan', '202cb962ac59075b964b07152d234b70'),
('trieuvy', '202cb962ac59075b964b07152d234b70'),
('trungviet', '202cb962ac59075b964b07152d234b70');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKhachHang`);

--
-- Indexes for table `maytinh`
--
ALTER TABLE `maytinh`
  ADD PRIMARY KEY (`MaMay`);

--
-- Indexes for table `monan`
--
ALTER TABLE `monan`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- Indexes for table `taikhoan_admin`
--
ALTER TABLE `taikhoan_admin`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MaKhachHang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `maytinh`
--
ALTER TABLE `maytinh`
  MODIFY `MaMay` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `monan`
--
ALTER TABLE `monan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MaNhanVien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
