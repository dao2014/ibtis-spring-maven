/*
Navicat MySQL Data Transfer

Source Server         : my1
Source Server Version : 50709
Source Host           : 115.29.113.54:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2015-11-17 09:10:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for date_base
-- ----------------------------
DROP TABLE IF EXISTS `date_base`;
CREATE TABLE `date_base` (
  `id` varchar(128) NOT NULL,
  `url` varchar(500) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of date_base
-- ----------------------------
INSERT INTO `date_base` VALUES ('1', 'jdbc:mysql://115.29.113.54:3306/mytest2?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull', 'root', '123456', '');
