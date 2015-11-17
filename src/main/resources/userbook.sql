/*
Navicat MySQL Data Transfer

Source Server         : my1
Source Server Version : 50709
Source Host           : 115.29.113.54:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2015-11-17 09:11:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userbook
-- ----------------------------
DROP TABLE IF EXISTS `userbook`;
CREATE TABLE `userbook` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `user_id` int(128) DEFAULT NULL,
  `book_id` int(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userbook
-- ----------------------------
INSERT INTO `userbook` VALUES ('1', '1', '1');
INSERT INTO `userbook` VALUES ('2', '1', '2');
