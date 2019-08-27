-- MySQL dump 10.13  Distrib 5.5.47, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: internal_enterprise_system
-- ------------------------------------------------------
-- Server version	5.5.47-0ubuntu0.14.04.1-log

drop database if exists internal_enterprise_system;
create database internal_enterprise_system;
use internal_enterprise_system;

DROP TABLE IF EXISTS `Employees`;
CREATE TABLE `Employees` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `surname` varchar(64) NOT NULL,
  `person_code` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `password` varchar(32) NOT NULL,
  `fk_access_level` int NOT NULL,
  `fk_role` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Employees`
--

LOCK TABLES `Employees` WRITE;
INSERT INTO `Employees` VALUES (1,'Math', 'Ematics', '111111-11111', 'myemail@example.com', 'password', 1, 1, 1),
							   (2,'Physics', 'Chimics', '222222-22222', 'maymail@exampl.com', 'pass', 2, 2, 2),
                               (1984,'Big', 'Brother', '123456-98765', 'exmpl@example.com', 'password', 1, 2, 1);
UNLOCK TABLES;


DROP TABLE IF EXISTS `Access_levels`;
CREATE TABLE `Access_levels` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `level` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Access_levels`
--

LOCK TABLES `Access_levels` WRITE;
INSERT INTO `Access_levels` VALUES (1,'low'),
								   (2,'high');
UNLOCK TABLES;


DROP TABLE IF EXISTS `Roles`;
CREATE TABLE `Roles` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Roles`
--

LOCK TABLES `Roles` WRITE;
INSERT INTO `Roles` VALUES (1,'Developer'),
						   (2,'Manager');
UNLOCK TABLES;


DROP TABLE IF EXISTS `Education`;
CREATE TABLE `Education` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fk_employee` int NOT NULL,
  `description` varchar(512) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Education`
--

LOCK TABLES `Education` WRITE;
INSERT INTO `Education` VALUES (1, 1, 'Master jedi'),
						       (2, 2, 'Bachelor jedi');
UNLOCK TABLES;


DROP TABLE IF EXISTS `Employee_feedbacks`;
CREATE TABLE `Employee_feedbacks` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fk_employee_to` int NOT NULL,
  `fk_employee_from` int NOT NULL,
  `fk_project` int NOT NULL,
  `date` datetime NOT NULL,
  `general_work_quality` int NOT NULL,
  `dependability` int NOT NULL,
  `area_knowledge` int NOT NULL,
  `communication_skills` int NOT NULL,
  `personality` int NOT NULL,
  `management_skills` int NOT NULL,
  `contribution` int NOT NULL,
  `productivity` int NOT NULL,
  `strong_points` varchar(512),
  `weak_points` varchar(512),
  `comment` varchar(512),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Employee_feedbacks`
--

LOCK TABLES `Employee_feedbacks` WRITE;
INSERT INTO `Employee_feedbacks` VALUES (null, 2, 1, 1, NOW(), 3, 3, 3, 3, 3, 3, 3, 4, 'three', 'three', 'three'),
										(null, 1, 2, 1, NOW(), 4, 4, 4, 4, 4, 4, 4, 4, 'four', 'four', 'four');
UNLOCK TABLES;


DROP TABLE IF EXISTS `Employee_comments`;
CREATE TABLE `Employee_comments` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fk_employee_to` int NOT NULL,
  `fk_employee_from` int NOT NULL,
  `date` datetime NOT NULL,
  `comment` varchar(512) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Employee_comments`
--

LOCK TABLES `Employee_comments` WRITE;
INSERT INTO `Employee_comments` VALUES (null, 1, 2, now(), 'first'),
									   (null, 2, 1, now(), 'second');
UNLOCK TABLES;


DROP TABLE IF EXISTS `Projects`;
CREATE TABLE `Projects` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `customer` varchar(64) NOT NULL,
  `details` varchar(512) NOT NULL,
  `date_from` datetime NOT NULL,
  `date_to` datetime NOT NULL,
  `fk_status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Projects`
--

LOCK TABLES `Projects` WRITE;
INSERT INTO `Projects` VALUES (null,'Google2.0', 'Bugs', 'detail123', now(), now() + interval 10 day, 1),
							  (null,'Potato ePhone OS', 'Belarus', 'detail321', now(), now() + interval 20 day, 2);
UNLOCK TABLES;


DROP TABLE IF EXISTS `Project_employee`;
CREATE TABLE `Project_employee` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `date_from` datetime NOT NULL,
  `date_to` datetime NOT NULL,
  `fk_project_id` int NOT NULL,
  `fk_employee_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Project_employee`
--

LOCK TABLES `Project_employee` WRITE;
INSERT INTO `Project_employee` VALUES (null, now(), now() + interval 10 day, 1, 2),
							  (null, now(), now() + interval 20 day, 2, 1);
UNLOCK TABLES;



DROP TABLE IF EXISTS `Project_statuses`;
CREATE TABLE `Project_statuses` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `status` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Project_statuses`
--

LOCK TABLES `Project_statuses` WRITE;
INSERT INTO `Project_statuses` VALUES (null,'started'),
									  (null, 'frozen'),
                                      (null, 'finished');
UNLOCK TABLES;




DROP TABLE IF EXISTS `Project_feedbacks`;
CREATE TABLE `Project_feedbacks` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fk_project` int NOT NULL,
  `date` datetime NOT NULL,
  `fitting_deadlines` int NOT NULL,
  `team_spirit` int NOT NULL,
  `code_quality` int NOT NULL,
  `documentation` int NOT NULL,
  `reusability` int NOT NULL,
  `requirement_achieved` int NOT NULL,
  `strong_points` varchar(512),
  `weak_points` varchar(512),
  `comment` varchar(512),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Project_feedbacks`
--

LOCK TABLES `Project_feedbacks` WRITE;
INSERT INTO `Project_feedbacks` VALUES (null, 1, NOW(), 3, 3, 3, 3, 3, 3, 'three', 'three', 'three'),
									   (null, 2, NOW(), 4, 4, 4, 4, 4, 4, 'four', 'four', 'four');
UNLOCK TABLES;


DROP TABLE IF EXISTS `Project_comments`;
CREATE TABLE `Project_comments` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fk_project` int NOT NULL,
  `fk_employee_from` int NOT NULL,
  `date` datetime NOT NULL,
  `comment` varchar(512) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Project_comments`
--

LOCK TABLES `Project_comments` WRITE;
INSERT INTO `Project_comments` VALUES (null, 1, 2, now(), 'first'),
									   (null, 2, 1, now(), 'second');
UNLOCK TABLES;