/*
Navicat MySQL Data Transfer

Source Server         : my1
Source Server Version : 50709
Source Host           : 115.29.113.54:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2015-11-17 09:10:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` varchar(128) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` varchar(158) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
