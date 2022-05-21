insert into member(seq,id,password,name,role) values(1,'admin','1q2w3e4r!!','관리자','ROLE_ADMIN') ON DUPLICATE KEY UPDATE use_yn = 'Y' ;
insert into member(seq,id,password,name,role) values(2,'user1','1q2w3e4r!!','사용자1','ROLE_USER') ON DUPLICATE KEY UPDATE use_yn = 'Y';
insert into member(seq,id,password,name,role) values(3,'user2','1q2w3e4r!!','사용자2','ROLE_USER') ON DUPLICATE KEY UPDATE use_yn = 'Y';
insert into member(seq,id,password,name,role, use_yn) values(4,'user3','1q2w3e4r!!','사용자3','ROLE_USER', 'N') ON DUPLICATE KEY UPDATE use_yn = 'N';


insert into login_log (id, login_status) values ( 'user3', 'N' );
insert into login_log (id, login_status) values ( 'user3', 'N' );
insert into login_log (id, login_status) values ( 'user3', 'N' );
insert into login_log (id, login_status) values ( 'user3', 'N' );
insert into login_log (id, login_status) values ( 'user3', 'N' );
