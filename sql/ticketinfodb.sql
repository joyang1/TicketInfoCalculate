USE `ticketinfodb`;

CREATE TABLE `datanum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL DEFAULT 0 COMMENT '数据总数 用来标志数据是否更新',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '数据数标志表';

DROP TABLE  IF EXISTS `yjdata`;
CREATE TABLE `yjdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `section` varchar(50) NOT NULL COMMENT '期号区间',
  `res` varchar(45) NOT NULL COMMENT '预警数据',
  `avg` varchar(45) NOT NULL DEFAULT '' COMMENT '数据均值',
  `bit` varchar(100) NOT NULL DEFAULT '' COMMENT '位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '预警数据表';

--ALTER TABLE yjdata ADD COLUMN 'section' VARCHAR(50) NOT NULL FIRST; --添加到第一列
--ALTER TABLE yjdata ADD COLUMN 'section' VARCHAR(50) NOT NULL;
