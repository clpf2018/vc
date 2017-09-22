CREATE DATABASE  IF NOT EXISTS `gestiondesbiens` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gestiondesbiens`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 35.189.250.88    Database: gestiondesbiens
-- ------------------------------------------------------
-- Server version	5.7.14-google-log

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--



--
-- Table structure for table `Action`
--

DROP TABLE IF EXISTS `Action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Action` (
  `ActCode` int(11) NOT NULL AUTO_INCREMENT,
  `ActName` varchar(45) NOT NULL,
  `ActDescription` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`ActCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Action`
--

LOCK TABLES `Action` WRITE;
/*!40000 ALTER TABLE `Action` DISABLE KEYS */;
/*!40000 ALTER TABLE `Action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Branch`
--

DROP TABLE IF EXISTS `Branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Branch` (
  `BrCode` int(11) NOT NULL AUTO_INCREMENT,
  `CompCode` int(11) NOT NULL,
  `BrName` varchar(45) DEFAULT NULL,
  `BrTel` varchar(15) DEFAULT NULL,
  `BrAddress` varchar(150) DEFAULT NULL,
  `BrStatus` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`BrCode`),
  KEY `CompCode_idx` (`CompCode`),
  CONSTRAINT `CompCode` FOREIGN KEY (`CompCode`) REFERENCES `company` (`CompCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Branch`
--

LOCK TABLES `Branch` WRITE;
/*!40000 ALTER TABLE `Branch` DISABLE KEYS */;
INSERT INTO `Branch` VALUES (2,21,'Br1','011111','111111','\0'),(3,1,'ss','ss','sss','\0'),(4,21,'Br2','022222','222222','\0');
/*!40000 ALTER TABLE `Branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BranchProduct`
--

DROP TABLE IF EXISTS `BranchProduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BranchProduct` (
  `BrProductCode` int(11) NOT NULL AUTO_INCREMENT,
  `BrCode` int(11) NOT NULL,
  `PrCode` int(11) NOT NULL,
  `Qty` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`BrProductCode`),
  KEY `BrCode_idx3` (`BrCode`),
  KEY `PrCode_idx3` (`PrCode`),
  CONSTRAINT `BrCode3` FOREIGN KEY (`BrCode`) REFERENCES `Branch` (`BrCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `PrCode3` FOREIGN KEY (`PrCode`) REFERENCES `Product` (`PrCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BranchProduct`
--

LOCK TABLES `BranchProduct` WRITE;
/*!40000 ALTER TABLE `BranchProduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `BranchProduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Brand`
--

DROP TABLE IF EXISTS `Brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Brand` (
  `BrdCode` int(11) NOT NULL AUTO_INCREMENT,
  `BrdName` varchar(45) DEFAULT NULL,
  `BrdCreationDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `BrdStatus` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`BrdCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Brand`
--

LOCK TABLES `Brand` WRITE;
/*!40000 ALTER TABLE `Brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `Brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Client`
--

DROP TABLE IF EXISTS `Client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Client` (
  `CltCode` int(11) NOT NULL,
  `CltTitle` varchar(45) DEFAULT NULL,
  `CltName` varchar(45) DEFAULT NULL,
  `CltMobile` varchar(45) DEFAULT NULL,
  `CltEmail` varchar(45) DEFAULT NULL,
  `SendMessage` bit(1) NOT NULL DEFAULT b'1',
  `SendCatalog` bit(1) NOT NULL DEFAULT b'1',
  `CltCreationDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`CltCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Client`
--

LOCK TABLES `Client` WRITE;
/*!40000 ALTER TABLE `Client` DISABLE KEYS */;
/*!40000 ALTER TABLE `Client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Order`
--

DROP TABLE IF EXISTS `Order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Order` (
  `OrdCode` int(11) NOT NULL AUTO_INCREMENT,
  `OrdDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `OrdSource` int(11) NOT NULL,
  `OrdDestination` int(11) NOT NULL,
  `TrCode` int(11) NOT NULL,
  `OrdQty` int(11) NOT NULL,
  `PrCode` int(11) NOT NULL,
  `CompCode` int(11) NOT NULL,
  `UsrCode` int(11) NOT NULL,
  PRIMARY KEY (`OrdCode`),
  KEY `TrCode_idx` (`TrCode`),
  KEY `CompCode_idx` (`CompCode`),
  KEY `UsrCode_idx` (`UsrCode`),
  CONSTRAINT `CompCode4` FOREIGN KEY (`CompCode`) REFERENCES `company` (`CompCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TrCode` FOREIGN KEY (`TrCode`) REFERENCES `TransactionType` (`TrCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `UsrCode5` FOREIGN KEY (`UsrCode`) REFERENCES `User` (`UsrCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Order`
--

LOCK TABLES `Order` WRITE;
/*!40000 ALTER TABLE `Order` DISABLE KEYS */;
/*!40000 ALTER TABLE `Order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product` (
  `PrCode` int(11) NOT NULL AUTO_INCREMENT,
  `PrBarCode` varchar(45) DEFAULT NULL,
  `PrName` varchar(45) DEFAULT NULL,
  `PrType` int(11) DEFAULT NULL,
  `PrFamily` varchar(45) DEFAULT NULL,
  `SupCode` int(11) NOT NULL,
  `PrStatus` bit(1) NOT NULL DEFAULT b'1',
  `BrdCode` int(11) NOT NULL,
  `PrSeason` varchar(45) DEFAULT NULL,
  `CostPrice` int(11) DEFAULT NULL,
  `SellingPrice` int(11) DEFAULT NULL,
  PRIMARY KEY (`PrCode`),
  KEY `SupCode_idx` (`SupCode`),
  KEY `BrdCode_idx` (`BrdCode`),
  CONSTRAINT `BrdCode` FOREIGN KEY (`BrdCode`) REFERENCES `Brand` (`BrdCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SupCode` FOREIGN KEY (`SupCode`) REFERENCES `Supplier` (`SupCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `RoCode` int(11) NOT NULL AUTO_INCREMENT,
  `RoName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`RoCode`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (1,'Admin'),(2,'DataEntry');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RoleAction`
--

DROP TABLE IF EXISTS `RoleAction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RoleAction` (
  `RoActionCode` int(11) NOT NULL AUTO_INCREMENT,
  `RoCode` int(11) NOT NULL,
  `ActCode` int(11) NOT NULL,
  PRIMARY KEY (`RoActionCode`),
  KEY `RoCode_idx` (`RoCode`),
  KEY `ActCode_idx` (`ActCode`),
  CONSTRAINT `ActCode4` FOREIGN KEY (`ActCode`) REFERENCES `Action` (`ActCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RoCode4` FOREIGN KEY (`RoCode`) REFERENCES `Role` (`RoCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RoleAction`
--

LOCK TABLES `RoleAction` WRITE;
/*!40000 ALTER TABLE `RoleAction` DISABLE KEYS */;
/*!40000 ALTER TABLE `RoleAction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RoleBranch`
--

DROP TABLE IF EXISTS `RoleBranch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RoleBranch` (
  `RoBranchCode` int(11) NOT NULL AUTO_INCREMENT,
  `RoCode` int(11) NOT NULL,
  `BrCode` int(11) NOT NULL,
  PRIMARY KEY (`RoBranchCode`),
  KEY `RoCode_idx` (`RoCode`),
  KEY `BrCode_idx` (`BrCode`),
  CONSTRAINT `BrCode5` FOREIGN KEY (`BrCode`) REFERENCES `Branch` (`BrCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RoCode5` FOREIGN KEY (`RoCode`) REFERENCES `Role` (`RoCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RoleBranch`
--

LOCK TABLES `RoleBranch` WRITE;
/*!40000 ALTER TABLE `RoleBranch` DISABLE KEYS */;
INSERT INTO `RoleBranch` VALUES (4,2,2),(5,1,2),(6,1,4);
/*!40000 ALTER TABLE `RoleBranch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Stock`
--

DROP TABLE IF EXISTS `Stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Stock` (
  `StkCode` int(11) NOT NULL AUTO_INCREMENT,
  `StkName` varchar(45) DEFAULT NULL,
  `StkTel` varchar(15) DEFAULT NULL,
  `StkAddress` varchar(150) DEFAULT NULL,
  `CompCode` int(11) NOT NULL,
  PRIMARY KEY (`StkCode`),
  KEY `CompCode_idx` (`CompCode`),
  CONSTRAINT `CompCode1` FOREIGN KEY (`CompCode`) REFERENCES `company` (`CompCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Stock`
--

LOCK TABLES `Stock` WRITE;
/*!40000 ALTER TABLE `Stock` DISABLE KEYS */;
INSERT INTO `Stock` VALUES (1,'S1','43235','Beirut',3),(2,'S1','3242','Beirut',1);
/*!40000 ALTER TABLE `Stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StockProduct`
--

DROP TABLE IF EXISTS `StockProduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `StockProduct` (
  `StkProductCode` int(11) NOT NULL AUTO_INCREMENT,
  `PrCode` int(11) NOT NULL,
  `StkCode` int(11) NOT NULL,
  `StkPrQty` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`StkProductCode`),
  KEY `PrCode_idx` (`PrCode`),
  KEY `StkCode_idx` (`StkCode`),
  CONSTRAINT `PrCode` FOREIGN KEY (`PrCode`) REFERENCES `Product` (`PrCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `StkCode` FOREIGN KEY (`StkCode`) REFERENCES `Stock` (`StkCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StockProduct`
--

LOCK TABLES `StockProduct` WRITE;
/*!40000 ALTER TABLE `StockProduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `StockProduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Supplier`
--

DROP TABLE IF EXISTS `Supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Supplier` (
  `SupCode` int(11) NOT NULL AUTO_INCREMENT,
  `SupName` varchar(45) DEFAULT NULL,
  `SupTel` varchar(15) DEFAULT NULL,
  `SupMobile` varchar(15) DEFAULT NULL,
  `SupAddress` varchar(150) DEFAULT NULL,
  `SupEmail` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SupCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Supplier`
--

LOCK TABLES `Supplier` WRITE;
/*!40000 ALTER TABLE `Supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `Supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TransactionType`
--

DROP TABLE IF EXISTS `TransactionType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TransactionType` (
  `TrCode` int(11) NOT NULL AUTO_INCREMENT,
  `Source` varchar(45) NOT NULL,
  `Destination` varchar(45) NOT NULL,
  PRIMARY KEY (`TrCode`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TransactionType`
--

LOCK TABLES `TransactionType` WRITE;
/*!40000 ALTER TABLE `TransactionType` DISABLE KEYS */;
INSERT INTO `TransactionType` VALUES (1,'Stock','Branch'),(2,'Branch','Stock'),(3,'Branch','Branch'),(4,'Branch','Customer'),(5,'Customer','Branch'),(6,'Customer','Branch');
/*!40000 ALTER TABLE `TransactionType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `UsrCode` int(11) NOT NULL AUTO_INCREMENT,
  `UsrFullname` varchar(45) DEFAULT NULL,
  `UsrUsername` varchar(45) NOT NULL,
  `UsrPassword` varchar(45) NOT NULL,
  `UsrMobile` varchar(15) DEFAULT NULL,
  `UsrAddress` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`UsrCode`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'User_1','usr1','123456','123456','Lebanon'),(2,'User_2','usr2','123456','123456','Lebanon'),(3,'User_3','usr3','123456','123456','Lebanon');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserRole`
--

DROP TABLE IF EXISTS `UserRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserRole` (
  `UsrRoleCode` int(11) NOT NULL AUTO_INCREMENT,
  `UsrCode` int(11) NOT NULL,
  `RoCode` int(11) NOT NULL,
  PRIMARY KEY (`UsrRoleCode`),
  KEY `UsrCode_idx` (`UsrCode`),
  KEY `RoCode_idx` (`RoCode`),
  CONSTRAINT `RoCode6` FOREIGN KEY (`RoCode`) REFERENCES `Role` (`RoCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `UsrCode6` FOREIGN KEY (`UsrCode`) REFERENCES `User` (`UsrCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserRole`
--

LOCK TABLES `UserRole` WRITE;
/*!40000 ALTER TABLE `UserRole` DISABLE KEYS */;
/*!40000 ALTER TABLE `UserRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `CompCode` int(11) NOT NULL AUTO_INCREMENT,
  `CompName` text,
  `CompDesc` text,
  `CompCreationDate` date DEFAULT NULL,
  `CompStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`CompCode`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Nike','Nike company','2017-07-27',1),(2,'alich','test alich','1970-01-01',1),(3,'Samsung','Samsung desc2 updated ','2017-07-27',1),(5,'C2','C2 desc','2017-07-27',1),(6,'C3','C3 desc','2017-07-27',1),(18,'C4','C4 desc',NULL,1),(19,'C5','C5',NULL,1),(21,'C6','C6',NULL,1),(22,'abc','abc',NULL,1);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-29 11:04:13
