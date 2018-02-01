-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: modern_ecommerce
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

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
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suppliers` (
  `supplier_id` bigint(20) NOT NULL,
  `company_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 NOT NULL,
  `type_id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,1,'2016-09-06 00:00:00','Nhiều hoa, trái, cây lạ phục vụ tết','Quán Sasuma ',2,'Nhiều hoa, trái, cây lạ phục vụ tết','//cdn.tgdd.vn/Products/Images/42/73704/iphone-6s-plus-64gb-400-400x450.png','1'),(2,2,'2016-09-06 00:00:00','Nhiều hoa, trái, cây lạ phục vụ tết','Quán Sasuma ',2,'Nhiều hoa, trái, cây lạ phục vụ tết','//cdn.tgdd.vn/Products/Images/42/73704/iphone-6s-plus-64gb-400-400x450.png','2'),(3,1,'2016-09-06 00:00:00','Nhiều hoa, trái, cây lạ phục vụ tết','Quán Sasuma ',2,'Nhiều hoa, trái, cây lạ phục vụ tết','//cdn.tgdd.vn/Products/Images/42/73704/iphone-6s-plus-64gb-400-400x450.png','3'),(4,1,'2016-09-06 00:00:00','Nhiều hoa, trái, cây lạ phục vụ tết','Quán Sasuma ',2,'2Nhiều hoa, trái, cây lạ phục vụ tết','//cdn.tgdd.vn/Products/Images/42/73704/iphone-6s-plus-64gb-400-400x450.png','4'),(5,3,'2016-09-06 00:00:00','Nhiều hoa, trái, cây lạ phục vụ tết','2Quán Sasuma ',2,'Nhiều hoa, trái, cây lạ phục vụ tết','//cdn.tgdd.vn/Products/Images/42/73704/iphone-6s-plus-64gb-400-400x450.png','4'),(6,4,'2016-09-06 00:00:00','Nhiều hoa, trái, cây lạ phục vụ tết','Quán Sasuma ',2,'Nhiều hoa, trái, cây lạ phục vụ tết','//cdn.tgdd.vn/Products/Images/42/73704/iphone-6s-plus-64gb-400-400x450.png','5'),(7,5,'2016-09-06 00:00:00','Nhiều hoa, trái, cây lạ phục vụ tết','Quán Sasuma ',2,'Nhiều hoa, trái, cây lạ phục vụ tết','//cdn.tgdd.vn/Products/Images/42/73704/iphone-6s-plus-64gb-400-400x450.png','6'),(8,2,'2016-09-06 00:00:00','Nhiều hoa, trái, cây lạ phục vụ tết','Quán Sasuma ',2,'Nhiều hoa, trái, cây lạ phục vụ tết','//cdn.tgdd.vn/Products/Images/42/73704/iphone-6s-plus-64gb-400-400x450.png','7');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-01 16:59:17
