<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		글쓰기
		<hr/>
		<form method="post">
			<table>
				<tr>
					<td style="background-color:gold; width:100px">제목</td>
					<td><input type="text" name="btitle" style="width:600px;" value="${freeboard.btitle}"/></td>
				</tr>
				<tr>
					<td style="background-color:gold; width:100px">내용</td>
					<td><textarea name="bcontent" style="width:600px; height:300px;">${freeboard.bcontent}</textarea></td>
				</tr>
			</table>
			<input type="submit" value="글쓰기"/>
		</form>
	</body>
</html>