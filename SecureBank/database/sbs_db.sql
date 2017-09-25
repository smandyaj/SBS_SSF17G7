-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 23, 2017 at 04:30 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sbs_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `account_id` bigint(16) NOT NULL,
  `account_type` int(11) NOT NULL,
  `account_balance` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `external_users`
--

CREATE TABLE `external_users` (
  `customer_id` int(10) NOT NULL,
  `email_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
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
  `password_hash` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `internal_user`
--

CREATE TABLE `internal_user` (
  `user_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `user_type` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `user_mail_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `user_phone_number` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sessions`
--

CREATE TABLE `sessions` (
  `session_id` varchar(255) NOT NULL,
  `expiry_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `customer_id` int(10) NOT NULL,
  `login_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
  `transaction_type` int(11) NOT NULL,
  `transaction_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `transaction_status` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `payer_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `receiver_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `transaction_amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`account_id`);

--
-- Indexes for table `external_users`
--
ALTER TABLE `external_users`
  ADD PRIMARY KEY (`customer_id`),
  ADD UNIQUE KEY `UNIQUE` (`phone`);

--
-- Indexes for table `internal_user`
--
ALTER TABLE `internal_user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`session_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
