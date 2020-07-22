/*
 Navicat Premium Data Transfer

 Source Server         : Logister
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : whereplace

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 14/07/2020 10:20:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for action_favor_store
-- ----------------------------
DROP TABLE IF EXISTS `action_favor_store`;
CREATE TABLE `action_favor_store`  (
  `user_id` bigint(255) NOT NULL,
  `favor_list_name` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NOT NULL,
  `store_id` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf16 COLLATE = utf16_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for action_focus_good
-- ----------------------------
DROP TABLE IF EXISTS `action_focus_good`;
CREATE TABLE `action_focus_good`  (
  `good_id` bigint(255) NOT NULL,
  `user_id` bigint(255) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf16 COLLATE = utf16_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for action_store_classification
-- ----------------------------
DROP TABLE IF EXISTS `action_store_classification`;
CREATE TABLE `action_store_classification`  (
  `store_id` bigint(255) NOT NULL,
  `type_name` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf16 COLLATE = utf16_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(255) NOT NULL,
  `timestamp` datetime(6) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  `good_id` bigint(255) NOT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `goodId`(`good_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf16 COLLATE = utf16_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for favor_list
-- ----------------------------
DROP TABLE IF EXISTS `favor_list`;
CREATE TABLE `favor_list`  (
  `user_id` bigint(255) NOT NULL,
  `favor_list_name` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf16 COLLATE = utf16_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `good_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `store_id` bigint(255) NOT NULL,
  `good_name` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  `price` double(255, 2) NULL DEFAULT NULL,
  `good_desc` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  `good_photo` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  `favorites` int(255) NOT NULL DEFAULT 0,
  `sales` int(255) NOT NULL DEFAULT 0,
  PRIMARY KEY (`good_id`) USING BTREE,
  INDEX `storeId`(`store_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf16 COLLATE = utf16_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `store_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(255) NOT NULL,
  `longitude` decimal(50, 4) NULL DEFAULT NULL,
  `latitude` decimal(50, 4) NULL DEFAULT NULL,
  `provinces` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  `block` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  `street` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  `street_number` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  `if_open` int(255) NOT NULL DEFAULT -1,
  `store_name` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  `store_desc` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  `store_photo` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  `followers` int(255) NOT NULL DEFAULT 0,
  `volumes` int(255) NOT NULL DEFAULT 0,
  PRIMARY KEY (`store_id`) USING BTREE,
  INDEX `userId`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf16 COLLATE = utf16_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_information
-- ----------------------------
DROP TABLE IF EXISTS `user_information`;
CREATE TABLE `user_information`  (
  `user_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NOT NULL,
  `user_type` int(255) NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`, `user_name`) USING BTREE,
  INDEX `userName`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf16 COLLATE = utf16_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
