<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
		<script type="text/javascript">
			function checkLoginForm(){
				var mid = document.querySelector("#mid").value;
				var mpassword = document.querySeleoctor("#mpassword").value;
				
				if(mid=="" || mpassword==""){
					alert("아이디 혹은 패스워드가 입력되지 않았습니다.");
					return false;
				} else if(mid.length < 4 || mid.length > 10) {
					alert("아이디의 길이가 맞지 않습니다.");
					return false;
				} else if(mpassword.length < 4 || mpassword.length > 10) {
					alert("패스워드의 길이가 맞지 않습니다.");
					return false;
				}
				return true;
			}
		</script>
	</head>

	<body>
		유효성 검사(입력값 검사)
		<hr/>	
		<%-- return 키워드를 설정하여 false를 리턴하면 폼 실행 X --%>
		<form id="loginForm" onsubmit="return checkLoginForm()"> 
			아이디: <input type="text" name="mid"/><br/>
			비밀번호: <input type="password" name="mpassword"/><br/>
			<input type="submit" value="로그인"/>
		</form>
	</body>
	
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        