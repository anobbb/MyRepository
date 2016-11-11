<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		글쓰기
		<hr/>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td style="background-color:gold; width:70px">제목</td>
					<td><input type="text" name="btitle" style="width:600px;" value="${photoboard.btitle}" /></td>
				</tr>
				<tr>
					<td style="background-color:gold; width:70px">내용</td>
					<td><textarea name="bcontent" style="width:600px; height:300px;">${photoboard.bcontent}</textarea></td>
				</tr>
				<tr>
					<td style="background-color:gold; width:70px">사진</td>
					<td><input type="file" name="photo" value="${photoboard.photo}"/></td>
				</tr>
			</table>
			<input type="submit" value="글수정"/>
		</form>
	</body>
</html>