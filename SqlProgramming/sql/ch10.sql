-- Section03 Equi Join( = Inner Join)
-- 조인 대상이 되는 두 테이블에서 공통으로 존재하는 컬럼의 값이
-- 일치하는 행을 연결하여 결과를 생성하는 조인 방법
-- 연결조건 개수 = 테이블 개수 - 1
--------------------------------------------------------------------------------
-- 101번 사원의 부서 이름은?
select department_name 
from departments d, employees e
where employee_id=101 
      and d.department_id=e.department_id;

-- ANSI Inner Join 문법 
-- on 연결조건
select department_name 
from departments
inner join employees
on departments.department_id=employees.department_id
where employee_id=101;
--------------------------------------------------------------------------------
-- Sales 부서가 있는 도시는?
select department_name, city
from departments d, locations l
where d.location_id = l.location_id
      and department_name='Sales';
      
-- ANSI Inner Join 문법 
select department_name, city
from departments
inner join locations
on departments.location_id = locations.location_id
where department_name='Sales';
--------------------------------------------------------------------------------
-- 101번 사원의 부서 번호와 부서 이름은?
select d.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id
      and employee_id=101;
--------------------------------------------------------------------------------
-- 101번 사원의 근무 도시는?
select employee_id, city
from employees e, departments d, locations l
where e.department_id=d.department_id 
and d.location_id=l.location_id
and employee_id=101;

-- ANSI Inner Join 문법
select employee_id, city
from employees e
inner join departments d on e.department_id=d.department_id
inner join locations l on d.location_id=l.location_id
where employee_id=101;
--------------------------------------------------------------------------------
-- 101번 사원의 사번, first name, 부서번호, 부서이름, 나라, 도시는?
select employee_id,first_name, d.department_id, department_name, country_name, city
from employees e, departments d, locations l, countries c
where e.department_id=d.department_id 
      and d.location_id=l.location_id 
      and l.country_id=c.country_id
      and employee_id=101;

-- ANSI INNER JOIN 문법
select employee_id,first_name, d.department_id, department_name, country_name, city
from employees e
inner join departments d on e.department_id=d.department_id 
inner join locations l on d.location_id=l.location_id
inner join countries c on l.country_id=c.country_id
where employee_id=101;
--------------------------------------------------------------------------------

-- Section04 Self Join(=Inner Join)
-- 101번 사원의 관리자 이름은?
select e2.first_name
from employees e1, employees e2
where e1.manager_id = e2.employee_id
      and e1.employee_id=101;
      
-- 5.3 ANSI Outer Join
create table member(
  mid varchar(10) primary key,
  mname varchar(10) not null
);
create table board(
  bno number(5) primary key,
  btitle varchar(100) not null,
  bwriter varchar(10) references member(mid)
);
insert into member values('user1', '사용자1');
insert into member values('user2', '사용자2');
insert into member values('user3', '사용자3');
insert into member values('user4', '사용자4');
insert into member values('user5', '사용자5');

insert into board values(1, '제목1', 'user1');
insert into board values(2, '제목2', 'user2');
insert into board values(3, '제목3', 'user3');

select mid, mname, bno, btitle
from lefttable
inner join righttable
on lefttable.mid=righttable.bwriter;

----------- 게시물을 한 번도 작성하지 않은 멤버의 정보는?
-- join 기준으로 왼쪽이니까 from인 member가 기준
select mid, mname, bno, btitle
from member
left outer join board
on member.mid=board.bwriter
where bno is null;
-- join을 기준으로 왼쪽 오른쪽 나뉨

-- join 기준으로 오른쪽이니까 join다음에 써있는 member가 기준, 결국 모두 같은 출력
select bno, btitle, mid, mname 
from board
right outer join member
on member.mid=board.bwriter
where bno is null;



-- LEFT OUTER JOIN
select mid, mname, bno, btitle
from member
left outer join board
on member.mid=board.bwriter;

-- RIGHT OUTER JOIN
select mid, mname, bno, btitle
from member
right outer join board
on member.mid=board.bwriter;

-- FULL OUTER JOIN
select mid, mname, bno, btitle
from member
full outer join board
on member.mid=board.bwriter;


-- [ 참고: only oracle ver. ] --------------------------------------------------
--left outer join
-- member.mid에 없는 board.bwriter에 null을 추가하시오
select mid, mname, bno, btitle
from board, member
where member.mid=board.bwriter(+);

-- right outer join 
-- member.mid에 없는 board.bwriter에 null을 추가하시오
select mid, mname, bno, btitle
from board, member
where board.bwriter(+)=member.mid;
--------------------------------------------------------------------------------


