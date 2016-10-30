<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		로그인
		<hr/>
		<form method="post">
			아이디: <input type="text" name="mid" value="${findMid}"/> 
			<c:if test="${error == 'LOGIN_FAIL_MID'}"><font color="red"> *아이디가 존재하지 않음</font></c:if>
			<br/>
			패스워드: <input type="password" name="mpassword"/>
			<c:if test="${error == 'LOGIN_FAIL_MPASSWORD'}"><font color="red"> *패스워드가 틀림</font></c:if>
			<br/>
			<input type="submit" value="로그인"/>
		</form>
		<!-- 절대경로 -->
		<a href="${pageContext.servletContext.contextPath}/member/join">회원 가입</a> <br/>
		<!-- 상대경로 -->
		<a href="findMid">아이디 찾기</a> <br/>
		비밀번호 찾기<br/>
	</body>
</html>