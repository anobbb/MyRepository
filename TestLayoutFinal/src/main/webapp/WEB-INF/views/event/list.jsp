<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
   </head>
   <body>
   <h1>eventList</h1>
   <hr/>
   <table style = "border-collapse: collapse;border: 1px solid black; width: 600px"><%-- tr => row 설정 th,td => columns 설정 --%>
			<tr style="background-color: #ffcc00">
				<td style="border: 1px solid black;">번호</td>
				<td style="border: 1px solid black;">제목</td>
				<td style="border: 1px solid black;">시작기간</td>
				<td style="border: 1px solid black;">만료기간</td>
				<td style="border: 1px solid black;">내용</td>
			</tr>
			 
			<c:forEach var="event" items='${eventList}'><%-- 컨트롤러가 넘겨준 list를 items로 찾아줌 items에 들어온 객체를 뽑아 var="b" 에 넣는다. null 처리 필요없음 --%>
				<tr>
					<td style="border: 1px solid black;">${event.eid}</td>
					<td style="border: 1px solid black;"><a href="info?eid=${event.eid}">${event.etitle}</a></td>
					<td style="border: 1px solid black;">${event.estartperiod}</td>
					<td style="border: 1px solid black;">${event.elastperiod}</td>
					<td style="border: 1px solid black;">${event.econtents}</td>
				</tr>
			</c:forEach>
		</table>
		<br/>
	<a href="register"><input type="button" value="등록하기"/></a>
	<a href="remove"><input type="button" value="삭제하기"/></a>	
	
   </body>
</html>