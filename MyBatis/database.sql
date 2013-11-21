CREATE DATABASE /*!32312 IF NOT EXISTS*/`springmvc` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

use springmvc;

CREATE TABLE `USER` (
  `id` int(18) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) NOT NULL,
  `password` varchar(10) NOT NULL,
  `sex` int(1) NOT NULL DEFAULT '0',
  `birthday` date NOT NULL,
  `hobby` text,
  `salary` int(10) DEFAULT NULL,
  `memo` text,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

