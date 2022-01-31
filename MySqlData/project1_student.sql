-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: project1
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `email` varchar(150) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `class_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_fe0i52si7ybu0wjedj6motiim` (`email`),
  KEY `FKnsl7w2nw6o6eq53hqlxfcijpm` (`class_id`),
  CONSTRAINT `FKnsl7w2nw6o6eq53hqlxfcijpm` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (21,21,'ram.kr.mu@gmail.com','Ram krishna',6),(22,22,'mathura.das@gmail.com','Mathura Dash',6),(23,21,'mangal.taman@gmail.com','Mangal taman',6),(24,19,'monika.manga@gmail.com','Monika Manga',6),(25,23,'shyamlal.yad@gmail.com','Shyam lal yadav',6),(26,20,'januta.dash@gmail.com','Januta das',6),(27,18,'jalsha.mana@gmail.com','Jalshah mana',6),(28,19,'jon.snow@gmail.com','Jon Snow',6),(29,31,'arya.stark@gmail.com','Arya Stark',6),(30,20,'tyrion.lannister@gmail.com','Tyrion Lannister',6),(31,20,'jaime.lannister@gmail.com','Jaime Lannister',6),(32,18,'cerseilannister@gmail.com','Cersei Lannister',6),(33,19,'Bran.Stark@gmail.com','Bran Stark',6),(34,19,'Sansa.Stark@gmail.com','Sansa Stark',6),(35,20,'Sandor.Clegane@gmail.com','Sandor Clegane',6),(36,19,'petyr.baelish@gmail.com','Petyr Baelish',6),(38,20,'joffrey.baratheon@gmail.com','Joffrey Baratheon',7),(39,25,'theon.greyjoy@gmail.com','Theon Greyjoy',7),(40,30,'Tywin.Lannister@gmail.com','Tywin Lannister',7),(41,33,'olenna.tyrell@gmail.com','Olenna Tyrell',7),(42,32,'margaery.tyrell@gmail.com','Margaery Tyrell',7),(43,23,'Robb.Stark@gmail.com','Robb Stark',7),(44,21,'oberyn.bartell@gmail.com','Oberyn Martell',7),(45,23,'Jorah.Mormont@gmail.com','Jorah Mormont',7),(46,21,'samwell.tarly@gmail.com','Samwell Tarly',7),(47,20,'Lord.varys@gmail.com','Lord Varys',7),(48,20,'tormund.giantsbane@gmail.com','Tormund Giantsbane',7),(49,23,'stannis.baratheon@gmail.com','Stannis Baratheon',7),(50,20,'catelyn.stark@gmail.com','Catelyn Stark',7),(51,21,'davosseaworth@gmail.com','Davos Seaworth',8),(52,28,'RamsayBolton@gmail.com','Ramsay Bolton',8),(53,31,'robert.baratheon@gmail.com','Robert Baratheon',8),(54,21,'khaldrogo@gmail.com','Khal Drogo',8),(55,21,'gregor.clegane@gmail.com','Gregor Clegane',8),(56,20,'Jaqenhghar@gmail.com','Jaqen H\'ghar',8),(57,20,'euron.greyjoy@gmail.com','Euron Greyjoy',8),(58,20,'yara.greyjoy@gmail.com','Yara Greyjoy',9),(59,20,'daarionaharis@gmail.com','Daario Naharis',9),(60,23,'roose.bolton@gmail.com','Roose Bolton',9),(61,17,'tommenbaratheon@gmail.com','Tommen Baratheon',9),(62,19,'viserys.targaryen@gmail.com','Viserys Targaryen',9),(63,20,'ellaria.sand@gmail.com','Ellaria Sand',9),(64,20,'High.sparrow@gmail.com','High Sparrow',10),(65,20,'rickon.stark@gmail.com','Rickon Stark',10),(66,20,'Lysa.Arryn@gmail.com','Lysa Arryn',10),(67,30,'grandmaesterpycelle@gmail.com','Grand Maester Pycelle',10);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-31 16:56:48
