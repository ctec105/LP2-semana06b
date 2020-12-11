-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema lp2db
--

CREATE DATABASE IF NOT EXISTS lp2db;
USE lp2db;

--
-- Definition of table `tbusuario`
--

DROP TABLE IF EXISTS `tbusuario`;
CREATE TABLE `tbusuario` (
  `usuario` varchar(20) NOT NULL,
  `clave` varchar(20) default NULL,
  `nombre` varchar(100) default NULL,
  `fecnac` datetime default NULL,
  `direccion` varchar(100) default NULL,
  `distrito` varchar(2) default NULL,
  `telefono` varchar(30) default NULL,
  PRIMARY KEY  (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbusuario`
--

/*!40000 ALTER TABLE `tbusuario` DISABLE KEYS */;
INSERT INTO `tbusuario` (`usuario`,`clave`,`nombre`,`fecnac`,`direccion`,`distrito`,`telefono`) VALUES 
 ('jimena','123','Jimena Cardenas Ramirez','1982-01-20 00:00:00','Av. San Felipe 3453. Jesus Maria','03','343343322'),
 ('jose','jose','Jose Manuel Vargas',NULL,'Su casita',NULL,NULL),
 ('pepito','pepito','Pepito Perez Pineda','1980-10-12 00:00:00','Los condes 123. San Borja','02','34343333');
/*!40000 ALTER TABLE `tbusuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
