<%@ page contentType= "text/html;charset=UTF-8" %>

<!DOCTYPE html> 
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	
	<body>
		[회원 가입 폼] <br/>
		
		<form method="post" action="/myapp/exam13/memberJoin">
			<%-- name은 parameter 이름, name을 주면 grouping도 됨 --%>
			아이디: <input type="text" name="mid" value="superman8"/> <br/>
			이름: <input type="text" name="mname" value="슈퍼맨"/> <br/>
			비밀번호: <input type="password" name="mpassword" value="12345"/> <br/>
			나이: <input type="number" name="mage" value="28"/> <br/>
			생년월일: <input type="date" name="mbirth" value="2016-09-29"/> <br/><br/>
			<input type="submit" value="회원가입"/>
			
		</form>
	</body>
</html>