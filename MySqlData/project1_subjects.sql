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
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `subject` varchar(150) NOT NULL,
  `subjectTime` varchar(8) NOT NULL,
  `class_id` int DEFAULT NULL,
  `teacher_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qtoqqor08hk6561vb08jcs4b6` (`subject`),
  KEY `FKd048krnmhb9t511uvfn30o5mm` (`class_id`),
  KEY `FKsjy6ghvvelraa2w9mhv3bbnys` (`teacher_id`),
  CONSTRAINT `FKd048krnmhb9t511uvfn30o5mm` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `FKsjy6ghvvelraa2w9mhv3bbnys` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (21,'Class 3 Math','10:30',6,1),(22,'Class 3 Sciences','11:30',6,3),(23,'Class 3 Meta Physics ','12:30',6,4),(24,'Class 3 Quantum Mechanics','01:30',6,5),(25,'Class 3 Machine Learning','2:30',6,1),(26,'Class 4 Machine Learning','10:20',7,1),(27,'Class 4 A.I. scripting for games','11:20',7,1),(28,'Class 4 Algorithms and data structures','12:20',7,8),(29,'Class 4 Computer games marketing','1:20',7,5),(30,'Class 4 Indie game development','2:20',7,4),(31,'Class 5 History and Philosophy of Social Work','8:30',8,1),(32,'Class 5 Social Science Concepts for Social Work','9:30',8,3),(33,'Community Work','10:30',8,8),(34,'Field Work (Concurrent)','11:30',8,4),(35,'Class 6 Elementary Algebra & Trigonometry','6:20',9,1),(36,'Class 6 Differential Calculus','7:30',9,3),(37,'Geometry & Vector Analysis','8:30',9,5),(38,'Class 6 Group Theory','9:30',9,7),(39,'Class 7 Linear Algebra','9:30',10,1),(40,'Class 7 Complex Analysis','10:30',10,1),(41,'Class 7 Functions of Several Variables & Partial Differential Equations','11:20',10,7),(42,'Class 7 Vector Spaces & Matrices','12:30',10,1);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
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
