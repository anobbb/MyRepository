<%@ page contentType= "text/html;charset=UTF-8" %>

<!DOCTYPE html> 
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	
	<body>
		[게시판 작성 폼] <br/>
		<form method="post" action="/lbnapptest/test04/board">
			제목: <input type="text" name="btitle" value="안녕하세요" /><br/>
			내용: <input type="text" name="bcontent" value="안녕하세요. 저는 KOSA3기 마스코트 superman이에요ㅎㅎ"><br/>
			글쓴이: <input type="text" name="bwriter" value="슈퍼맨" /><br/>
			이메일주소: <input type="email" name="bemail" value="superman@naver.com"/> <br/>
			
			<input type="submit" value="확인"/>
			
		</form>
	</body>
</html>