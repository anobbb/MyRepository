<%@ page contentType= "text/html;charset=UTF-8" %>

<!DOCTYPE html> 
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	
	<body>
		[로그인 폼] <br/>
		<form method="post" action="/myapp/exam11/memberLogin"> <%-- /myapp/exam11/index --%>
			<%-- name은 parameter 이름, name을 주면 grouping도 됨 --%>
			아이디: <input type="text" name="mid" value="superman"/> <br/>
			비밀번호: <input type="password" name="mpassword" value="12345"/> <br/>
			<br/>
			<input type="submit" value="로그인"/>			
		</form>
	</body>
</html>