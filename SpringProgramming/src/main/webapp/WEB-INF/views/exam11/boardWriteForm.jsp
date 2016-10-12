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
			글쓴이: <input type="text" name="bwriter" value="기아"/> <br/>
			제목: <input type="text" name="btitle" value="가을야구"/> <br/>
			내용: <textarea row="5" cols="20" name="bcontent" >가을야구 기아기아기아ㅏ아ㅏㅏㅏ</textarea> <br/>
			<input type="submit" value="글쓰기"/>
		</form>
	</body>
</html>