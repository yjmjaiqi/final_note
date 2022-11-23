/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : java_note

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 23/11/2022 11:47:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `academyid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ac`(`academyid`) USING BTREE,
  CONSTRAINT `ac` FOREIGN KEY (`academyid`) REFERENCES `academy` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, 'B200603', 1);
INSERT INTO `class` VALUES (2, 'B200602', 1);
INSERT INTO `class` VALUES (3, 'B200601', 1);
INSERT INTO `class` VALUES (4, 'B200104', 6);
INSERT INTO `class` VALUES (5, 'B200103', 2);
INSERT INTO `class` VALUES (6, 'B200102', 3);
INSERT INTO `class` VALUES (7, 'B200101', 4);
INSERT INTO `class` VALUES (8, 'B200504', 5);
INSERT INTO `class` VALUES (9, 'B200503', 7);
INSERT INTO `class` VALUES (10, 'B200502', 8);

DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `academyName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `academyName`(`academyName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of academy
-- ----------------------------
INSERT INTO `academy` VALUES (2, 'vr与艺术学院');
INSERT INTO `academy` VALUES (4, '信息技术学院');
INSERT INTO `academy` VALUES (1, '区块链学院');
INSERT INTO `academy` VALUES (7, '新媒体学院');
INSERT INTO `academy` VALUES (6, '智能科技学院');
INSERT INTO `academy` VALUES (5, '经济管理学院');
INSERT INTO `academy` VALUES (3, '软件工程学院');
INSERT INTO `academy` VALUES (8, '退役军人学院');

DROP TABLE IF EXISTS `academy_note`;
CREATE TABLE `academy_note`  (
  `academyName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `note_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of academy_note
-- ----------------------------
INSERT INTO `academy_note` VALUES ('区块链学院', 17);

DROP TABLE IF EXISTS `class_note`;
CREATE TABLE `class_note`  (
  `className` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `note_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_note
-- ----------------------------
INSERT INTO `class_note` VALUES ('B200603', 16);
INSERT INTO `class_note` VALUES ('B200603', 16);
INSERT INTO `class_note` VALUES ('B200603', 12);
INSERT INTO `class_note` VALUES ('B200603', 17);

DROP TABLE IF EXISTS `note`;
CREATE TABLE `note`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `note_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `note_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `alter_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `userid` int(11) NULL DEFAULT NULL,
  `shareid` enum('TRUE','FALSE') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'FALSE',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `un`(`userid`) USING BTREE,
  CONSTRAINT `un` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES (3, '窥见漫天星光', '我追求了半生的春天，你一笑便是了', '2022-11-13 13:18:06', '', 2, 'TRUE');
INSERT INTO `note` VALUES (6, '窥见漫天星光', '问了问心,它说情不自禁', '2022-11-14 14:04:04', '', 2, 'FALSE');
INSERT INTO `note` VALUES (9, '星辰大海', '所以我走向了你，山月星河都做了贺礼', '2022-11-17 13:49:01', '2022-11-19 12:23:21', 2, 'FALSE');
INSERT INTO `note` VALUES (10, '萧伯纳', '我已经挣扎到了对岸，你们才抛过来救生圈', '2022-11-17 17:03:55', '', 2, 'FALSE');
INSERT INTO `note` VALUES (11, '泰戈尔', '世界以痛吻我，要我报之以歌', '2022-11-17 17:05:13', '', 2, 'TRUE');
INSERT INTO `note` VALUES (12, '罗素', '世上的麻烦是这样的，愚者过于自信，而智者满腹怀疑 ', '2022-11-17 17:05:57', '2022-11-22 18:06:08', 2, 'TRUE');
INSERT INTO `note` VALUES (13, '海明威', '生活总是让我们遍体鳞伤，\r\n但是后来，那些受伤的地方\r\n一定会变成我们最强壮的地方', '2022-11-17 17:07:07', '', 2, 'TRUE');
INSERT INTO `note` VALUES (14, '罗曼.罗兰', '人生犹如一股奔流，没有暗礁，激不起美丽的浪花', '2022-11-17 17:07:59', '', 2, 'TRUE');
INSERT INTO `note` VALUES (15, '川端康成', '这个世界太拥挤了，没有比夜更拥挤的伤，没有比梦更短的遗忘，最好的故事在黎明前死去，最爱的人给我的总是惆怅', '2022-11-17 17:09:55', '', 2, 'TRUE');
INSERT INTO `note` VALUES (16, '等你归来', '挥挥近近远远一身尘埃，俯仰皆是无奈', '2022-11-19 13:21:34', '', 2, 'TRUE');

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `className` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `academyName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'xxzx', '4QrcOUm6Wau+VuBX8g+IPg==', 'B200603', '区块链学院');
INSERT INTO `user` VALUES (6, '佳期如梦', '4QrcOUm6Wau+VuBX8g+IPg==', 'B200104', '智能科技学院');
INSERT INTO `user` VALUES (7, 'yjm', '4QrcOUm6Wau+VuBX8g+IPg==', 'B200603', '区块链学院');
INSERT INTO `user` VALUES (8, 'zyf', '4QrcOUm6Wau+VuBX8g+IPg==', 'B200602', '区块链学院');
INSERT INTO `user` VALUES (9, 'cjx', '4QrcOUm6Wau+VuBX8g+IPg==', 'B200603', '区块链学院');
INSERT INTO `user` VALUES (10, 'cwx', '4QrcOUm6Wau+VuBX8g+IPg==', 'B200603', '区块链学院');

DROP TABLE IF EXISTS `user_note`;
CREATE TABLE `user_note`  (
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `note_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_note
-- ----------------------------
INSERT INTO `user_note` VALUES ('xxzx', 14);
INSERT INTO `user_note` VALUES ('xxzx', 11);
INSERT INTO `user_note` VALUES ('xxzx', 17);
INSERT INTO `user_note` VALUES ('xxzx', 17);


SET FOREIGN_KEY_CHECKS = 1;
