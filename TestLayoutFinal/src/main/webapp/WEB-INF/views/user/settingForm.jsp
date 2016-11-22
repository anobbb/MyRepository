<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--2016-11-14(월)--%>
<%--작성자: 이윤주--%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		설정
		<hr/>
		<form method="post"><%--action=~ 이 없으면 현재 넘어간 요청경로로 다시 이동하다.--%>
			<input type="submit" value="로그아웃"><br/>
			<input type="submit" value="내 정보 보기"><br/>
			PUSH 알람<label class= "switch">
						<input type="checkbox" value="ON">
						<div class="slider"></div>
			 		</label>
			 		<label class= "switch">
						<input type="checkbox" value="OFF">
						<div class="slider"></div>
			 		</label>
					<br/>
			<input type="submit" value="탙퇴하기"/>
		</form>
	</body>
</html>