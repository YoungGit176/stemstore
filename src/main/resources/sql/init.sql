-- 删除数据库
drop
database if exists stemgame;


-- 创建数据库
create
database stemgame default charset=UTF8MB4;

-- 切换数据库
use
stemgame;

-- 创建用户表
create table stemgame.user
(
    user_id   int(10) primary key not null auto_increment,
    user_name varchar(20) NOT NULL UNIQUE ,
    user_pwd  varchar(20) NOT NULL
)engine=InnoDB default charset=UTF8MB4;


-- 创建游戏表
create table stemgame.game
(
    game_id    int(10) primary key not null auto_increment,
    game_name  varchar(20),
    game_price int(4),
    game_intro varchar(20)
)engine=InnoDB default charset=UTF8MB4;

-- 创建收藏表
create table stemgame.coll
(
    user_id int(10),
    game_id int(10),
    FOREIGN KEY (user_id) REFERENCES user (user_id),
    FOREIGN KEY (game_id) REFERENCES game (game_id)
)engine=InnoDB default charset=UTF8MB4;

-- 创建收藏表
create table stemgame.odr
(
    order_num  int(10) primary key not null auto_increment,
    order_date date,
    order_stat int(1),
    user_id    int(10),
    game_id    int(10),
    FOREIGN KEY (user_id) REFERENCES user (user_id),
    FOREIGN KEY (game_id) REFERENCES game (game_id)
)engine=InnoDB default charset=UTF8MB4;
-- 添加联合唯一约束
alter table odr add unique key(user_id,game_id);
-- 插入用户测试数据
insert into stemgame.user(user_id, user_name, user_pwd)
values (1001, 'qurui', '123456');
insert into stemgame.user(user_id, user_name, user_pwd)
values (1002, 'xiehui', '123456');
insert into stemgame.user(user_id, user_name, user_pwd)
values (1003, 'yangjun', '123456');
insert into stemgame.user(user_id, user_name, user_pwd)
values (1004, 'zhangxiangyi', '123456');


-- 插入游戏测试数据
insert into stemgame.game(game_id, game_name, game_price, game_intro)
values (2001, 'Call of Duty', 269, '动视所推出的第一人称射击游戏');
insert into stemgame.game(game_id, game_name, game_price, game_intro)
values (2002, 'Apex Legends', 0, '大逃杀类多人在线角色扮演第一人称射击游戏');
insert into stemgame.game(game_id, game_name, game_price, game_intro)
values (2003, 'League of Legends', 0, '5v5多人在线战斗技术型');
insert into stemgame.game(game_id, game_name, game_price, game_intro)
values (2004, 'Counter-Strike', 20, '经典第一人称射击游戏');
insert into stemgame.game(game_id, game_name, game_price, game_intro)
values (2005, 'Battlefield 2042', 240, '第一人称射击游戏');
insert into stemgame.game(game_id, game_name, game_price, game_intro)
values (2006, 'It Takes Two', 198, '一款双人运动游戏');

-- 插入收藏测试数据
insert into stemgame.coll(user_id, game_id)
values (1001, 2001);
insert into stemgame.coll(user_id, game_id)
values (1001, 2002);
insert into stemgame.coll(user_id, game_id)
values (1002, 2004);
insert into stemgame.coll(user_id, game_id)
values (1002, 2002);
insert into stemgame.coll(user_id, game_id)
values (1003, 2005);
insert into stemgame.coll(user_id, game_id)
values (1004, 2003);

-- 插入订单测试数据
insert into stemgame.odr(order_num, order_date, order_stat, user_id, game_id)
values (3001, now(), 0, 1001, 2003);
insert into stemgame.odr(order_num, order_date, order_stat, user_id, game_id)
values (3002, now(), 1, 1001, 2001);
insert into stemgame.odr(order_num, order_date, order_stat, user_id, game_id)
values (3003, now(), 1, 1002, 2002);
insert into stemgame.odr(order_num, order_date, order_stat, user_id, game_id)
values (3004, now(), 1, 1003, 2004);
insert into stemgame.odr(order_num, order_date, order_stat, user_id, game_id)
values (3005, now(), 1, 1004, 2005);

-- 查看添加的测试数据
select *
from stemgame.user;
select *
from stemgame.game;
select *
from stemgame.coll;
select *
from stemgame.odr;

