-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fivecrowdsourcing
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `runner`
--

DROP TABLE IF EXISTS `runner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `runner` (
  `runnerId` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `idCardNumber` varchar(18) DEFAULT NULL,
  `photoOfIdCardInhand` varchar(50) DEFAULT NULL,
  `photoOfIdCardOppo` varchar(50) DEFAULT NULL,
  `photoOfIdCardPosi` varchar(50) DEFAULT NULL,
  `photoOfHealCert` varchar(50) DEFAULT NULL,
  `balance` decimal(18,2) DEFAULT NULL,
  `integral` int(11) DEFAULT NULL,
  `margin` int(1) DEFAULT NULL,
  PRIMARY KEY (`runnerId`),
  KEY `runnerId` (`runnerId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `runner`
--

LOCK TABLES `runner` WRITE;
/*!40000 ALTER TABLE `runner` DISABLE KEYS */;
INSERT INTO `runner` VALUES (1,'177740','123456','wch','7698','images\\1\\Screenshot_20180317-155238.jpg','images\\1\\Screenshot_20180316-212928.jpg',NULL,'images\\1\\Screenshot_20180316-212928.jpg',100.00,NULL,NULL);
/*!40000 ALTER TABLE `runner` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-18 10:16:55
