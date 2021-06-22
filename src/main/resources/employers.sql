/*
 Navicat Premium Data Transfer

 Source Server         : Ubuntu-MySQL
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : employers

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 16/06/2021 16:37:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for boss
-- ----------------------------
DROP TABLE IF EXISTS `boss`;
CREATE TABLE `boss`  (
  `bossId` int(0) NOT NULL AUTO_INCREMENT,
  `bossName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bossPassword` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bossId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of boss
-- ----------------------------
INSERT INTO `boss` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for employer
-- ----------------------------
DROP TABLE IF EXISTS `employer`;
CREATE TABLE `employer`  (
  `employerId` int(0) NOT NULL AUTO_INCREMENT,
  `employerName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employerPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employerDept` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employerPosition` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employerSalary` float NULL DEFAULT NULL,
  PRIMARY KEY (`employerId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employer
-- ----------------------------
INSERT INTO `employer` VALUES (5, 'Lili', '222-444', '秘书部', '秘书', 20000);
INSERT INTO `employer` VALUES (6, 'David', '12580', '安保部', '门卫', 10000);
INSERT INTO `employer` VALUES (7, 'Smart', '10001', '安保部', '保安', 12000);
INSERT INTO `employer` VALUES (8, 'Lucy', '111-222', '运维部', '运维', 12000);
INSERT INTO `employer` VALUES (10, '王浩', '1441', '生产部', '生产队长', 20000);
INSERT INTO `employer` VALUES (11, '周杰', '10001', '生产部', '生产专员', 10000);

-- ----------------------------
-- Table structure for employerleaves
-- ----------------------------
DROP TABLE IF EXISTS `employerleaves`;
CREATE TABLE `employerleaves`  (
  `employerId` int(0) NOT NULL,
  `employerName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employerPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employerDept` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employerPosition` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employerLeave` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employerLeaveStatus` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employerLeaveFile` longblob NULL,
  PRIMARY KEY (`employerId`) USING BTREE,
  CONSTRAINT `FK` FOREIGN KEY (`employerId`) REFERENCES `employer` (`employerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
