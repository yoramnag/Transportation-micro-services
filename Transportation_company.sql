CREATE DATABASE  IF NOT EXISTS `transportation_company`;

USE `transportation_company`;

--
-- Table structure for table `driver`
--
DROP TABLE IF EXISTS `training`;
DROP TABLE IF EXISTS `events`;
DROP TABLE IF EXISTS `vehicle`;
DROP TABLE IF EXISTS `driver`;


CREATE TABLE `driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `driver`
--

INSERT INTO `driver` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com'),
	(2,'Emma','Baumgarten','emma@luv2code.com'),
	(3,'Avani','Gupta','avani@luv2code.com'),
	(4,'Yuri','Petrov','yuri@luv2code.com'),
	(5,'Juan','Vega','juan@luv2code.com');


CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plate_number` varchar(128) DEFAULT NULL,
  `vehicle_type` varchar(128) DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_DRIVER_idx` (`driver_id`),
  
  CONSTRAINT `FK_DRIVER_idx` 
  FOREIGN KEY (`driver_id`) 
  REFERENCES `driver` (`id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


INSERT INTO `VEHICLE` VALUES 
	(1, '44-854-11','hyundai', '3'),
	(2, '88-358-99','mercedes' , '3'),
	(3, '25-987-33','volkswagen', '2'),
	(4, '25-111-35','volkswagen', '1');


SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) DEFAULT NULL,
  `vehicle_id` int(11) DEFAULT NULL,
  `event_date` DATE DEFAULT NULL,
  `city` varchar(128) DEFAULT NULL,
  `street` varchar(128) DEFAULT NULL,
  `other_vehicle_id` int(11) DEFAULT NULL,
  `fine` int(11) DEFAULT NULL,
   `couse` varchar(128) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_VEHICLE_idx` (`vehicle_id`),
  
  CONSTRAINT `FK_VEHICLE_idx` 
  FOREIGN KEY (`vehicle_id`) 
  REFERENCES `vehicle` (`id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

INSERT INTO `events` VALUES 
	(1, '10','1', '2020-02-16', 'Beer-Sheva' , 'Gedon' , '0' , '200' , 'red light');
    
CREATE TABLE `training` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `course_title` varchar(128) DEFAULT NULL,
    `start_date` DATE DEFAULT NULL,
    `end_date` DATE DEFAULT NULL,
    `number_of_participants` int(11) DEFAULT NULl,
	`max_number_of_participants` int(11) DEFAULT NULl,
	`tr_driver_id` int(11) DEFAULT NULL,
     UNIQUE (course_title),
  
  PRIMARY KEY (`id`),
  
  KEY `FK_TR_DRIVER_idx` (`tr_driver_id`),
  CONSTRAINT `FK_TR_DRIVER` 
  FOREIGN KEY (`tr_driver_id`) 
  REFERENCES `driver` (`id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

INSERT INTO `training` VALUES 
	(1, 'Drive' ,'2020-02-16', '2020-02-19' , 2 , 5 , 1);

SET FOREIGN_KEY_CHECKS = 1;
