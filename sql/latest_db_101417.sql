CREATE DATABASE  IF NOT EXISTS `sbs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sbs`;
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
INSERT INTO `account` VALUES (1,1,1000,1),(2,1,1000,4);
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
  `phone` int(10) NOT NULL,
  `account_type` int(11) NOT NULL,
  `customer_type` int(11) NOT NULL,
  `balance` double NOT NULL,
  `password_hash` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_users`
--

LOCK TABLES `external_users` WRITE;
/*!40000 ALTER TABLE `external_users` DISABLE KEYS */;
INSERT INTO `external_users` VALUES (1,'1@asu.edu','Santosh','MJ','something','AZ','USA',85281,48030021,1,0,1000,'sdsasda'),(4,'1@asu.edu','Santosh','MJ1','something','AZ','USA',85281,480220021,1,0,1000,'sdsasda');
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
  `password_hash` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `creation_date` datetime NOT NULL,
  `last_login` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internal_users`
--

LOCK TABLES `internal_users` WRITE;
/*!40000 ALTER TABLE `internal_users` DISABLE KEYS */;
INSERT INTO `internal_users` VALUES (2,1,'Santosh','MJ1','smj@asu',480220021,'something','smandyaj','a7usy','2017-10-04 13:03:15','2017-10-04 20:03:15'),(3,1,'Santosh','MJ','ssmj@yahoo.com',4803002224,'somewhere','smandyaj','1111','2017-10-04 18:07:01','2017-10-05 01:07:01'),(4,2,'santosh','mj11','smj@asu',4803002224,'something11','smandyaj11','4321','2017-10-04 18:19:40','2017-10-05 01:19:40'),(6,1,'santosh1','mj1','smj1@asu',4803002224,'something','smandyaj','','2017-10-04 18:31:11','2017-10-05 01:31:11');
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
  `user_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password_hash` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `user_type` int(1) NOT NULL,
  `status` int(1) NOT NULL,
  `status_quo` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `mod_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`mod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modified_users`
--

LOCK TABLES `modified_users` WRITE;
/*!40000 ALTER TABLE `modified_users` DISABLE KEYS */;
INSERT INTO `modified_users` VALUES (2,'Santosh','MJ1','1@gmail.com',480220021,'something','smj','abracadrbra',1,1,'approved',5),(3,'Santosh','MJ1','1@gmail.com',480220021,'something','smj','abracadrbra',1,1,'approved',6),(4,'Santosh','MJ1','1@gmail.com',480220021,'something','smj','abracadrbra',1,2,'declined',7),(5,'Santosh','MJ1','1@gmail.com',480220021,'something','smj','abracadrbra',1,1,'approved',8);
/*!40000 ALTER TABLE `modified_users` ENABLE KEYS */;
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
INSERT INTO `systemlog` VALUES (1,'2017-09-30 04:50:09','MJ','Santosh','Debit'),(2,'2017-09-30 04:50:09','SJ','Abhi','Credit'),(3,'2017-09-30 04:50:09','AJ','Ambi','Both');
/*!40000 ALTER TABLE `systemlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
  `transaction_type` int(11) NOT NULL,
  `transaction_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `transaction_status` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `payer_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `receiver_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `transaction_amount` float NOT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-14 17:27:21
