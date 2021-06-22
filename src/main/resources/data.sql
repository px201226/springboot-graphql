INSERT INTO USER_TABLE (id,name, email) VALUES
(1,'name1','email1@naver.com'),
(2,'name2','email2@naver.com'),
(3,'name3','email3@naver.com');

INSERT INTO POST (id,title, user_id) VALUES
(1,'포스트1',1),
(2,'포스트2',1),
(3,'포스트3',1),
(4,'포스트4',2);

INSERT INTO COMMENT (id,title, user_id, post_id) VALUES
(1,'제목1',1,1),
(2,'제목2',1,1),
(3,'제목3',1,1),
(4,'제목4',1,2),
(5,'제목5',2,1),
(6,'제목6',3,1),
(7,'제목7',3,1);

