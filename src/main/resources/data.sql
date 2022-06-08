INSERT INTO article(id,title,content) values (1,'H','123');
INSERT INTO article(id,title,content) values (2,'T','456');
INSERT INTO article(id,title,content) values (3,'W','789');
INSERT INTO article(id,title,content) values (4,'J','012');

-- article 더미 데이터
INSERT INTO article(id,title,content) values (5,'Food','comment go');
INSERT INTO article(id,title,content) values (6,'Movie','comment go go');
INSERT INTO article(id,title,content) values (7,'Hobby','comment go go go');

--comment 더미 데이터

---- 5번 게시글의 댓글들
INSERT INTO comment(id,article_id,nickname,body) values(1,5,'JBH','pizza');
INSERT INTO comment(id,article_id,nickname,body) values(2,5,'JBH','chicken');
INSERT INTO comment(id,article_id,nickname,body) values(3,5,'JBH','Hamburger');

---- 6번 게시글의 댓글들
INSERT INTO comment(id,article_id,nickname,body) values(4,6,'JBH','Trueman');
INSERT INTO comment(id,article_id,nickname,body) values(5,6,'JBH','iron man');
INSERT INTO comment(id,article_id,nickname,body) values(6,6,'JBH','world war 2');

---- 7번 게시글의 댓글들
INSERT INTO comment(id,article_id,nickname,body) values(7,7,'JBH','tennis');
INSERT INTO comment(id,article_id,nickname,body) values(8,7,'JBH','soccer');
INSERT INTO comment(id,article_id,nickname,body) values(9,7,'JBH','ski');


