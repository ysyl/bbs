use bbs;
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

INSERT t_topic(broad_id, user_id, title) VALUES(1, 1, "测试话题1");
INSERT t_topic(broad_id, user_id, title) VALUES(2, 2, "测试电影话题1"); 
INSERT t_topic(broad_id, user_id, title) VALUES(3, 3, "测试动画话题1");
INSERT t_topic(broad_id, user_id, title) VALUES(1, 1, "测试游戏话题2");

