-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.7.19-0ubuntu0.16.04.1 - (Ubuntu)
-- SE du serveur:                Linux
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour butterlink
CREATE DATABASE IF NOT EXISTS `butterlink` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `butterlink`;

-- Export de la structure de la table butterlink. passwords
CREATE TABLE IF NOT EXISTS `passwords` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(250) DEFAULT NULL,
  `id_site_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `siteId_idx` (`id_site_user`),
  CONSTRAINT `siteId` FOREIGN KEY (`id_site_user`) REFERENCES `site_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table butterlink.passwords : ~0 rows (environ)
/*!40000 ALTER TABLE `passwords` DISABLE KEYS */;
/*!40000 ALTER TABLE `passwords` ENABLE KEYS */;

-- Export de la structure de la table butterlink. simple_site
CREATE TABLE IF NOT EXISTS `simple_site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `friendly_url` varchar(100) DEFAULT NULL,
  `default_url` varchar(250) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `expire_date` datetime DEFAULT NULL,
  `is_secure` int(11) DEFAULT '0',
  `password` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Export de données de la table butterlink.simple_site : ~0 rows (environ)
/*!40000 ALTER TABLE `simple_site` DISABLE KEYS */;
INSERT INTO `simple_site` (`id`, `friendly_url`, `default_url`, `created_at`, `expire_date`, `is_secure`, `password`) VALUES
	(1, 'urlaraccourcir.com', 'urlaraccourcir.com', '1115-01-04 00:00:00', '1115-01-04 00:00:00', 0, 'password');
/*!40000 ALTER TABLE `simple_site` ENABLE KEYS */;

-- Export de la structure de la table butterlink. site_user
CREATE TABLE IF NOT EXISTS `site_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nb_traffic` int(11) DEFAULT NULL,
  `captcha` int(11) DEFAULT '0',
  `max_clics` int(11) DEFAULT NULL,
  `id_simple_site` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `simple site id_idx` (`id_simple_site`),
  KEY `userid_idx` (`user_id`),
  CONSTRAINT `simple site id` FOREIGN KEY (`id_simple_site`) REFERENCES `simple_site` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table butterlink.site_user : ~0 rows (environ)
/*!40000 ALTER TABLE `site_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_user` ENABLE KEYS */;

-- Export de la structure de la table butterlink. statistics
CREATE TABLE IF NOT EXISTS `statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_clic` datetime DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `site_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_site_idx` (`site_id`),
  CONSTRAINT `id_site` FOREIGN KEY (`site_id`) REFERENCES `site_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table butterlink.statistics : ~0 rows (environ)
/*!40000 ALTER TABLE `statistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `statistics` ENABLE KEYS */;

-- Export de la structure de la table butterlink. user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Export de données de la table butterlink.user : ~1 rows (environ)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `firstname`, `lastname`, `email`, `password`) VALUES
	(1, 'younes', 'diouri', 'younesdiouri@gmail.com', 'diouriyouri');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
