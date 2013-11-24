-- MySQL dump 10.13  Distrib 5.5.31, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: chess
-- ------------------------------------------------------
-- Server version	5.5.31-0+wheezy1

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
-- Table structure for table `partie`
--

DROP TABLE IF EXISTS `partie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partie` (
  `idPartie` int(11) NOT NULL AUTO_INCREMENT,
  `joueurs` varchar(40) NOT NULL,
  `deplacement` mediumtext NOT NULL,
  `partieFini` tinyint(1) NOT NULL,
  `vainqueur` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idPartie`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partie`
--

LOCK TABLES `partie` WRITE;
/*!40000 ALTER TABLE `partie` DISABLE KEYS */;
/*!40000 ALTER TABLE `partie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `nom` varchar(20) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `courriel` varchar(30) NOT NULL,
  `connect` tinyint(1) NOT NULL,
  `play` tinyint(1) NOT NULL,
  `invit` tinyint(1) NOT NULL,
  PRIMARY KEY (`nom`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='user''s table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('ilyes','ilyes','iliesaithamouda@gmail.com',0,0,0),('talla','talla','mtalaBalde@gmail.com',0,0,0),('sadek','sadek','vileps@gmail.com',0,0,0),('moumene','moumene','atoudeft@crosemont.qc.ca',0,0,0),('fransisco','fransisco','fransisco@ta.gom',0,0,0),('bassel','bassel','bassel@gmail.com',0,0,0),('toto','toto','toto@hotmail.com',0,0,0);
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

-- Dump completed on 2013-11-23 17:26:14
