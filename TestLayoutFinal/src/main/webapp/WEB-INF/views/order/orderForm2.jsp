<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--이명진--%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">

		function getSelectValue(frm)
		{
 			frm.sname.value = frm.snameBox.options[frm.snameBox.selectedIndex].text;
 			frm.optionValue.value = frm.snameBox.options[frm.snameBox.selectedIndex].value;
		}
		</script>
	</head>
	<body>
		주문 하기
		<hr/>
		<form method="post">
			아이디: <input type="text" name="sid" value="">
			<input type ="button" href="checkSid">중복체크<br/>
			이메일: <input type="email" name="semail" value=""><br/>
			
			비밀번호: <input type="password" name="spw" value=""><br/>
			비밀번호  확인: <input type="password" name="" value=""><br/>
			카페명: <input type="text" name="sname">
			<select name="snameBox"  onChange="getSelectValue(this.form);">
						<option selected value="option1">직접 입력</option>
						<option value="option1">스타벅스</option>
						<option value="option2">탐앤탐스</option>
						<option value="option3">할리스 커피</option>
						<option value="option4">투썸플레이스</option>					
						<option value="option5">커핀그루나루</option>		
						<option value="option6">카페베네</option>
						<option value="option7">드롭탑</option>
						<option value="option8">파스쿠찌</option>
						<option value="option9">엔제리너스</option>					
						<option value="option10">커피빈</option>	
						<option value="option11">이디야</option>							
					</select><br/>
							
			지점명: <input type="text" name="slocal" value=""><br/>
			주소: <input type="text" name="saddr" value=""><br/>
			대표전화:
			<input type="tel" name="stel" value="" placeholder="-뺴고 숫자만 입력" ><br/>		
			오픈시간: <input type="time" name="sopen" value=""><br/>
			마감시간: <input type="time" name="sclosed" value=""><br/>
			비콘번호: <input type="text" name="sbeacon" value=""><br/>
			사진첨부: <input type="file" name="photo" multiple="multiple"/><br/>
			<input type="submit" value="가입"/>
			<input type="reset" value="취소"/>
		</form>
	</body>
</html>