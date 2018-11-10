/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50723
Source Host           : 39.107.242.109:3306
Source Database       : cms

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-11 01:07:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` char(32) NOT NULL,
  `open_id` varchar(64) NOT NULL COMMENT '买家openid',
  `buyer_name` varchar(32) NOT NULL COMMENT '买家姓名',
  `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) NOT NULL COMMENT '买家地址',
  `postal_code` varchar(32) NOT NULL COMMENT '邮政编码',
  `is_default` tinyint(2) NOT NULL COMMENT '0:默认收货地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收货地址';

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('20a7c71e320247d79f4ae53266e5f780', '', '张三大哥', '17862833425', '广东省 广州市 海珠区  新港中路397号', '510000', '1', '2018-10-28 21:25:16', '2018-10-28 21:25:16');
INSERT INTO `address` VALUES ('2e482390f75949d69fec8904769973f4', '', '老王头', '13638565656', '河北省 石家庄市 长安区 长安大街608', '67543833', '0', '2018-10-28 21:12:07', '2018-10-28 21:23:32');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cart_id` char(32) NOT NULL,
  `open_id` varchar(64) NOT NULL COMMENT '买家openid',
  `product_id` char(32) NOT NULL COMMENT '商品ID',
  `product_num` int(5) NOT NULL COMMENT '商品数量',
  `size` varchar(32) DEFAULT NULL COMMENT '商品规格',
  `color` varchar(32) DEFAULT NULL COMMENT '商品颜色',
  `cart_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '购物车状态 0未结算 1已结算',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('44236e67bdaa47b9909c89d03d32c2e5', '', '1a93cb8d40954a2cb9a9466592b69ba2', '1', null, null, '0', '2018-11-10 17:32:34', '2018-11-10 17:32:34');

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `coupon_id` char(32) NOT NULL,
  `open_id` varchar(64) NOT NULL COMMENT '买家openid',
  `coupon_price` decimal(6,2) NOT NULL COMMENT '优惠金额',
  `remark` varchar(128) NOT NULL COMMENT '备注',
  `limit_price` decimal(6,2) NOT NULL COMMENT '满减金额',
  `now` varchar(64) NOT NULL COMMENT '有效期开始',
  `end` varchar(64) NOT NULL COMMENT '有效期结束',
  `status` tinyint(2) NOT NULL COMMENT '0:未领取',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠卷';

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES ('1c4163ef41364944a665bbb861892592', '', '20.00', '今天我开心,你们随便花', '500.00', '2018-8-7', '2018-10-7', '2', '2018-11-04 21:58:27', '2018-11-11 00:56:07');
INSERT INTO `coupon` VALUES ('f07611672e9442bdba14608d8ffc2178', '', '200.00', '双11 特别行动', '200.00', '2018-10-7', '2018-11-11', '0', '2018-11-11 01:04:22', '2018-11-11 01:05:38');

-- ----------------------------
-- Table structure for major_product
-- ----------------------------
DROP TABLE IF EXISTS `major_product`;
CREATE TABLE `major_product` (
  `major_id` char(32) NOT NULL,
  `product_id` char(32) NOT NULL COMMENT '商品id',
  `product_img` varchar(512) NOT NULL COMMENT '商品图片',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`major_id`),
  UNIQUE KEY `product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='热门推荐';

-- ----------------------------
-- Records of major_product
-- ----------------------------
INSERT INTO `major_product` VALUES ('35980df8b2ca412d87157463ee6a8b92', 'd640b5e7a6054890994d92c489ae5cf8', 'https://g-search3.alicdn.com/img/bao/uploaded/i4/i1/285020023/O1CN011C2ZZmnVRpMmAGF_!!285020023.jpg_230x230.jpg_.webp', '2018-10-25 19:22:42', '2018-10-25 19:22:42');
INSERT INTO `major_product` VALUES ('8d8f43cfc05f4772a1b61484ba3b4825', '1a93cb8d40954a2cb9a9466592b69ba2', 'https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i3/120349015/TB2mxabIVuWBuNjSszbXXcS7FXa_!!0-saturn_solar.jpg_230x230.jpg_.webp', '2018-10-25 20:14:06', '2018-10-25 20:14:06');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL COMMENT '订单编号',
  `product_id` varchar(32) NOT NULL COMMENT '商品编号',
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(4,2) NOT NULL COMMENT '商品价格',
  `product_quantity` int(11) NOT NULL COMMENT '商品数量',
  `product_icon` varchar(128) NOT NULL COMMENT '商品图片',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`detail_id`),
  KEY `index_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` varchar(32) NOT NULL,
  `buyer_name` varchar(32) NOT NULL COMMENT '买家姓名',
  `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
  `buyer_adder` varchar(128) NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) NOT NULL COMMENT '买家openid',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '订单状态 默认0 新下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付状态 默认0 未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `index_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order_master
