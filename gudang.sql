-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 21, 2018 at 01:27 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gudang`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id` int(11) NOT NULL,
  `kode` varchar(20) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `deskripsi` text NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `gambar` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id`, `kode`, `nama`, `deskripsi`, `jumlah`, `harga`, `gambar`, `created_at`, `updated_at`) VALUES
(1, '8997005886871', 'Masker Indomaret', 'size: 5 pcs, Rak B2, Warna Biru Muda', 19, 10500, 'stefanus.jpg', '2018-12-21 09:59:02', '2018-12-21 02:59:02'),
(2, '8998838380048', 'Binder Kenko', 'Rak B6, lubang 24', 7, 0, 'IMG_20181205_083703.jpg', '2018-12-20 01:42:58', '0000-00-00 00:00:00'),
(4, '8993137695138', 'Wardah Nature Daily', 'bottle 100ml, Aloe Vera Extract. Rak H5', 467, 0, 'wardah.jpg', '2018-12-20 01:42:58', '0000-00-00 00:00:00'),
(6, '6925473835802', 'Hatsu Gel Pen', 'hkvggk', 50, 631651, '114555449.png', '2018-12-21 10:01:11', '2018-12-21 03:00:01');

-- --------------------------------------------------------

--
-- Table structure for table `head`
--

CREATE TABLE `head` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` text NOT NULL,
  `remember_token` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `head`
--

INSERT INTO `head` (`id`, `username`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'stefanus.alvin16@gmail.com', '6ef29c24a0d8827537fdbf1f488cc4e6', 'PJwmUpj2s0SrJh6P1VCPQqr04fzP0ueq4hIXJP30Ano5GVN4PFtPkpJjzI6p', '2018-12-20 15:09:52', '0000-00-00 00:00:00'),
(2, 'admin@gmail.com', '21232f297a57a5a743894a0e4a801fc3', 'ByZO017keW1hcRsFL84jXMuBSspkuNJoMWrVPdua2GR4awXhl5Bk7bXDNqgG', '2018-12-21 10:01:43', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id` int(4) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` text NOT NULL,
  `nama` varchar(50) NOT NULL,
  `gambar` text NOT NULL,
  `level` enum('low','head','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id`, `username`, `password`, `nama`, `gambar`, `level`) VALUES
(1, 'stefanus.alvin16@gmail.com', '6ef29c24a0d8827537fdbf1f488cc4e6', 'Stefanus Alvin', 'b173fc133a5b75c33d17c30ce9bd7cd2.jpg', 'low'),
(2, 'runnydesta@gmail.com', '595f683d6277202232c913a6c6fe86df', 'Runny Desta Anggraeni', 'runny.jpg', 'low'),
(3, 'maditya@gmail.com', 'fd8443acf3976d97b51563ed8771958a', 'M. Aditya Fajrianto', 'tool.png', 'low');

-- --------------------------------------------------------

--
-- Table structure for table `low`
--

CREATE TABLE `low` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` text NOT NULL,
  `remember_token` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `low`
--

INSERT INTO `low` (`id`, `username`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'staff@gmail.com', 'de9bf5643eabf80f4a56fda3bbb84483', '3cssLc1LPOxep9aQlCTi9KWxWgL8z2nyeYe89YoGtkF3bw5IeqEwUSwX8RjZ', '2018-12-21 09:52:50', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `head`
--
ALTER TABLE `head`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `low`
--
ALTER TABLE `low`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `head`
--
ALTER TABLE `head`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `low`
--
ALTER TABLE `low`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
