<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
   </head>
   <body>
		  수정하기
		<hr/>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td style="background-color:orange; width:70px">이벤트제목</td>
					<td><input type="text" name="etitle" value="${event.etitle}"></td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">날짜</td>
					<td><pre><input type="date" name="estartperiod" value="${event.estartperiod}"/> ~ <input type="date" name="elastperiod" value="${event.elastperiod}"/></pre></td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">이벤트내용</td>
					<td><pre><textarea name="econtents" rows="8" cols="30">${event.econtents}</textarea></pre></td>
				</tr>
				<tr>
					<td rowspan=2 style="background-colot:orange; width:70px">사진</td>
					<td>  
						<input type="file" name="photo"/>
					</td>
				</tr>
				<tr>
					<td>기존파일 : ${event.esavedfile}</td>
				</tr>
			</table>
			<div>
				<c:if test="${login == event.sid}">
					<input type="submit" value="수정완료" />
				</c:if>
				<a href="list"><input type="button" value="목록"/></a>
			</div>
		</form>
		<hr/>


   </body>
</html>