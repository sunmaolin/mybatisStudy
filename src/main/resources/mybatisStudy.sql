/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 8.0.17 : Database - mybatisstudy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatisstudy` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mybatisstudy`;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(50) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_sex` int(1) DEFAULT NULL,
  `role_phone` varchar(20) DEFAULT NULL,
  `role_address` varchar(50) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role_name`,`role_sex`,`role_phone`,`role_address`,`note`) values 
(1,'孙茂林',1,'15069125899','山东省青岛市','太太太帅了'),
(2,'郑婷',0,'13793178562','山东省日照市','这个人太丑'),
(5,'张三',1,NULL,NULL,NULL),
(6,'张三',1,NULL,NULL,'太太太帅了');

/*Table structure for table `t_employee` */

DROP TABLE IF EXISTS `t_employee`;

CREATE TABLE `t_employee` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(60) NOT NULL,
  `sex` int(2) NOT NULL,
  `birthday` date NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `email` varchar(60) NOT NULL,
  `POSITION` varchar(20) NOT NULL,
  `note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_employee` */

insert  into `t_employee`(`id`,`real_name`,`sex`,`birthday`,`mobile`,`email`,`POSITION`,`note`) values 
(1,'孙茂林',1,'2021-01-01','15069125899','sunmaolin@126.com','经理','很帅'),
(2,'郑婷',0,'2021-01-04','13793178562','zhengting@126.com','前端web工程师','太丑了');

/*Table structure for table `t_employee_task` */

DROP TABLE IF EXISTS `t_employee_task`;

CREATE TABLE `t_employee_task` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `emp_id` int(12) NOT NULL,
  `task_id` int(12) NOT NULL,
  `task_name` varchar(60) NOT NULL,
  `note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_4` (`emp_id`),
  KEY `FK_Reference_8` (`task_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`task_id`) REFERENCES `t_task` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_employee_task` */

insert  into `t_employee_task`(`id`,`emp_id`,`task_id`,`task_name`,`note`) values 
(1,1,1,'任务1','已完成'),
(2,1,2,'任务2','已完成'),
(3,2,3,'任务3','未完成'),
(4,2,4,'任务4','未完成');

/*Table structure for table `t_female_health_form` */

DROP TABLE IF EXISTS `t_female_health_form`;

CREATE TABLE `t_female_health_form` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `emp_id` int(12) NOT NULL,
  `heart` varchar(64) NOT NULL,
  `liver` varchar(64) NOT NULL,
  `spleen` varchar(64) NOT NULL,
  `lung` varchar(64) NOT NULL,
  `kidney` varchar(64) NOT NULL,
  `uterus` varchar(64) NOT NULL,
  `note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_5` (`emp_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_female_health_form` */

insert  into `t_female_health_form`(`id`,`emp_id`,`heart`,`liver`,`spleen`,`lung`,`kidney`,`uterus`,`note`) values 
(1,2,'坏死','坏死','坏死','坏死','坏死','坏死','全是毛病');

/*Table structure for table `t_male_health_form` */

DROP TABLE IF EXISTS `t_male_health_form`;

CREATE TABLE `t_male_health_form` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `emp_id` int(12) NOT NULL,
  `heart` varchar(64) NOT NULL,
  `liver` varchar(64) NOT NULL,
  `spleen` varchar(64) NOT NULL,
  `lung` varchar(64) NOT NULL,
  `kidney` varchar(64) NOT NULL,
  `prostate` varchar(64) NOT NULL,
  `note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_6` (`emp_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_male_health_form` */

insert  into `t_male_health_form`(`id`,`emp_id`,`heart`,`liver`,`spleen`,`lung`,`kidney`,`prostate`,`note`) values 
(1,1,'良好','良好','良好','良好','良好','良好','没有毛病');

/*Table structure for table `t_task` */

DROP TABLE IF EXISTS `t_task`;

CREATE TABLE `t_task` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL,
  `context` varchar(256) NOT NULL,
  `note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_task` */

insert  into `t_task`(`id`,`title`,`context`,`note`) values 
(1,'任务1','任务1的内容','争取完成'),
(2,'任务2','任务2的内容','争取完成'),
(3,'任务3','任务3的内容','争取完成'),
(4,'任务4','任务4的内容','争取完成');

/*Table structure for table `t_work_card` */

DROP TABLE IF EXISTS `t_work_card`;

CREATE TABLE `t_work_card` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `emp_id` int(12) NOT NULL,
  `real_name` varchar(60) NOT NULL,
  `department` varchar(20) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `POSITION` varchar(30) NOT NULL,
  `note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_7` (`emp_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_work_card` */

insert  into `t_work_card`(`id`,`emp_id`,`real_name`,`department`,`mobile`,`POSITION`,`note`) values 
(1,1,'孙茂林','研发部门','15069125899','部门经理','太帅了'),
(2,2,'郑婷','研发部门','13793178562','员工','太丑了');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
