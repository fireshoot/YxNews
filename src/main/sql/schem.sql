
--数据库初始化脚本

--创建数据库

CREATE database news;

--使用数据库

USE news;


--创建新闻系统的用户

CREATE TABLE user(
    `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT  '用户名id',
    `user_type` bigint NOT NULL  COMMENT '用户类别，0：表示普通用户;1：认证用户;2：管理员',
    `user_password` VARCHAR(120) NOT NULL COMMENT '用户密码',
    `user_name` VARCHAR(120) NOT NULL COMMENT '用户昵称',
    `user_email` VARCHAR (20)  NOT NULL COMMENT '邮箱',
    `user_age` SMALLINT  COMMENT '年龄',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (user_id),
    KEY idx_user_id(user_id),
    KEY idx_user_type(user_type),
    KEY idx_create_time(create_time)
)engine=InnoDB auto_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='用户表';

--初始化一些数据

INSERT INTO user(user_type,user_password,user_name, user_email, user_age)
VALUES
(0,'123','杨鑫','82345988@qq.com',18),
(1,'123','yangXin','82345988@qq.com',18),
(1,'123','caoXinDi','82345988@qq.com',18),
(0,'123','yx','82345988@qq.com',18),
(0,'123','cxd','82345988@qq.com',18),
(1,'123','杨鑫','82345988@qq.com',18);


--创建新闻表

CREATE TABLE new(
    `new_id` bigint NOT NULL AUTO_INCREMENT COMMENT '新闻id',
    `category_id` bigint NOT NULL COMMENT '类别id',
    `user_id` bigint NOT NULL COMMENT '作者的id',
    `title` VARCHAR (100) NOT NULL COMMENT '新闻标题',
    `content` TEXT  NOT NULL COMMENT '新闻内容',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `key_words` VARCHAR (120) COMMENT '新闻关键字',
    PRIMARY KEY (new_id,category_id,user_id),
    KEY idx_create_time(create_time)
)engine=InnoDB DEFAULT CHARSET=utf8 comment='新闻表';

--创建评论表

CREATE TABLE new_comment(
    `comment_id` bigint NOT NULL AUTO_INCREMENT COMMENT '评论id',
    `new_id` bigint NOT NULL COMMENT '新闻的id',
    `user_id` bigint NOT NULL COMMENT '评论者的id',
    `content` TEXT  NOT NULL COMMENT '评论内容',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY(comment_id,new_id,user_id),
    KEY idx_create_time(create_time)
)engine=InnoDB DEFAULT CHARSET=utf8 comment='评论表';

--创建类别表
CREATE TABLE category(
    `category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '类别id',
    `category_name` VARCHAR (120) NOT NULL COMMENT '类别名称',
    PRIMARY KEY(category_id)
)engine=InnoDB DEFAULT CHARSET=utf8 comment='类别表';

INSERT INTO category(CATEGORY_NAME)
VALUES
('娱乐'),
('军事'),
('体育'),
('社会'),
('历史'),
('法制');