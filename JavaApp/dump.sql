-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: gamr-gamr.d.aivencloud.com    Database: gamr
-- ------------------------------------------------------
-- Server version	8.0.35

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'd007c83e-c53c-11f0-b3c7-862ccfb0564b:1-282';

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (101,'Juan','Pérez','juan.perez@gmail.com','678123432'),(102,'Ana','García','ana.garcia@email.com','678123456'),(103,'Carlos','López','carlos.lopez@email.com','699887766'),(104,'Sofía','Martínez','sofia.martinez@email.com','611223344'),(105,'Luis','Suarez','luis.suarez@email.com','786547523');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cupones`
--

DROP TABLE IF EXISTS `cupones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cupones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(50) NOT NULL,
  `descripcion` text,
  `tipo_descuento` enum('PORCENTAJE','FIJO') NOT NULL,
  `valor_descuento` decimal(10,2) NOT NULL,
  `valido_desde` date DEFAULT NULL,
  `valido_hasta` date DEFAULT NULL,
  `max_usos` int DEFAULT NULL,
  `usos_actuales` int DEFAULT '0',
  `activo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=706 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupones`
--

LOCK TABLES `cupones` WRITE;
/*!40000 ALTER TABLE `cupones` DISABLE KEYS */;
INSERT INTO `cupones` VALUES (701,'WELCOME10',NULL,'PORCENTAJE',0.10,'2025-01-01','2025-12-31',100,0,1),(702,'CINCOEUROS',NULL,'FIJO',5.00,'2025-11-01','2025-11-30',50,0,1),(705,'UNEUROFF',NULL,'FIJO',1.00,'2025-10-01','2026-03-31',10,0,1);
/*!40000 ALTER TABLE `cupones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direcciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `calle` varchar(100) DEFAULT NULL,
  `codigo_postal` int DEFAULT NULL,
  `ciudad` varchar(50) DEFAULT NULL,
  `provincia` varchar(50) DEFAULT NULL,
  `pais` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_direccion_cliente` (`id_cliente`),
  CONSTRAINT `fk_direccion_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=505 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
INSERT INTO `direcciones` VALUES (501,101,'Calle Mayor 15',28001,'Madrid','Madrid','España'),(502,102,'Avenida Diagonal 22',8005,'Barcelona','Barcelona','España'),(503,101,'Ronda de Atocha 3',28012,'Madrid','Madrid','España'),(504,103,'Plaza Nueva 10',41001,'Sevilla','Sevilla','España');
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_videojuego` int NOT NULL,
  `cantidad` int DEFAULT '0',
  `umbral_min` int DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_inventario_videojuego` (`id_videojuego`),
  CONSTRAINT `fk_inventario_videojuego` FOREIGN KEY (`id_videojuego`) REFERENCES `videojuegos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_pedido`
--

DROP TABLE IF EXISTS `item_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_pedido` (
  `item_pedido_id` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  `descuento` decimal(10,2) DEFAULT '0.00',
  `id_pedido` int DEFAULT NULL,
  `id_videojuego` int DEFAULT NULL,
  PRIMARY KEY (`item_pedido_id`),
  KEY `fk_item_pedido_pedido` (`id_pedido`),
  KEY `fk_item_pedido_videojuego` (`id_videojuego`),
  CONSTRAINT `fk_item_pedido_pedido` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id`),
  CONSTRAINT `fk_item_pedido_videojuego` FOREIGN KEY (`id_videojuego`) REFERENCES `videojuegos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_pedido`
--

LOCK TABLES `item_pedido` WRITE;
/*!40000 ALTER TABLE `item_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `num_pedido` varchar(50) NOT NULL,
  `order_date` date NOT NULL,
  `estado` enum('Pendiente','Pagado','Enviado','Cancelado') NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `id_cliente` int DEFAULT NULL,
  `id_cupon` int DEFAULT NULL,
  `shipping_address_id` int DEFAULT NULL,
  `billing_address_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pedido_cliente` (`id_cliente`),
  KEY `fk_pedido_cupon` (`id_cupon`),
  KEY `fk_pedido_shipping` (`shipping_address_id`),
  KEY `fk_pedido_billing` (`billing_address_id`),
  CONSTRAINT `fk_pedido_billing` FOREIGN KEY (`billing_address_id`) REFERENCES `direcciones` (`id`),
  CONSTRAINT `fk_pedido_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`),
  CONSTRAINT `fk_pedido_cupon` FOREIGN KEY (`id_cupon`) REFERENCES `cupones` (`id`),
  CONSTRAINT `fk_pedido_shipping` FOREIGN KEY (`shipping_address_id`) REFERENCES `direcciones` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,'PED0001','2025-11-20','Enviado',2000.00,101,701,501,501),(2,'PED0002','2025-11-20','Enviado',2000.00,102,702,502,503);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plataformas`
--

DROP TABLE IF EXISTS `plataformas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plataformas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plataformas`
--

LOCK TABLES `plataformas` WRITE;
/*!40000 ALTER TABLE `plataformas` DISABLE KEYS */;
INSERT INTO `plataformas` VALUES (1,'Playstation'),(2,'Xbox'),(3,'Windows');
/*!40000 ALTER TABLE `plataformas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'Rockstar Games','support@rockstar.com','111111111'),(2,'Ubisoft','contact@ubisoft.com','22222222'),(3,'Electronic Arts','help@ea.com','33333333'),(4,'Nintendo','support@nintendo.com','44444444'),(5,'Sony Interactive Entertainment','info@sony.com','55555555'),(6,'Bethesda Softworks','support@bethesda.net','66666666'),(7,'Square Enix','support@square-enix.com','77777777'),(8,'Capcom','service@capcom.com','88888888'),(9,'CD Projekt Red','contact@cdprojektred.com','99999999'),(10,'Activision Blizzard','support@activisionblizzard.com','10101010');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `join_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'GhostRider_2024','ghost.rider@example.com','MotoGP_99!','2023-01-15'),(2,'Sarah_Snipes','sarah.g@mail.com','Headsh0tQwerty','2023-02-20'),(3,'Tank_Commander','tanky@testmail.com','ShieldWall123','2023-03-05'),(4,'Loot_Goblin_X','gimme.loot@example.com','GoldCoins$$$','2023-03-12'),(5,'Retro_Dave_88','david.retro@mail.com','MarioIsKing1985','2023-04-01'),(6,'NoScope_Nina','nina.p@example.com','SniperElite_7','2023-05-10'),(7,'Afk_Potato','potato.farm@testmail.com','FriesAreGood','2023-06-15'),(8,'Critical_Hit_Jim','jimbo.slice@mail.com','D20_Roller!','2023-07-22'),(9,'Healer_Plz','support.main@example.com','HealthPotion50','2023-08-30'),(10,'Pixel_Queen','monique.pixel@mail.com','8Bit_Heart<3','2023-09-05'),(11,'a','a@gmail.com','b','2025-11-26');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videojuego_categoria`
--

DROP TABLE IF EXISTS `videojuego_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videojuego_categoria` (
  `id_videojuego` int NOT NULL,
  `id_categoria` int NOT NULL,
  PRIMARY KEY (`id_videojuego`,`id_categoria`),
  KEY `fk_vc_categoria` (`id_categoria`),
  CONSTRAINT `fk_vc_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`),
  CONSTRAINT `fk_vc_videojuego` FOREIGN KEY (`id_videojuego`) REFERENCES `videojuegos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videojuego_categoria`
--

LOCK TABLES `videojuego_categoria` WRITE;
/*!40000 ALTER TABLE `videojuego_categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `videojuego_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videojuego_plataforma`
--

DROP TABLE IF EXISTS `videojuego_plataforma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videojuego_plataforma` (
  `id_videojuego` int NOT NULL,
  `id_plataforma` int NOT NULL,
  PRIMARY KEY (`id_videojuego`,`id_plataforma`),
  KEY `fk_vp_plataforma` (`id_plataforma`),
  CONSTRAINT `fk_vp_plataforma` FOREIGN KEY (`id_plataforma`) REFERENCES `plataformas` (`id`),
  CONSTRAINT `fk_vp_videojuego` FOREIGN KEY (`id_videojuego`) REFERENCES `videojuegos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videojuego_plataforma`
--

LOCK TABLES `videojuego_plataforma` WRITE;
/*!40000 ALTER TABLE `videojuego_plataforma` DISABLE KEYS */;
/*!40000 ALTER TABLE `videojuego_plataforma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videojuegos`
--

DROP TABLE IF EXISTS `videojuegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videojuegos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unidad` int DEFAULT NULL,
  `titulo` varchar(100) NOT NULL,
  `descripcion` text,
  `precio_base` decimal(10,2) NOT NULL,
  `es_digital` tinyint(1) NOT NULL DEFAULT '0',
  `clasificacion` enum('E','E10+','T','M','AO') NOT NULL,
  `fecha_lanzamiento` date DEFAULT NULL,
  `id_proveedor` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_videojuego_proveedor` (`id_proveedor`),
  CONSTRAINT `fk_videojuego_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videojuegos`
--

LOCK TABLES `videojuegos` WRITE;
/*!40000 ALTER TABLE `videojuegos` DISABLE KEYS */;
INSERT INTO `videojuegos` VALUES (1,1,'Red Dead Redemption 2','Un juego de acción y aventura ambientado en el Salvaje Oeste estadounidense a finales del siglo XIX.',60.00,0,'M','2018-10-26',1),(2,120,'The Legend of Eldoria','Aventura épica en un mundo abierto lleno de magia y misterio.',59.99,1,'T','2023-05-18',1),(3,80,'CyberStrike 2099','Shooter futurista ambientado en una ciudad cibernética con armas avanzadas.',49.99,1,'M','2024-03-11',2),(4,200,'Farm Life Deluxe','Simulador de vida en el campo con plantaciones, animales y gestión de recursos.',39.99,0,'E','2022-10-02',1),(5,150,'Galaxy Racer X','Carreras espaciales de alta velocidad con naves personalizables y circuitos intergalácticos.',44.99,1,'E10+','2023-09-27',3),(6,50,'Horror Mansion','Terror psicológico en una mansión maldita llena de acertijos y criaturas.',54.99,0,'M','2024-10-13',2),(7,300,'Soccer Pro 25','Juego de fútbol realista con equipos internacionales y ligas personalizables.',69.99,1,'E','2025-08-10',4),(8,95,'Battle Heroes Online','Juego multijugador de acción con héroes, poderes y arenas PvP.',59.49,1,'T','2023-12-05',5),(9,130,'Mystic Quest Reborn','RPG de fantasía con sistema de combate táctico y exploración libre.',64.99,0,'T','2024-06-21',1),(10,180,'Street Racers Underground','Carreras urbanas ilegales con autos personalizables y banda sonora intensa.',42.50,1,'T','2023-11-09',3),(11,110,'Dragonfall Chronicles','Aventura RPG en un continente dividido por dragones ancestrales y guerras mágicas.',59.99,0,'T','2024-07-18',1),(12,140,'Neon Drift 3000','Carreras futuristas con autos antigravitatorios y pistas iluminadas con neón.',49.99,1,'E','2023-11-05',2),(13,60,'Shadowline Ops','Shooter táctico de infiltración con misiones sigilosas en ciudades hostiles.',39.99,1,'M','2024-03-21',3),(14,175,'Kingdom Builders','Simulador de construcción y gestión de un reino medieval en expansión.',44.99,0,'E10+','2023-08-14',3),(15,90,'Starforge Legends','Acción y exploración espacial con combate entre naves y misterios galácticos.',59.99,1,'T','2024-01-29',1),(16,45,'Nightmare Circus','Terror surrealista ambientado en un circo abandonado lleno de ilusiones macabras.',29.99,0,'M','2023-10-31',4),(17,220,'Ultimate Basket League 25','Juego de baloncesto realista con ligas internacionales y modo carrera.',69.99,1,'E','2024-09-10',2),(18,85,'Mage Arena Online','MOBA mágico con hechiceros, criaturas invocadas y arenas dinámicas.',0.00,1,'T','2023-12-06',5),(19,160,'Viking Saga: Blood and Honor','RPG de acción ambientado en la era vikinga con saqueos, raids y construcción de asentamientos.',54.99,0,'M','2024-04-28',1),(20,100,'Turbo Drift Outlaws','Carreras de derrape extremo con autos modificados y circuitos urbanos peligrosos.',39.99,1,'T','2023-09-19',3),(21,140,'ChronoBlade Exodus','RPG de acción donde los jugadores viajan entre líneas temporales para evitar el colapso del multiverso.',59.99,1,'T','2024-05-22',1),(22,95,'Steel Guardian Zero','Shooter futurista con mechas personalizables y batallas masivas en terrenos urbanos.',49.99,0,'M','2023-11-15',3),(23,180,'Fantasy Valley Sim','Simulador de vida en un valle mágico con criaturas, cultivos y construcción de aldeas.',39.99,1,'E','2024-02-10',4),(24,70,'Darkwater Abyss','Juego de terror submarino ambientado en una estación abandonada bajo el océano.',34.99,0,'M','2023-10-05',5),(25,200,'Moto Racer XTreme','Carreras extremas con motocicletas personalizables y pistas llenas de obstáculos.',44.99,1,'E10+','2024-06-03',2),(26,160,'Empire of Sands','Estrategia en tiempo real ambientada en reinos desérticos con construcción, combates y diplomacia.',59.99,0,'T','2024-03-18',1),(27,85,'Cyber Arena Royale','Battle royale futurista con armas de energía y arenas dinámicas que cambian en tiempo real.',0.00,1,'T','2023-12-29',5),(28,55,'Haunted Forest Tales','Aventura narrativa de terror en un bosque embrujado con decisiones que alteran la historia.',29.99,0,'M','2023-09-25',4),(29,130,'Star Patrol Omega','Juego de exploración espacial con gestión de nave, combate y descubrimiento de sistemas lejanos.',54.99,1,'T','2024-07-01',3),(30,175,'Urban Fighters Legacy','Beat’em up urbano con campañas cooperativas, jefes épicos y habilidades mejorables.',49.99,0,'T','2023-11-11',2);
/*!40000 ALTER TABLE `videojuegos` ENABLE KEYS */;
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

-- Dump completed on 2025-12-09  8:03:26
