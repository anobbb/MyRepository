-- Section01 시퀀스 생성
create sequence seq_1;
-- 다음 수 얻기
select seq_1.nextval from dual;
-- 현재 부여된 번호
select seq_1.currval from dual;

create sequence seq_2
  start with 101
  increment by 10
  maxvalue 1000
  nocycle
  nocache;
  
select seq_2.nextval from dual;

drop sequence seq_1;
drop sequence seq_2;
drop sequence seq_board_bno;

-- Section04 인덱스 개요
-- table scan
set timing on;
select*from board where btitle= '제목9333';

create index idx_board_btitle on board(btitle);
select*from board where btitle= '제목9333';
drop index idx_board_btitle;

select*from board where bno=9333;

create unique index seq_board_bno on board(bno);
select*from board where bno=9333;
drop index idx_board_bno;