-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 05, 2017 at 04:51 AM
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
-- Database: `sbs`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `account_id` int(11) NOT NULL,
  `account_type` int(11) NOT NULL,
  `account_balance` decimal(10,0) NOT NULL,
  `customer_id` int(10) DEFAULT NULL,
  `account_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `account_limit` decimal(10,0) NOT NULL,
  `account_due` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`account_id`, `account_type`, `account_balance`, `customer_id`, `account_name`, `account_limit`, `account_due`) VALUES
(1, 1, '1200', 1, 'checking', '0', 0),
(2, 1, '1001', 4, 'checking', '0', 0),
(3, 0, '730', 1, 'savings', '0', 0),
(6, 0, '990', 4, 'savings', '0', 0),
(7, 2, '1000', 1, 'credit', '100000', 10102017),
(9, 0, '1600', 5, 'Savings', '1000', 0),
(10, 0, '1000', 6, 'Savings', '1000', 0),
(11, 2, '1000', 7, 'Credit', '1000', 0);

-- --------------------------------------------------------

--
-- Table structure for table `external_users`
--

CREATE TABLE `external_users` (
  `customer_id` int(10) NOT NULL,
  `email_id` varchar(100) DEFAULT NULL,
  `first_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `customer_address` varchar(100) NOT NULL,
  `phone` bigint(10) NOT NULL,
  `customer_type` int(11) NOT NULL,
  `password_hash` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(100) DEFAULT 'smandyaj',
  `secret_key` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `external_users`
--

INSERT INTO `external_users` (`customer_id`, `email_id`, `first_name`, `last_name`, `customer_address`, `phone`, `customer_type`, `password_hash`, `user_name`, `secret_key`) VALUES
(1, 'ambarish.ravindran@gmail.com', 'Santosh', 'MJ', 'something', 48030021, 0, '$2a$11$eBpPJZy6sD.QXBV3G5RH6e11jbD6ITecvNWUxfRBz4KvOm2/DqLvK', 'smandyaj1', ''),
(4, 'santosh.mandyajayaram@gmail.com', 'Santosh', 'MJ1', 'something', 480220021, 0, '$2a$11$z1d5iyE.ZyGb1LzMBLm4tuD.nNEWiKsqJAXaZWR4pBT7m284hCGAG', 'smandyaj2', ''),
(5, 'chandanshetty@asu.edu', 'Chandan', 'Somashekar', 'asu', 677288819, 1, '$2a$11$h.6IYxLwOoIcx4ppdOrUo.tzKsIHnyqP.GwKtIYVDcXmDDmv7vWEu', 'chandan', ''),
(6, 'chandangs16@outlook.com', 'Chandan', 'Shetrty', 'Bengaluru', 973982819, 0, '$2a$11$D3S4uF7YeGO3Bn49ykZ23Oqb33xClU60NokHJKf478KJFvEtgLBIC', 'chandanshetty', '$2a$11$9e.O6zQ93UHgmUAEZzPQdepVpTaMkz8EZ8aYRd6eB2Q2EXdhyTLSy'),
(7, 'chandangs16@outlook.com', 'Chanadan', 'Shetty', 'great', 672818910, 0, '$2a$11$nYLtP76qhKNS57SHgRKGSeGThfKiFg.I.QDn/r/FvZfJOjtsu1glO', 'chandan12', '$2a$11$Kaev07bw0G8/GWIhIhO0JefwgfJqRK39jACg3HG4VTAc6g/PaIELK');

-- --------------------------------------------------------

--
-- Table structure for table `internal_users`
--

