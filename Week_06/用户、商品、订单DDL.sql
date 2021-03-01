CREATE TABLE `user_info` (
  `user_id` BIGINT(20) NOT NULL COMMENT '用户id',
  `user_name` VARCHAR(32) DEFAULT NULL COMMENT '姓名',
  `user_sex` INT(11) DEFAULT NULL COMMENT '性别',
  `user_address` VARCHAR(255) DEFAULT NULL COMMENT '地址',
  `user_phone` VARCHAR(20) DEFAULT NULL COMMENT '联系电话',
  `status` TINYINT(3) NOT NULL COMMENT '状态：0: 正常  1: 删除',
  `created_by` BIGINT(20) NOT NULL COMMENT '创建人ID',
  `updated_by` BIGINT(20) DEFAULT NULL COMMENT '更新人ID',
  `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `extend` VARCHAR(3000) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '扩展字段',
  `version` INT(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';


CREATE TABLE `goods_info` (
  `goods_id` BIGINT(20) NOT NULL COMMENT '主键，商品id',
  `goods_name` VARCHAR(1000) DEFAULT NULL COMMENT '商品名称',
  `goods_specifications` VARCHAR(128) DEFAULT '' COMMENT '规格名称',
  `goods_price` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '商品价格',
  `goods_status` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '商品状态',
  `goods_stock` INT(11) NOT NULL DEFAULT '1' COMMENT '商品库存',
  `buy_stock` INT(11) NOT NULL DEFAULT '0' COMMENT '记录当前可购买的商品库存数',
  `goods_sold` INT(11) NOT NULL DEFAULT '0' COMMENT '商品销量',
  `status` TINYINT(3) NOT NULL COMMENT '状态：0: 正常  1: 删除',
  `created_by` VARCHAR(100) DEFAULT '' COMMENT '创建人',
  `updated_by` VARCHAR(100) DEFAULT '' COMMENT '修改人',
  `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `extend` VARCHAR(3000) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '扩展字段',
  `version` SMALLINT(20) DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`goods_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息表';



CREATE TABLE `order_info` (
  `order_id` BIGINT(32) NOT NULL COMMENT '订单号',
  `user_id` BIGINT(20) NOT NULL COMMENT '创建人id',
  `order_status` BIGINT(32) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `total_amount` INT(16) NOT NULL COMMENT '商品总金额',
  `express_no` VARCHAR(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运单号',
  `express_fee` INT(8) NOT NULL COMMENT '运费',
  `consignee_id` BIGINT(20) NOT NULL COMMENT '收货人ID',
  `consignee` VARCHAR(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收货人',
  `consignee_phone` VARCHAR(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收货人手机号',
  `consignee_address` VARCHAR(256) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '详细地址',
  `pay_time` TIMESTAMP NULL DEFAULT NULL COMMENT '支付时间',
  `complete_time` TIMESTAMP NULL DEFAULT NULL COMMENT '完成时间',
  `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` TINYINT(3) NOT NULL DEFAULT '0' COMMENT '状态(-1删除，0正常)',
  `extend` VARCHAR(3000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段',
  `version` INT(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`order_id`),
  KEY `index_user_id` (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单表';



CREATE TABLE `order_goods_info` (
  `detail_id` BIGINT(32) NOT NULL COMMENT '订单明细ID',
  `order_id` BIGINT(32) NOT NULL COMMENT '订单ID',
  `goods_id` BIGINT(20) NOT NULL COMMENT '商品 id',
  `settle_price` INT(16) NOT NULL COMMENT '结算单价',
  `sku_count` INT(8) NOT NULL COMMENT '数量',
  `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` TINYINT(3) NOT NULL DEFAULT '0' COMMENT '状态(-1删除，0正常)',
  `extend` VARCHAR(3000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段',
  `version` INT(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`),
  KEY `index_goods_id` (`goods_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单商品表';