-- ----------------------------

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) NOT NULL COMMENT '类目名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类目ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品类目';

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('1', '电脑', null, '2018-10-26 09:18:15', '2018-10-26 09:18:15');
INSERT INTO `product_category` VALUES ('2', '手机', null, '2018-10-26 09:18:41', '2018-10-26 09:18:41');
INSERT INTO `product_category` VALUES ('3', '水果类', null, '2018-11-10 17:31:09', '2018-11-10 17:31:09');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(6,2) NOT NULL COMMENT '商品单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(1024) DEFAULT NULL COMMENT '图标',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `product_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '商品状态 默认0 上架',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('1a93cb8d40954a2cb9a9466592b69ba2', '小苹果', '12.60', '20', '当天采摘,现摘现卖', 'https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i3/120349015/TB2mxabIVuWBuNjSszbXXcS7FXa_!!0-saturn_solar.jpg_230x230.jpg_.webp,https://img.alicdn.com/imgextra/i1/3015214310/TB2rNg7FaSWBuNjSsrbXXa0mVXa_!!3015214310.jpg_430x430q90.jpg,https://img.alicdn.com/imgextra/i4/3015214310/TB2lAyiFv9TBuNjy0FcXXbeiFXa_!!3015214310.jpg_430x430q90.jpg,https://img.alicdn.com/imgextra/i4/3015214310/TB2_Wa6FuuSBuNjSsziXXbq8pXa_!!3015214310.jpg_430x430q90.jpg,https://img.alicdn.com/imgextra/i4/3015214310/TB22oL1FxWYBuNjy1zkXXXGGpXa_!!3015214310.jpg_430x430q90.jpg', '1', '0', '2018-10-16 21:49:57', '2018-10-21 11:08:39');
INSERT INTO `product_info` VALUES ('5057f212967e4bc282aed9ff11898cf3', '12期免息vivo NEX官方正品nex手机vivonex限量版oppofindx旗艦店', '13.00', '101', '手机中的战斗机', 'https://gd4.alicdn.com/imgextra/i4/100038105/TB24D0_o5CYBuNkHFCcXXcHtVXa_!!100038105.jpg_400x400.jpg_.webp,https://gd4.alicdn.com/imgextra/i4/100038105/TB2KH.8xoR1BeNjy0FmXXb0wVXa_!!100038105.jpg_400x400.jpg_.webp,https://gd4.alicdn.com/imgextra/i4/100038105/TB24D0_o5CYBuNkHFCcXXcHtVXa_!!100038105.jpg_400x400.jpg_.webp', '2', '0', '2018-10-27 12:49:41', '2018-10-27 12:49:41');
INSERT INTO `product_info` VALUES ('d640b5e7a6054890994d92c489ae5cf8', '红辣椒', '11.00', '20', '甜甜的', 'https://g-search3.alicdn.com/img/bao/uploaded/i4/i1/285020023/O1CN011C2ZZmnVRpMmAGF_!!285020023.jpg_230x230.jpg_.webp', '1', '0', '2018-10-16 18:42:13', '2018-10-21 09:09:20');
