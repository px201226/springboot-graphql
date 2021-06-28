INSERT INTO USER (id,name, email,create_date_time) VALUES
(1,'김두한','email1@naver.com',now()),
(2,'홍길동','email2@naver.com',now()),
(3,'이순신','email3@naver.com',now());

INSERT INTO POST (id,title, user_id,create_date_time) VALUES
(1,'날씨가 좋네요',1,now()),
(2,'산책하기 좋네요',2,now()),
(3,'영화보실분?',3,now()),
(4,'밥드실분?',2,now()),
(5,'코딩하실분?',3,now());

INSERT INTO COMMENT (id,title, user_id, post_id,create_date_time) VALUES
(1,'완전 여름이네요',1,1,now()),
(2,'더워요',1,1,now()),
(3,'반갑습니다',1,1,now()),
(4,'안녕하세요',1,2,now()),
(5,'만나서 반갑습니다.',2,2,now()),
(6,'그러게요',3,1,now()),
(7,'공감합니다',3,1,now());

