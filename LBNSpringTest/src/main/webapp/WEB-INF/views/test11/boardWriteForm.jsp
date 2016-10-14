<%@ page contentType= "text/html;charset=UTF-8" %>

<!DOCTYPE html> 
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	
	<body> 
		게시물 쓰기
		<hr/>
		<form method="post" action="/lbnapptest/test11/boardWrite">
			글쓴이: <input type="text" name="bwriter" value="글쓴이1"/> <br/>
			제목: <input type="text" name="btitle" value="지금"/> <br/>
			내용: <textarea row="5" cols="20" name="bcontent">지금지금지금지금</textarea><br/>
			<input type="submit" value="글쓰기"/>
		</form>
	</body>
</html>