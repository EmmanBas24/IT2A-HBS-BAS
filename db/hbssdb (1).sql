-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2025 at 02:48 AM
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
-- Database: `hbssdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE `guest` (
  `g_id` int(11) NOT NULL,
  `g_fname` varchar(100) NOT NULL,
  `g_lname` varchar(100) NOT NULL,
  `g_email` varchar(100) DEFAULT NULL,
  `g_status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `guest`
--

INSERT INTO `guest` (`g_id`, `g_fname`, `g_lname`, `g_email`, `g_status`) VALUES
(101, 'rica', 'patenio', 'rica@gmail.com', 'Active'),
(107, 'John', 'Doe', 'john.doe@example.com', 'Active'),
(108, 'Jane', 'Smith', 'jane.smith@example.com', 'Pending'),
(109, 'Carlos', 'Reyes', 'carlos.reyes@example.com', 'Active'),
(110, 'Maria', 'Santos', 'maria.santos@example.com', 'Pending'),
(111, 'Liam', 'Garcia', 'liam.garcia@example.com', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(20) NOT NULL,
  `booking_id` int(20) NOT NULL,
  `amount` decimal(50,2) NOT NULL,
  `payment_method` varchar(50) NOT NULL,
  `payment_status` varchar(50) NOT NULL,
  `payment_date` datetime NOT NULL,
  `handled_by` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_id`, `booking_id`, `amount`, `payment_method`, `payment_status`, `payment_date`, `handled_by`) VALUES
(8, 14, 2500.00, 'cash', 'Paid', '2025-05-22 06:34:16', 1007),
(9, 15, 8000.00, 'cash', 'Paid', '2025-05-22 06:45:08', 1007),
(10, 16, 3000.00, 'cash', 'Paid', '2025-05-22 07:08:35', 1007);

-- --------------------------------------------------------

--
-- Table structure for table `room_category`
--

CREATE TABLE `room_category` (
  `rc_id` int(11) NOT NULL,
  `category_name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `price_per_night` decimal(65,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `room_category`
--

INSERT INTO `room_category` (`rc_id`, `category_name`, `description`, `price_per_night`) VALUES
(18, 'Standard Room', 'A cozy room with basic amenities for budget travelers.', 1500.00),
(19, 'Deluxe Room', 'Spacious room with a queen-size bed, mini-fridge, and city view.', 2500.00),
(20, 'Family Suite', 'Large suite ideal for families with two beds and a living area.', 4000.00),
(21, 'Executive Room', 'Room for business travelers with work desk and high-speed internet.', 3200.00),
(22, 'Presidential Suite', 'Luxurious suite with living room, kitchen, and Jacuzzi.', 8000.00);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_booking`
--

CREATE TABLE `tbl_booking` (
  `booking_id` int(20) NOT NULL,
  `g_id` int(20) NOT NULL,
  `u_id` int(20) NOT NULL,
  `check_in_date` date NOT NULL,
  `check_out_date` date NOT NULL,
  `b_status` varchar(20) NOT NULL,
  `room_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_booking`
--

INSERT INTO `tbl_booking` (`booking_id`, `g_id`, `u_id`, `check_in_date`, `check_out_date`, `b_status`, `room_id`) VALUES
(14, 101, 1007, '2025-05-22', '2025-05-23', 'Checked-In', 50),
(15, 109, 1007, '2025-05-22', '2025-05-24', 'Checked-In', 51),
(16, 107, 1007, '2025-05-22', '2025-05-24', 'Checked-In', 47);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_rooms`
--

CREATE TABLE `tbl_rooms` (
  `room_id` int(11) NOT NULL,
  `room_number` int(15) NOT NULL,
  `room_status` varchar(100) NOT NULL,
  `rc_id` int(100) NOT NULL,
  `category_name` varchar(100) NOT NULL,
  `price_per_night` decimal(65,0) NOT NULL,
  `room_floor` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_rooms`
--

INSERT INTO `tbl_rooms` (`room_id`, `room_number`, `room_status`, `rc_id`, `category_name`, `price_per_night`, `room_floor`) VALUES
(47, 101, 'Occupied', 18, 'Standard Room', 1500, 1),
(48, 102, 'Available', 18, 'Standard Room', 1500, 1),
(49, 201, 'Available', 19, 'Deluxe Room', 2500, 2),
(50, 202, 'Occupied', 19, 'Deluxe Room', 2500, 2),
(51, 301, 'Occupied', 20, 'Family Suite', 4000, 3),
(52, 401, 'Available', 21, 'Executive Room', 3200, 4),
(53, 501, 'Available', 22, 'Presidential Suite', 8000, 5);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(20) NOT NULL,
  `u_user` varchar(50) NOT NULL,
  `u_pass` varchar(50) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `u_image` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_user`, `u_pass`, `u_fname`, `u_lname`, `u_email`, `u_type`, `u_status`, `u_image`) VALUES
(1006, 'emman', 'cPmAePssfXv7OuFzMLkeqgGBELA4lpebTIi/rtOAWQY=', 'emman', 'bas', 'emman@test.com', 'Admin', 'Active', NULL),
(1007, 'qwer', 'cPmAePssfXv7OuFzMLkeqgGBELA4lpebTIi/rtOAWQY=', 'emman', 'bas', 'qwer@test.com', 'Receptionist', 'Active', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `guest`
--
ALTER TABLE `guest`
  ADD PRIMARY KEY (`g_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `bid` (`booking_id`),
  ADD KEY `uid` (`handled_by`);

--
-- Indexes for table `room_category`
--
ALTER TABLE `room_category`
  ADD PRIMARY KEY (`rc_id`);

--
-- Indexes for table `tbl_booking`
--
ALTER TABLE `tbl_booking`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `gid` (`g_id`),
  ADD KEY `uid` (`u_id`) USING BTREE,
  ADD KEY `rid` (`room_id`);

--
-- Indexes for table `tbl_rooms`
--
ALTER TABLE `tbl_rooms`
  ADD PRIMARY KEY (`room_id`),
  ADD KEY `cid` (`rc_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `guest`
--
ALTER TABLE `guest`
  MODIFY `g_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `room_category`
--
ALTER TABLE `room_category`
  MODIFY `rc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `tbl_booking`
--
ALTER TABLE `tbl_booking`
  MODIFY `booking_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tbl_rooms`
--
ALTER TABLE `tbl_rooms`
  MODIFY `room_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1008;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `bid` FOREIGN KEY (`booking_id`) REFERENCES `tbl_booking` (`booking_id`),
  ADD CONSTRAINT `u_id` FOREIGN KEY (`handled_by`) REFERENCES `tbl_user` (`u_id`);

--
-- Constraints for table `tbl_booking`
--
ALTER TABLE `tbl_booking`
  ADD CONSTRAINT `gid` FOREIGN KEY (`g_id`) REFERENCES `guest` (`g_id`),
  ADD CONSTRAINT `rid` FOREIGN KEY (`room_id`) REFERENCES `tbl_rooms` (`room_id`),
  ADD CONSTRAINT `uid` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);

--
-- Constraints for table `tbl_rooms`
--
ALTER TABLE `tbl_rooms`
  ADD CONSTRAINT `cid` FOREIGN KEY (`rc_id`) REFERENCES `room_category` (`rc_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
