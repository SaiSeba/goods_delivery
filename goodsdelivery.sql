-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 05, 2024 at 08:26 PM
-- Server version: 5.7.11
-- PHP Version: 7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `goodsdelivery`
--

-- --------------------------------------------------------

--
-- Table structure for table `neworder`
--

CREATE TABLE `neworder` (
  `orderid` int(30) NOT NULL,
  `deliverydate` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `userid` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `neworder`
--

INSERT INTO `neworder` (`orderid`, `deliverydate`, `address`, `status`, `userid`) VALUES
(1, 'Sat Feb 03 22:25:04 CET 2024', 'a\nb\nc\nd', 0, 2),
(2, 'Sat Feb 03 22:25:04 CET 2024', 'a\nb\nc\nd', 0, 2),
(3, 'Sat Feb 03 22:29:32 CET 2024', 'd\nf\ng\ng', 0, 2),
(4, 'Sat Feb 03 22:33:55 CET 2024', 'a\nb\nc\nd', 0, 2),
(5, 'Sat Feb 03 22:59:31 CET 2024', 'd\nd\nsd\n\ndddd', 0, 2),
(6, 'Mon Feb 05 22:59:31 CET 2024', 'd\nd\nsd\n\nddddghfgvkjl:Lk\nhgkkj\n\nhggkhll', 0, 2),
(7, 'Mon Feb 05 17:02:58 CET 2024', 'a\nc\nv\n\ndd\nd\nd\n', 0, 2),
(8, 'Mon Feb 05 17:04:53 CET 2024', 'a\na\nd\n\ns', 0, 2),
(9, 'Sun Feb 04 20:28:43 CET 2024', 'drvc', 0, 6),
(10, 'Sun Feb 04 20:28:43 CET 2024', 'drvc', 0, 6),
(11, 'Tue Feb 13 22:27:51 CET 2024', 'a\ns\nc', 0, 2),
(12, 'Tue Feb 06 22:30:48 CET 2024', '\na\nss\nd', 0, 2),
(13, 'Tue Feb 06 22:30:48 CET 2024', '\na\nss\nd', 0, 2),
(14, 'Wed Feb 07 00:22:37 CET 2024', 'ab\nb\nc\n', 0, 2),
(15, 'Thu Feb 08 03:51:20 CET 2024', 'a\nv\nv', 0, 2),
(16, 'Wed Feb 14 03:58:37 CET 2024', 'a\nd', 0, 2);

-- --------------------------------------------------------

--
-- Table structure for table `orderproduct`
--

CREATE TABLE `orderproduct` (
  `orderproductid` int(30) NOT NULL,
  `quantity` int(30) NOT NULL,
  `orderid` int(30) NOT NULL,
  `productid` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderproduct`
--

INSERT INTO `orderproduct` (`orderproductid`, `quantity`, `orderid`, `productid`) VALUES
(1, 3, 5, 1),
(2, 7, 6, 3),
(3, 1, 7, 1),
(4, 1, 8, 1),
(5, 1, 9, 1),
(6, 1, 10, 1),
(7, 1, 11, 1),
(8, 2, 12, 1),
(9, 2, 13, 1),
(10, 2, 14, 1),
(11, 6, 15, 3),
(12, 9, 16, 1),
(13, 9, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `productlist`
--

CREATE TABLE `productlist` (
  `productid` int(30) NOT NULL,
  `productname` varchar(100) NOT NULL,
  `weight` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productlist`
--

INSERT INTO `productlist` (`productid`, `productname`, `weight`) VALUES
(1, 'Orange', 10),
(3, 'Apples', 12);

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `id` int(11) NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `phonenumber` varchar(15) NOT NULL,
  `role` varchar(10) NOT NULL,
  `regnumber` varchar(20) NOT NULL,
  `capacity` int(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`id`, `email`, `password`, `firstname`, `lastname`, `phonenumber`, `role`, `regnumber`, `capacity`) VALUES
(1, 'sai@email.com', '547547', 'Sai', 'Sebastian', '485648545', 'Customer', '8365858', 379),
(2, 'customer@gmail.com', 'abc', 'abcnew0102', 'last', '76535636', 'Customer', '', 0),
(3, 'schedular@gmail.com', 'abc', 'schedular', 'last', '89765655673', 'Schedular', '5355533', 20),
(4, 'Customer3', 'abc', 'Customer3', 'Customer3', '765653533', 'Customer', '', 0),
(5, 'ajay@gmail.com', '1', 'ajay', 'devaradjou', '1234', 'Driver', '9876', 56),
(6, 'ajay@gmail', '1', 'Ajay', 'Deva', '1123', 'Customer', '', 0),
(7, 'email@gmail.com', 'abc', 'Name', 'Last Name', '6336336734', 'Customer', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `scheduleid` int(30) NOT NULL,
  `deliverydate` varchar(30) NOT NULL,
  `warehouse` varchar(40) NOT NULL DEFAULT 'Warehouse Name',
  `warehouseaddress` varchar(100) NOT NULL DEFAULT 'Warehouse address1\\nWarehouse address line2\\nWarehouse address line3',
  `schdriverid` int(30) DEFAULT NULL,
  `schrouteid` int(30) DEFAULT NULL,
  `productid` int(30) NOT NULL,
  `quantity` int(40) NOT NULL,
  `orderid` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`scheduleid`, `deliverydate`, `warehouse`, `warehouseaddress`, `schdriverid`, `schrouteid`, `productid`, `quantity`, `orderid`, `status`) VALUES
(1, 'Tue Feb 06 22:30:48 CET 2024', 'Warehouse Name', 'Warehouse address1\\nWarehouse address line2\\nWarehouse address line3', 5, NULL, 1, 2, 13, 1),
(2, 'Wed Feb 07 00:22:37 CET 2024', 'Warehouse Name', 'Warehouse address1\\nWarehouse address line2\\nWarehouse address line3', 5, NULL, 1, 2, 14, 1),
(3, 'Thu Feb 08 03:51:20 CET 2024', 'Warehouse Name', 'Warehouse address1\\nWarehouse address line2\\nWarehouse address line3', 5, NULL, 3, 6, 15, 1),
(4, 'Wed Feb 14 03:58:37 CET 2024', 'Warehouse Name', 'Warehouse address1\\nWarehouse address line2\\nWarehouse address line3', 5, NULL, 1, 9, 16, 0),
(5, 'Tue Feb 06 10:49:14 CET 2024', 'Warehouse Name', 'Warehouse address1\\nWarehouse address line2\\nWarehouse address line3', 5, NULL, 1, 9, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `neworder`
--
ALTER TABLE `neworder`
  ADD PRIMARY KEY (`orderid`);

--
-- Indexes for table `orderproduct`
--
ALTER TABLE `orderproduct`
  ADD PRIMARY KEY (`orderproductid`);

--
-- Indexes for table `productlist`
--
ALTER TABLE `productlist`
  ADD PRIMARY KEY (`productid`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`scheduleid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `neworder`
--
ALTER TABLE `neworder`
  MODIFY `orderid` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `orderproduct`
--
ALTER TABLE `orderproduct`
  MODIFY `orderproductid` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `productlist`
--
ALTER TABLE `productlist`
  MODIFY `productid` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `registration`
--
ALTER TABLE `registration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `scheduleid` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
