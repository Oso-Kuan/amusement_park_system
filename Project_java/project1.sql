/*
 Navicat Premium Data Transfer

 Source Server         : lvying
 Source Server Type    : MySQL
 Source Server Version : 80200 (8.2.0)
 Source Host           : localhost:3306
 Source Schema         : project1

 Target Server Type    : MySQL
 Target Server Version : 80200 (8.2.0)
 File Encoding         : 65001

 Date: 25/12/2024 18:16:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for amusementfacility
-- ----------------------------
DROP TABLE IF EXISTS `amusementfacility`;
CREATE TABLE `amusementfacility`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `isdel` tinyint NOT NULL DEFAULT 0,
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `amusementtypeid` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of amusementfacility
-- ----------------------------
INSERT INTO `amusementfacility` VALUES (1, '旋转木马', '正常', 0, '/api/img/2234d968-3c1d-426f-822e-d9683782f70e.jfif', 1);
INSERT INTO `amusementfacility` VALUES (2, '过山车', '正常', 0, '/api/img/e1286a67-f1ca-4d3c-bf9e-af61cceb1b33.jfif', 2);
INSERT INTO `amusementfacility` VALUES (3, '碰碰车', '正常', 0, '/api/img/4aa35e17-4e08-4f0b-a6d1-a014f04cb04f.jfif', 3);
INSERT INTO `amusementfacility` VALUES (4, '激流勇进', '正常', 0, '/api/img/a973de24-9e93-45cb-8443-f88125a8554e.jfif', 2);
INSERT INTO `amusementfacility` VALUES (5, '鬼屋', '维护中', 0, '/api/img/9836cdd5-bc9e-4119-89c2-8b6f11b71452.jfif', 2);
INSERT INTO `amusementfacility` VALUES (6, '哈哈泡泡', '正常', 0, '/api/img/b4bd79ba-765b-444f-a1b7-ca33273e984d.jfif', 1);
INSERT INTO `amusementfacility` VALUES (7, '大摆锤', '正常', 0, '/api/img/9b933961-d506-4128-bf22-8d86cb56ea0c.jfif', 2);
INSERT INTO `amusementfacility` VALUES (8, '动物餐厅', '维护中', 0, '/api/img/03e6e254-63f1-44ef-8bcf-a6becd0476a9.jfif', 3);
INSERT INTO `amusementfacility` VALUES (11, '秋千', '维护中', 0, '/api/img/7f0c1dfc-6aa0-48f5-b957-4775f613236a.jfif', 3);
INSERT INTO `amusementfacility` VALUES (14, '有轨电车', '正常', 0, NULL, 4);

-- ----------------------------
-- Table structure for amusementtype
-- ----------------------------
DROP TABLE IF EXISTS `amusementtype`;
CREATE TABLE `amusementtype`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `isdel` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of amusementtype
-- ----------------------------
INSERT INTO `amusementtype` VALUES (1, '放松类', 0);
INSERT INTO `amusementtype` VALUES (2, '刺激类', 0);
INSERT INTO `amusementtype` VALUES (3, '娱乐类', 0);
INSERT INTO `amusementtype` VALUES (4, '电车类', 0);

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `discount` double(5, 2) NOT NULL,
  `isdel` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES (1, '儿童票', 0.70, 0);
INSERT INTO `bill` VALUES (2, '成人票', 1.00, 0);
INSERT INTO `bill` VALUES (3, '家庭票', 0.80, 0);
INSERT INTO `bill` VALUES (4, '情侣票', 0.90, 0);
INSERT INTO `bill` VALUES (6, '活动票', 0.60, 0);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `isdel` tinyint NOT NULL DEFAULT 0,
  `ticketid` int NOT NULL,
  `amusementfacilityid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 0, 4, 1);
INSERT INTO `category` VALUES (3, 0, 2, 2);
INSERT INTO `category` VALUES (4, 0, 5, 3);
INSERT INTO `category` VALUES (5, 0, 4, 4);
INSERT INTO `category` VALUES (6, 0, 2, 5);
INSERT INTO `category` VALUES (7, 0, 1, 6);
INSERT INTO `category` VALUES (8, 0, 2, 7);
INSERT INTO `category` VALUES (10, 0, 3, 8);
INSERT INTO `category` VALUES (12, 0, 4, 11);
INSERT INTO `category` VALUES (13, 0, 4, 3);
INSERT INTO `category` VALUES (14, 0, 5, 4);
INSERT INTO `category` VALUES (15, 0, 1, 8);
INSERT INTO `category` VALUES (16, 0, 4, 11);

-- ----------------------------
-- Table structure for consumptionrecord
-- ----------------------------
DROP TABLE IF EXISTS `consumptionrecord`;
CREATE TABLE `consumptionrecord`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `billid` int NOT NULL,
  `ticketid` int NOT NULL,
  `actualprice` double(10, 2) NOT NULL,
  `number` int NOT NULL,
  `isdel` tinyint NOT NULL DEFAULT 0,
  `time` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumptionrecord
-- ----------------------------
INSERT INTO `consumptionrecord` VALUES (1, 1, 1, 70.00, 44, 0, '2024-08-22');
INSERT INTO `consumptionrecord` VALUES (2, 2, 2, 150.00, 150, 0, '2024-08-18');
INSERT INTO `consumptionrecord` VALUES (3, 3, 3, 64.00, 100, 0, '2024-08-16');
INSERT INTO `consumptionrecord` VALUES (4, 4, 1, 90.00, 99, 0, '2024-08-15');
INSERT INTO `consumptionrecord` VALUES (12, 1, 5, 35.00, 115, 0, '2024-08-16');
INSERT INTO `consumptionrecord` VALUES (13, 1, 3, 56.00, 34, 0, '2024-08-20');
INSERT INTO `consumptionrecord` VALUES (14, 4, 3, 72.00, 100, 0, '2024-08-20');
INSERT INTO `consumptionrecord` VALUES (15, 2, 1, 100.00, 72, 0, '2024-08-13');
INSERT INTO `consumptionrecord` VALUES (16, 6, 2, 90.00, 114, 0, '2024-08-15');
INSERT INTO `consumptionrecord` VALUES (17, 6, 5, 30.00, 664, 0, '2024-08-20');
INSERT INTO `consumptionrecord` VALUES (18, 3, 5, 40.00, 73, 0, '2024-08-20');
INSERT INTO `consumptionrecord` VALUES (19, 4, 1, 90.00, 54, 0, '2024-08-12');
INSERT INTO `consumptionrecord` VALUES (20, 3, 4, 52.80, 37, 0, '2024-08-17');
INSERT INTO `consumptionrecord` VALUES (23, 3, 1, 80.00, 55, 0, '2024-08-11');
INSERT INTO `consumptionrecord` VALUES (24, 1, 3, 56.00, 59, 0, '2024-08-02');
INSERT INTO `consumptionrecord` VALUES (25, 6, 2, 90.00, 32, 0, '2024-08-17');
INSERT INTO `consumptionrecord` VALUES (26, 3, 1, 80.00, 64, 0, '2024-08-14');
INSERT INTO `consumptionrecord` VALUES (27, 6, 2, 90.00, 111, 0, '2024-08-09');
INSERT INTO `consumptionrecord` VALUES (28, 3, 2, 120.00, 79, 0, '2024-08-10');
INSERT INTO `consumptionrecord` VALUES (29, 3, 2, 120.00, 71, 0, '2024-08-15');
INSERT INTO `consumptionrecord` VALUES (30, 2, 4, 110.00, 37, 0, '2024-08-20');
INSERT INTO `consumptionrecord` VALUES (31, 4, 2, 135.00, 77, 0, '2024-08-12');
INSERT INTO `consumptionrecord` VALUES (32, 3, 1, 80.00, 88, 0, '2024-08-22');
INSERT INTO `consumptionrecord` VALUES (33, 4, 3, 72.00, 73, 0, '2024-08-22');
INSERT INTO `consumptionrecord` VALUES (34, 4, 5, 45.00, 44, 0, '2024-08-23');
INSERT INTO `consumptionrecord` VALUES (35, 1, 2, 105.00, 77, 0, '2024-08-24');
INSERT INTO `consumptionrecord` VALUES (36, 3, 4, 88.00, 57, 0, '2024-08-23');
INSERT INTO `consumptionrecord` VALUES (37, 3, 1, 80.00, 26, 0, '2024-08-23');
INSERT INTO `consumptionrecord` VALUES (38, 4, 2, 135.00, 57, 0, '2024-08-26');
INSERT INTO `consumptionrecord` VALUES (39, 2, 3, 80.00, 39, 0, '2024-08-25');
INSERT INTO `consumptionrecord` VALUES (40, 1, 4, 77.00, 48, 0, '2024-08-27');
INSERT INTO `consumptionrecord` VALUES (41, 4, 2, 135.00, 66, 0, '2024-08-04');
INSERT INTO `consumptionrecord` VALUES (42, 4, 3, 72.00, 70, 0, '2024-08-07');
INSERT INTO `consumptionrecord` VALUES (43, 3, 3, 64.00, 63, 0, '2024-08-24');
INSERT INTO `consumptionrecord` VALUES (44, 2, 2, 150.00, 66, 0, '2024-10-25');
INSERT INTO `consumptionrecord` VALUES (45, 4, 4, 99.00, 79, 0, '2024-10-23');
INSERT INTO `consumptionrecord` VALUES (46, 3, 1, 80.00, 55, 1, '2024-10-23');
INSERT INTO `consumptionrecord` VALUES (47, 3, 1, 80.00, 33, 0, '2024-10-25');
INSERT INTO `consumptionrecord` VALUES (48, 1, 5, 35.00, 41, 0, '2024-10-23');
INSERT INTO `consumptionrecord` VALUES (50, 1, 3, 56.00, 11, 0, '2024-10-24');
INSERT INTO `consumptionrecord` VALUES (51, 1, 4, 77.00, 33, 0, '2024-10-24');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `salary` double(10, 2) NOT NULL,
  `isdel` tinyint NOT NULL DEFAULT 0,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, '管理员', 4211.00, 0, '张三');
INSERT INTO `staff` VALUES (2, '维护工程师', 4000.00, 0, '李四');
INSERT INTO `staff` VALUES (3, '保安', 3500.00, 0, '王五');
INSERT INTO `staff` VALUES (4, '管理员', 5000.00, 0, '赵六');
INSERT INTO `staff` VALUES (5, '售票员', 5714.00, 0, '阿飞');
INSERT INTO `staff` VALUES (7, '保安', 3333.00, 0, '阿凡');
INSERT INTO `staff` VALUES (8, '服务员', 6677.00, 0, '吕述晗');
INSERT INTO `staff` VALUES (9, '维护工程师', 5000.00, 0, '威威');
INSERT INTO `staff` VALUES (10, '服务员', 4000.00, 0, '曲昊');
INSERT INTO `staff` VALUES (11, '管理员', 5555.00, 0, '依依');

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` double(10, 2) NOT NULL,
  `isdel` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES (1, '通票', 100.00, 0);
INSERT INTO `ticket` VALUES (2, '心跳刺激票', 150.00, 0);
INSERT INTO `ticket` VALUES (3, '赏心悦目票', 80.00, 0);
INSERT INTO `ticket` VALUES (4, '娱乐票', 110.00, 0);
INSERT INTO `ticket` VALUES (5, '活动票', 50.00, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userpass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` int NOT NULL DEFAULT 0,
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '64dc50846ffa69a34469fb59b1d6f80256', 0, '/api/img/f03bb8c8-4357-4773-832e-27215b5900fe.jpg');
INSERT INTO `user` VALUES (2, '李四', 'ce8e48482b3f6f310e96e78ba33ee5c86e', 0, '/api/img/50dbc565-0415-4c4b-b9d8-ca849178f1ac.jpg');
INSERT INTO `user` VALUES (6, '王五', '85cb71dad24d8cc79fe53fa13f6bdec81a', 0, '/api/img/60c03015-0977-4eb9-b8da-6a317e33cc1c.jfif');
INSERT INTO `user` VALUES (17, '赵六', '4a66c296b1ad521a4c7d0df9a628b7471e', 0, '/api/img/1df28a52-5766-40ba-a8f1-8312d0d558a6.jpg');
INSERT INTO `user` VALUES (18, '爱丽丝', '201f5f32e0a96edc996bdfb6e46a56f15b', 0, '/api/img/42e344ff-40be-4463-99d5-790b5b544484.jpg');

SET FOREIGN_KEY_CHECKS = 1;
