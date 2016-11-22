<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--이명진 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1개 주문 내역 상세 보기</title>
</head>
<body>
	1개 주문 내역 상세 보기
	<hr />

	<table
		style="border-collapse: collapse; border: 1px solid black; width: 600px">
		<tr style="background-color: #00D8FF">
			<th style="border: 1px solid black;">품목</th>
			<th style="border: 1px solid black;">수량</th>
			<th style="border: 1px solid black;">사이드</th>
			<th style="border: 1px solid black;">가격</th>
		</tr>


		<c:forEach var="detailOrders" items="${detailOrders}">
			<tr>
				<th style="border: 1px solid black;">${detailOrders.mname }</th>
				<th style="border: 1px solid black;">${detailOrders.sameItemCount }</th>
				<th style="border: 1px solid black;">${detailOrders.xname }</th>
				<th style="border: 1px solid black;">${detailOrders.sameItemPrice }</th>
			</tr>
		</c:forEach>
	</table>
		<c:forEach var="detailOrders" items="${detailOrders}" begin="1" end="1">
 			<p>총 가격 : ${detailOrders.totalprice}</p>
			<p>결제방법 : ${detailOrders.oghowpay}</p>
		</c:forEach>
	<div>
		
	</div>

</body>
</html>