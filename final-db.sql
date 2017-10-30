-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 30, 2017 at 04:40 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sbs`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_type` int(11) NOT NULL,
  `account_balance` decimal(10,0) NOT NULL,
  `customer_id` int(10) DEFAULT NULL,
  `account_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `account_limit` decimal(10,0) NOT NULL,
  `account_due` int(11) NOT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`account_id`, `account_type`, `account_balance`, `customer_id`, `account_name`, `account_limit`, `account_due`) VALUES
(1, 1, '1200', 1, 'checking', '0', 0),
(2, 1, '1001', 4, 'checking', '0', 0),
(3, 0, '1330', 1, 'savings', '0', 0),
(6, 0, '990', 4, 'savings', '0', 0),
(7, 2, '1000', 1, 'credit', '100000', 10102017);

-- --------------------------------------------------------

--
-- Table structure for table `external_users`
--

DROP TABLE IF EXISTS `external_users`;
CREATE TABLE IF NOT EXISTS `external_users` (
  `customer_id` int(10) NOT NULL AUTO_INCREMENT,
  `email_id` varchar(40) DEFAULT NULL,
  `first_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `customer_address` varchar(30) NOT NULL,
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `country` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `zip` int(8) NOT NULL,
  `phone` int(10) NOT NULL,
  `account_type` int(11) NOT NULL,
  `customer_type` int(11) NOT NULL,
  `balance` double NOT NULL,
  `password_hash` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `user_type` varchar(50) NOT NULL DEFAULT 'CUSTOMER',
  `user_name` varchar(100) DEFAULT 'smandyaj',
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `external_users`
--

INSERT INTO `external_users` (`customer_id`, `email_id`, `first_name`, `last_name`, `customer_address`, `state`, `country`, `zip`, `phone`, `account_type`, `customer_type`, `balance`, `password_hash`, `user_type`, `user_name`) VALUES
(1, 'santosh.mandyajayaram@gmail.com', 'Santosh', 'MJ', 'something', 'AZ', 'USA', 85281, 48030021, 1, 0, 1000, '$2a$11$eBpPJZy6sD.QXBV3G5RH6e11jbD6ITecvNWUxfRBz4KvOm2/DqLvK', 'CUSTOMER', 'smandyaj1'),
(4, 'santosh.mandyajayaram@gmail.com', 'Santosh', 'MJ1', 'something', 'AZ', 'USA', 85281, 480220021, 1, 0, 1000, '$2a$11$z1d5iyE.ZyGb1LzMBLm4tuD.nNEWiKsqJAXaZWR4pBT7m284hCGAG', 'CUSTOMER', 'smandyaj2');

-- --------------------------------------------------------

--
-- Table structure for table `internal_users`
--

