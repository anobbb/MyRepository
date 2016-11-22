<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--2016-11-16(수)--%>
<%--작성자: 이윤주--%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		비밀번호 찾기
		<hr/>
		<form method="post"><%--action=~ 이 없으면 현재 넘어간 요청경로로 다시 이동하다.--%>
			아이디: <input type="text" name="user_id">${error}<br/>
			이메일: <input type="email" name="user_email">${error}<br/>
			<input type="submit" value="비밀번호 찾기"/>
		</form>
	</body>
</html>