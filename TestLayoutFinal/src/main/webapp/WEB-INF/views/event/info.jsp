<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
   </head>
   <body>
		  세부내용
		<hr/>
			<table>
				<tr>
					<td style="background-color:orange; width:70px">이벤트제목</td>
					<td>${event.etitle}</td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">날짜</td>
					<td><pre>${event.estartperiod} ~ ${event.elastperiod}</pre></td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">이벤트내용</td>
					<td><pre>${event.econtents}</pre></td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px" >사진</td>
					<td><img src="showPhoto?esavedfile=${event.esavedfile}" width="500px"/></td>
				</tr>
			</table>
			<div>
				<c:if test="${login == event.sid}">
					<a href="modify?eid=${event.eid}"><input type="button" value="수정"/></a>
					<a href="remove?eid=${event.eid}"><input type="button" value="삭제"/></a>
				</c:if>
					<a href="list"><input type="button" value="목록"/></a>
			</div>
   </body>
</html>