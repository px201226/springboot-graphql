INSERT INTO USER (id,name, email,create_date_time) VALUES
(1,'name1','email1@naver.com',now()),
(2,'name2','email2@naver.com',now()),
(3,'name3','email3@naver.com',now());

INSERT INTO POST (id,title, user_id,create_date_time) VALUES
(1,'포스트1',1,now()),
(2,'포스트2',1,now()),
(3,'포스트3',1,now()),
(4,'포스트4',2,now()),
(5,'포스트5',3,now());

INSERT INTO COMMENT (id,title, user_id, post_id,create_date_time) VALUES
(1,'제목1',1,1,now()),
(2,'제목2',1,1,now()),
(3,'제목3',1,1,now()),
(4,'제목4',1,2,now()),
(5,'제목5',2,1,now()),
(6,'제목6',3,1,now()),
(7,'제목7',3,1,now());

