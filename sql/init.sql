CREATE TABLE  `product_info` (
    `product_id` VARCHAR(32) not null ,
	  `product_name` VARCHAR(64) not null COMMENT '商品名称',
    `product_price` DECIMAL(4,2) not null COMMENT '商品单价',
    `product_stock` INT NOT NULL COMMENT '库存',
    `product_description` VARCHAR(64) COMMENT '描述',
    `product_icon` VARCHAR(512) COMMENT '图标',
    `category_type` INT NOT NULL COMMENT '类目编号',
    `product_status` TINYINT(3) NOT NULL DEFAULT '0' COMMENT '商品状态 默认0 上架',
    `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
    `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE  current_timestamp COMMENT '修改时间',
     PRIMARY KEY(`product_id`)
)ENGINE=InnoDB COMMENT '商品信息表';

CREATE TABLE `product_category`(
  `category_id` INT NOT NULL auto_increment,
  `category_name` VARCHAR(64) NOT NULL comment '类目名称',
  `category_type` INT NOT NULL comment '类目编号',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE  current_timestamp COMMENT '修改时间',
  PRIMARY KEY(`category_id`),
  UNIQUE KEY `category_type` (`category_type`)
)ENGINE=INNODB COMMENT '商品类目';

CREATE TABLE `order_master`(
	`order_id` VARCHAR(32) NOT NULL,
	`buyer_name` VARCHAR(32) NOT NULL comment '买家姓名',
  `buyer_phone` VARCHAR(32) NOT NULL comment '买家电话',
  `buyer_adder` VARCHAR(128) NOT NULL comment '买家地址',
	`buyer_openid` VARCHAR(64) NOT NULL comment '买家openid',
	`order_amount` DECIMAL(8,2) NOT NULL comment '订单总金额',
	`order_status` TINYINT(3) NOT NULL DEFAULt '0' comment '订单状态 默认0 新下单',
	`pay_status` TINYINT(3) NOT NULL DEFAULT '0' comment '支付状态 默认0 未支付',
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
	`product_price` DECIMAL(4,2) NOT NULL COMMENT '商品价格',
	`product_quantity` INT NOT NULL COMMENT '商品数量',
	`product_icon` VARCHAR(128) NOT NULL COMMENT '商品图片',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE  current_timestamp COMMENT '修改时间',
	PRIMARY KEY (`detail_id`),
	KEY `index_order_id` (`order_id`)
)ENGINE=INNODB COMMENT '订单详情表';