-- 행 순번 붙이기
select rownum, bno, btitle
from board
order by bno;

-- 정렬되기 전에 결과에 rownum을 붙이고(~from까지), order by에는 rownum이 적용되지 않음
-- rownum이 끝까지 적용되기 하려면 subquery를 사용하여야 한다
select rownum, bno, btitle
from (select bno, btitle from board order by bno);

select rownum, bno, btitle
from (select bno, btitle from board order by bno desc);

-- 최근 삽입된 행 5개를 가져오시오
select rownum, bno, btitle
from (select bno, btitle from board order by bno desc)
where rownum<=5;
-- 순번을 매길 때마다 where의 조건을 검사함
-- where 조건절이 false가 나올 때까지 순번을 매김
-- 예를 들어 where rownum>5000을 주면 where에서 false가 나와서 몇 번 검사할지 모름
-- 주어진 수보다 작거나 같은 것은 검색 가능하지만 초과되는 내용은 검색불가(rownum의 기능 상실)

-- 11~20번까지를 가져오기
select rn, bno, btitle
from (
select rownum as rn, bno, btitle
from (select bno, btitle from board order by bno desc)
where rownum<=20
)
where rn>=11;

-- 1페이지에 10개씩 구성하고, n번째 페이지를 가져오시오
select rn, bno, btitle
from (
select rownum as rn, bno, btitle
from (select bno, btitle from board order by bno desc)
where rownum<=(n*10)
)
where rn>=((n-1)*10+1);