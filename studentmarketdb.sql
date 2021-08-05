-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: studentmarketdb
-- ------------------------------------------------------
-- Server version	5.5.62

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
-- Table structure for table `tblcategory`
--

DROP TABLE IF EXISTS `tblcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblcategory` (
  `categoryID` int(11) NOT NULL AUTO_INCREMENT,
  `catName` varchar(50) DEFAULT NULL,
  `catSumProducts` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcategory`
--

LOCK TABLES `tblcategory` WRITE;
/*!40000 ALTER TABLE `tblcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbllocation`
--

DROP TABLE IF EXISTS `tbllocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbllocation` (
  `locationID` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` decimal(50,0) DEFAULT NULL,
  `longitude` decimal(50,0) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `prodID` int(11) DEFAULT NULL,
  PRIMARY KEY (`locationID`),
  KEY `userID` (`userID`),
  KEY `prodID` (`prodID`),
  CONSTRAINT `tbllocation_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `tbluser` (`userID`),
  CONSTRAINT `tbllocation_ibfk_2` FOREIGN KEY (`prodID`) REFERENCES `tblproduct` (`prodID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbllocation`
--

LOCK TABLES `tbllocation` WRITE;
/*!40000 ALTER TABLE `tbllocation` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbllocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblorder`
--

DROP TABLE IF EXISTS `tblorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblorder` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `prodID` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `orderAmount` float DEFAULT NULL,
  `unitPrice` float DEFAULT NULL,
  `orderQuantity` int(11) DEFAULT NULL,
  `orderNote` varchar(255) DEFAULT NULL,
  `orderDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `locationID` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `userID` (`userID`),
  KEY `prodID` (`prodID`),
  KEY `locationID` (`locationID`),
  CONSTRAINT `tblorder_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `tbluser` (`userID`),
  CONSTRAINT `tblorder_ibfk_2` FOREIGN KEY (`prodID`) REFERENCES `tblproduct` (`prodID`),
  CONSTRAINT `tblorder_ibfk_3` FOREIGN KEY (`locationID`) REFERENCES `tbllocation` (`locationID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblorder`
--

LOCK TABLES `tblorder` WRITE;
/*!40000 ALTER TABLE `tblorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblproduct`
--

DROP TABLE IF EXISTS `tblproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblproduct` (
  `prodID` int(11) NOT NULL AUTO_INCREMENT,
  `categoryID` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `prodName` varchar(50) DEFAULT NULL,
  `prodDescription` varchar(50) DEFAULT NULL,
  `prodPrice` float DEFAULT NULL,
  `prodRange` float DEFAULT NULL,
  `prodLive` tinyint(1) DEFAULT NULL,
  `servTime` int(11) DEFAULT NULL,
  `prodPicture` longblob,
  PRIMARY KEY (`prodID`),
  KEY `userID` (`userID`),
  KEY `categoryID` (`categoryID`),
  CONSTRAINT `tblproduct_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `tbluser` (`userID`),
  CONSTRAINT `tblproduct_ibfk_2` FOREIGN KEY (`categoryID`) REFERENCES `tblcategory` (`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblproduct`
--

LOCK TABLES `tblproduct` WRITE;
/*!40000 ALTER TABLE `tblproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblreview`
--

DROP TABLE IF EXISTS `tblreview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblreview` (
  `reviewID` int(11) NOT NULL AUTO_INCREMENT,
  `prodID` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `reviewStars` int(5) DEFAULT NULL,
  `reviewfeedback` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`reviewID`),
  KEY `userID` (`userID`),
  KEY `prodID` (`prodID`),
  CONSTRAINT `tblreview_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `tbluser` (`userID`),
  CONSTRAINT `tblreview_ibfk_2` FOREIGN KEY (`prodID`) REFERENCES `tblproduct` (`prodID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblreview`
--

LOCK TABLES `tblreview` WRITE;
/*!40000 ALTER TABLE `tblreview` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblreview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblsaved`
--

DROP TABLE IF EXISTS `tblsaved`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblsaved` (
  `savedID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `prodID` int(11) DEFAULT NULL,
  `dateSaved` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`savedID`),
  KEY `prodID` (`prodID`),
  KEY `userID` (`userID`),
  CONSTRAINT `tblsaved_ibfk_1` FOREIGN KEY (`prodID`) REFERENCES `tblproduct` (`prodID`),
  CONSTRAINT `tblsaved_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `tbluser` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblsaved`
--

LOCK TABLES `tblsaved` WRITE;
/*!40000 ALTER TABLE `tblsaved` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblsaved` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblstore`
--

DROP TABLE IF EXISTS `tblstore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblstore` (
  `storeID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `prodID` int(11) DEFAULT NULL,
  `storeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`storeID`),
  KEY `userID` (`userID`),
  KEY `prodID` (`prodID`),
  CONSTRAINT `tblstore_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `tbluser` (`userID`),
  CONSTRAINT `tblstore_ibfk_2` FOREIGN KEY (`prodID`) REFERENCES `tblproduct` (`prodID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblstore`
--

LOCK TABLES `tblstore` WRITE;
/*!40000 ALTER TABLE `tblstore` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblstore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltier`
--

DROP TABLE IF EXISTS `tbltier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbltier` (
  `tierID` int(11) NOT NULL AUTO_INCREMENT,
  `prodID` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `tierPrice` float DEFAULT NULL,
  `tierDescription` varchar(255) DEFAULT NULL,
  `tierName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tierID`),
  KEY `userID` (`userID`),
  KEY `prodID` (`prodID`),
  CONSTRAINT `tbltier_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `tbluser` (`userID`),
  CONSTRAINT `tbltier_ibfk_2` FOREIGN KEY (`prodID`) REFERENCES `tblproduct` (`prodID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltier`
--

LOCK TABLES `tbltier` WRITE;
/*!40000 ALTER TABLE `tbltier` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbltier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbluser`
--

DROP TABLE IF EXISTS `tbluser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbluser` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `userEmail` varchar(50) NOT NULL,
  `userPhonenumber` int(10) DEFAULT NULL,
  `userPassword` varchar(50) DEFAULT NULL,
  `userUniversty` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbluser`
--

LOCK TABLES `tbluser` WRITE;
/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbluser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-05 22:09:08
