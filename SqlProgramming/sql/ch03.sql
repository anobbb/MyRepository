-- Section01 DUAL 테이블 (계산 식의 값을 얻기 위한 가상테이블)
select * from dual;
select 10+20 from dual; -- select 다음의 행단위대로 출력
select sysdate from dual; -- ()가 없는 함수: 프로시져(함수의 일종), 현재 oracle dbms의 날짜

-- Section02 숫자 함수
-- 2.1 절대값을 구하는 ABS 함수
select abs(-10) from dual;
select ABS(-15) "Absolute" from dual;
update emp set sal=sal/7;
select * from emp;
rollback;
-----------------------------------------------------------------------------------------
-- single-row 함수
-- 소수 첫째자리까지 나타내기(반올림)
select sal, round(sal) from emp;
select sal, round(sal, 1) from emp;
-- 바로 아래 정수
select sal, floor(sal) from emp; -- 해당 값 바로 밑의 정수 ex) 42.86 -> 42
-- 바로 위 정수 
select sal, ceil(sal) from emp;
-- 소수 첫째자리까지 나타내기(잘라내기)
select sal, trunc(sal, 1) from emp;

-- Section03 문자 처리 함수
-- 3.1 대소문자 변환함수
select * from employees;
select phone_number from employees
where first_name='steven'; -- 컬럼명이나 테이블명 등의 object들은 대소문자 상관없지만, 순수한 data들은 대소문자를 가림
select phone_number from employees
where lower(first_name)='steven';

-- 3.3 문자 조작 함수
-- 3.3.1 문자열 일부만 추출하는 SUBSTR 함수
select * from employees;
select first_name, substr(first_name, 1, 5) from employees;
-- 3.3.5 특정 기호로 채우는 LPAD/RPAD 함수
select lpad('oracle', 20, '*') from dual;
-- 10자리 공간에 사원 이름(first_name)을 5자리까지만 나오게 하고 나머지 오른쪽은 (*) 처리를 하시오.
select rpad(substr(first_name, 1, 5), 10, '*') from employees; -- 게시판에서 제목이 길 때 ...처리하는 경우 이런 함수를 사용

-- Section04 형변환 함수
-- 4.1.1 날짜형을 문자형으로 변환하기
select hire_date, to_char(hire_date, 'YYYY.MM.DD DAY') from employees; -- app에서 원하는 문자열을 db에서 가져올 때

-- 4.2 문자형을 날짜형으로 변환하기
select first_name, hire_date from employees where hire_date=to_date('06.17/2003', 'MM-DD-YYYY'); -- app이 db에 문자열을 주고 날짜를 변환할 때?

-- Section05 날짜함수
-- 5.1 DBMS의 현재 날짜
select sysdate from dual;
-- DBMS의 현재 날짜를 "2016.10.17 월요일"로 변환해 보세요
select to_char(sysdate, 'YYYY.MM.DD DAY') from dual;

-- Section06 NULL을 다른 값으로 변환하는 NVL 함수
select salary*12 + nvl(commission_pct, 0)*salary from employees;
select nvl2(
          commission_pct, 
          salary*12+commission_pct*salary, -- null이 아닐 때 return값
          salary*12 --null일 때 return값
      ) as 연봉 from employees;