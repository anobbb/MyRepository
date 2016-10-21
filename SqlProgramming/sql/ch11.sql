-- Section01 서브쿼리의 기본 개념
-- 테이블간의 데이터를 연결(Join문으로 변경가능)
-- 이문세 사원의 부서 이름은?
select dname
from dept
where deptno=(select deptno from emp where ename='이문세');

select dname
from emp, dept
where emp.deptno = dept.deptno
      and ename='이문세';
      
-- join은 같은 값끼리 연결시키는 데에 시간이 더 오래걸림
-- sub query가 join보다 더 빠름(값만 얻은 후 값을 넘겨서 다시 실행하는 방식)

-- 1.1 단일행 서브 쿼리
select dname
from dept
where deptno=(select deptno from emp where ename='이문세');
-- 최저 봉급을 받아가는 사원의 정보는?
select *
from emp
where sal=(select min(sal) from emp);
-- 평균 봉급 이상을 받아가는 사원의 수는?
select count(*)
from emp
where sal>=(select avg(sal) from emp);

-- Section02 다중행 서브 쿼리
-- 서브 쿼리의 결과 값이 하나가 아니라서 =는 사용할 수 없음, 대신 in을 사용
-- 서울에 근무하는 사원의 이름은?
select ename
from emp
where deptno in (select deptno from dept where loc='서울');

-- 2.4 EXISTS 연산자
-- 사원이 1명이라도 존재하는 부서의 이름은?
select distinct dname
from dept d, emp e
where d.deptno=e.deptno;

select d.dname
from emp e, dept d
where d.deptno=e.deptno
group by d.dname;

-- sub쿼리에 주쿼리의 컬럼 사용 가능, dept에 10행이 있으면 서브 쿼리는 10번 실행, 그 중 
-- 서브쿼리의 where절 만족 여부를 체크 후 주쿼리 실행
select dname
from dept
where exists (select * from emp where emp.deptno=dept.deptno);

-- 사원이 존재하지 않는 부서의 이름은?
select dname
from dept d
left outer join emp 
on d.deptno=emp.deptno
where empno is null;

select dname
from dept
where not dname in (
      select distinct dname
      from dept d, emp e
      where d.deptno=e.deptno
);

select dname
from dept
where not exists (select * from emp where emp.deptno=dept.deptno);

-- Section03 서브쿼리를 이용하여 테이블을 생성하고 데이터를 조작하기
-- emp 테이블을 복제해서 emp2로 만드세요(하나의 DDL로만 작성하시오)
-- 제약조건(pk, fk, check, not null, default 등)은 복제되지 않음
-- 인덱스도 복제되지 않음 (제약조건인 primary key 등이 복제되지 않았으므로)
create table emp2
as
select * from emp;

-- emp 테이블의 구조만 복제해서 emp3로 만드세요
-- 제약 조건과 인덱스는 복제하지 않아도 됨
create table emp3
as
select * from emp where 1=0;
-- 3.3 서브 쿼리로 데이터를 삽입하기 
-- emp3을 만들었다면 10번 부서의 사원들만 복사하세요
-- values는 한 행만 삽입, values대신 select사용하면 조건에 맞는 여러 행 삽입 가능
insert into emp3 
select * from emp where deptno=10;

-- 3.4 서브 쿼리를 이용한 데이터 변경
-- 20번 부서의 위치를 40번 부서의 위치로 변경하세요
update dept 
set loc=(select loc from dept where deptno=40) 
where deptno=20;

-- 3.5 서브 쿼리를 이용한 데이터 삭제
-- 영업부서의 사원을 삭제하세요
delete emp
where deptno=(select deptno from dept where dname='영업부');

