-- MySQL dump 10.13  Distrib 8.0.25, for macos11.3 (x86_64)
--
-- Host: localhost    Database: colorly_db
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL,
  `owner_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8hgaiwsmbdl9eg5r4ne7xrqq8` (`owner_id`),
  CONSTRAINT `FK8hgaiwsmbdl9eg5r4ne7xrqq8` FOREIGN KEY (`owner_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (64,63),(69,68),(72,71);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_items`
--

DROP TABLE IF EXISTS `cart_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_items` (
  `cart_id` int NOT NULL,
  `items_id` int NOT NULL,
  PRIMARY KEY (`cart_id`,`items_id`),
  KEY `FKbgmrxyvqs3kxt1im75fde3psy` (`items_id`),
  CONSTRAINT `FK99e0am9jpriwxcm6is7xfedy3` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
  CONSTRAINT `FKbgmrxyvqs3kxt1im75fde3psy` FOREIGN KEY (`items_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_items`
--

LOCK TABLES `cart_items` WRITE;
/*!40000 ALTER TABLE `cart_items` DISABLE KEYS */;
INSERT INTO `cart_items` VALUES (72,1),(64,2),(69,2),(72,5);
/*!40000 ALTER TABLE `cart_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (74);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` int NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `picture` longtext,
  `price` varchar(255) DEFAULT NULL,
  `source` longtext,
  `color1` varchar(255) DEFAULT NULL,
  `color2` varchar(255) DEFAULT NULL,
  `color3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Levi’s','510™ Skinny Jeans are a sharp essential.','510™ Skinny Fit Levi’s® Flex Men\'s Jeans','https://lsco.scene7.com/is/image/lsco/055100862-front-pdp?fmt=jpeg&qlt=70,1&op_sharpen=0&resMode=sharp2&op_usm=0.8,1,10,0&fit=crop,0&wid=900&hei=1200','69.50','https://www.levi.com/US/en_US/apparel/clothing/bottoms/510-skinny-fit-levis-flex-mens-jeans/p/055100862','#000','#000','#000'),(2,'Walmart','George Men\'s Baseball Hat','George Men\'s Baseball Hat','https://i5.walmartimages.com/asr/297b57ef-0aab-4de8-abb8-aba56689149e.4e27847291a324368e528dd168cafabd.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF','3.72','https://www.walmart.com/ip/George-Men-s-Baseball-Hat/954527407?wl13=3180&selectedSellerId=0','#171616','#171717','#050505'),(3,'H&M','Fine-knit sweater in soft cotton fabric with a round neck, long sleeves, and ribbing at cuffs and hem.','Fine-knit Sweater','https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fb5%2F30%2Fb530d55bb814e78a62162679786351ff5fd2b40c.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_cardigansjumpers_jumpers%5D%2Ctype%5BLOOKBOOK%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]','19.99','https://www2.hm.com/en_us/productpage.0564358012.html','#09090b','#110f12','#1a181d'),(4,'Zara','Short sweatshirt with adjustable drawstring hood and long sleeves. Rib trim.','Cropped Hooded Sweatshirt','https://static.zara.net/photos///2021/I/0/1/p/1961/455/615/2/w/1500/1961455615_2_1_1.jpg?ts=1634898282684','25.90','https://www.zara.com/us/en/cropped-hooded-sweatshirt-p01961455.html?v1=137436679','#ef6f2b','#f8882f','#fe9822'),(5,'Nordstrom','Some things are worth taking to the extreme.','Just Float On Flare Leg Jeans','https://n.nordstrommedia.com/id/sr3/a72d7c31-0bd9-4af0-9092-583e046230b2.jpeg?crop=pad&pad_color=FFF&format=jpeg&w=780&h=1196&dpr=2','98.00','https://www.nordstrom.com/s/free-people-just-float-on-flare-leg-jeans/5620944?origin=category-personalizedsort&breadcrumb=Home%2FWomen%2FClothing%2FPants%20%26%20Leggings&fashioncolor=Orange&color=801','#e3e1cf','#ebe8de','#a44736'),(6,'Louis Vuitton','pre-owned 2004 tote bag.','pre-owned 2004 tote bag','https://cdn-images.farfetch-contents.com/16/82/94/32/16829432_33474924_1000.jpg','1,306.00','https://www.farfetch.com/shopping/women/louis-vuitton-pre-owned-2004-tote-bag-item-16829432.aspx?storeid=10031','#eb9759','#d56e2a','#f48643');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outfit`
--

DROP TABLE IF EXISTS `outfit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `outfit` (
  `id` int NOT NULL,
  `owner_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5qkj6i9wb33jg7j69jo0kiwlx` (`owner_id`),
  CONSTRAINT `FK5qkj6i9wb33jg7j69jo0kiwlx` FOREIGN KEY (`owner_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outfit`
--

LOCK TABLES `outfit` WRITE;
/*!40000 ALTER TABLE `outfit` DISABLE KEYS */;
INSERT INTO `outfit` VALUES (66,63),(70,68),(73,71);
/*!40000 ALTER TABLE `outfit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outfit_items`
--

DROP TABLE IF EXISTS `outfit_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `outfit_items` (
  `outfit_id` int NOT NULL,
  `items_id` int NOT NULL,
  PRIMARY KEY (`outfit_id`,`items_id`),
  KEY `FKg8l8xyuxva677w5x0pagkpd8v` (`items_id`),
  CONSTRAINT `FKfqvl9mop9mr5l430xrftha9qv` FOREIGN KEY (`outfit_id`) REFERENCES `outfit` (`id`),
  CONSTRAINT `FKg8l8xyuxva677w5x0pagkpd8v` FOREIGN KEY (`items_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outfit_items`
--

LOCK TABLES `outfit_items` WRITE;
/*!40000 ALTER TABLE `outfit_items` DISABLE KEYS */;
INSERT INTO `outfit_items` VALUES (73,1),(70,2),(66,3),(73,5);
/*!40000 ALTER TABLE `outfit_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outfit_likers`
--

DROP TABLE IF EXISTS `outfit_likers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `outfit_likers` (
  `outfit_id` int NOT NULL,
  `likers_id` int NOT NULL,
  PRIMARY KEY (`outfit_id`,`likers_id`),
  KEY `FKs3idc96pk384m2p6liiup7v41` (`likers_id`),
  CONSTRAINT `FK7uhlktt8wa643d6ysitjpxf67` FOREIGN KEY (`outfit_id`) REFERENCES `outfit` (`id`),
  CONSTRAINT `FKs3idc96pk384m2p6liiup7v41` FOREIGN KEY (`likers_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outfit_likers`
--

LOCK TABLES `outfit_likers` WRITE;
/*!40000 ALTER TABLE `outfit_likers` DISABLE KEYS */;
INSERT INTO `outfit_likers` VALUES (66,68),(66,71);
/*!40000 ALTER TABLE `outfit_likers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `cart_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtqa69bib34k2c0jhe7afqsao6` (`cart_id`),
  CONSTRAINT `FKtqa69bib34k2c0jhe7afqsao6` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (63,'karim@karimrahal.com','$2a$10$ntbY4xuhATw0ZMn8c9R6h.tSn7N5CPvTSE2ty2jLH6NYYfcEOIf5.','karim',NULL),(68,'william@william.com','$2a$10$dQtLD9NcXR.suIY05x2rNeXWJonN6EAei.8SxJw5diNEFX2hKm0Kq','william',NULL),(71,'jess@jess.com','$2a$10$0ge1subDHZgyZ.1oZGjObOqjKkEj8qdKXn5Hn/W2YQXQBGMhnPuny','jess',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-08 21:28:44
