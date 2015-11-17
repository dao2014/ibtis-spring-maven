/*
Navicat MySQL Data Transfer

Source Server         : my1
Source Server Version : 50709
Source Host           : 115.29.113.54:3306
Source Database       : mytest2

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2015-11-17 09:12:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'test2', '12', '2');
