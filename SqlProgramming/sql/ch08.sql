-- ch08: DML(Data Manipulation Language) - 데이터 관련된 명령어
--          : 저장(insert), 수정(update), 삭제(delete), 조회(select)
--       DDL(Data Definition Language) - 데이터 베이스 객체(Object)와 관련된 명령어
--          : 생성(create), 삭제(drop), 수정(alter)
--       DCL(Data Control Language) - 권한 및 사용자와 관련된 명령어
--          : 권한할당(grant), 권한삭제(revoke), 작업반영(commit), 작업취소(rollback)

-- Section01 테이블에 내용을 추가하는 INSERT 문
insert into member(mid, mname, mage, mbirth) 
values('user3', '사용자3', 10, '2006.5.15');

insert into member(mid, mname) 
values('user4', '사용자4');

-- 컬럼명을 생략할 경우, 데이터를 입력하지 않는 컬럼의 자리가 있다면 순서대로 컬럼의 개수를 채워줘야 함
insert into member values('user5', '사용자5', null, null);

insert into board(bno, btitle, bcontent, bwriter, bhitcount, bdate)
values(4, '제목4', '내용4', 'user2', 0, '16.10.19');

insert into board
values(5, '제목5', '내용5', 'user3', 0, sysdate);

insert into board(bno, btitle, bcontent, bwriter)
values(6, '제목6', '내용6', 'user2');

-- Section02 테이블의 내용을 수정하는 UPDATE문
-- set: 변경하라는 명령어
update member set mage=10 where mid='user4';
update member set mage=20, mbirth='2001.08.10' where mid='user5';
update member set mage=mage+1 where mid='user4';

-- Section03 테이블의 내용을 삭제하는 DELETE문
delete member where mid='user5';
delete member where mage<=20;

-- Section04 트랜잭션 관리
create table account(
  ano varchar(20) not null,
  abalance number(10) null
);
insert into account(ano, abalance) values('111-111', 1000000);
insert into account(ano, abalance) values('111-112', 0);
commit;

-- 계좌이체: 출금작업 + 입금작업 --> 트랜잭션 작업 = All or Nothing
    -- 출금작업 
    update account set abalance = abalance-10000 where ano='111-111';
    select * from account;
    -- 입금작업
    update account set abalance = abalance+10000 where ano='111-113';
-- 출금은 성공했으나, 입금이 실패했기 때문에 전체를 실패처리해야함
 rollback;
 -- 출금도 성공했고, 입금도 성공했다면 전체를 영구반영 처리해야함
 commit;