DROP TABLE IF EXISTS `internal_users`;
CREATE TABLE IF NOT EXISTS `internal_users` (
  `employee_id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_type` int(1) NOT NULL,
  `first_name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `mail_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` bigint(10) NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password_hash` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_date` datetime NOT NULL,
  `last_login` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_type` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'REGULAR',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `internal_users`
--

INSERT INTO `internal_users` (`employee_id`, `employee_type`, `first_name`, `last_name`, `mail_id`, `phone_number`, `address`, `user_name`, `password_hash`, `creation_date`, `last_login`, `user_type`) VALUES
(4, 2, 'santosh', 'mj11', 'smj@asu', 4803002224, 'something11', 'smandyaj3', '$2a$11$D8ZGC10vtqbiUVOUMGSRUuBa.FQVbHrIrD91FbGZnm0lVmNvBmSqW', '2017-10-04 18:19:40', '2017-10-17 06:11:57', 'REGULAR'),
(6, 1, 'santosh1', 'mj1', 'smj1@asu', 4803002224, 'something', 'smandyaj4', '$2a$11$M74852doYfHH3Odt9q2JYe67pdxeKw/AalMjFk4pdliPW/zo4imfi', '2017-10-04 18:31:11', '2017-10-17 06:11:57', 'REGULAR');

-- --------------------------------------------------------

--
-- Table structure for table `modified_users`
--

DROP TABLE IF EXISTS `modified_users`;
CREATE TABLE IF NOT EXISTS `modified_users` (
  `id` int(10) NOT NULL,
  `first_name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `mail_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` bigint(10) NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `user_type` int(1) NOT NULL,
  `status` int(1) NOT NULL,
  `status_quo` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `mod_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`mod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `modified_users`
--

INSERT INTO `modified_users` (`id`, `first_name`, `last_name`, `mail_id`, `phone_number`, `address`, `user_name`, `user_type`, `status`, `status_quo`, `mod_id`) VALUES
(2, 'Santosh', 'MJ1', '1@gmail.com', 480220021, 'something', 'smj', 1, 1, 'approved', 5),
(3, 'Santosh', 'MJ1', '1@gmail.com', 480220021, 'something', 'smj', 1, 1, 'approved', 6),
(4, 'Santosh', 'MJ1', '1@gmail.com', 480220021, 'something', 'smj', 1, 2, 'declined', 7),
(5, 'Santosh', 'MJ1', '1@gmail.com', 480220021, 'something', 'smj', 1, 1, 'approved', 8),
(1, 'Santosh', 'MJ', '1@asu.edu', 6666666, 'something else', 'smandyaj1', 3, 0, 'pending', 9);

-- --------------------------------------------------------

--
-- Table structure for table `otp`
--

DROP TABLE IF EXISTS `otp`;
CREATE TABLE IF NOT EXISTS `otp` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `otp` varchar(100) DEFAULT NULL,
  `datetime` datetime NOT NULL,
  `transactionId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `otp`
--

INSERT INTO `otp` (`id`, `otp`, `datetime`, `transactionId`, `customerId`, `type`) VALUES
(5, '$2a$11$IhnHLBXTRhQEEzP93ApP6uEcjve8YPreCk80OWfYktohJGAlq9nqC', '2017-10-30 01:20:41', 48, 1, 'creditdebit'),
(6, '$2a$11$kwJSx0hh.LRmonVDfVYwRegHPSUG5mGe1dTKEAvgP3mB0BbNTekvW', '2017-10-30 03:57:33', 49, 1, 'creditdebit'),
(7, '$2a$11$qBwdECChDM1gFpL2pwtnp.p/XD51zDxgP0hTLZUnyt7Gkch9JV.vG', '2017-10-30 04:11:00', 50, 1, 'creditdebit');

-- --------------------------------------------------------

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
CREATE TABLE IF NOT EXISTS `sessions` (
  `session_id` varchar(255) NOT NULL,
  `expiry_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `customer_id` int(10) NOT NULL,
  `login_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `systemlog`
--

DROP TABLE IF EXISTS `systemlog`;
CREATE TABLE IF NOT EXISTS `systemlog` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `action` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `systemlog`
--

INSERT INTO `systemlog` (`id`, `login_time`, `last_name`, `first_name`, `action`) VALUES
(1, '2017-09-30 04:50:09', 'MJ', 'Santosh', 'Debit'),
(2, '2017-09-30 04:50:09', 'SJ', 'Abhi', 'Credit'),
(3, '2017-09-30 04:50:09', 'AJ', 'Ambi', 'Both');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_type` int(11) NOT NULL,
  `transaction_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `payer_id` bigint(11) DEFAULT NULL,
  `receiver_id` bigint(11) DEFAULT NULL,
  `transaction_amount` float NOT NULL,
  `status` int(11) DEFAULT '0',
  `status_quo` varchar(100) COLLATE utf8_unicode_ci DEFAULT 'PENDING',
  `auth` int(11) DEFAULT '0',
  `senderAccNumber` bigint(11) DEFAULT NULL,
  `receiverAccNumber` bigint(11) DEFAULT NULL,
  `pair_id` int(10) DEFAULT NULL,
  `is_critical` int(11) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `transaction_type`, `transaction_create_time`, `payer_id`, `receiver_id`, `transaction_amount`, `status`, `status_quo`, `auth`, `senderAccNumber`, `receiverAccNumber`, `pair_id`, `is_critical`) VALUES
(29, 0, '2017-10-30 01:57:14', 1, 1, 10, 1, 'approved', 1, 3, 1, 0, 0),
(30, 1, '2017-10-30 01:57:14', 1, 1, 10, 1, 'approved', 0, 3, 1, 0, 0),
(31, 0, '2017-10-30 02:03:08', 1, 1, 10, 1, 'approved', 1, 3, 1, 0, 0),
(32, 1, '2017-10-30 02:03:08', 1, 1, 10, 1, 'approved', 0, 3, 1, 0, 0),
(35, 0, '2017-10-30 02:04:57', 1, 4, 10, 2, 'declined', 1, 3, 2, 0, 0),
(36, 1, '2017-10-30 02:04:57', 1, 4, 10, 1, 'approved', 0, 3, 2, 0, 0),
(37, 0, '2017-10-30 14:50:40', 1, 4, 501, 0, 'pending', 1, 3, 2, 0, 1),
(38, 1, '2017-10-30 02:16:42', 1, 4, 501, 1, 'approved', 0, 3, 2, 0, 1),
(48, 0, '2017-10-30 08:20:41', 1, 1, 501, 0, 'pending', 1, 1, 1, 0, 1),
(49, 1, '2017-10-30 10:57:33', 1, 1, 501, 4, 'otp', 1, 3, 3, 0, 1),
(50, 0, '2017-10-30 11:11:00', 1, 1, 501, 4, 'otp', 1, 1, 1, 0, 1),
(51, 0, '2017-10-30 14:27:08', 4, 1, 100, 1, 'approved', 0, 2, 3, 0, 1),
(52, 1, '2017-10-30 14:27:08', 4, 1, 100, 1, 'approved', 1, 2, 3, 0, 1),
(53, 0, '2017-10-30 14:27:22', 4, 1, 220, 1, 'approved', 0, 2, 3, 0, 1),
(54, 1, '2017-10-30 14:27:22', 4, 1, 220, 1, 'approved', 1, 2, 3, 0, 1),
(55, 0, '2017-10-30 14:57:59', 4, 1, 100, 2, 'declined', 0, 2, 3, 0, 1),
(56, 1, '2017-10-30 14:57:59', 4, 1, 100, 1, 'approved', 1, 2, 3, 0, 1),
(57, 0, '2017-10-30 15:01:42', 4, 1, 13, 2, 'declined', 0, 2, 3, 0, 1),
(58, 1, '2017-10-30 15:01:42', 4, 1, 13, 1, 'approved', 1, 2, 3, 0, 1),
(59, 0, '2017-10-30 15:08:18', 1, 4, 14, 0, 'pending', 0, 3, 6, 0, 1),
(60, 1, '2017-10-30 15:08:18', 1, 4, 14, 1, 'approved', 1, 3, 6, 0, 1),
(61, 0, '2017-10-30 15:25:28', 4, 1, 10, 1, 'approved', 0, 6, 3, 0, 1),
(62, 1, '2017-10-30 15:25:28', 4, 1, 10, 1, 'approved', 1, 6, 3, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` int(11) DEFAULT '1',
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_name`, `password`, `enabled`) VALUES
('manager', '$2a$11$3UGrQHloimzHntUkcEiAhOYJf1HISsQOBCDGc9mQFTHwGcw2hwWjy', 1),
('smandyaj1', '$2a$11$eBpPJZy6sD.QXBV3G5RH6e11jbD6ITecvNWUxfRBz4KvOm2/DqLvK', 1),
('smandyaj2', '$2a$11$z1d5iyE.ZyGb1LzMBLm4tuD.nNEWiKsqJAXaZWR4pBT7m284hCGAG', 1),
('smandyaj3', '$2a$11$D8ZGC10vtqbiUVOUMGSRUuBa.FQVbHrIrD91FbGZnm0lVmNvBmSqW', 1),
('smandyaj4', '$2a$11$M74852doYfHH3Odt9q2JYe67pdxeKw/AalMjFk4pdliPW/zo4imfi', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_name` varchar(100) NOT NULL,
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(100) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_name`, `role_id`, `role`) VALUES
('smandyaj1', 1, 'ROLE_CUSTOMER'),
('smandyaj2', 2, 'ROLE_MERCHANT'),
('smandyaj3', 3, 'ROLE_ADMIN'),
('smandyaj4', 4, 'ROLE_REGULAR'),
('manager', 5, 'ROLE_MANAGER');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
