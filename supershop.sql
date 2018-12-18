-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 08, 2017 at 09:50 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `supershop`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `branch_id` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`branch_id`, `district`, `address`) VALUES
('bo1', 'Dhaka', 'Malibagh'),
('bo2', 'Comilla', 'Shodor'),
('bo3', 'Rajshahi', 'Charghat'),
('bo4', 'Khulna', 'Dumuria'),
('bo5', 'Barishal', 'Babuganj'),
('bo6', 'Rangpur', 'Pirganj'),
('bo7', 'Chittagong', 'Hazaribagh');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Employee_Id` varchar(10) NOT NULL,
  `Employee_name` varchar(30) NOT NULL,
  `Age` int(2) NOT NULL,
  `Phone_no` varchar(11) NOT NULL,
  `Catagory` varchar(20) NOT NULL,
  `Gender` varchar(7) NOT NULL,
  `Salary` int(7) NOT NULL,
  `branch_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Employee_Id`, `Employee_name`, `Age`, `Phone_no`, `Catagory`, `Gender`, `Salary`, `branch_id`) VALUES
('E101', 'Fahim', 30, '0171', 'Manager', 'Male', 30000, 'bo2'),
('E102', 'Rahim', 25, '0181', 'Salesman', 'Male', 15000, 'bo1'),
('E103', 'Belal', 33, '0151', 'Watchman', 'Male', 8000, 'bo3'),
('E104', 'Ria', 24, '0188', 'Receptionist', 'Female', 17000, 'bo6'),
('E105', 'Tamim', 27, '0191', 'Salesman', 'Male', 15000, 'bo7'),
('E106', 'Fatema', 28, '0199', 'Cleaner', 'Female', 6000, 'bo5'),
('E107', 'Isha', 23, '0155', 'Salesgirl', 'Female', 15000, 'bo3'),
('E108', 'Aysha', 25, '0176', 'Receptionist', 'Female', 17000, 'bo1'),
('E109', 'Joy', 32, '0195', 'Manager', 'Male', 30000, 'bo4'),
('E110', 'Ashik', 35, '0158', 'Salesman', 'Male', 15000, 'bo7');

-- --------------------------------------------------------

--
-- Table structure for table `got`
--

CREATE TABLE `got` (
  `num` int(11) NOT NULL,
  `p_id` varchar(20) NOT NULL,
  `pay_no` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `got`
--

INSERT INTO `got` (`num`, `p_id`, `pay_no`) VALUES
(1, 'pro1', 'po14'),
(5, 'pro14', 'po3'),
(2, 'pro15', 'po5'),
(2, 'pro2', 'po13'),
(2, 'pro2', 'po2'),
(2, 'pro2', 'po5'),
(2, 'pro3', 'po1'),
(3, 'pro3', 'po12'),
(2, 'pro3', 'po14'),
(3, 'pro3', 'po2'),
(2, 'pro3', 'po4'),
(6, 'pro3', 'po8'),
(2, 'pro4', 'po11'),
(1, 'pro4', 'po6'),
(2, 'pro4', 'po7'),
(4, 'pro5', 'po10'),
(2, 'pro5', 'po2'),
(5, 'pro5', 'po6'),
(5, 'pro5', 'po9'),
(1, 'pro8', 'po1');

-- --------------------------------------------------------

--
-- Table structure for table `onsale`
--

CREATE TABLE `onsale` (
  `Product_id` varchar(6) NOT NULL,
  `Brand_id` varchar(7) NOT NULL,
  `Sale_percentage` varchar(5) NOT NULL,
  `Validity` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `onsale`
--

INSERT INTO `onsale` (`Product_id`, `Brand_id`, `Sale_percentage`, `Validity`) VALUES
('pr03', 'b04', '7%', '2017-08-14'),
('pr04', 'b05', '5%', '2017-08-15'),
('pr07', 'b02', '15%', '2017-08-23'),
('pr10', 'b06', '3%', '2017-08-12'),
('pr11', 'b01', '10%', '2017-08-19'),
('pr12', 'b07', '30%', '2017-08-16');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `pay_no` varchar(20) NOT NULL,
  `c_id` varchar(20) NOT NULL,
  `total` int(11) NOT NULL,
  `branch_id` varchar(20) NOT NULL,
  `year` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `date` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`pay_no`, `c_id`, `total`, `branch_id`, `year`, `month`, `date`) VALUES
('po1', 'c105', 550, 'bo2', 17, 7, 5),
('po10', 'c101', 550, 'bo3', 16, 2, 5),
('po11', 'c103', 550, 'bo5', 17, 4, 5),
('po12', 'c101', 550, 'bo2', 17, 4, 1),
('po13', 'c106', 550, 'bo2', 17, 7, 15),
('po14', 'c107', 550, 'bo1', 17, 4, 5),
('po2', 'c104', 550, 'bo7', 17, 6, 15),
('po3', 'c101', 550, 'bo4', 16, 2, 5),
('po4', 'c103', 550, 'bo1', 17, 4, 5),
('po5', 'c101', 550, 'bo3', 17, 4, 1),
('po6', 'c106', 550, 'bo2', 17, 7, 5),
('po7', 'c107', 550, 'bo2', 17, 7, 5),
('po8', 'c105', 550, 'bo1', 17, 7, 5),
('po9', 'c104', 550, 'bo3', 17, 6, 15);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `p_id` varchar(20) NOT NULL,
  `category` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`p_id`, `category`, `name`, `price`) VALUES
('pro1', 'softdrinks', 'Cocacola', 70),
('pro10', 'shampoo', 'All Clear', 120),
('pro11', 'chips', 'Lays', 12),
('pro12', 'chips', 'Lays', 12),
('pro13', 'RiceBranOil', 'BD Food', 525),
('pro14', 'icecream', 'Bellisimo', 325),
('pro15', 'icecream', 'Polar', 200),
('pro2', 'softdrinks', 'Pepsi', 50),
('pro3', 'chips', 'Lays', 12),
('pro4', 'chips', 'Chesse', 20),
('pro5', 'chips', 'Kurkure', 25),
('pro7', 'icecream', 'igloo', 125),
('pro8', 'RiceBranOil', 'Pran Oil', 500),
('pro9', 'chips', 'Potato', 15);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `branch_id` varchar(20) NOT NULL,
  `p_id` varchar(20) NOT NULL,
  `num` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`branch_id`, `p_id`, `num`) VALUES
('bo1', 'pro1', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`branch_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Employee_Id`,`branch_id`) USING BTREE,
  ADD KEY `branch_id` (`branch_id`);

--
-- Indexes for table `got`
--
ALTER TABLE `got`
  ADD PRIMARY KEY (`p_id`,`pay_no`),
  ADD KEY `got_ibfk_2` (`pay_no`);

--
-- Indexes for table `onsale`
--
ALTER TABLE `onsale`
  ADD PRIMARY KEY (`Product_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`pay_no`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`branch_id`,`p_id`),
  ADD KEY `p_id` (`p_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `got`
--
ALTER TABLE `got`
  ADD CONSTRAINT `got_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `got_ibfk_2` FOREIGN KEY (`pay_no`) REFERENCES `payment` (`pay_no`) ON DELETE NO ACTION;

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`),
  ADD CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
