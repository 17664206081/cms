CREATE TABLE  `product_info` (
    `product_id` VARCHAR(32) NOT NULL ,
	  `product_name` VARCHAR(64) NOT NULL COMMENT '商品名称',
    `product_price` DECIMAL(6,2) NOT NULL COMMENT '商品单价',
    `product_stock` INT NOT NULL COMMENT '库存',
    `product_description` VARCHAR(64) COMMENT '描述',
    `product_icon` VARCHAR(1024) COMMENT '图标',
    `category_type` INT NOT NULL COMMENT '类目编号',
    `product_status` ENUM ('sell','nsell') COMMENT '商品状态 售卖 未售卖',
    `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
    `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE  current_timestamp COMMENT '修改时间',
     PRIMARY KEY(`product_id`)
)ENGINE=InnoDB COMMENT '商品信息表';

CREATE TABLE `product_category`(
  `category_id` INT NOT NULL auto_increment,
  `category_name` VARCHAR(64) NOT NULL COMMENT '类目名称',
  `parent_id` INT COMMENT '父类目ID',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE  current_timestamp COMMENT '修改时间',
  PRIMARY KEY(`category_id`),
)ENGINE=INNODB COMMENT '商品类目';

CREATE TABLE `order_master`(
	`order_id` VARCHAR(32) NOT NULL,
	`buyer_name` VARCHAR(32) NOT NULL COMMENT '买家姓名',
  `buyer_phone` VARCHAR(32) NOT NULL COMMENT '买家电话',
  `buyer_adder` VARCHAR(128) NOT NULL COMMENT '买家地址',
	`buyer_openid` VARCHAR(64) NOT NULL COMMENT '买家openid',
	`order_amount` DECIMAL(8,2) NOT NULL COMMENT '订单总金额',
	`order_status` TINYINT(3) NOT NULL DEFAULt '0' COMMENT '订单状态 默认0 新下单',
	`pay_status` TINYINT(3) NOT NULL DEFAULT '0' COMMENT '支付状态 默认0 未支付',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE  current_timestamp COMMENT '修改时间',
   PRIMARY KEY (`order_id`),
	 KEY `index_buyer_openid` (`buyer_openid`)
)ENGINE=INNODB COMMENT '订单表';

CREATE TABLE `order_detail`(
	`detail_id` VARCHAR(32) NOT NULL ,
	`order_id` 	VARCHAR(32) NOT NULL COMMENT '订单编号',
	`product_id` VARCHAR(32) NOT NULL COMMENT '商品编号',
	`product_name` VARCHAR(64) NOT NULL COMMENT '商品名称',
	`product_price` DECIMAL(6,2) NOT NULL COMMENT '商品价格',
	`product_quantity` INT NOT NULL COMMENT '商品数量',
	`product_icon` VARCHAR(128) NOT NULL COMMENT '商品图片',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE  current_timestamp COMMENT '修改时间',
	PRIMARY KEY (`detail_id`),
	KEY `index_order_id` (`order_id`)
)ENGINE=INNODB COMMENT '订单详情表';

CREATE TABLE `cart`(
	`cart_id` CHAR(32) NOT NULL,
	`open_id` VARCHAR(64) NOT NULL COMMENT '买家openid',
	`product_id` CHAR(32) NOT NULL COMMENT '商品ID',
	`product_num` INT(5) NOT NULL COMMENT '商品数量',
	`size` VARCHAR(32) COMMENT '商品规格',
	`color` VARCHAR(32) COMMENT '商品颜色',
	`cart_status` TINYINT(3) NOT NULL DEFAULT '0' COMMENT '购物车状态 0未结算 1已结算',
	`create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE  current_timestamp COMMENT '修改时间',
   PRIMARY KEY (`cart_id`)
)ENGINE=INNODB COMMENT '购物车';

CREATE TABLE `major_product` (
  `major_id` char(32) NOT NULL,
  `product_id` char(32) NOT NULL COMMENT '商品id',
  `product_img` varchar(512) NOT NULL COMMENT '商品图片',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`major_id`),
	UNIQUE KEY `product_id`(`product_id`)
) ENGINE=InnoDB COMMENT='热门推荐';


CREATE TABLE `address` (
  `address_id` char(32) NOT NULL,
  `open_id` VARCHAR(64) NOT NULL COMMENT '买家openid',
  `buyer_name` VARCHAR(32) NOT NULL COMMENT '买家姓名',
  `buyer_phone` VARCHAR(32) NOT NULL COMMENT '买家电话',
  `buyer_address` VARCHAR(128) NOT NULL comment '买家地址',
  `postal_code` varchar(32) NOT NULL COMMENT '邮政编码',
  `is_default` TINYINT(2) NOT NULL  COMMENT '0:默认收货地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB COMMENT='收货地址';

CREATE TABLE `coupon` (
  `coupon_id` char(32) NOT NULL,
  `open_id` VARCHAR(64) NOT NULL COMMENT '买家openid',
  `coupon_price` DECIMAL(6,2) NOT NULL COMMENT '优惠金额',
  `remark` VARCHAR(128) NOT NULL COMMENT '备注',
  `limit_price` DECIMAL(6,2) NOT NULL COMMENT '满减金额',
  `now` VARCHAR(64) NOT NULL COMMENT '有效期开始',
  `end` VARCHAR(64) NOT NULL COMMENT '有效期结束',
  `status` TINYINT(2) NOT NULL  COMMENT '0:未领取',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB COMMENT='优惠卷';