CREATE TABLE `internal_users` (
  `employee_id` int(10) NOT NULL,
  `employee_type` int(1) NOT NULL,
  `first_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `mail_id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` bigint(12) NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password_hash` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_date` datetime NOT NULL,
  `last_login` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_type` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'REGULAR'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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

CREATE TABLE `modified_users` (
  `id` int(10) NOT NULL,
  `first_name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `mail_id` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` bigint(12) NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `user_type` int(1) NOT NULL,
  `status` int(1) NOT NULL,
  `status_quo` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `mod_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `modified_users`
--

INSERT INTO `modified_users` (`id`, `first_name`, `last_name`, `mail_id`, `phone_number`, `address`, `user_name`, `user_type`, `status`, `status_quo`, `mod_id`) VALUES
(2, 'Santosh', 'MJ1', '1@gmail.com', 480220021, 'something', 'smj', 1, 1, 'approved', 5),
(3, 'Santosh', 'MJ1', '1@gmail.com', 480220021, 'something', 'smj', 1, 1, 'approved', 6),
(4, 'Santosh', 'MJ1', '1@gmail.com', 480220021, 'something', 'smj', 1, 2, 'declined', 7),
(5, 'Santosh', 'MJ1', '1@gmail.com', 480220021, 'something', 'smj', 1, 1, 'approved', 8),
(1, 'Santosh', 'MJ', '1@asu.edu', 6666666, 'something else', 'smandyaj1', 3, 0, 'pending', 9),
(1, 'Santosh', 'MJ', 'ambarish.ravindran@gmail.com', 48030021, 'something', 'smandyaj1', 0, 0, 'pending', 10),
(7, 'Chanadan', 'Shetty', 'chandangs16@outlook.com', 672818910, 'great12', 'chandan12', 0, 0, 'pending', 11),
(7, 'Chanadan', 'Shetty', 'chandangs16@outlook.com', 672818910, 'great14', 'chandan12', 0, 0, 'pending', 12);

-- --------------------------------------------------------

--
-- Table structure for table `otp`
--

CREATE TABLE `otp` (
  `id` int(40) NOT NULL,
  `otp` varchar(100) DEFAULT NULL,
  `datetime` datetime NOT NULL,
  `transactionId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `otp`
--

INSERT INTO `otp` (`id`, `otp`, `datetime`, `transactionId`, `customerId`, `type`) VALUES
(5, '$2a$11$IhnHLBXTRhQEEzP93ApP6uEcjve8YPreCk80OWfYktohJGAlq9nqC', '2017-10-30 01:20:41', 48, 1, 'creditdebit'),
(6, '$2a$11$kwJSx0hh.LRmonVDfVYwRegHPSUG5mGe1dTKEAvgP3mB0BbNTekvW', '2017-10-30 03:57:33', 49, 1, 'creditdebit'),
(7, '$2a$11$qBwdECChDM1gFpL2pwtnp.p/XD51zDxgP0hTLZUnyt7Gkch9JV.vG', '2017-10-30 04:11:00', 50, 1, 'creditdebit'),
(8, '$2a$11$9/1xtWD0z49QSInFmufT.eFg/toIiTtM0RswyWYUmR14zdIVFaq5G', '2017-10-30 11:39:16', 69, 1, 'creditdebit'),
(9, '$2a$11$hxyXEevaMqhXaJIy2SNHz.rx24c.l7PUFgyHqWXins.mqknllPnS6', '2017-10-30 11:42:17', 70, 1, 'creditdebit'),
(10, '$2a$11$NWVO24jNgg5VBRFmXXG/beqflAbHHzwAcwACDaSTDaa9IySdtuZPC', '2017-10-30 11:48:57', 71, 1, 'creditdebit'),
(11, '$2a$11$orfGANyG3LRepvnKfyD38OPPg9GM5Ii6GGLQnBk6wAJerqN0oCBba', '2017-10-30 11:52:36', 72, 1, 'creditdebit'),
(12, '$2a$11$2eGK8A7.ycNaxYGXkO9GM.wRCATyZ1H4XJfXBGjv728oFb/Y./Lve', '2017-10-30 12:07:10', 73, 1, 'creditdebit'),
(13, '$2a$11$AlaK7nhsRHcojIdgABJ2.OeZaKbFJkFE8f7EdLbreodZQfvOQr0tG', '2017-10-30 12:14:44', 74, 1, 'creditdebit'),
(14, '$2a$11$Kq4gVvUPSMmAzc/VajS7heC3PkT4Qr5IOmBLzYdV342Td3nfCoE5S', '2017-10-30 12:26:57', 75, 1, 'creditdebit'),
(15, '$2a$11$pS8rSanUSHGdd7ZwbdtLfOvydGAjS6EyW.8UvVTRueZ8COGxY2zni', '2017-10-30 12:37:10', 76, 1, 'creditdebit'),
(16, '$2a$11$Htf0VO4IKZ/MK524IlEaUemmTjMkNs2rsKo7frHPlfqsdLtmbzIDO', '2017-10-30 12:37:25', 77, 1, 'creditdebit'),
(17, '$2a$11$Z8vjxY3quWI5JGzdbZWzGusJdVw.Xw8RYXbWH3cxO6YomZ6k1AaCO', '2017-10-30 12:38:03', 78, 1, 'creditdebit'),
(18, '$2a$11$5mDbpmL5iRqDmiDgvoZqhOFu.F4RcKg3KYn5ldDWpqKfjAefsDabm', '2017-10-30 12:43:38', 79, 1, 'creditdebit'),
(19, '$2a$11$LQQ6pqRAjz13TZKPKVKMxOuq8ZtqJ7j.ASzf7hs/jT3uSvL.eiFWu', '2017-10-30 12:46:29', 80, 1, 'creditdebit'),
(20, '$2a$11$htGQdimixhts/NeT2vlkPO8eNb6bJV65FTo07DPcs/7oBkCXOHdWq', '2017-11-04 20:23:24', 82, 1, 'creditdebit'),
(21, '$2a$11$/wAOxLmSOo6CpHrH4Otoi.OJcMRDi2ci1speijk9LQ7dqnSPJ3gwm', '2017-11-04 20:37:12', 83, 1, 'creditdebit'),
(22, '$2a$11$yXhegokmejNc7g3HrBH.DOt0uOV534LHtKS6i.XkzCIh0KBeA2Yla', '2017-11-04 20:39:39', 84, 1, 'creditdebit'),
(23, '$2a$11$tGa0KI7EP7zJi8UsVjKdpe9KGuRY6QnzMTeftcirFdm2lNtqqoUF.', '2017-11-04 20:43:22', 85, 1, 'creditdebit'),
(24, '$2a$11$pIA27aA9GMx54c6u7GXL8Ow2EUXU52Tpq0ofMd.EKZQaPntZexqha', '2017-11-04 20:43:54', 86, 1, 'creditdebit'),
(25, '$2a$11$Zkl0ZSQwmsuR35rRQKI0nOeG0nC2.TU.M0LgQ2hygt4KaWIqfqJs6', '2017-11-04 20:44:18', 87, 1, 'creditdebit'),
(26, '$2a$11$ZpebrK48/2YeiULDtkMss.45VEv4Po4m2PG5Q7O8ql0P5YAaM2T4a', '2017-11-04 20:45:12', 88, 1, 'creditdebit'),
(27, '$2a$11$QNT.gcwtOGdOSezck2b9Q.Z917uw0GHgwM6Uq3axtfE16T3QzsenC', '2017-11-04 20:45:27', 89, 1, 'creditdebit'),
(28, '$2a$11$3bxXpa9ygv6KNnqMeTiU2epZbUFZea2N5rOQObTeq6K1NKtHf2WcS', '2017-11-04 20:49:26', 90, 1, 'creditdebit');

-- --------------------------------------------------------

--
-- Table structure for table `systemlog`
--

CREATE TABLE `systemlog` (
  `id` bigint(16) NOT NULL,
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `action` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `systemlog`
--

INSERT INTO `systemlog` (`id`, `login_time`, `last_name`, `first_name`, `action`) VALUES
(1, '2017-09-30 04:50:09', 'MJ', 'Santosh', 'Debit'),
(2, '2017-09-30 04:50:09', 'SJ', 'Abhi', 'Credit'),
(3, '2017-09-30 04:50:09', 'AJ', 'Ambi', 'Both'),
(4, '2017-11-04 19:34:24', 'MJ', 'Santosh', 'request-money'),
(5, '2017-11-04 22:23:18', 'MJ', 'Santosh', 'request-money'),
(6, '2017-11-04 22:25:05', 'MJ', 'Santosh', 'request-money'),
(7, '2017-11-05 01:55:43', 'MJ', 'Santosh', 'bank-statements'),
(8, '2017-11-05 01:55:49', 'MJ', 'Santosh', 'bank-statements'),
(9, '2017-11-05 01:56:36', 'Somashekar', 'Chandan', 'bank-statements'),
(10, '2017-11-05 01:57:08', 'MJ1', 'Santosh', 'bank-statements'),
(11, '2017-11-05 02:00:13', 'MJ1', 'Santosh', 'bank-statements'),
(12, '2017-11-05 02:00:17', 'MJ1', 'Santosh', 'bank-statements'),
(13, '2017-11-05 02:01:18', 'MJ1', 'Santosh', 'bank-statements'),
(14, '2017-11-05 02:08:04', 'MJ', 'Santosh', 'bank-statements'),
(15, '2017-11-05 02:10:14', 'MJ', 'Santosh', 'bank-statements'),
(16, '2017-11-05 02:10:26', 'MJ', 'Santosh', 'bank-statements'),
(17, '2017-11-05 02:10:31', 'MJ', 'Santosh', 'bank-statements'),
(18, '2017-11-05 02:10:49', 'Somashekar', 'Chandan', 'bank-statements'),
(19, '2017-11-05 02:16:44', 'MJ', 'Santosh', 'bank-statements'),
(20, '2017-11-05 03:20:33', 'MJ', 'Santosh', 'request-money'),
(21, '2017-11-05 03:23:12', 'MJ', 'Santosh', 'credit/debit'),
(22, '2017-11-05 03:23:24', 'MJ', 'Santosh', 'credit/debit'),
(23, '2017-11-05 03:37:12', 'MJ', 'Santosh', 'credit/debit'),
(24, '2017-11-05 03:39:39', 'MJ', 'Santosh', 'credit/debit'),
(25, '2017-11-05 03:43:22', 'MJ', 'Santosh', 'credit/debit'),
(26, '2017-11-05 03:43:54', 'MJ', 'Santosh', 'credit/debit'),
(27, '2017-11-05 03:44:18', 'MJ', 'Santosh', 'credit/debit'),
(28, '2017-11-05 03:45:12', 'MJ', 'Santosh', 'credit/debit'),
(29, '2017-11-05 03:45:26', 'MJ', 'Santosh', 'credit/debit'),
(30, '2017-11-05 03:49:26', 'MJ', 'Santosh', 'credit/debit');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
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
  `is_critical` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `transaction_type`, `transaction_create_time`, `payer_id`, `receiver_id`, `transaction_amount`, `status`, `status_quo`, `auth`, `senderAccNumber`, `receiverAccNumber`, `pair_id`, `is_critical`) VALUES
(81, 3, '2017-11-05 02:16:24', 1, 5, 600, 1, 'approved', 1, 3, 9, 0, 1),
(82, 1, '2017-11-05 03:23:24', 1, 1, 1000, 4, 'otp', 0, 3, 3, 0, 1),
(83, 1, '2017-11-05 03:37:12', 1, 1, 1000, 4, 'otp', 0, 3, 3, 0, 1),
(84, 1, '2017-11-05 03:39:39', 1, 1, 1000, 4, 'otp', 0, 3, 3, 0, 1),
(85, 1, '2017-11-05 03:43:22', 1, 1, 1000, 4, 'otp', 0, 3, 3, 0, 1),
(86, 1, '2017-11-05 03:43:54', 1, 1, 1000, 4, 'otp', 0, 3, 3, 0, 1),
(87, 1, '2017-11-05 03:44:18', 1, 1, 1000, 4, 'otp', 0, 3, 3, 0, 1),
(88, 1, '2017-11-05 03:45:12', 1, 1, 1000, 4, 'otp', 0, 3, 3, 0, 1),
(89, 1, '2017-11-05 03:45:27', 1, 1, 1000, 4, 'otp', 0, 3, 3, 0, 1),
(90, 1, '2017-11-05 03:49:26', 1, 1, 1001, 4, 'otp', 0, 3, 3, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` int(11) DEFAULT '1',
  `email_id` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_name`, `password`, `enabled`, `email_id`) VALUES
('chandan', '$2a$11$h.6IYxLwOoIcx4ppdOrUo.tzKsIHnyqP.GwKtIYVDcXmDDmv7vWEu', 1, 'chandanshetty@asu.edu'),
('chandan12', '$2a$11$nYLtP76qhKNS57SHgRKGSeGThfKiFg.I.QDn/r/FvZfJOjtsu1glO', 1, 'chandangs16@outlook.com'),
('chandanshetty', '$2a$11$D3S4uF7YeGO3Bn49ykZ23Oqb33xClU60NokHJKf478KJFvEtgLBIC', 1, 'chandangs16@outlook.com'),
('hakim', '$2a$11$FM1.M6iqH6Anizq7E4y1jOg4hVgTnBT8b6MfOzJZe/O.nBIKrOJwG', 1, 'hakim.badshah@gmail.com'),
('manager', '$2a$11$3UGrQHloimzHntUkcEiAhOYJf1HISsQOBCDGc9mQFTHwGcw2hwWjy', 1, ''),
('smandyaj1', '$2a$11$eBpPJZy6sD.QXBV3G5RH6e11jbD6ITecvNWUxfRBz4KvOm2/DqLvK', 1, ''),
('smandyaj2', '$2a$11$z1d5iyE.ZyGb1LzMBLm4tuD.nNEWiKsqJAXaZWR4pBT7m284hCGAG', 1, ''),
('smandyaj3', '$2a$11$D8ZGC10vtqbiUVOUMGSRUuBa.FQVbHrIrD91FbGZnm0lVmNvBmSqW', 1, ''),
('smandyaj4', '$2a$11$M74852doYfHH3Odt9q2JYe67pdxeKw/AalMjFk4pdliPW/zo4imfi', 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_name` varchar(100) NOT NULL,
  `role_id` int(11) NOT NULL,
  `role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_name`, `role_id`, `role`) VALUES
('smandyaj1', 1, 'ROLE_CUSTOMER'),
('smandyaj2', 2, 'ROLE_MERCHANT'),
('smandyaj3', 3, 'ROLE_ADMIN'),
('smandyaj4', 4, 'ROLE_REGULAR'),
('manager', 5, 'ROLE_MANAGER'),
('hakim', 6, 'ROLE_ADMIN'),
('chandan', 7, 'ROLE_MERCHANT'),
('chandanshetty', 9, 'ROLE_CUSTOMER'),
('chandan12', 10, 'ROLE_CUSTOMER');

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
-- Indexes for table `internal_users`
--
ALTER TABLE `internal_users`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `modified_users`
--
ALTER TABLE `modified_users`
  ADD PRIMARY KEY (`mod_id`);

--
-- Indexes for table `otp`
--
ALTER TABLE `otp`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `systemlog`
--
ALTER TABLE `systemlog`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_name`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `external_users`
--
ALTER TABLE `external_users`
  MODIFY `customer_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `internal_users`
--
ALTER TABLE `internal_users`
  MODIFY `employee_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `modified_users`
--
ALTER TABLE `modified_users`
  MODIFY `mod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `otp`
--
ALTER TABLE `otp`
  MODIFY `id` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `systemlog`
--
ALTER TABLE `systemlog`
  MODIFY `id` bigint(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;
--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
