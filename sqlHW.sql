--------------------- ch02 ------------------------
-- 1. (3)
-- 2. (3)
-- 3. (2)
-- 4. (2)
-- 5. (1)
-- 6. (1)
-- 7.
select empno, ename
from emp
order by empno desc;

-------------------- ch03 ----------------------------
-- 1.
select * from emp
where mod(empno,2)=1;
-- 2.
select hiredate, substr(hiredate, 1, 2) as �⵵, substr(hiredate, 4, 2) as ��, substr(hiredate, 7, 4) as ��
from emp;
-- 3. ����� ���� ����.
-- 4. 
select empno, ename, mgr(to_char(mgr, '9999'), 'CEO') as "���� ���"
from emp
where mgr is null;
-- 5. dual
-- 6,7 ����� ���� ����
-- 8. null���� null�� ó������ �ʰ�, ������ ����+���ʽ�, ���ʽ��� ���
-- 9. case
-- 10. sysdate

------------------------ ch04 --------------------------------
-- 1. 3
-- 2. 1
-- 3. 3
-- 4. 1
-- 5. 3
-- 6. 1
-- 7. 
select count(deptno) as �����
from emp
where comm is not null;
-- 8.
select max(hiredate) as �Ի���, min(hiredate) as �Ի���
from emp;
-- 9.
select job, sum(sal) as "(�� �̸� ����)"
from emp
where sal>300
group by job;

-------------------------- ch07 ---------------------
-- 1. 2
-- 2. 1
-- 3. Database Defined Language, ���̺��� ������ ����, ����, �����ϴ� ��ɾ�

-------------------------- ch08 ----------------------
-- 1. 4
-- 2. 4
-- 3. 2
-- 4. 2
-- 5. 3
-- 6. 3
-- 7. Database Manipulation Language, ���̺� ���ο� �����͸� ����, ������ �����͸� ����, �����ϴ� ��ɾ� ����

-------------------------- ch09 ----------------------
-- 1. 3
-- 2. 3
-- 3. 2

-------------------------- ch10 ----------------------
-- 1. 4
-- 2. 1
-- 3. 4
-- 4. 4
-- 5. 1
-- 6. 4
-- 7. 4
-- 8. 4
-- 9. 2
-- 10. 4
-- 11. 
select ename, d.deptno, dname
from emp e inner join dept d
on e.deptno=d.deptno 
order by deptno;
-- 12.
select e.ename, e.hiredate
from emp e, dept d
where e.deptno = d.deptno and d.dname='�渮��';
-- 13. 
select e.ename, d.dname
from emp e, dept d
where d.deptno=e.deptno and e.job='����';

-- 14.
select work.ename, work.job
from emp work, emp manager
where work.mgr=manager.empno and work.mgr=1008;
-- 15.
select work.ename, friend.ename
from emp work, emp friend
where work.deptno=friend.deptno and work.empno=1008 and friend.ename!='���켺';
-------------------------- ch11 ----------------------
-- 1. 4
-- 2. 4
-- 3. 2
-- 4. 2
-- 5. 1
-- 6. 4
-- 7.
create table emp06 as select*from emp;
select*from emp06;

-- 8. 
select ename, sal from emp06
where job!='����' and sal >( 
select min(sal) from emp06 
where job='����'
) order by sal desc;

-- 9.
update emp06
set sal = sal+100
where deptno in (select deptno from dept where loc='��õ');
select*from emp06;

-- 10.
delete emp06
where deptno in (select deptno from dept where dname='�渮��');
select*from emp06;

-- 11.
select ename, deptno from emp
where ename!='�̹���' and deptno in (select deptno from emp where ename='�̹���');

-- 12.
select * from emp
where ename!='�̹���' and job in (select job from emp where ename='�̹���');

-- 13
select ename, sal from emp
where ename !='�̹���' and sal >= (select sal from emp where ename='�̹���');

-- 14
select ename, deptno from emp
where deptno in (select deptno from dept where loc='��õ');

-- 15
select ename, sal, mgr from emp
where mgr in (select deptno from emp where ename='���켺');

-- 16 
select empno, ename, sal, deptno from emp
where sal in (select max(sal) from emp group by deptno) order by deptno;

-- 17
select dept.deptno, dname, loc from dept
where deptno in (select deptno from emp where job='����');

-- 18
select ename, sal, job from emp
where job!='����' and sal >( 
select max(sal) from emp where job='����');