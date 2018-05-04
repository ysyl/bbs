use bbs;

DROP TABLE IF EXISTS t_broad_manager;
DROP TABLE IF EXISTS t_post;
DROP TABLE IF EXISTS t_topic;
DROP TABLE IF EXISTS t_role_user;
DROP TABLE IF EXISTS t_role;
DROP TABLE IF EXISTS t_broad;
DROP TABLE IF EXISTS t_user;
DROP TABLE IF EXISTS t_login_log;

CREATE TABLE `t_broad` (
    id int NOT NULL AUTO_INCREMENT, 
    broad_name varchar(15) NOT NULL,
    broad_desc varchar(255) COMMENT '版块描述',
    topic_num int DEFAULT 0 COMMENT '帖子数目',
    PRIMARY KEY(id)
);

CREATE TABLE t_user (
    id bigint NOT NULL AUTO_INCREMENT,
    username varchar(15) NOT NULL,
    password varchar(30) NOT NULL,
    credit int COMMENT '积分',
    lock_type tinyint NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);

CREATE TABLE t_role (
    id int NOT NULL AUTO_INCREMENT,
    role_name varchar(15) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE t_role_user (
    role_id int NOT NULL,
    user_id bigint NOT NULL,
    PRIMARY KEY(role_id, user_id)
);

CREATE TABLE t_broad_manager (
    broad_id int NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT fk_broad_manager FOREIGN KEY (broad_id) REFERENCES t_broad(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_user_manager FOREIGN KEY (user_id) REFERENCES t_user(id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(broad_id, user_id)
);

CREATE TABLE t_topic (
    id bigint NOT NULL AUTO_INCREMENT,
    broad_id int NOT NULL,
    user_id bigint NOT NULL,
    title varchar(30) NOT NULL,
    views int NOT NULL DEFAULT 0,
    last_post datetime NOT NULL DEFAULT now(),
    digest tinyint NOT NULL DEFAULT 0,
    replies int NOT NULL DEFAULT 0,
    CONSTRAINT fk_broad_topic FOREIGN KEY (broad_id) REFERENCES t_broad(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_user_topic FOREIGN KEY (user_id) REFERENCES t_user(id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(id)
);

CREATE TABLE t_post (
    id bigint NOT NULL AUTO_INCREMENT,
    content varchar(1024) NOT NULL,
    user_id bigint NOT NULL,
    topic_id bigint NOT NULL,
    post_type int(2) NOT NULL,
    reply_post_id bigint,
    create_time datetime NOT NULL DEFAULT now(),
    CONSTRAINT fk_user_post FOREIGN KEY (user_id) REFERENCES t_user(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_topic_post FOREIGN KEY (topic_id) REFERENCES t_topic(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_reply_post FOREIGN KEY (reply_post_id) REFERENCES t_post(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    PRIMARY KEY(id)
);

INSERT t_broad(broad_name, broad_desc ) VALUES("游戏", "游戏版块");
INSERT t_broad(broad_name, broad_desc ) VALUES("电影", "电影版块");
INSERT t_broad(broad_name, broad_desc ) VALUES("动画", "动画版块");
INSERT t_broad(broad_name, broad_desc ) VALUES("音乐", "音乐版块");

INSERT t_user(username, password) VALUES("瑜亮", "123456");
INSERT t_user(username, password) VALUES("joy", "123457");
INSERT t_user(username, password) VALUES("tom", "123458");

INSERT t_role(role_name) VALUES("visitor");  
INSERT t_role(role_name) VALUES("normal_user");
INSERT t_role(role_name) VALUES("broad_manager");
INSERT t_role(role_name) VALUES("bbs_manager");

INSERT t_role_user(role_id, user_id) VALUES(4, 1); 
INSERT t_role_user(role_id, user_id) VALUES(3, 1); 
INSERT t_role_user(role_id, user_id) VALUES(2, 2); 
INSERT t_role_user(role_id, user_id) VALUES(3, 3); 

INSERT t_topic(broad_id, user_id, title) VALUES(1, 1, "测试游戏话题1");
INSERT t_topic(broad_id, user_id, title) VALUES(1, 1, "测试游戏话题2");
INSERT t_topic(broad_id, user_id, title) VALUES(1, 1, "测试游戏话题3");
INSERT t_topic(broad_id, user_id, title) VALUES(1, 1, "测试游戏话题4");
INSERT t_topic(broad_id, user_id, title) VALUES(1, 1, "测试游戏话题5");
INSERT t_topic(broad_id, user_id, title) VALUES(1, 1, "测试游戏话题6");
INSERT t_topic(broad_id, user_id, title) VALUES(2, 2, "测试电影话题1"); 
INSERT t_topic(broad_id, user_id, title) VALUES(2, 2, "测试电影话题2"); 
INSERT t_topic(broad_id, user_id, title) VALUES(2, 2, "测试电影话题3"); 
INSERT t_topic(broad_id, user_id, title) VALUES(2, 2, "测试电影话题4"); 
INSERT t_topic(broad_id, user_id, title) VALUES(3, 3, "测试动画话题1");
INSERT t_topic(broad_id, user_id, title) VALUES(3, 3, "测试动画话题2");
INSERT t_topic(broad_id, user_id, title) VALUES(3, 3, "测试动画话题3");
INSERT t_topic(broad_id, user_id, title) VALUES(3, 3, "测试动画话题4");
INSERT t_topic(broad_id, user_id, title) VALUES(4, 3, "测试音乐话题1");

INSERT t_post(user_id, topic_id, post_type, content) VALUES( 1, 1, 0, "测试游戏话题1 主贴"); 
INSERT t_post(user_id, topic_id, post_type, content) VALUES( 1, 2, 0, "测试游戏话题2 主贴"); 
INSERT t_post(user_id, topic_id, post_type, content) VALUES( 1, 3, 0, "测试游戏话题3 主贴"); 
INSERT t_post(user_id, topic_id, post_type, content) VALUES( 1, 4, 0, "测试游戏话题4 主贴"); 
INSERT t_post(user_id, topic_id, post_type, content) VALUES( 1, 5, 0, "测试游戏话题5 主贴"); 
INSERT t_post(user_id, topic_id, post_type, content) VALUES( 1, 6, 0, "测试游戏话题6 主贴"); 
INSERT t_post(user_id, topic_id, post_type, content) VALUES( 2, 7, 0, "测试电影话题2 主贴"); 
INSERT t_post(user_id, topic_id, post_type, content) VALUES( 3, 8, 0, "测试动画话题2 主贴"); 
INSERT t_post(user_id, topic_id, post_type, content) VALUES( 1, 9, 0, "测试游戏话题3 主贴"); 
INSERT t_post(user_id, topic_id, post_type, content) VALUES( 1, 10, 0, "测试游戏话题4 主贴"); 
INSERT t_post(user_id, topic_id, post_type, content) VALUES( 1, 11, 0, "测试游戏话题5 主贴"); 
INSERT t_post(user_id, topic_id, post_type, content) VALUES( 1, 12, 0, "测试游戏话题6 主贴"); 

INSERT t_post(user_id, topic_id, post_type, reply_post_id, content) VALUES( 1, 1, 1, null, "测试游戏话题1 回复"); 
INSERT t_post(user_id, topic_id, post_type, reply_post_id, content) VALUES( 1, 2, 1, 13, "测试游戏话题2 回复1"); 
INSERT t_post(user_id, topic_id, post_type, reply_post_id, content) VALUES( 1, 2, 1, 13, "测试游戏话题2 回复2"); 
INSERT t_post(user_id, topic_id, post_type, reply_post_id, content) VALUES( 1, 2, 1, 13, "测试游戏话题2 回复3"); 
INSERT t_post(user_id, topic_id, post_type, reply_post_id, content) VALUES( 1, 2, 1, 13, "测试游戏话题2 回复4"); 

