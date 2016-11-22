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
		회원가입
		<hr/>
		<form method="post"><%--action=~ 이 없으면 현재 넘어간 요청경로로 다시 이동하다.--%>
			이메일: <input type="email" name="user_email" value="" placeholder="e-mail을 입력해주세요.">
			<input type ="button" href="checkUser_email">중복체크</a><br/>
			비밀번호: <input type="password" name="" placeholder="비밀번호를 입력해주세요."><br/>
			비밀번호 확인: <input type="password" name="" placeholder="비밀번호를 다시 입력해주세요."><br/>
			휴대전화: <input type="tel" name="user_tel" value="" placeholder="휴대전화번호를 입력해주세요."><br/>
			<input type="submit" value="가입"/>
		</form>
	</body>
</html>