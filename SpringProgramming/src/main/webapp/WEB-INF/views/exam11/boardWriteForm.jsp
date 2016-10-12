<%@ page contentType= "text/html;charset=UTF-8" %>

<!DOCTYPE html> 
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	
	<body> 
		게시물 쓰기
		<hr/>
		<form method="post" action="/myapp/exam11/boardWrite">
			제목: <input type="text" name="bwriter" value="늦가을"/> <br/>
			제목: <input type="text" name="btitle" value="소풍가쟈아아아"/> <br/>
			내용: <textarea row="5" cols="20" name="bcontent" >겨울 오기 전에 피크닉ㄱㄱㄱㄱㄱ</textarea> <br/>
			<input type="submit" value="글쓰기"/>
		</form>
	</body>
</html>