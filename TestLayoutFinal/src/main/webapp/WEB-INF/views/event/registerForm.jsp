<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<style>
				table,tr,td{
					border: 1px solid black;
				}
				div{
					display:inline-block;
					float:right;
					margin:5px;
				}
			 
			</style>
		</head>
		<body>
			<h1>event 등록</h1>
			<hr/>
			<form method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>이벤트 제목</td>
						<td><input name="etitle"  type="text" /><br/></td>
					</tr>
					<tr>
						<td>기간</td>
						<td><input name="estartperiod" type="date"> ~ <input name="elastperiod" type="date"><br/></td>			
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="econtents" rows="5" cols="30"></textarea></td> 
					</tr>
					<tr>
						<td>사진</td>
						<td><input type="file" name="photo"/></td>
					</tr> 
				</table>	
				
				<br/>
				
				<fieldset style="width:370px">
					<legend>할인 메뉴</legend>
					<div><a href="#">커피</a></div>
					<div><a href="#">음료</a></div>
					<div><a href="#">쉐이크</a></div>
				</fieldset>
				
				
				
				
				
				
			<input type="submit" value ="등록"/>
			</form>
		</body>
	</html>