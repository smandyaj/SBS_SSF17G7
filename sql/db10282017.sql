-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sbs
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_type` int(11) NOT NULL,
  `account_balance` decimal(10,0) NOT NULL,
  `customer_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,1,1980,1),(2,1,2020,4);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `external_users`
--

DROP TABLE IF EXISTS `external_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `external_users` (
  `customer_id` int(10) NOT NULL AUTO_INCREMENT,
  `email_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `customer_address` varchar(30) NOT NULL,
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `country` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `zip` int(8) NOT NULL,
  `phone` bigint(10) DEFAULT NULL,
  `account_type` int(11) NOT NULL,
  `customer_type` int(11) NOT NULL,
  `balance` double NOT NULL,
  `password_hash` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `user_type` varchar(50) NOT NULL DEFAULT 'CUSTOMER',
  `user_name` varchar(100) DEFAULT 'smandyaj',
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_users`
--

LOCK TABLES `external_users` WRITE;
/*!40000 ALTER TABLE `external_users` DISABLE KEYS */;
INSERT INTO `external_users` VALUES (1,'1@asu.edu','Santosh','MJ','something','AZ','USA',85281,48030021,1,0,1000,'$2a$11$eBpPJZy6sD.QXBV3G5RH6e11jbD6ITecvNWUxfRBz4KvOm2/DqLvK','CUSTOMER','smandyaj1'),(4,'1@asu.edu','Santosh','MJ1','something','AZ','USA',85281,480220021,1,0,1000,'$2a$11$z1d5iyE.ZyGb1LzMBLm4tuD.nNEWiKsqJAXaZWR4pBT7m284hCGAG','CUSTOMER','smandyaj2');
/*!40000 ALTER TABLE `external_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `internal_users`
--

DROP TABLE IF EXISTS `internal_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internal_users` (
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internal_users`
--

LOCK TABLES `internal_users` WRITE;
/*!40000 ALTER TABLE `internal_users` DISABLE KEYS */;
INSERT INTO `internal_users` VALUES (4,2,'santosh','mj11','smj@asu',4803002224,'something11','smandyaj3','$2a$11$D8ZGC10vtqbiUVOUMGSRUuBa.FQVbHrIrD91FbGZnm0lVmNvBmSqW','2017-10-04 18:19:40','2017-10-17 06:11:57','REGULAR'),(6,1,'santosh1','mj1','smj12@asu',4803002224,'something','smandyaj4','$2a$11$M74852doYfHH3Odt9q2JYe67pdxeKw/AalMjFk4pdliPW/zo4imfi','2017-10-04 18:31:11','2017-10-17 06:11:57','REGULAR'),(7,0,'aadithya','ravindran','aadi@asu.edu',480222011,'same address','aadi','aadi','2017-10-22 11:15:07','2017-10-22 18:15:07','REGULAR');
/*!40000 ALTER TABLE `internal_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modified_users`
--

DROP TABLE IF EXISTS `modified_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modified_users` (
  `id` int(10) NOT NULL,
  `first_name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `mail_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` bigint(10) NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_type` int(1) NOT NULL,
  `status` int(1) NOT NULL,
  `status_quo` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `mod_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`mod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modified_users`
--

LOCK TABLES `modified_users` WRITE;
/*!40000 ALTER TABLE `modified_users` DISABLE KEYS */;
INSERT INTO `modified_users` VALUES (2,'Santosh','MJ1','1@gmail.com',480220021,'something',1,1,'approved',5),(3,'Santosh','MJ1','1@gmail.com',480220021,'something',1,1,'approved',6),(4,'Santosh','MJ1','1@gmail.com',480220021,'something',1,2,'declined',7),(5,'Santosh','MJ1','1@gmail.com',480220021,'something',1,1,'approved',8),(6,'santosh12','mj12','smj1@asu',4803002224,'something',1,1,'pending',9),(1,'Santosh','MJ1','smandyaj1@asu.edu',4803002221,'tempe1',0,1,'approved',10),(4,'Santosh','MJ2','smandyaj2@asu.edu',4803002222,'tempe2',0,0,'pending',11);
/*!40000 ALTER TABLE `modified_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otp`
--

DROP TABLE IF EXISTS `otp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `otp` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `otp` varchar(100) DEFAULT NULL,
  `datetime` datetime NOT NULL,
  `transactionId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otp`
--

LOCK TABLES `otp` WRITE;
/*!40000 ALTER TABLE `otp` DISABLE KEYS */;
/*!40000 ALTER TABLE `otp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessions` (
  `session_id` varchar(255) NOT NULL,
  `expiry_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `customer_id` int(10) NOT NULL,
  `login_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemlog`
--

DROP TABLE IF EXISTS `systemlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemlog` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `action` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemlog`
--

LOCK TABLES `systemlog` WRITE;
/*!40000 ALTER TABLE `systemlog` DISABLE KEYS */;
INSERT INTO `systemlog` VALUES (1,'2017-09-30 11:50:09','MJ','Santosh','Debit'),(2,'2017-09-30 11:50:09','SJ','Abhi','Credit'),(3,'2017-09-30 11:50:09','AJ','Ambi','Both');
/*!40000 ALTER TABLE `systemlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
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
  `transaction_type_quo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (11,0,'2017-10-28 18:32:31',1,4,10,1,'approved',1,1,2,'sellf'),(12,1,'2017-10-28 18:32:31',1,4,10,1,'approved',1,1,2,'self'),(13,0,'2017-10-28 18:32:31',1,4,510,1,'approved',1,1,2,'self'),(14,1,'2017-10-28 18:32:31',1,4,510,0,'pending',1,1,2,'self');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_name` varchar(100) NOT NULL,
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(100) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES ('smandyaj1',1,'ROLE_CUSTOMER'),('smandyaj2',2,'ROLE_MERCHANT'),('smandyaj3',3,'ROLE_ADMIN'),('smandyaj4',4,'ROLE_REGULAR'),('aadi',5,'ROLE_MANAGER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` int(11) DEFAULT '1',
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('aadi','$2a$11$mIzbbud7wLAr34npRjEqreFTYa/z6EwL5ppFDPqJxvuMmZzHiMEci',1),('smandyaj1','$2a$11$eBpPJZy6sD.QXBV3G5RH6e11jbD6ITecvNWUxfRBz4KvOm2/DqLvK',1),('smandyaj2','$2a$11$z1d5iyE.ZyGb1LzMBLm4tuD.nNEWiKsqJAXaZWR4pBT7m284hCGAG',1),('smandyaj3','$2a$11$D8ZGC10vtqbiUVOUMGSRUuBa.FQVbHrIrD91FbGZnm0lVmNvBmSqW',1),('smandyaj4','$2a$11$M74852doYfHH3Odt9q2JYe67pdxeKw/AalMjFk4pdliPW/zo4imfi',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-28 18:03:39
