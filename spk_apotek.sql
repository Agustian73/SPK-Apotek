-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2017 at 04:29 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `spk_apotek`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` varchar(8) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `hak_akses` enum('Admin','User') NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`, `hak_akses`) VALUES
('US001', 'admin', 'admin', 'Admin'),
('US002', 'user', 'user', 'User');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE IF NOT EXISTS `pembelian` (
  `kd_faktur` varchar(8) NOT NULL,
  `nm_supplier` varchar(25) NOT NULL,
  `kd_barang` varchar(20) NOT NULL,
  `hrg_beli` int(11) NOT NULL,
  `jml_beli` int(9) NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`kd_faktur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`kd_faktur`, `nm_supplier`, `kd_barang`, `hrg_beli`, `jml_beli`, `total`) VALUES
('FK001', 'otong', 'DKL9306409410A1', 75000, 15, 1125000),
('FK002', 'hh', 'DKL911480340A1', 4000, 4, 16000);

--
-- Triggers `pembelian`
--
DROP TRIGGER IF EXISTS `INPUT_BELI`;
DELIMITER //
CREATE TRIGGER `INPUT_BELI` BEFORE INSERT ON `pembelian`
 FOR EACH ROW BEGIN
 UPDATE persediaan SET stok=stok+NEW.jml_beli  
 WHERE kd_barang=NEW.kd_barang; 
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `UPDATE_BELI`;
DELIMITER //
CREATE TRIGGER `UPDATE_BELI` AFTER UPDATE ON `pembelian`
 FOR EACH ROW BEGIN
 UPDATE persediaan SET stok=stok-(OLD.jml_beli-NEW.jml_beli)  
 WHERE kd_barang=NEW.kd_barang; 
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE IF NOT EXISTS `penjualan` (
  `id_detail` int(8) NOT NULL AUTO_INCREMENT,
  `kd_jual` varchar(8) NOT NULL,
  `kd_barang` varchar(20) NOT NULL,
  `jml` int(9) NOT NULL,
  `harga` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`id_detail`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id_detail`, `kd_jual`, `kd_barang`, `jml`, `harga`, `total`) VALUES
(23, 'NJ001', 'DKL9306409410A1', 5, 2500, 12500),
(24, 'NJ001', 'DKL911480340A1', 5, 10000, 50000),
(25, 'NJ002', 'DKL911480340A1', 10, 10000, 100000),
(26, 'NJ003', 'DKL911480340A1', 15, 10000, 150000),
(28, 'NJ005', 'DKL911480340A1', 2, 10000, 20000),
(29, 'NJ005', 'DKL9306409410A1', 1, 2500, 2500),
(30, 'NJ006', 'DTL9131102504A1', 54, 5000, 270000),
(31, 'NJ007', 'DTL9131102504A1', 32, 5000, 160000),
(32, 'NJ008', 'DTL9131102504A1', 22, 5000, 110000),
(33, 'NJ009', 'DTL9131102504A1', 21, 5000, 105000),
(34, 'NJ010', 'DTL9131102504A1', 11, 5000, 55000),
(35, 'NJ011', 'DTL9131102504A1', 12, 5000, 60000),
(36, 'NJ012', 'DTL9131102504A1', 13, 5000, 65000),
(37, 'NJ013', 'DTL9131102504A1', 33, 5000, 165000),
(38, 'NJ014', 'DTL9131102504A1', 35, 5000, 175000),
(39, 'NJ015', 'DTL9131102504A1', 44, 5000, 220000),
(40, 'NJ016', 'DTL9131102504A1', 45, 5000, 225000),
(41, 'NJ017', 'DTL9131102504A1', 55, 5000, 275000),
(42, 'NJ018', 'DTL9131102504A1', 40, 5000, 200000),
(43, 'NJ019', 'DTL9131102504A1', 21, 5000, 105000),
(44, 'NJ020', 'DTL9131102504A1', 14, 5000, 70000);

--
-- Triggers `penjualan`
--
DROP TRIGGER IF EXISTS `INPUT_JUAL`;
DELIMITER //
CREATE TRIGGER `INPUT_JUAL` AFTER INSERT ON `penjualan`
 FOR EACH ROW BEGIN
 UPDATE persediaan SET stok=stok-NEW.jml  
 WHERE kd_barang=NEW.kd_barang; 
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `UPDATE_JUAL`;
DELIMITER //
CREATE TRIGGER `UPDATE_JUAL` AFTER UPDATE ON `penjualan`
 FOR EACH ROW BEGIN
 UPDATE persediaan SET stok=stok+(OLD.jml-NEW.jml)  
 WHERE kd_barang=NEW.kd_barang; 
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `peramalan`
--

CREATE TABLE IF NOT EXISTS `peramalan` (
  `kd_ramal` int(8) NOT NULL AUTO_INCREMENT,
  `kd_barang` varchar(20) NOT NULL,
  `tgl_ramal` date NOT NULL,
  `hasil` int(11) NOT NULL,
  PRIMARY KEY (`kd_ramal`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `peramalan`
--

INSERT INTO `peramalan` (`kd_ramal`, `kd_barang`, `tgl_ramal`, `hasil`) VALUES
(1, 'DKL911480340A1', '2017-06-24', 20);

-- --------------------------------------------------------

--
-- Table structure for table `persediaan`
--

CREATE TABLE IF NOT EXISTS `persediaan` (
  `kd_barang` varchar(20) NOT NULL,
  `nm_barang` varchar(25) NOT NULL,
  `hrg_jual` int(11) NOT NULL,
  `satuan` varchar(20) NOT NULL,
  `stok` int(9) NOT NULL,
  `tgl_exp` date NOT NULL,
  PRIMARY KEY (`kd_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persediaan`
--

INSERT INTO `persediaan` (`kd_barang`, `nm_barang`, `hrg_jual`, `satuan`, `stok`, `tgl_exp`) VALUES
('DKL911480340A1', 'Polacel', 10000, 'tablet', 12, '2017-08-01'),
('DKL9306409410A1', 'Dexteem plus', 2500, 'tablet', 34, '2017-08-01'),
('DTL9131102504A1', 'Grantusif', 5000, 'kaplet', 50, '2017-08-01');

-- --------------------------------------------------------

--
-- Table structure for table `trans_penjualan`
--

CREATE TABLE IF NOT EXISTS `trans_penjualan` (
  `kd_jual` varchar(8) NOT NULL,
  `total` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`kd_jual`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trans_penjualan`
--

INSERT INTO `trans_penjualan` (`kd_jual`, `total`, `tanggal`) VALUES
('NJ001', 62500, '2017-04-23'),
('NJ002', 100000, '2017-05-23'),
('NJ003', 150000, '2017-06-23'),
('NJ005', 22500, '2017-07-01'),
('NJ006', 270000, '2016-01-04'),
('NJ007', 160000, '2016-02-04'),
('NJ008', 110000, '2016-03-04'),
('NJ009', 105000, '2016-04-04'),
('NJ010', 55000, '2016-05-04'),
('NJ011', 60000, '2016-06-04'),
('NJ012', 65000, '2016-07-04'),
('NJ013', 165000, '2016-08-04'),
('NJ014', 175000, '2016-09-04'),
('NJ015', 220000, '2016-10-04'),
('NJ016', 225000, '2016-11-04'),
('NJ017', 275000, '2016-12-04'),
('NJ018', 200000, '2017-01-04'),
('NJ019', 105000, '2017-02-04'),
('NJ020', 70000, '2017-03-04');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
