-- CREATE DATABASE `miaosha`;

CREATE TABLE `miaosha_user`(
  `id` BIGINT(20) NOT NULL COMMENT '用户id 手机号码',
  `nickname` VARCHAR(255) NOT NULL ,
  `password` VARCHAR(32) DEFAULT NULL COMMENT 'MD5(MD5(pass明文+固定salt))',
  `salt` VARCHAR(10) DEFAULT NULL ,
  `head` VARCHAR(128) DEFAULT NULL COMMENT '头像，云存储的ID',
  `register_date` DATETIME DEFAULT NULL COMMENT '注册时间',
  `last_login_date` DATETIME DEFAULT NULL COMMENT '上次登录时间',
  `login_count` INT(11) DEFAULT '0' COMMENT '登录次数',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO miaosha_user (id, nickname, password, salt, head, register_date, last_login_date, login_count) VALUES (18701356721, '18701356721', 'b7797cce01b4b131b433b6acf4add449', '1a2b3c4d', null, '2018-01-11 13:52:14', '2018-01-11 13:52:16', 0);

CREATE TABLE `goods`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goods_name` VARCHAR(16) DEFAULT NULL COMMENT '商品名称',
  `goods_title` VARCHAR(64) DEFAULT NULL COMMENT '商品标题',
  `goods_img` VARCHAR(64) DEFAULT NULL COMMENT '商品图片',
  `goods_detail` LONGTEXT DEFAULT NULL COMMENT '商品详情',
  `goods_price` DECIMAL(10,2) DEFAULT NULL COMMENT '商品价格',
  `goods_stock` INT(11) DEFAULT NULL COMMENT '库存数量',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `miaosha_goods` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '秒杀的商品表',
  `goods_id` BIGINT(20) DEFAULT NULL COMMENT '商品id',
  `miaosha_price` DECIMAL(10,2) DEFAULT '0.00' COMMENT '秒杀价',
  `stock_count` INT(11) DEFAULT NULL COMMENT '库存数量',
  `start_date` DATETIME DEFAULT NULL COMMENT '秒杀开始时间',
  `end_date` DATETIME DEFAULT NULL COMMENT '秒杀结束时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

INSERT INTO `miaosha_goods` VALUES (1,1,0.01,4,'2018-01-12 12:15:00','2018-01-12 12:17:00'),(2,2,0.01,3,'2018-01-12 12:18:00','2018-01-12 12:19:00');

CREATE TABLE `order_info`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) DEFAULT NULL COMMENT '用户id',
  `goods_id` BIGINT(20) DEFAULT NULL COMMENT '商品id',
  `delivery_addr_id` BIGINT(20) DEFAULT NULL COMMENT '收货地址id',
  `goods_name` VARCHAR(16) DEFAULT NULL COMMENT '冗余过来的商品名称',
  `goods_count` int(11) DEFAULT 0 COMMENT '商品数量',
  `goods_price` DECIMAL(10,2) DEFAULT '0.00' COMMENT '商品单价',
  `order_channel` TINYINT(4) DEFAULT '0' COMMENT '1 pc,2 android,3 iOS',
  `status` TINYINT(4) DEFAULT '0' COMMENT '订单状态：0新建支付，1已支付，2已发货，3已收货，4已退款，5已完成',
  `create_date` DATETIME DEFAULT NULL COMMENT '订单创建时间',
  `pay_date` DATETIME DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `miaosha_order`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) DEFAULT NULL COMMENT '用户id',
  `order_id` BIGINT(20) DEFAULT NULL COMMENT '订单id',
  `goods_id` BIGINT(20) DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;



















