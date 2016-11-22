<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 보나 20161118~ --%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
   </head>
   <body>
   <h2>메뉴 수정</h2>
   <hr/>
   
   <a href="list"> 
   		<input type="button" value="목록"/> 
   </a>
   
   <form method="post" enctype="multipart/form-data">
   		<table>
   			<tr>
   				<td style="background-color:gold; width:70px">분류</td>
   				<td>
   					<select name="mgroup">
   						<option value="커피" <c:if test="${menu.mgroup eq '커피'}"> selected="selected" </c:if>> 커피 </option>
   						<option value="차" <c:if test="${menu.mgroup eq '차'}"> selected="selected" </c:if>> 차 </option>
   						<option value="디저트" <c:if test="${menu.mgroup eq '디저트'}"> selected="selected" </c:if>> 디저트 </option>
   						<option value="기타" <c:if test="${menu.mgroup eq '기타'}"> selected="selected" </c:if>> 기타 </option>
   					</select>
   				</td>
   			</tr>
   			<tr>
   				<td style="background-color:gold; width:70px">메뉴명</td>
   				<td><input type="text" name="mname" value="${menu.mname}" style="width:200px;"></td>
   			</tr>
   			<tr>
   			
   				<td style="background-color:gold; width:70px">아이스/핫</td>
   				<td>
   					<input type="radio" name="hot_ice" value="HOT" <c:if test="${menu.hot_ice eq 'HOT'}"> checked="checked" </c:if>/> HOT
   					<input type="radio" name="hot_ice" value="ICED" <c:if test="${menu.hot_ice eq 'ICED'}"> checked="checked" </c:if>/> ICED
   					<input type="radio" name="hot_ice" value=" " <c:if test="${menu.hot_ice eq ' '}"> checked="checked" </c:if>/> 없음
   				</td>
   			</tr>
   			<tr>
   				<td style="background-color:gold; width:70px">가격</td>
   				<td><input type="text" name="mprice" value="${menu.mprice}" style="width:100px;"></td>
   			</tr>
   			<tr>
   				<td style="background-color:gold; width:70px">설명</td>
   				<td><input type="text" name="mcontents" value ="${menu.mcontents}" style="width:600px;"></td>
   			</tr>
   			<tr>
				<td style="background-color:gold; width:70px">사진</td>
				<td><input type="file" name="photo" value="${menu.msavedfile}"></td>
			</tr>
   		</table>
   		<input type="submit" value="수정완료"/>
   		<input type="reset" value="초기화"/>
   		
   		
   </form>
   
   </body>
</html>
  