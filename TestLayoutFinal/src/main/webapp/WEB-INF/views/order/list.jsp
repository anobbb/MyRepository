<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--이명진 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 주문 내역 전체 보기</title>
</head>
<body>
	모든 주문 내역 전체 보기
	<hr />
	<form action = "/myweb/order/termList" accept-charset="utf-8" name = "termList" method = "post"> 
           <fieldset style = "width:350">
          	<legend>조회 기간</legend>
                  <br>
                    시작 날짜 입력<br>
                    <input type = "date" min = "1987-07-01" max = "2020-08-01" name = "date1" step = "1">
                    <br><br>
                    끄읕 날짜 입력<br>
                    <input type = "date" min = "1987-07-01" max = "2020-08-01" name = "date2" step = "1">
                    <br><br>
                    <input type = "submit" value = "검색"/>
                    <input type = "reset" value = "리셋"/><br><br>
            </fieldset>
    </form>


	<table style="border-collapse: collapse; border: 1px solid black; width: 600px">
		<tr style="background-color: #00D8FF">
			<th style="border: 1px solid black;">번호</th>
			<th style="border: 1px solid black;">사용자</th>
			<th style="border: 1px solid black;">시간</th>
			<th style="border: 1px solid black;">가격</th>
			<th style="border: 1px solid black;">결제 내용</th>
		</tr>


		<c:forEach var="orderList" items="${list}">
			<tr>
				<th style="border: 1px solid black;"><a href="detailList?ogid=${orderList.ogid}">${orderList.ogid }</a></th>
				<th style="border: 1px solid black;">${orderList.user_id}</th>
				<th style="border: 1px solid black;">${orderList.ogtime }</th>
				<th style="border: 1px solid black;">${orderList.ogtotalprice }</th>
				<th style="border: 1px solid black;">${orderList.oghowpay }</th>
			</tr>
		</c:forEach>
	</table>


	<div style="width: 600px">
		<a href="list?pageNo=1">[처음]</a>
		<c:if test="${groupNo>1 }">
			<a href="list?pageNo=${startPageNo-1 }">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPageNo}" end="${endPageNo }">
			<a href="list?pageNo=${i}"
				<c:if test="${pageNo==i }">style="color:red"</c:if>>${i}</a>
		</c:forEach>

		<c:if test="${groupNo<totalGroupNo }">
			<a href="list?pageNo=${endPageNo+1 }">[다음]</a>
		</c:if>
		<a href="list?pageNo=${totalPageNo }">[맨끝]</a>
	</div>

</body>
</html>