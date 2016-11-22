<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
   <head>
    <meta charset="utf-8">
  </head>	
	
  <body>
   <!-- action을 지정하지않으면 현재 경로로 요청을 하게됨 -->
	<form method="post">
		아이디:<input type="text" name="sid"/>
		<br/>
		
		패스워드:<input type="password" name="spw"/>
		<br/>
		
		<input type = "submit" value="로그인"/>
	</form>
	
	<a href="join">회원가입</a><br/>    
	<a href="findSid">아이디 찾기</a><br/>
	<a href="findSpw">비밀번호 찾기</a><br/>
	<a href="user/login">사용자 로그인</a><br/>
  </body>
</html>
